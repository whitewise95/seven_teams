import React from "react"
import styled from "styled-components";
import HomeIcon from "@material-ui/icons/Home";
import { useNavigate } from "react-router-dom";

const Header = () => {
    const Navigate = useNavigate();

    
    return (
        <Head>
            <HomeIcon  style={{margin: "0 0 0 25px"}}
              margin="0px"
              cursor="pointer"
              onClick={() => {
                Navigate(`/`)
            }}
            >
            </HomeIcon>
            <Blank></Blank>
            <Sign 
            onClick={() => {
                Navigate(`/signup`)
            }}
            >회원가입</Sign>
            <Log
            onClick={() => {
                Navigate(`/login`)
            }}
            >로그인</Log>
        </Head>
    );
};

const Head = styled.div`
    height: 72px;
    width: 1296px;
    background: white;
    margin: 0 auto;
    display: flex;
    align-items: center;
`

const Sign = styled.button`
    height: 50px;
    width: 100px;
    background: none;
    display: flex;
    justify-content : center;
    align-items: center;
    font-size: 20px;
    border: none;
    font-weight:bolder ;
    &:hover {
        color: gray;
    }
`;
const Blank = styled.div`
    height: 50px;
    width: 1074px;
`

const Log = styled.button`
    height: 50px;
    width: 100px;
    background: none;
    display: flex;
    justify-content : center;
    align-items: center;
    font-size: 20px;
    border: none;
    font-weight:bolder ;
    &:hover {
        color: gray;
    }
`;


export default Header;