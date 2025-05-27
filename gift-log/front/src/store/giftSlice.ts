import {Gift} from "@/src/types";
import {createSlice} from "@reduxjs/toolkit";

const initialState: Gift[] = [];

const giftSlice = createSlice({
    name: "gifts",
    initialState,
    reducers: {
        setGifts : (state, action) => { return action.payload },
        addGift : (state, action) => { state.push(action.payload); },
    }
})

export const { setGifts, addGift } = giftSlice.actions;
export default giftSlice.reducer;