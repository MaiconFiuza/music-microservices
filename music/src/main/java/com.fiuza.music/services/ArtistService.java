package com.fiuza.music.services;

import com.fiuza.music.dtos.AuthenticationTokenDTO;
import com.fiuza.music.models.ArtistResult;
import com.fiuza.spotify.sdk.entities.ArtistInformations;
import com.fiuza.spotify.sdk.entities.SpotifyArtist;
import com.fiuza.spotify.sdk.service.SpotifyHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private SpotifyHttpClient spotifyHttpClient;

    public ArtistResult getArtist (String name) {
        try {
            String auth =  authenticationService.getAuthenticationToken().access_token();
            SpotifyArtist artist = spotifyHttpClient.getArtist(name, auth);
            ArtistInformations result = artist.getArtists().getItems().get(0);

            if (result == null) {
                throw  new RuntimeException("Não foi encontrado nenhum artista");
            }

            return new ArtistResult(result.getId(), result.getName(),
                    result.getImages().get(0).getUrl() );

        } catch (RuntimeException e) {
            throw  new RuntimeException(e);
        }
    }
}
