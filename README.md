#  music-microservices

<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->

[![All Contributors](https://img.shields.io/badge/all_contributors-1-orange.svg?style=flat-square)](#contributors-)
<!-- ALL-CONTRIBUTORS-BADGE:END -->


### Requirements

### Kotlin + Spring Boot
- [Java](https://www.java.com/pt-BR/)
- [Spring Boot](https://spring.io/quickstart)

## Running


HTTPS:

```sh
git clone  https://github.com/MaiconFiuza/music-microservices.git
```

- [How to clone a repository](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository)
- [Cloning a repo with SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)



### Accessing 
- endpoints will be available on http://localhost:8082/ or http://localhost:8081/
- To run project you need to change the file [Env](/musics-app/.env) and put your spotify credentials `clientId` and `clientSecret`, you can see how to do this in [Spotify Docs](https://developer.spotify.com/documentation/web-api)


### Endpoints

#### - Authentication 
 Endpoint to authenticate your user with spotify API 

 ```
  curl --location 'http://localhost:8082/authentication'
 ```

this endpoint will respond with bearer token to be used on the other endpoint

#### - getArtist  

Endpoint to search for an artist based on name

 ```
curl --location 'http://localhost:8081/music/artist/emicida' \
--header 'yourToken'
 ```

--------------------
## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="https://MaiconFiuza.github.io/"><img src="https://avatars.githubusercontent.com/u/33963730?s=400&u=ce0fc19f279969cfc9e5c83346602bcb5ba51cce&v=4" width="100px;" alt=""/><br /><sub><b>Maicon Fiuza</b></sub></a><br /><a href="https://github.com/MaiconFiuza/kotlin-spring-api-spotify/graphs/commit-activity" title="Code">💻</a></td>
</tr>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification. Contributions of any kind welcome!