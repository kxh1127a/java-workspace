import { createSlice } from "@reduxjs/toolkit";
import { Friend } from '@/src/types';

const initialState: Friend[] = [];

const friendSlice = createSlice({
    name: 'friends',
    initialState,
    reducers: {
        setFriends : (_, action) => { return action.payload },
        addFriend: (state, action) => { state.push(action.payload); },
    }
});

export const { setFriends, addFriend } = friendSlice.actions;
export default friendSlice.reducer;