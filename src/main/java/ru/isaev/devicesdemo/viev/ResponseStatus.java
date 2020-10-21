package ru.isaev.devicesdemo.viev;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseStatus {
    @NonNull
    private int deviceCount;
    @NonNull
    private int deviceWithErrors;
    @NonNull
    private int stableDevices;
}
