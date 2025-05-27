import React, {useState} from 'react';
import styles from './AddItemModal.module.scss';

const AddItemModal = (props) => {
    const [newValue, setNewValue] = useState('');
    const [newPhoneValue, setNewPhoneValue] = useState('');

    const createRequest = async () => {
        let payload = {};

        switch (props.title) {
            case "친구":
                // console.log(1);
                payload = {
                    name: newValue,
                    phone: newPhoneValue,
                };
                break;
            case "선물":
                payload = {
                    name: newValue
                };
                break;
        }
        try {
            const res = await fetch("http://localhost:8080/api/person/new", {
                method: "POST",
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(payload),
            });

            if (res.status === 200) {
                console.log("person add successfully!");
            } else {
                console.log("error: " + res.status);
            }
        } catch (error) {
            console.log(error);
        }
    }


return (
    <div className={styles.container}>
        <h3>{props.title} 추가</h3>

        <input placeholder="name" type="text" onChange={(e) => setNewValue(e.target.value)}/>
        {
            props.title === "친구" ? (<input placeholder="phone" type="text" onChange={(e) => {
                setNewPhoneValue(e.target.value)
            }}/>) : ""
        }
        <button onClick={createRequest}>등록</button>

    </div>
);
}
;

export default AddItemModal;