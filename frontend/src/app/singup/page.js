'use client'

import "./styles.css"
import axios from "axios";
import {useState} from "react"

export default function SingUp() {

    const [type, setType] = useState("1");
    const [logradouro, setLogradouro] = useState("")
    const [bairro, setBairro] = useState("")
    const [cidade, setCidade] = useState("")
    const [uf, setUf] = useState("")
    const [cep, setCep] = useState("")
    const [nomeEstacionamento, setNomeEstacionamento] = useState("")
    const [cpfDono, setCpfDono] = useState("")
    const [nomeDono, setNomeDono] = useState("")
    const [qntdVagas, setQntdVagas] = useState("")
    const [senhaEstacionamento, setSenhaEstacionamento] = useState("")
    const [nomeFuncionario, setNomeFuncionario] = useState("")
    const [cpfFuncionario, setCpfFuncionario] = useState("")
    const [cnpjFiliado, setCnpjFiliado] = useState("")
    const [emailFuncionario, setEmailFuncionario] = useState("")
    const [senhaFuncionario, setSenhaFuncionario] = useState("")
    const [confirmarSenhaFuncionario, setConfirmarSenhaFuncionario] = useState("")

    const onChangeLogradouro = (event) => {
        setLogradouro(event.target.value)
    }
    const onChangeBairro = (event) => {
        setBairro(event.target.value)
    }
    const onChangeCidade = (event) => {
        setCidade(event.target.value)
    }
    const onChangeUf = (event) => {
        setUf(event.target.value)
    }

    const onChangeNomeFuncionario = (event) => { setNomeFuncionario(event.target.value)}
    const onChangeCpfFuncionario = (event) => { setCpfFuncionario(event.target.value)}
    const onChangeCnpjFiliado = (event) =>  {setCnpjFiliado(event.target.value)}
    const onChangeEmailFuncionario = (event) => { setEmailFuncionario(event.target.value)}
    const onChangeSenhaFuncionario = (event) =>  {setSenhaFuncionario(event.target.value) };
    const onChangeConfirmarSenhaFuncionario = (event) =>  {setConfirmarSenhaFuncionario(event.target.value) };

    const getAddress = (cepParam) => {
        if(cepParam.length == 8){
            axios.get(`https://viacep.com.br/ws/${cepParam}/json`)
            .then((response) => {
                console.log({response})
                setCep(cepParam)
                setLogradouro(response.data.logradouro);
                setBairro(response.data.bairro)
                setCidade(response.data.localidade)
                setUf(response.data.uf)
            })
            .catch(e => {

            })
        }
    }


    const clearFields = () => {
        setLogradouro("")
        setBairro("")
        setCidade("")
        setUf("")
        setCep("")
        setNomeEstacionamento("")
        setCpfDono("")
        setNomeDono("")
        setQntdVagas("")
        setSenhaEstacionamento("")
    }

    return (
        <div className={"main-singup"}>

            <div className={"child-singup"}>
            <label>Tipo de Cadastro</label>
                <select name="sing-types" id="singup-type" onChange={(e) => {clearFields(); setType(e.currentTarget.value)}} value={type}>
                    <option value="1">Estacionamento</option>
                    <option value="2">Funcionario</option>
                </select>

                {type == "1" ?  
                
                    <div className={"child-singup-type-1"}>
                        <h2>Estacionamento</h2>
                        <input type="text" placeholder="CNPJ" onKeyUp={() => {}}/>
                        <input type="text" placeholder="NOME" onKeyUp={() => {}}/>
                        <input type="number" placeholder="CEP" onChange={(e) => getAddress(e.target.value)}/>
                        <input type="text" placeholder="LOGRADOURO" value={logradouro} onChange={onChangeLogradouro}/>
                        <input type="text" placeholder="BAIRRO" value={bairro} onChange={onChangeBairro}/>
                        <input type="text" placeholder="CIDADE" value={cidade} onChange={onChangeCidade}/>
                        <input type="text" placeholder="UF" value={uf} onChange={onChangeUf}/>
                        <input type="text" placeholder="NUMERO" onKeyUp={() => {}}/>
                        <input type="text" placeholder="CPF DONO" onKeyUp={() => {}}/>
                        <input type="text" placeholder="NOME DONO" onKeyUp={() => {}}/>
                        <input type="text" placeholder="EMAIL" onKeyUp={() => {}}/>
                        <input type="number" placeholder="QUANTIDADE DE VAGAS TOTAIS" onKeyUp={() => {}}/>
                        <input type="password" placeholder="SENHA" onKeyUp={() => {}}/>
                        <input type="password" placeholder="CONFIRMAR SENHA" onKeyUp={() => {}}/>
                    </div>:

                    <div className={"child-singup-type-2"}>
                        <h2>Funcionario</h2>
                        <input type="text" placeholder="NOME" value={nomeFuncionario} onChange={onChangeNomeFuncionario}/>
                        <input type="text" placeholder="CPF" value={cpfFuncionario} onChange={onChangeCpfFuncionario}/>
                        <input type="text" placeholder="CNPJ ESTACIONAMENTO" value={cnpjFiliado} onChange={onChangeCnpjFiliado}/>
                        <input type="text" placeholder="EMAIL" value={emailFuncionario} onChange={onChangeEmailFuncionario}/>
                        <input type="password" placeholder="SENHA" value={senhaFuncionario} onChange={onChangeSenhaFuncionario}/>
                        <input type="password" placeholder="CONFIRMAR SENHA" value={confirmarSenhaFuncionario} onChange={onChangeConfirmarSenhaFuncionario}/>
                    </div>
                }

                <button>Cadastrar</button>
                <button onClick = {() => {
                    window.location = "/"
                }}> Cancelar</button>
            </div>

        </div>
    );
}