import React, { Component } from "react";

class CurrencyConvertor extends Component {
  constructor() {
    super();
    this.state = {
      amount: "",
      currency: "", // Start as empty
    };
  }

  handleAmountChange = (e) => {
    this.setState({ amount: e.target.value });
  };

  handleCurrencyChange = (e) => {
    this.setState({ currency: e.target.value });
  };

  handleSubmit = (e) => {
    e.preventDefault();

    const conversionRate = 80; // Assume 1 Euro = 80 INR

    if (this.state.currency === "") {
      alert("Please select a currency.");
      return;
    }

    const convertedAmount = this.state.amount * conversionRate;
    alert(`Converting to ${this.state.currency} Amount is ${convertedAmount}`);
  };

  render() {
    return (
      <div>
        <h2 style={{ color: "green" }}>Currency Convertor!!!</h2>
        <form onSubmit={this.handleSubmit} style={{ display: "flex", flexDirection: "column", width: "300px", gap: "15px" }}>
          <label>Amount: </label>
          <input
            type="number"
            value={this.state.amount}
            onChange={this.handleAmountChange}
            style={{ height: "35px", fontSize: "16px", padding: "5px" }}
          />

          <label>Currency: </label>
          <select
            value={this.state.currency}
            onChange={this.handleCurrencyChange}
            style={{ height: "35px", fontSize: "16px", padding: "5px" }}
          >
            <option value="" disabled>-- Select Currency --</option>
            <option value="Euro">Euro</option>
          </select>

          <div style={{ textAlign: "center" }}>
            <button type="submit" style={{ padding: "10px 20px", fontSize: "16px" }}>
              Submit
            </button>
          </div>
        </form>
      </div>
    );
  }
}

export default CurrencyConvertor;
