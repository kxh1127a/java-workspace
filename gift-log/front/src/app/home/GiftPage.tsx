'use client';

import React, {useEffect} from 'react';
import FriendSelect from "@/src/components/FriendSelect";
import GiftSelect from "@/src/components/GiftSelect";

import {setFriends} from "../../store/friendSlice";
import {setGifts} from "@/src/store/giftSlice";
// import {useAppDispatch} from "../../store/hooks";
import {useDispatch, useSelector} from "react-redux";
// import {AppDispatch} from "../../store/store";


const GiftPage = (props) => {
    const { giftData, personData } = props;
    // console.log(giftData, personData);
    const dispatch = useDispatch();

    useEffect (()=>{
       // console.log(giftData, personData);
       dispatch(setFriends(personData));
       dispatch(setGifts(giftData));

    }, [giftData, personData, dispatch]);

    // @ts-ignore
    const temp = useSelector(state => state.friends);
    // console.log(temp);




    return (
        <main className="min-h-screen flex flex-col items-center justify-center p-6 bg-gray-50">
            <h1 className="text-2xl font-bold mb-6">🎁 선물 기록</h1>

            <div className="w-full max-w-md space-y-4">
                <FriendSelect />
                <GiftSelect />
                <button
                    className="w-full py-2 bg-blue-600 text-white rounded hover:bg-blue-700 transition"
                >
                    기록 저장
                </button>
            </div>
        </main>
    );
};

export default GiftPage;