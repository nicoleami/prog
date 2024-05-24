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
    public Time updateTime(@PathVariable Long id, @RequestBody Time timeAtualizado) {
        for (Time time: listaTimes) {
            if (time.getId().equals(id)) {
                if (timeAtualizado.getNome().isEmpty()) {
                    time.setNome(time.getNome());
                } else {
                    time.setNome(timeAtualizado.getNome());
                }
                if (timeAtualizado.getEstado().isEmpty()) {
                    time.setEstado(time.getEstado());
                } else {
                    time.setEstado(timeAtualizado.getEstado());
                }
                if (timeAtualizado.getCidade().isEmpty()) {
                    time.setCidade(time.getCidade());
                } else {
                    time.setCidade(timeAtualizado.getCidade());
                }
                if (timeAtualizado.getDataFundacao().isEmpty()) {
                    time.setDataFundacao(time.getDataFundacao());
                } else {
                    time.setDataFundacao(timeAtualizado.getDataFundacao());
                }
                break;
            }
        }
        return timeAtualizado;
    }

    @GetMapping("/{id}")
    public Time listarTimePorId(@PathVariable Long id){
        for (Time time: listaTimes){
            if (time.getId().equals(id)){
                return time;
            }
        }
        return null;
    }

    @GetMapping("/pesquisa")
    public List<Time> mostrarCidade(@RequestParam String nome){
        List<Time> timesA = new ArrayList<>();
        for(Time time: listaTimes){
            if (time.getNome().equals(nome)){
                timesA.add(time);
            }
        }
        return timesA;
    }
}