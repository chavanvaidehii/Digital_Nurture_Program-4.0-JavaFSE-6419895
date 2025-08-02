import React from "react";

const courses = [
  { name: "Angular", date: "4/5/2021" },
  { name: "React", date: "6/3/2021" },
];

const CourseDetails = () => {
  return (
    <div>
      <h2>Course Details</h2>
      {courses.map((course, index) => (
        <div
          key={index}
          style={{
            borderLeft: "6px solid green",
            paddingLeft: "10px",
            marginBottom: "10px"
          }}
        >
          <h3 style={{ margin: "0" }}>{course.name}</h3>
          <p style={{ margin: "4px 0" }}>{course.date}</p>
        </div>
      ))}
    </div>
  );
};

export default CourseDetails;
