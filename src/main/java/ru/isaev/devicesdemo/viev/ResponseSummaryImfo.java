package ru.isaev.devicesdemo.viev;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseSummaryImfo {
    @NonNull
    private int eventCount;
    @NonNull
    private int warningCount;
    @NonNull
    private int errorCount;

}
