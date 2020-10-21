package ru.isaev.devicesdemo.viev;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class ResponseDevices {
    @NonNull
    private int id;
    @NonNull
    private String serialNumber;
    @NonNull
    private int projectId;
    @NonNull
    private boolean hashErrors;
    @NonNull
    private ResponseSummaryImfo summaryImfo;
}
