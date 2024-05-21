'use client'

import './styles.css'
import {Chart} from 'react-google-charts'
import { useState } from 'react'

export default function Overview(){

    const [chartOptions, setChartOptions] = useState({
        chartArea: {width: "100%", height : "75%"},
        legend: {position: "bottom"},
        curveType: "function",
    })

    const [chartData, setChartData] = useState([
        ["ColumnName", "Valores", {role: "style"}],
        ["Receita", 10000, "blue"],
        ["Despesa", 1000, "red"],
        ["Lucro", 9000, "green"]
    ])


    return (
        <div className={'main-overview'}>
        <div className={'infos'}>
            <div className={'info'}>
                <h3>OCUPAÇÃO TOTAL</h3>
                <h1>0</h1>
                <p className={'p-info'}>TOTAL: 0</p>
            </div>
            <div className={'info'}>
                <h3>O.S PAGAS</h3>
                <h1>0</h1>
                <p className={'p-info'}>TOTAL: R$ 0,00</p>
            </div>
            <div className={'info'}>
                <h3>O.S CANCELADAS</h3>
                <h1>0</h1>
                <p className={'p-info'}>TOTAL: R$ 0</p>
            </div>
        </div>
        <div className={'chart'}>
            <Chart
                chartType="ColumnChart"
                data={chartData}
                width="100%"
                height="100%"
            />
        </div>
    </div>
    )

}