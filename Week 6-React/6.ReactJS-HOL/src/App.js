
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './Components/Home';
import TrainersList from './Components/TrainersList';
import TrainerDetail from './Components/TrainerDetail';
import trainers from './TrainersMock';

function App() {
  return (
    <Router>
      <div>
        <nav>
          <Link to="/">Home</Link> | <Link to="/trainers">Trainers</Link>
        </nav>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList trainers={trainers} />} />
          <Route path="/trainer/:id" element={<TrainerDetail />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
