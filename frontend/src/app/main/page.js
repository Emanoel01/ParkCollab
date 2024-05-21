'use client'
import Menu from '../../components/menu/menu'
import Overview from '@/components/overview/overview';
import Operational from '@/components/operational/operational';
import './styles.css'
import { useState } from "react";

export default function Main(){

    const [visaoGeral, setVisaoGeral] = useState(true)
    const [operacial, setOperacional] = useState(false)
    const [clientes, setClientes] = useState(false)

    const funcVisaoGeral = () =>{
        setVisaoGeral(true)
        setOperacional(false)
        setClientes(false)
    }

    const funcOperacional = () => {
        setVisaoGeral(false)
        setOperacional(true)
        setClientes(false)
    }

    const funcClientes = () => {
        setVisaoGeral(false)
        setOperacional(false)
        setClientes(true)
    }

    return (
        <div className={"main"}>
            <Menu 
                functionOp={funcOperacional}
                functionCl={funcClientes}
                functionVG={funcVisaoGeral}
            />
            {visaoGeral ? 
            <Overview/>
            : false    
            }

            {
                operacial ?
                <Operational/>
                : false
            }
        </div>
    )
}