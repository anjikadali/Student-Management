import React, { useEffect, useState } from "react";
import { getStudents, deleteStudent } from "../services/api";
import StudentForm from "./StudentForm";
import StudentEdit from "./StudentEdit";

export default function StudentList() {
  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [editing, setEditing] = useState(null);
  const [showForm, setShowForm] = useState(false);

  const load = async () => {
    setLoading(true);
    try {
      const data = await getStudents();
      setStudents(data || []);
      setError(null);
    } catch (e) {
      setError(e.message || "Failed to load students");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => { load(); }, []);

  const onDelete = async (id) => {
    if (!window.confirm("Delete this student?")) return;
    try {
      await deleteStudent(id);
      setStudents(prev => prev.filter(s => s.studentId !== id));
    } catch (e) {
      alert("Delete failed: " + e.message);
    }
  };

  const onCreated = (newStudent) => {
    setStudents(prev => [newStudent, ...prev]);
    setShowForm(false);
  };

  const onUpdated = (updated) => {
    setStudents(prev => prev.map(s => (s.studentId === updated.studentId ? updated : s)));
    setEditing(null);
  };

  return (
    <div className="container container-card">
      <div className="card p-4">
        <div className="d-flex justify-content-between align-items-center mb-3">
          <h3 className="m-0">Student Management</h3>
          <div>
            <button className="btn btn-primary me-2" onClick={() => setShowForm(s => !s)}>
              {showForm ? "Close" : "Add Student"}
            </button>
            <button className="btn btn-outline-secondary" onClick={load}>Refresh</button>
          </div>
        </div>

        {showForm && <StudentForm onCreated={onCreated} />}

        {editing && <StudentEdit student={editing} onUpdated={onUpdated} onCancel={() => setEditing(null)} />}

        {loading ? (
          <div className="text-center py-4">Loading...</div>
        ) : error ? (
          <div className="alert alert-danger">{error}</div>
        ) : students.length === 0 ? (
          <div className="text-center py-4">No students found.</div>
        ) : (
          <div className="table-responsive">
            <table className="table table-striped table-hover mt-3">
              <thead className="table-light">
                <tr>
                  <th>#</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Course</th>
                  <th>Created</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {students.map((s, idx) => (
                  <tr key={s.studentId}>
                    <td>{idx + 1}</td>
                    <td>{s.firstName} {s.lastName}</td>
                    <td>{s.email}</td>
                    <td>{s.course}</td>
                    <td>{new Date(s.createdAt).toLocaleString()}</td>
                    <td>
                      <button className="btn btn-sm btn-outline-primary me-2" onClick={() => setEditing(s)}>Edit</button>
                      <button className="btn btn-sm btn-outline-danger" onClick={() => onDelete(s.studentId)}>Delete</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        )}
      </div>
    </div>
  );
}
