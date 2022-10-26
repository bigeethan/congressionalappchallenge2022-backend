package com.ethanfriedman.congressionalappchallenge.controllers;

import com.ethanfriedman.congressionalappchallenge.models.Governors;
import com.ethanfriedman.congressionalappchallenge.models.Presidents;
import com.ethanfriedman.congressionalappchallenge.models.Senators;
import com.ethanfriedman.congressionalappchallenge.services.PoliticianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class PoliticianController {
    @Autowired
    PoliticianService politicianService;

    //Governor Endpoints
    @CrossOrigin
    @GetMapping("/getgovernor/{name}")
    public Governors getGovernor(@PathVariable String name) throws ExecutionException, InterruptedException {
        return politicianService.getGovernor(name);
    }

    @CrossOrigin
    @PostMapping("/creategovernor")
    public String postGovernor(@RequestBody Governors governors) throws ExecutionException, InterruptedException {
        return politicianService.saveGovernor(governors);
    }

    //President endpoints
    @CrossOrigin
    @GetMapping("/getpresident/{name}")
    public Presidents getPresident(@PathVariable String name) throws ExecutionException, InterruptedException {
        return politicianService.getPresident(name);
    }

    @CrossOrigin
    @PostMapping("/createpresident")
    public String postPresident(@RequestBody Presidents presidents) throws ExecutionException, InterruptedException {
        return politicianService.savePresident(presidents);
    }

    //Senator endpoints
    @CrossOrigin
    @GetMapping("/getsenator/{name}")
    public Senators getSenator(@PathVariable String name) throws ExecutionException, InterruptedException {
        return politicianService.getSenator(name);
    }

    @CrossOrigin
    @PostMapping("/createsenator")
    public String postSenator(@RequestBody Senators senators) throws ExecutionException, InterruptedException {
        return politicianService.saveSenator(senators);
    }
}
