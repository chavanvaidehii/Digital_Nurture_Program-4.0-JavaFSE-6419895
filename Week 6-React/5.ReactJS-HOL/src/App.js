import React from "react";
import CohortDetails from "./components/CohortDetails";

function App() {
  return (
    <div>
      <h2 style={{ textAlign: "center" }}>Cohort Dashboard</h2>
      <CohortDetails
        name="GenAI Training"
        status="Ongoing"
        coach="Ashta"
        startDate="01-Jul-2025"
        endDate="30-Jul-2025"
      />
      <CohortDetails
        name="Java Full Stack"
        status="Completed"
        coach="Samiksha"
        startDate="01-Jun-2025"
        endDate="30-Jun-2025"
      />
      <CohortDetails
        name="CDBJF21025 - Java FSD"
        status="Scheduled"
        coach="Vaidehi "
        startDate="01-Sept-2025"
        endDate="30-Sept-2025"
      />
    </div>
  );
}

export default App;
