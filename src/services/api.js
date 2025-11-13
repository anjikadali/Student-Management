const BASE = "http://localhost:8080/api/students";

async function handleResponse(res) {
  if (!res.ok) {
    const errText = await res.text().catch(()=>null);
    throw new Error(errText || res.statusText || 'API error');
  }
  if (res.status === 204) return null;
  return res.json();
}

export async function getStudents() {
  const res = await fetch(BASE);
  return handleResponse(res);
}

export async function getStudent(id) {
  const res = await fetch(`${BASE}/${id}`);
  return handleResponse(res);
}

export async function createStudent(student) {
  const res = await fetch(BASE, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(student)
  });
  return handleResponse(res);
}

export async function updateStudent(id, student) {
  const res = await fetch(`${BASE}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(student)
  });
  return handleResponse(res);
}

export async function deleteStudent(id) {
  const res = await fetch(`${BASE}/${id}`, { method: "DELETE" });
  return handleResponse(res);
}
