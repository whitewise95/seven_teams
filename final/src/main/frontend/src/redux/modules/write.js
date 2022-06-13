// write.js
import {
  collection,
  getDocs,
  addDoc,
  updateDoc,
  doc,
  deleteDoc,
} from "firebase/firestore";

// Actions
const LOAD = "write/LOAD";
const ADD = "write/ADD";

const initialState = {
  list: [
    {
      todo: "포기하지말고 항해하라!",
      checkComplete: "false",
      goalDay: "220616",
    },
    {
      todo: "밥은 먹고 코드 쓰시나",
      checkComplete: "true",
      goalDay: "220616",
    },
    
  ],
};

// Action Creators
export function loadWrite(write_list) {
  return { type: LOAD, write_list };
}

export function addWrite(write) {
  return { type: ADD, write };
}

// 미들웨어 가져오기
export const loadWriteFB = () => {
  return async function (dispatch) {
    const write_data = await getDocs(collection(db, "write"));
    let write_list = [];
    // console.log(write_data);
    // firebase 콜렉션 db에서 write를 가져올거야, 콘솔확인
    // 빈 배열 하나 만들어주고

    write_data.forEach((b) => {
      write_list.push({ id: b.id, ...b.data() });
      // write_data를 하나씩 배열 데이터로 만들어줍시다!
      // 콘솔로 확인해요!
      // console.log(b.id, b.data());
      // write_list 빈 배열에 하나씩 넣어줘
    });

    dispatch(loadWrite(write_list));
    // 잘 만들어졌는 지 리스트도 확인해봐요! :)
    // console.log(write_list);
    // loadwrite(write_list) = Load Type에 FB 데이터를 디스패치 보내
  };
};

// 미들웨어 추가하기
export const addWriteFB = (write) => {
  return async function (dispatch) {
    console.log(write);
    const docRef = await addDoc(collection(db, "write"), write);
    const write_data = { id: docRef.id, ...write };
    dispatch(addWrite(write_data));
    // 추가하는것도 비동기 작업이다 그래서 async,await로 차례대로하자
    // await =  addDoc 작업 끝날때까지 기다렸다가 답주고가
    // addDoc((db,콜렉션이름, 추가할데이터 함수로 받아온 write))
  };
};


// Reducer
export default function reducer(state = initialState, action = {}) {
  switch (action.type) {
    case "write/LOAD": {
      return { list: action.write_list };
    }
    // 리듀서를 내보낼건데 state= 값이 없으면 init초기값을 보여줘
    // 액션 타입을 case로 swith 해보자
    // 미들웨어에서 디스패치한 wirte_list를
    // list에 넣어서 보여줘

    case "write/ADD": {
      console.log("이제 값을 넣을꺼야!");
      const new_write_list = [...state.list, action.write];
      return { ...state, list: new_write_list };
    }
    // console.log({list: new_write_list});
    // console.log(new_Write_list);
    // 액션에 createWrite이 디스패치되어 case를 switch했다,
    // 리턴값은 리스트에 새로운 버킷리스트를 넣어줄거야

    default:
      return state;
  }
}
