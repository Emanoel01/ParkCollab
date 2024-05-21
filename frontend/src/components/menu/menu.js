'use client'
import './styles.css'

export default function Menu({functionVG, functionOp, functionCl}){

    const changeStyleOfClickedButton = (currentId) => {

        const allButtons = document.getElementsByClassName('button-option');
        for(let i=0;i< allButtons.length; i++ ){
            allButtons[i].setAttribute('style', 'background-color: black')
        }

        const currentButton = document.getElementById(currentId);
        currentButton.style.backgroundColor = 'gray';
        currentButton.style.borderRadius = '10px'; 
        
    }

    return (
        <div className={'main-div-menu'}>
            <div className={'div-logo'}></div>
            <div className={'options'}>
                <div className={'option'}>
                    <button className={'button-option'} id={'buttonVisaoGeral'} onClick={
                        () => {changeStyleOfClickedButton('buttonVisaoGeral'), functionVG()}}>visão geral</button>
                </div>
                <div className={'option'}>
                    <button className={'button-option'} id={'buttonOperacional'} onClick={
                        () => {changeStyleOfClickedButton('buttonOperacional'), functionOp()}}>operacional</button>
                </div>
                <div className={'option'}>
                    <button className={'button-option'} id={'buttonClientes'} onClick={
                        () => {changeStyleOfClickedButton('buttonClientes'), functionCl()}}>clientes</button>
                </div>
            </div>
        </div>

    );
}