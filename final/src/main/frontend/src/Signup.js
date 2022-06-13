import React from "react";
import styled from "styled-components";

import Header from "./Header"

const Signup = () => {
    return (
        <>
        <Header/>
        <Box>
        <h1>회원가입</h1>
        <Ul>
            <Li>
                <Text>이름</Text>
                <Input></Input>
            </Li>
            <Li>
                <Text>아이디</Text>
                <Input></Input>
            </Li>
            <Li>
                <Text>비밀번호</Text>
                <Input></Input>
            </Li>
            <Li>
                <Text>비밀번호 재확인</Text>
                <Input></Input>
            </Li>
        </Ul>

        <Btnsign>회원가입</Btnsign>
    </Box>
    </>
    )
}

const Box = styled.div`
display: flex;
flex-direction: column;
align-items: center;
margin-top: 50px;
`;

const Text = styled.span`

`; 

const Input = styled.input`

`;

const Ul = styled.ul`
display: flex;
flex-direction: column;
list-style-type: none;
margin-left: -80px;
`;

const Li = styled.li`
display: flex;
justify-content: flex-end;
margin-bottom: 10px;
`;

const Btnlog = styled.button`

`;

const Btnsign = styled.button`

`;

export default Signup;