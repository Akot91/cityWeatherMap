package com.cityweathermap.mapper;

import com.cityweathermap.domain.Installation;
import com.cityweathermap.domain.InstallationDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InstallationMapper {

    /*
    public Installation mapToInstallation(InstallationDto installationDto) {
        return new Installation(
                installationDto.getFromDateTime(),
                installationDto.getTillDateTime(),
                installationDto.getValues());
    }

    public InstallationDto mapToInstallationDto(Installation installation) {
        return new InstallationDto(
                installation.getFromDateTime(),
                installation.getFromDateTime(),
                installation.getValues());
    }

    public List<Installation> mapToInstallations(final List<InstallationDto> installationDtoList) {
        return installationDtoList.stream()
                .map(installation -> new Installation(installation.getFromDateTime(),
                        installation.getTillDateTime(),
                        installation.getValues()))
                .collect(Collectors.toList());
    }

    public List<InstallationDto> mapToInstallationsDto(final List<Installation> installationList) {
        return installationList.stream()
                .map(installation -> new InstallationDto(installation.getFromDateTime(),
                        installation.getTillDateTime(),
                        installation.getValues()))
                .collect(Collectors.toList());
    }

     */
}
