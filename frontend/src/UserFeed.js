import React, { useState, useEffect } from "react";
import Axios from "axios";

function UserFeed() {
    const [transaction, setTransactions] = useState([]);


    useEffect(() => {
        Axios("http://localhost:8080/transactions")
        .then(data=> setTransactions(data))
        .catch(err => console.log(err))
    
        
      }, []);
      
      return <React.Fragment>
        
      </React.Fragment>
}
