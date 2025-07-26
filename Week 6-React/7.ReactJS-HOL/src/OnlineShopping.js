import React from 'react';
import Cart from './Cart';

class OnlineShopping extends React.Component {
  render() {
    const cartItems = [
      { itemname: "T-shirt", price: 500 },
      { itemname: "Shoes", price: 1200 },
      { itemname: "Watch", price: 2500 },
      { itemname: "Jeans", price: 1500 },
      { itemname: "Backpack", price: 1000 }
    ];

    return (
      <div style={{
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        minHeight: '100vh',
        backgroundColor: '#e0f7fa' // Light teal background
      }}>
        <div style={{
          backgroundColor: '#ffffff',
          padding: '15px',
          borderRadius: '10px',
          boxShadow: '0 3px 8px rgba(0,0,0,0.1)',
          width: '360px',
          textAlign: 'center'
        }}>
          <h3 style={{
            marginBottom: '10px',
            color: '#00796b' // Dark teal
          }}>🛒 Online Shopping Cart</h3>
          {cartItems.map((item, index) => (
            <Cart key={index} itemname={item.itemname} price={item.price} />
          ))}
        </div>
      </div>
    );
  }
}

export default OnlineShopping;
