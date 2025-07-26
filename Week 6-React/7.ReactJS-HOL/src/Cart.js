import React from 'react';

class Cart extends React.Component {
  render() {
    return (
      <div style={{
        borderBottom: "1px solid #e0e0e0",
        padding: "6px 0",
        backgroundColor: '#f9fbe7' // Light yellow-green
      }}>
        <h4 style={{
          margin: '4px 0',
          color: '#33691e' // Olive green
        }}>{this.props.itemname}</h4>
        <p style={{
          margin: '2px 0',
          color: '#424242' // Dark grey
        }}>Price: ₹{this.props.price}</p>
      </div>
    );
  }
}

export default Cart;
