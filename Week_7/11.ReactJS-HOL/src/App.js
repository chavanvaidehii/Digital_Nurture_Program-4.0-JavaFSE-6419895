import React, { Component } from "react";
import CurrencyConvertor from "./CurrencyConvertor";

class App extends Component {
  constructor() {
    super();
    this.state = {
      count: 1,
    };
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 });
    this.sayHello();
  };

  sayHello = () => {
    alert("Hello! This is a static message.");
  };

  decrement = () => {
    this.setState({ count: this.state.count - 1 });
  };

  sayWelcome = (message) => {
    alert(message);
  };

  handleClick = (event) => {
    alert("I was clicked");
    console.log("Synthetic event:", event);
  };

 render() {
  return (
    <div>
      <p>{this.state.count}</p>

      {/* Increment & Decrement buttons stacked */}
      <div style={{ display: 'flex', flexDirection: 'column', width: '120px', gap: '10px' }}>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>
      </div>

      <br />

      {/* Say Welcome & Click on me buttons stacked */}
      <div style={{ display: 'flex', flexDirection: 'column', width: '120px', gap: '10px' }}>
        <button onClick={() => this.sayWelcome("Welcome!")}>Say welcome</button>
        <button onClick={this.handleClick}>Click on me</button>
      </div>

      <br /><br />
      <CurrencyConvertor />
    </div>
  );
}

}
export default App;
