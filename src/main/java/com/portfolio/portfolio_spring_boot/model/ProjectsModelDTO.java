package com.portfolio.portfolio_spring_boot.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProjectsModelDTO {

    private Long id;

    @Size(max = 255)
    private String projectName;

    @Size(max = 255)
    private String appType;

    @Size(max = 800)
    private String projectDescription;

    @Size(max = 255)
    private String projectLiveUrl;

    @Size(max = 255)
    private String projectGithubLink;

    @Size(max = 255)
    private String projectImage;

    @Size(max = 255)
    private String programingLanguagesUsed;

}
