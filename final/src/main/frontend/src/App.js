import React, {useEffect, useState} from "react";
import { Routes, Route } from "react-router-dom";
import axios from 'axios';

import Home from "./Home";
import Todo from "./Todo";
import Login from "./Login";
import Signup from "./Signup";

function App() {

    // const [hello, setHello] = useState('')
    //
    // useEffect(() => {
    //     axios.get('/api/hello')
    //         .then(response => setHello(response.data))
    //         .catch(error => console.log(error))
    // }, []);
    //
    // return (
    //     <div>
    //         백엔드에서 가져온 데이터입니다 : {hello}
    //     </div>
    // );

  return (
    <div className="App">
      <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path="/todo" element={<Todo/>}/>
      <Route path="/login" element={<Login/>}/>
      <Route path="/signup" element={<Signup/>}/>
      </Routes>

    </div>
  );
}

export default App;
