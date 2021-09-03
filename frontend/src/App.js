import logo from './logo.svg';
import './App.css';
import React, { useState, useEffect } from "react";
import 'semantic-ui-css/semantic.min.css'
import NavBar from './Layout/NavBar';
import {
  Segment,
  Grid,
  Form,
  Divider,
  Button,
  Header,
  Container,
  Image,
  Icon,
  Message
} from "semantic-ui-react";

function App() {
  // const [transactions, setTransactions] = useState([]);
  
  // useEffect(() => {
  //   fetch("http://localhost:8080/transactions")
  //   .then(res => res.json())
  //   .then(data=> setTransactions(data))
  //   .catch(err => console.log(err))

  //   console.log(transactions);
  // }, [transactions]);
  // return (

  //   <div className="App">
    
  //     <header className="App-header">
  //       {/* <img src={logo} className="App-logo" alt="logo" /> */}
  //       {/* <p>
  //         Edit <code>src/App.js</code> and save to reload.
  //       </p> */}
  //       Hello World!
  //       {/* <LenderTable /> */}
      
  //     </header>
  //   </div>
  // );

  // const [state, setState] = useState([])
  // const [hasError, setHasError] = useState(false)
  // const [loading, setLoading] = useState(false)
  // useEffect(() => {
  //     // setLoading(true);
  //     const fetchUsers = async () => {
  //       const users = await fetch("http://localhost:8080/transactions")
  //           .then(data => data.json())
  //           .then(user => setState(user))
  //   }
  //   fetchUsers()
  // }, []);

  // console.log(state);
  return (
      <>
 
    <NavBar/>
   
 
    <Container  text style={{ marginTop: '7em' }}>
    <Header as='h1'>Semantic UI React</Header>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      <p>
      Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
      </p>
  
    </Container>
         
      </>
  );
}

export default App;
