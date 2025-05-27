'use client';

import {useSelector} from "react-redux";
import {RootState} from "@/src/store/store";
import AddItemModal from "@/src/components/AddItemModal";
import {useState} from "react";

export default function GiftSelect() {
    const [showModal, setShowModal] = useState(false);

    const gifts = useSelector((state: RootState) => state.gifts);
    console.log(gifts);
    return (
        <div>
            <label className="block mb-1 font-medium">🎁 선물 목록</label>
            <select className="w-full border rounded px-3 py-2">
                {
                    gifts.map((gift) => (
                        <option key={gift.id} value={gift.id}>{gift.name}</option>
                    ))
                }
            </select>

            <button onClick={()=>setShowModal(true)}>추가</button>

            {
                showModal && (
                    <AddItemModal title="선물"></AddItemModal>
                )
            }
        </div>
    );
}
