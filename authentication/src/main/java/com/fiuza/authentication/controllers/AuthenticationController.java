package com.fiuza.authentication.controllers;

import com.fiuza.spotify.sdk.entities.CreateApiResponse;
import com.fiuza.spotify.sdk.service.SpotifyHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private SpotifyHttpClient spotifyService;

    @GetMapping
    public CreateApiResponse getAuthenticationToken() {
        return spotifyService.authOptions();
    }
}

