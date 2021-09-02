import logo from './logo.svg';
import './App.css';
import React, { useState, useEffect } from "react";


function App() {
  useEffect(() => {
    fetch("http://localhost:8080/transactions")
    .then(data=> console.log(data))
    .catch(err => console.log(err))

    
  }, []);
  return (

    <div className="App">
    
      <header className="App-header">
        {/* <img src={logo} className="App-logo" alt="logo" /> */}
        {/* <p>
          Edit <code>src/App.js</code> and save to reload.
        </p> */}
        Hello World!

      
      </header>
    </div>
  );
}

export default App;
