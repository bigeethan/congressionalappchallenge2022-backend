package com.ethanfriedman.congressionalappchallenge.controllers;

import com.ethanfriedman.congressionalappchallenge.models.Parties;
import com.ethanfriedman.congressionalappchallenge.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class PartiesController {
    @Autowired
    PartyService partyService;

    //Party endpoints
    @CrossOrigin
    @GetMapping("/getparty/{name}")
    public Parties getParty(@PathVariable String name) throws ExecutionException, InterruptedException {
        return partyService.getParty(name);
    }

    @CrossOrigin
    @PostMapping("/createparty")
    public String createParty(@RequestBody Parties parties) throws ExecutionException, InterruptedException {
        return partyService.saveParty(parties);
    }
}
