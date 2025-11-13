import React, { useState } from "react";
import { updateStudent } from "../services/api";

export default function StudentEdit({ student, onUpdated, onCancel }) {
  const [form, setForm] = useState({
    firstName: student.firstName || "",
    lastName: student.lastName || "",
    course: student.course || ""
  });
  const [loading, setLoading] = useState(false);

  const onChange = (e) => setForm(prev => ({ ...prev, [e.target.name]: e.target.value }));

  const submit = async (e) => {
    e.preventDefault();
    setLoading(true);
    try {
      const updated = await updateStudent(student.studentId, form);
      if (onUpdated) onUpdated(updated);
    } catch (err) {
      alert("Update failed: " + err.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <form className="card card-body mb-3" onSubmit={submit}>
      <div className="d-flex justify-content-between align-items-center mb-2">
        <h6 className="m-0">Edit: {student.firstName} {student.lastName}</h6>
        <button type="button" className="btn btn-sm btn-outline-secondary" onClick={onCancel}>Close</button>
      </div>
      <div className="row g-2">
        <div className="col-md-4">
          <input required name="firstName" value={form.firstName} onChange={onChange} className="form-control" placeholder="First name" />
        </div>
        <div className="col-md-4">
          <input name="lastName" value={form.lastName} onChange={onChange} className="form-control" placeholder="Last name" />
        </div>
        <div className="col-md-3">
          <input name="course" value={form.course} onChange={onChange} className="form-control" placeholder="Course" />
        </div>
        <div className="col-md-1 d-grid">
          <button className="btn btn-primary" type="submit" disabled={loading}>{loading ? "Saving..." : "Save"}</button>
        </div>
      </div>
    </form>
  );
}
