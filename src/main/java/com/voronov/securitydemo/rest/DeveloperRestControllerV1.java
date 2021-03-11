package com.voronov.securitydemo.rest;

import com.voronov.securitydemo.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {

    private final List <Developer> DEVELOPERS = Stream.of(
            new Developer(1L,"Ivan","Petrov"),
            new Developer(2L,"Ivan","Suvorov"),
            new Developer(3L,"Ivan","Ivanov")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll(){
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id){
        return DEVELOPERS.stream()
                .filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
