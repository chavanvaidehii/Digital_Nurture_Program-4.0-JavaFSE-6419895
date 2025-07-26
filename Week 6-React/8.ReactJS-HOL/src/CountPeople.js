import React, { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entryCount: 3,
      exitCount: 2,
    };
  }

  updateEntry = () => {
    this.setState((prevState) => ({
      entryCount: prevState.entryCount + 1,
    }));
  };

  updateExit = () => {
    this.setState((prevState) => ({
      exitCount: prevState.exitCount + 1,
    }));
  };

  render() {
    const buttonStyle = {
      backgroundColor: 'green',
      color: 'white',
      padding: '10px 20px',
      margin: '0 10px',
      border: 'none',
      borderRadius: '5px',
      cursor: 'pointer',
      fontSize: '16px'
    };

    const containerStyle = {
      textAlign: 'center',
      marginTop: '50px',
    };

    const rowStyle = {
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      gap: '20px',
      flexWrap: 'wrap'
    };

    return (
      <div style={containerStyle}>
        <div style={rowStyle}>
          <button style={buttonStyle} onClick={this.updateEntry}>Login</button>
          <span style={{ fontSize: '18px' }}>{this.state.entryCount} people entered!!!</span>
          <button style={buttonStyle} onClick={this.updateExit}>Exit</button>
          <span style={{ fontSize: '18px' }}>{this.state.exitCount} people left!!</span>
        </div>
      </div>
    );
  }
}

export default CountPeople;
