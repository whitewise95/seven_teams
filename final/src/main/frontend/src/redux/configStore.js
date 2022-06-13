//configStore.js
//리듀서들을 묶어서 createStore에 넣어줌
import {createStore, combineReducers, applyMiddleware} from "redux";
import thunk from "redux-thunk";
import write from "./modules/write";

// root 리듀서를 만들어줍니다.
// 나중에 리듀서를 여러개 만들게 되면 여기에 하나씩 추가해주는 거예요!
const middlewares = [thunk];
const rootReducer = combineReducers({ write });
const enhancer = applyMiddleware(...middlewares);

// 스토어를 만듭니다.
const store = createStore(rootReducer, enhancer);

export default store;

//reducer를 뭉친거 rootReducer로 store를 만들었다
//스토어 데이터를 사용하고 싶어서 사용한다.