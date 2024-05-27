'use client'

import './styles.css'
import {useState} from 'react'


export default function Operational () {

    const [option, setOption] = useState("3");

    return (
        <div className={'main-operational'}>
            <div className={'main-operational-options'}>
                <button onClick={() => {setOption("1")}}>Listar Todos</button>
                <button onClick={() => {setOption("2")}}>Listar Diaria</button>
                <button onClick={() => {setOption("3")}}>Cadastrar Carro</button>
                <button onClick={() => {setOption("4")}}>Indicar</button>
            </div>
                {
                option == "1" ? "":
                option == "2"? "":
                option == "3" ?
                <>
                    <div className={'car-infos'}>
                        <div className={'car-info'}>
                            <p>PLACA</p>
                            <input type="text" className={"input-car-info"} placeholder="XXXXXXX"/>
                        </div>
                        <div className={'car-info'}>
                            <p>MARCA/MODELO</p>
                            <input type="text" className={"input-car-info"} placeholder="XXXXXXX/XXXXX"/>
                        </div>
                        <div className={'car-info'}>
                            <p>COR</p>
                            <input type="text" className={"input-car-info"} placeholder="XXXXXXX/XXXXX"/>
                        </div>
                    </div>
                   <input type="text" className={'observacao'} placeholder="Observação"/>
                   <button className={'button-operational'} onClick={ () => alert("Operacional")}>ENTRADA</button>
                                </>:
                    ""
                }
        </div>
    )
}