package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {
    private List<Time> listaTimes = new ArrayList<>();

    @GetMapping
    public List<Time> listarTimes(){
        return listaTimes;
    }

    @PostMapping
    public void criarTime(@RequestBody Time time){
        listaTimes.add(time);
    }

    @DeleteMapping("/{id}")
    public void deletarTime(@PathVariable Long id){
        listaTimes.removeIf(time -> time.getId().equals(id));
    }

    @PutMapping("/{id}")
    public List<Time> updateTime(@PathVariable Long id, @RequestBody Time timeAtualizado) {
        for (Time time: listaTimes){
            if (time.getId().equals(id)) {
                time.setNome(timeAtualizado.getNome());
                time.setDataFundacao(timeAtualizado.getDataFundacao());
                time.setCidade(timeAtualizado.getCidade());
                time.setEstado(timeAtualizado.getEstado());
                break;
            }
        }
        return listaTimes;
    }
}