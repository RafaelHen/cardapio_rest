/* eslint-disable react-hooks/exhaustive-deps */
import { useEffect, useState } from "react"
import { useFoodDataMutate } from "../../hooks/useFoodDataMutate"
import { FoodData } from "../../interface/FoodData"
import "./create-modal.css"

interface InputProps {
    label: string,
    value: string | number,
    updateValue(value: unknown): void
}

const Input = ({ label, value, updateValue} : InputProps) => {
    return (
        <>
            <label>{label}</label>
            <input value={value} onChange={e => updateValue(e.target.value)}></input>
        </>
        )
}

interface ModalProps {
    closeModal(): void
}

// eslint-disable-next-line @typescript-eslint/no-unused-vars
export function CreateModal ( { closeModal }:ModalProps) {
    const [title, setTitle] = useState("");
    const [price, setPrice] = useState(0);
    const [image, setimage] = useState("");
    const  {mutate, isSuccess}  = useFoodDataMutate();

    const submit = () => {
        const foodData: FoodData ={
            title,
            price,
            image
        }
        mutate(foodData);
    }

    useEffect(() => {
        if(!isSuccess) return closeModal()
    }, [isSuccess])

        return (
        <div className="modal-overlay">
            <div className="modal-body">
             <h2>Cadastre um novo item!</h2>
             <form className = "input-container">
                <Input label="title" value={title} updateValue={setTitle} ></Input>
                <Input label="price" value={price} updateValue={setPrice}></Input>
                <Input label="image" value={image} updateValue={setimage}></Input>
             </form>
             <button onClick={submit} className="btn-secondary">Salvar</button>
            </div>
        </div>
        )
    }

 
