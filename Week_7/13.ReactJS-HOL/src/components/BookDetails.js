import React from "react";

const books = [
  { title: "Master React", price: 670 },
  { title: "Deep Dive into Angular 11", price: 800 },
  { title: "Mongo Essentials", price: 450 },
];

const BookDetails = () => {
  return (
    <div style={{ borderLeft: "8px solid green", paddingLeft: "20px" }}>
      <h2>Book Details</h2>
      {books.map((book, index) => (
        <div key={index}>
          <h3>{book.title}</h3>
          <p>{book.price}</p>
        </div>
      ))}
    </div>
  );
};

export default BookDetails;
