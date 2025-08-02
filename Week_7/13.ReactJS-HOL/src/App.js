import React, { Component } from "react";
import CourseDetails from "./components/CourseDetails";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";

class App extends Component {
  constructor() {
    super();
    this.state = {
      showCourses: true,
      showBooks: true,
      showBlogs: true,
    };
  }

  render() {
    return (
      <div style={{ display: "flex", justifyContent: "space-around", padding: "50px" }}>
        {this.state.showCourses && <CourseDetails />}
        {this.state.showBooks && <BookDetails />}
        {this.state.showBlogs ? <BlogDetails /> : <p>No Blog Data</p>}
      </div>
    );
  }
}

export default App;
