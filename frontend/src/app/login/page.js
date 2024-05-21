'use client'
import "./style.css"
import { useState } from "react";
import { useRouter } from "next/navigation";

export default function Login(){

    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const router = useRouter();

    function login(){   
        router.push("/main");
    }

    return (
        <div className={'mainDiv'} >

            <div className={'middle-container'}>
                <div className={'middle-container-child'}>
                    <h1 className={'logo'}>P</h1>
                </div>
                <div className={'middle-container-child'}>
                    <input type='text' className={'input-login input-email'} placeholder='EMAIL' onKeyUp={e => setEmail(e.target.value)}></input>
                    <input type='text' className={'input-login input-senha'} placeholder='SENHA' onKeyUp={e => setSenha(e.target.value)}></input>
                </div>
                <div className={'middle-container-child'}>
                    <button className={'button-login'} onClick={() => login()}>ENTRAR</button>
                </div>
            </div>

        </div>
    )
}