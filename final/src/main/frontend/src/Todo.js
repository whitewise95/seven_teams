import React from "react";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";

import Header from "./Header"

const Home = (props) => {

  const navigate = useNavigate();

  return (
    <>
    <Header/>
    <Container>
      <h1>작성하기</h1>
      <Box>
        <p>제목</p>
        <input type="text" />
        <p>내용</p>
        <input className="content" type="text" />
      </Box>
      <button
        onClick={() => {
          navigate("/");
        }}
      >
        작성하기
      </button>
      <button
        onClick={() => {
          navigate("/");
        }}
      >
        취소
      </button>
    </Container>
    </>
  );
};

const Container = styled.div`
  width: 800px;
  height: 600px;
  margin: 20px auto;
  padding: 16px;
  border: 1px solid;
  text-align: center; 

  & h1 {
  }

  & button {
    width: 300px;
    height: 30px;
    margin: 20px;
  }
`;

const Box = styled.div`
  width: 600px;
  height: 350px;
  margin: auto;
  padding: 16px;
  border: 1px solid;
  & p { 
    text-align: left; 

  }
  & input {
    width: 590px;
    display: flex;
    flex-direction: column;
    list-style-type: none;
  }

  .content {
    height: 150px;
  }
  
`;

export default Home;
