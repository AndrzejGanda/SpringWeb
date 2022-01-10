package com.allegro.challenge.github;

import com.allegro.challenge.github.model.GithubBasicResponseDTO;
import com.allegro.challenge.github.model.GithubStarsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class GitHubController {

    private final GithubService githubService;

    @GetMapping("/{userName}/repositories")
    public ResponseEntity<GithubBasicResponseDTO[]> getUserRepositories(@PathVariable String userName) {
        return ResponseEntity.ok(githubService.getUserRepositories(userName));
    }

    @GetMapping("/{userName}/repositories/sumstars")
    public ResponseEntity<GithubStarsDTO> getAllStarsFromRepos(@PathVariable String userName) {
       return ResponseEntity.ok(githubService.getAllStarsByUserName(userName));
    }

}
