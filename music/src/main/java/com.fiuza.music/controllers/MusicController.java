package com.fiuza.music.controllers;

import com.fiuza.music.models.ArtistResult;
import com.fiuza.music.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    ArtistService artistService;

    @GetMapping("/artist/{name}")
    public ArtistResult getArtist(@PathVariable String name) {
        return artistService.getArtist(name);
    }
}
