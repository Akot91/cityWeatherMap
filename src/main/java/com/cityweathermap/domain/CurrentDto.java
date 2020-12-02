package com.cityweathermap.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentDto {

    @JsonProperty(value = "current")
    private InstallationDto installationDto;

    public CurrentDto() {}

    public CurrentDto(InstallationDto installationDto) {
        this.installationDto = installationDto;
    }

    public InstallationDto getInstallationDto() {
        return installationDto;
    }
}
