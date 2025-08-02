import React from 'react';

const IndianPlayers = () => {
  const players = [
    'Sachin1',
    'Dhoni2',
    'Virat3',
    'Rohit4',
    'Yuvaraj5',
    'Raina6'
  ];

  const oddPlayers = players.filter((_, index) => index % 2 === 0);
  const evenPlayers = players.filter((_, index) => index % 2 !== 0);

  const T20players = ['Mr. First Player', 'Mr. Second Player', 'Mr. Third Player'];
  const RanjiPlayers = ['Mr. Fourth Player', 'Mr. Fifth Player', 'Mr. Sixth Player'];
  const mergedPlayers = [...T20players, ...RanjiPlayers];

  return (
    <div>
      <h2>Odd Players</h2>
      <ul>
        {oddPlayers.map((player, index) => (
          <li key={index}>
            {`${
              index === 0 ? 'First' :
              index === 1 ? 'Third' :
              index === 2 ? 'Fifth' : ''
            } : ${player}`}
          </li>
        ))}
      </ul>

      <h2>Even Players</h2>
      <ul>
        {evenPlayers.map((player, index) => (
          <li key={index}>
            {`${
              index === 0 ? 'Second' :
              index === 1 ? 'Fourth' :
              index === 2 ? 'Sixth' : ''
            } : ${player}`}
          </li>
        ))}
      </ul>

      <h2>List of Indian Players Merged:</h2>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;
