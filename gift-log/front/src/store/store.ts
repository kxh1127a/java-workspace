import { configureStore } from "@reduxjs/toolkit";
import friendReducers from "./friendSlice";
import giftReducers from "./giftSlice";

export const store = configureStore({
    reducer: {
        friends: friendReducers,
        gifts: giftReducers,
    }
})

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;