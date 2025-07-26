import React from 'react';
import './Stylesheets/mystyle.css';
import CalculateScore from './Components/CalculateScore';

function App() {
  return (
    <div className="App">
      <CalculateScore name="Vaidehi Chavan" school="ABC High School" total={450} goal={5} />
    </div>
  );
}

export default App;
