import React from "react";
import styled from "styled-components";
import { useNavigate } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";

import { loadWriteFB, addWriteFB } from "./redux/modules/write";
import { loadTodo } from "./redux/modules/axios";

import axios from "axios";
import Header from "./Header";

const Home = (props) => {
  const navigate = useNavigate();
  const dispatch = useDispatch();

  const write_ref = React.useRef(null);

  React.useEffect(() => {
    dispatch(loadTodo());
  }, []);
  // 렌더링 될 때마다 실행 됨
  // useEffect가 middleware를 실행시켜줌
  // useEffect 안에 [value] =  화면에 value값이 변경될 때 실행
  // 빈칸은 화면에 첫 렌더링이 될 때 실행

  const addWriteList = () => {
    dispatch(
      addWriteFB({
        write: write_ref.current?.value,
        checkComplete: false,
      })
    );
  };
  const write_data = useSelector((state) => state.write);
  // FB 콜렉션 write 불러오기
  // console.log(write_data);
  // 리듀서된 state를 가져와서 write_data에 넣어줘

  return (
    <>
      <Header />

      <Container>
        <Date>
          <button>◀</button>
          <p>{write_data.list[0].goalDay}</p>
          <button>▶</button>
        </Date>

        <Box>
          {write_data.list.map((list, index) => {
            return (
              <Todo key={index}>
                <span>{list.todo}</span>
                <button>완료</button>
                <button>삭제</button>
                <button>수정</button>
              </Todo>
            );
          })}
        </Box>
        <input
          type="text"
          ref={write_ref}
          placeholder="  목표를 입력해주세요"
        />
        <button
          className="Plus"
          onClick={() => {
            addWriteList();
            // navigate("/Todo");
          }}
        >
          +
        </button>
      </Container>
    </>
  );
};

const Container = styled.div`
  width: 800px;
  height: 650px;
  margin: 20px auto;
  padding: 16px;
  border: 1px solid;
  & div {
    margin: 20px auto;
  }

  & input {
    width: 625px;
    height: 30px;
    margin: 20px auto;
    justify-content: center;
    align-items: center;
    display: flex;
  }
  .Plus {
    width: 635px;
    height: 50px;
    margin: auto;
    justify-content: center;
    align-items: center;
    display: flex;
  }
`;

const Date = styled.div`
  width: 600px;
  height: 30px;
  margin: auto;
  padding: 16px;
  border: 1px solid;
  display: flex;
  & p {
    margin: auto;
  }
`;

const Box = styled.div`
  width: 600px;
  height: 350px;
  margin: auto;
  padding: 16px;
  border: 1px solid;
  display: column;
  & p {
    margin: auto;
  }
`;

const Todo = styled.div`
  width: 580px;
  height: 30px;
  padding: 10px;
  border: 1px solid;

  & p {
  }
  & button {
    float: right;
    margin: 3px;
  }
`;

export default Home;
