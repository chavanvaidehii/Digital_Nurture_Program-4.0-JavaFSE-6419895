import React, { Component } from "react";
import GuestPage from "./GuestPage";
import UserPage from "./UserPage";

class App extends Component {
  constructor() {
    super();
    this.state = {
      isLoggedIn: false,
    };
  }

  handleLogin = () => {
    this.setState({ isLoggedIn: true });
  };

  handleLogout = () => {
    this.setState({ isLoggedIn: false });
  };

  render() {
    let pageContent;
    if (this.state.isLoggedIn) {
      pageContent = <UserPage />;
    } else {
      pageContent = <GuestPage />;
    }

    return (
      <div>
        <h1>Welcome to Ticket Booking App</h1>

        {/* Conditional Buttons */}
        {
          this.state.isLoggedIn ? (
            <button onClick={this.handleLogout}>Logout</button>
          ) : (
            <button onClick={this.handleLogin}>Login</button>
          )
        }

        <hr />
        {/* Conditional Page Rendering */}
        {pageContent}
      </div>
    );
  }
}

export default App;
