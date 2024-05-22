'use client'

import "./styles.css"
import {useState} from 'react'

export default function ForgotPassword(){

    const [step, setStep] = useState("1")

    return (
        <div className={"main-forgot-password"}>
            { step == "1" ? 
            <div className={"content-forgot-password"}>
                <h2>Digite o email para envio do código</h2>
                <input type="email" placeholder="EMAIL"/>
                <br/>
                <label>Será enviado para o email um código para reset de senha</label>
                <br/>
                <button>Enviar código</button>
                <br/>
                <button onClick={() => setStep("2")}>Já tenho o código</button>
                <br/>
                <button onClick={() => {window.location.href="/"}}>Cancelar</button>
            </div>:

            <div className={"content-forgot-password"}>
                <h2>Confirme o código para inserir a nova senha</h2>
                <input type="text" placeholder="CÓDIGO"/>
                <br/>
                <input type="password" placeholder="DIGITE A NOVA SENHA"/>
                <br/>
                <input type="password" placeholder="CONFIRME A NOVA SENHA"/>
                <br/>
                <button>Atualizar senha</button>
                <br/>
                <button onClick={() => setStep("1")}>Não tenho o código</button>
                <br/>
                <button onClick={() => {window.location.href="/"}}>Cancelar</button>
            </div>
        }
        </div>
    );
}