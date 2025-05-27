'use client';

import { useSelector } from "react-redux";
import { RootState } from '@/src/store/store'; // RootState를 직접 정의한 경우
import AddItemModal from "@/src/components/AddItemModal";
import {useState} from "react";

export default function FriendSelect() {
    const [showModal, setShowModal] = useState(false);
    // @ts-ignore 제거를 위해 state 타입 명시
    const friends = useSelector((state: RootState) => state.friends);

    return (
        <div>
            <label className="block mb-1 font-medium">👤 친구 이름</label>
            <select className="w-full border rounded px-3 py-2">
                {friends.map((friend, index) => (
                    <option key={index} value={friend.nameInfo}>
                        {friend.nameInfo}
                    </option>
                ))}
            </select>
            <button onClick={()=>setShowModal(true)}>추가</button>

            {
                showModal && (
                    <AddItemModal title="친구"></AddItemModal>
                )
            }
        </div>
    );
}
