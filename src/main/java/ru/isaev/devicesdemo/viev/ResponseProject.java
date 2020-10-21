package ru.isaev.devicesdemo.viev;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class ResponseProject {
    @NonNull
    private int id;
    @NonNull
    private String projectName;
    @NonNull
    private ResponseStatus status;
    @NonNull
    private List<String> devices;
}
