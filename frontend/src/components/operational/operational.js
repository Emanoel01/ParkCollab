'use client'

import './styles.css'


export default function Operational () {
    return (
        <div className={'main-operational'}>
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
        </div>
    )
}