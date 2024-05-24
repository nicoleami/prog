const api = 'http://localhost:8080/times'
var lugarTimes = document.getElementById('lista')
const lista = fetch(api)
    .then(response => response.json())
    .then(data => {
        for (var i = 0; i < data.length; i++) {
            lugarTimes.innerHTML += `
                <td>${data[i].id}</td>
                <td>${data[i].nome}</td>
                <td>${data[i].cidade}</td>
                <td>${data[i].estado}</td>
                <td>${data[i].dataFundacao}</td>
                <td class="td1">
                    <li class="list-group-item"><a href="edita_time.html" class="btn btn-primary">Editar</a></li>
                    <li class="list-group-item"><button class="btn btn-danger" type="button" onclick="deletarTime(${data[i].id})">Excluir</button></li>
                </td>
            `
        }
    });

async function deletarTime(id) {
    const URL = `http://localhost:8080/times/${id}`;
    const deleteRequest = {
        method: 'DELETE'
    };
    fetch(URL, deleteRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })

    location.reload(true);
}

const txtId = document.getElementById('id')
const txtNome = document.getElementById('nome')
const txtCidade = document.getElementById('cidade')
const txtEstado = document.getElementById('estado')
const txtFund = document.getElementById('fund')

function criarTime() {
    const dadosTime = {
        'id': txtId.value,
        'nome': txtNome.value,
        'cidade': txtCidade.value,
        'estado': txtEstado.value,
        'dataFundacao': txtFund.value,
    }
    console.log(dadosTime)
    asyncCriarTime(dadosTime);
}

function asyncCriarTime(dadosTime) {
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosTime),
        headers: { 'Content-type': 'application/json' }
    };

    fetch(api, postRequest)
        .then(response => response.json())

}


function atualizarTime() {
    const dadosTime = {
        'id': txtId.value,
        'nome': txtNome.value,
        'cidade': txtCidade.value,
        'estado': txtEstado.value,
        'dataFundacao': txtFund.value,
    }
    asyncAtualizarTime(dadosTime);
    console.log(dadosTime)
}

function asyncAtualizarTime(dadosTime) {
    const URL = `http://localhost:8080/times/${dadosTime.id}`
    const postRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosTime),
        headers: { 'Content-type': 'application/json' }
    };

    fetch(URL, postRequest)
        .then(response => response.json())

}

//TODO: PESQUISAR POR ID

function pesquisarTimeId(event) {
    event.preventDefault();
    id = txtId.value
    asyncPesquisarTimeId(id);
}

async function asyncPesquisarTimeId(id) {
    const getID = `http://localhost:8080/times/${id}`

    fetch(getID)
        .then(resposta => resposta.json())
        .then(data => {
            console.log(data)
            lugarTimes.innerHTML = `
            <td>${data.id}</td>
            <td>${data.nome}</td>
            <td>${data.cidade}</td>
            <td>${data.estado}</td>
            <td>${data.dataFundacao}</td>
            <td class="td1">
                <li class="list-group-item"><a href="edita_time.html" class="btn btn-primary">Editar</a></li>
                <li class="list-group-item"><button class="btn btn-danger" type="button" onclick="deletarTime(${data.id})">Excluir</button></li>
            </td>`
        }

        )


}
const formulario = document.getElementById("formulario");
formulario.addEventListener("submit", pesquisarTimeId);

const formulario2 = document.getElementById("formulario2");
formulario2.addEventListener("submit", pesquisarTimeNome);

function pesquisarTimeNome(event) {
    event.preventDefault();
    nome = txtNome.value

    asyncPesquisarTimeNome(nome);
}

async function asyncPesquisarTimeNome(nome) {
    const getNome = `http://localhost:8080/times/pesquisa?nome=${nome}`

    fetch(getNome)
        .then(resposta => resposta.json())
        .then(data => {
            console.log(data[0])
            for (let i = 0; i < data.length; i++) {
                lugarTimes.innerHTML = `
                <td>${data[i].id}</td>
                <td>${data[i].nome}</td>
                <td>${data[i].cidade}</td>
                <td>${data[i].estado}</td>
                <td>${data[i].dataFundacao}</td>
                <td class="td1">
                    <li class="list-group-item"><a href="edita_time.html" class="btn btn-primary">Editar</a></li>
                    <li class="list-group-item"><button class="btn btn-danger" type="button" onclick="deletarTime(${data[i].id})">Excluir</button></li>
                </td>`
            }
        }
        )
}
