package com.allegro.challenge.github;

import com.allegro.challenge.github.model.GithubBasicResponseDTO;
import com.allegro.challenge.github.model.GithubStarsDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubService {

    private final static String GITHUB_USER_REPOS = "https://api.github.com/users/%s/repos";

    public GithubBasicResponseDTO[] getUserRepositories(String name) {
        RestTemplate restTemplate = new RestTemplate();
        String requestUrl = GITHUB_USER_REPOS.formatted(name);
        return restTemplate.getForObject(requestUrl, GithubBasicResponseDTO[].class);
    }

    public GithubStarsDTO getAllStarsByUserName(String userName) {
        GithubBasicResponseDTO[] userRepos = getUserRepositories(userName);
        long sum = 0;
        for (GithubBasicResponseDTO repo : userRepos) {
            sum += repo.getStargazers_count();
        }
        return new GithubStarsDTO(sum);
    }
}