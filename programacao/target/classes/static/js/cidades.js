const api = 'http://localhost:8080/cidades'
var lugarCidades = document.getElementById('lista')
const lista = fetch(api)
    .then(response => response.json())
    .then(data => {
        for (var i = 0; i < data.length; i++) {
            lugarCidades.innerHTML += `
                <td>${data[i].id}</td>
                <td>${data[i].nome}</td>
                <td>${data[i].estado}</td>
                <td>${data[i].pais}</td>
                <td>${data[i].populacao}</td>
                <td class="td1">
                    <li class="list-group-item"><a href="edita_cidade.html" class="btn btn-primary">Editar</a></li>
                    <li class="list-group-item"><button class="btn btn-danger" type="button" onclick="deletarCidade(${data[i].id})">Excluir</button></li>
                </td>
            `
        }
    });

async function deletarCidade(id) {
    const URL = `http://localhost:8080/cidades/${id}`;
    const deleteRequest = {
        method: 'DELETE'
    };
    fetch(URL, deleteRequest)
        .then(resposta => { if (!resposta.ok) throw Error(resposta.status); return resposta; })


    location.reload(true);
}

const txtId = document.getElementById('id')
const txtNome = document.getElementById('nome')
const txtEstado = document.getElementById('estado')
const txtPais = document.getElementById('pais')
const txtPopulacao = document.getElementById('populacao')

function criarCidade() {
    const dadosCidade = {
        'id': txtId.value,
        'nome': txtNome.value,
        'estado': txtEstado.value,
        'pais': txtPais.value,
        'populacao': txtPopulacao.value,
    }
    console.log(dadosCidade)
    asyncCriarCidade(dadosCidade);
}

function asyncCriarCidade(dadosCidade) {
    const postRequest = {
        method: 'POST',
        body: JSON.stringify(dadosCidade),
        headers: { 'Content-type': 'application/json' }
    };

    fetch(api, postRequest)
        .then(response => response.json())

}


function atualizarCidade() {
    const dadosCidade = {
        'id': txtId.value,
        'nome': txtNome.value,
        'estado': txtEstado.value,
        'pais': txtPais.value,
        'populacao': txtPopulacao.value,
    }
    asyncAtualizarCidade(dadosCidade);
    console.log(dadosCidade)
}

function asyncAtualizarCidade(dadosCidade) {
    const URL = `http://localhost:8080/cidades/${dadosCidade.id}`
    const postRequest = {
        method: 'PUT',
        body: JSON.stringify(dadosCidade),
        headers: { 'Content-type': 'application/json' }
    };

    fetch(URL, postRequest)
        .then(response => response.json())

}


function pesquisarCidadeId(event) {
    event.preventDefault();
    id = txtId.value
    asyncPesquisarCidadeId(id);
}
async function asyncPesquisarCidadeId(id) {
    const getID = `http://localhost:8080/cidades/${id}`

    fetch(getID)
        .then(resposta => resposta.json())
        .then(data => {
            console.log(data)
            lugarCidades.innerHTML = `
            <td class="td">${data.id}</td>
            <td >${data.nome}</td>
            <td>${data.estado}</td>
            <td>${data.pais}</td>
            <td>${data.populacao}</td>
            <td class="td1">
                <li class="list-group-item"><a href="edita_cidade.html" class="btn btn-primary">Editar</a></li>
                <li class="list-group-item"><button class="btn btn-danger" type="button" onclick="deletarCidade(${data.id})">Excluir</button></li>
            </td>`
        }

        )


}

const formulario = document.getElementById("formulario");
formulario.addEventListener("submit", pesquisarCidadeId);


const formulario2 = document.getElementById("formulario2");
formulario2.addEventListener("submit", pesquisarCidadeNome);

function pesquisarCidadeNome(event) {
    event.preventDefault();
    nome = txtNome.value

    asyncPesquisarCidadeNome(nome);
}

async function asyncPesquisarCidadeNome(nome) {
    const getNome = `http://localhost:8080/cidades/pesquisa?nome=${nome}`

    fetch(getNome)
        .then(resposta => resposta.json())
        .then(data => {
            console.log(data[0])
            for (let i = 0; i < data.length; i++) {
                lugarCidades.innerHTML = `
                <td class="td">${data[i].id}</td>
                <td >${data[i].nome}</td>
                <td>${data[i].estado}</td>
                <td>${data[i].pais}</td>
                <td>${data[i].populacao}</td>
                <td class="td1">
                    <li class="list-group-item"><a href="edita_cidade.html" class="btn btn-primary">Editar</a></li>
                    <li class="list-group-item"><button class="btn btn-danger" type="button" onclick="deletarCidade(${data[i].id})">Excluir</button></li>
                </td>`
            }
        }
        )
}