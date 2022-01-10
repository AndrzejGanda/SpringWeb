package com.allegro.challenge.github.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class GithubBasicResponseDTO {

    private String html_url;
    private int stargazers_count;

}
