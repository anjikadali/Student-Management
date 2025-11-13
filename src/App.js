import React from "react";
import StudentList from "./components/StudentList";

function App() {
  return (
    <div>
      <nav className="navbar navbar-dark bg-primary">
        <div className="container">
          <span className="navbar-brand mb-0 h1">Student Management</span>
        </div>
      </nav>
      <StudentList />
    </div>
  );
}

export default App;
