import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";

class Dashboard extends Component {
  render() {
    return (
      <div className="dashboard">
        <h1 className="alert alert-warning">Welcome to Dashboard</h1>
        <ProjectItem />
        <ProjectItem />
      </div>
    );
  }
}
export default Dashboard;
