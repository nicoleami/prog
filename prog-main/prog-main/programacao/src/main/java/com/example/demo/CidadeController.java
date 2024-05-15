package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    private List<Cidade> cidades = new ArrayList<>();

    @GetMapping
    public List<Cidade> mostraCidades(){
        return cidades;
    }

    @PostMapping
    public List<Cidade> cadastraCidade(@RequestBody Cidade cidade){
        cidades.add(cidade);
        return cidades;
    }

    @DeleteMapping("/{id}")
    public void deletarDisciplina(@PathVariable Long id) {
        cidades.removeIf(cidade -> cidade.getId().equals(id));
    }

    @PutMapping("/{id}")
    public List<Cidade> atualizaCidade(@PathVariable Long id, @RequestBody Cidade cidadeAtualizada) {
        for (Cidade cidade : cidades) {
            if (cidade.getId().equals(id)) {
                cidade.setNome(cidadeAtualizada.getNome());
                cidade.setEstado(cidadeAtualizada.getEstado());
                cidade.setPais(cidadeAtualizada.getPais());
                cidade.setPopulacao(cidadeAtualizada.getPopulacao());
                break;
            }
        }
        return cidades;
    }

}
