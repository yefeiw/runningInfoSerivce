package com.ross.cs504.runninganalysisservice.service.impl;

import com.ross.cs504.runninganalysisservice.domain.RunningInformation;
import lombok.Data;

@Data
public class RunningInfoDto {
    public enum HealthWarningLevel {
        NA, LOW, NORMAL, HIGH
    }


    private String runningId;
    private double runningDistance;
    private double totalRunningTIme;

    private int heartRate;
    private long userId;
    private String username;
    private String address;
    private HealthWarningLevel healthWarningLevel;

    public RunningInfoDto() {

    }

    public RunningInfoDto(RunningInformation runningInfo) {
        this.setRunningId(runningInfo.getRunningId());
        this.setRunningDistance(runningInfo.getRunningDistance());
        this.setTotalRunningTIme(runningInfo.getTotalRunningTIme());
        this.setHeartRate(runningInfo.getHeartRate());
        this.setUserId(runningInfo.getUserInfo().getId());
        this.setUsername(runningInfo.getUserInfo().getUsername());
        this.setAddress(runningInfo.getUserInfo().getAddress());
        this.setHealthWarningLevel(convertWarningLevel(heartRate));
    }

    private HealthWarningLevel convertWarningLevel(int heartRate) {
        if (heartRate >= 60 && heartRate <= 75) {
            return HealthWarningLevel.LOW;
        } else if (heartRate > 75 && heartRate <= 120) {
            return HealthWarningLevel.NORMAL;
        } else if (heartRate > 120) {
            return HealthWarningLevel.HIGH;
        }
        return HealthWarningLevel.NA;
    }
}
