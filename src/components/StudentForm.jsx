import React, { useState } from "react";
import { createStudent } from "../services/api";

export default function StudentForm({ onCreated }) {
  const [form, setForm] = useState({ firstName: "", lastName: "", email: "", course: "" });
  const [loading, setLoading] = useState(false);

  const onChange = (e) => setForm(prev => ({ ...prev, [e.target.name]: e.target.value }));

  const submit = async (e) => {
    e.preventDefault();
    setLoading(true);
    try {
      const created = await createStudent(form);
      if (onCreated) onCreated(created);
      setForm({ firstName: "", lastName: "", email: "", course: "" });
    } catch (err) {
      alert("Create failed: " + (err.message || err));
    } finally {
      setLoading(false);
    }
  };

  return (
    <form className="card card-body mb-3" onSubmit={submit}>
      <div className="row g-2">
        <div className="col-md-3">
          <input required name="firstName" value={form.firstName} onChange={onChange} className="form-control" placeholder="First name" />
        </div>
        <div className="col-md-3">
          <input name="lastName" value={form.lastName} onChange={onChange} className="form-control" placeholder="Last name" />
        </div>
        <div className="col-md-3">
          <input required type="email" name="email" value={form.email} onChange={onChange} className="form-control" placeholder="Email" />
        </div>
        <div className="col-md-2">
          <input name="course" value={form.course} onChange={onChange} className="form-control" placeholder="Course" />
        </div>
        <div className="col-md-1 d-grid">
          <button className="btn btn-success" type="submit" disabled={loading}>{loading ? "Saving..." : "Save"}</button>
        </div>
      </div>
    </form>
  );
}
