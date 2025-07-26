import React from "react";
import styles from "../styles/CohortDetails.module.css";

function CohortDetails({ name, status, coach,startDate, endDate }) {
  const headingStyle = {
    color: status.toLowerCase() === "ongoing" ? "green" : "blue"
  };

  return (
    <div className={styles.box}>
      <h3 style={headingStyle}>{name}</h3>
      <dl>
        <dt>Status:</dt>
        <dd>{status}</dd>
        <dt>Coach:</dt>
        <dd>{coach}</dd>
        <dt>Start Date:</dt>
        <dd>{startDate}</dd>
        <dt>End Date:</dt>
        <dd>{endDate}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
