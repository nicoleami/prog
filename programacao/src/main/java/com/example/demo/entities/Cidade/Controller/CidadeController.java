package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController //annotation usada pra especificar que essa classe é um controller
@RequestMapping("/cidades") //annotation usada pra especificar o caminho das reqs
public class CidadeController { //iniciando a classe do controller
    //criacao da lista para armazenar as cidades
    private final List<Cidade> cidades = new ArrayList<>();

    //criacao do método de buscar todas as cidades
    @GetMapping
    public List<Cidade> mostraCidades(){
        return cidades;
    }

    //criacao do método de cadastrar uma cidade
    @PostMapping
    public void cadastraCidade(@RequestBody Cidade cidade){
        //annotation @RequestBody indica que os valores para os atributos do objeto vem pelo corpo da requisição
        cidades.add(cidade);
    }

    //criacao do método de deletar uma cidade
    @DeleteMapping("/{id}") //id é passado na URL (exemplo: 'http://localhost:8080/cidades/1')
    //annotation @PathVariable utilizada para indicar que a variável utilizada para fazer a requisição ({id}) é passado pela url pelo usuário
    public void deletarCidade(@PathVariable Long id) {
        cidades.removeIf(cidade -> cidade.getId().equals(id));
    }

    // criacao do método para atualizar uma cidade
    @PutMapping("/{id}") //id é passado na URL (exemplo: 'http://localhost:8080/cidades/1')
    public Cidade atualizaCidade(@PathVariable Long id, @RequestBody Cidade cidadeAtualizada) {
        //for faz com que passe pela lista de cidades linearmente e encontre a cidade que tem o id correspondente ao passado na url pelo usuário
        for (Cidade cidade : cidades) {
            if (cidade.getId().equals(id)) {
                //se o campo do nome da cidade estiver vazio, ele automaticamente seta o valor antigo e assim segue para todos os atributos
                if(cidadeAtualizada.getNome().isEmpty()){
                    cidade.setNome(cidade.getNome());
                } else {
                    cidade.setNome(cidadeAtualizada.getNome());
                }
                if (cidadeAtualizada.getEstado().isEmpty()){
                    cidade.setEstado(cidade.getEstado());
                } else{
                    cidade.setEstado(cidadeAtualizada.getEstado());
                }
                if (cidadeAtualizada.getPais().isEmpty()){
                    cidade.setPais(cidade.getPais());
                } else{
                    cidade.setPais(cidadeAtualizada.getPais());
                }
                cidade.setPopulacao(cidadeAtualizada.getPopulacao());
                break;
            }
        }
        return cidadeAtualizada;
    }

    //criacao do método para listar uma cidade específica pelo id
    @GetMapping("/{id}")
    public Cidade listarCidadePorId(@PathVariable Long id){
        //for faz com que passe pela lista de cidades linearmente e encontre a cidade que tem o id correspondente ao passado na url pelo usuário
        for (Cidade cidade: cidades){
            if (cidade.getId().equals(id)){
                return cidade;
            }
        }
        return null;
    }

    //criacao do método para listar uma cidade específica pelo nome
    @GetMapping("/pesquisa")//nome é passado na URL (exemplo: 'http://localhost:8080/cidades/pesquisa?nome=Osasco')
    public List<Cidade> mostrarCidade(@RequestParam String nome){
        //annotation @RequestParam é utilizada quando o cliente envia uma solicitação HTTP, os parâmetros são passados na url, como no exemplo do comentário acima
        List<Cidade> cidadesA = new ArrayList<>();
        for(Cidade cidade: cidades){
            if (cidade.getNome().equals(nome)){
                cidadesA.add(cidade);
            }
        }
        return cidadesA;
    }

}
