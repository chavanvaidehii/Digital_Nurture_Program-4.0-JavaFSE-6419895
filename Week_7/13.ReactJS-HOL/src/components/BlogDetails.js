import React from "react";

const blogs = [
  {
    title: "React Learning",
    author: "Vaidehi Chavan",
    content: "Welcome to learning React!",
  },
  {
    title: "Installation",
    author: "Samiksha Thakre",
    content: "You can install React from npm.",
  },
];

const BlogDetails = () => {
  return (
    <div style={{ borderLeft: "8px solid green", paddingLeft: "20px" }}>
      <h2>Blog Details</h2>
      {blogs.map((blog, index) => (
        <div key={index}>
          <h3>{blog.title}</h3>
          <strong>{blog.author}</strong>
          <p>{blog.content}</p>
        </div>
      ))}
    </div>
  );
};

export default BlogDetails;
