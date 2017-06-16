package com.ross.cs504.runninganalysisservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "RUNNING_ANALYSIS")
public class RunningInformation {

//    public enum HealthWarningLevel {
//        LOW, NORMAL, HIGH
//    }


    @Id
    @GeneratedValue
    private Long id;

    private String runningId;

    // Create an embedded field
    @ManyToOne(targetEntity = UserInfo.class, cascade = CascadeType.ALL)
    private UserInfo userInfo;

    private double longitude;
    private double latitude;

    private double runningDistance;
    private double totalRunningTIme;

    private int heartRate;
//    private HealthWarningLevel healthWarningLevel;

    private Date timestamp = new Date();

    public RunningInformation() {
        userInfo = new UserInfo();
    }

    public RunningInformation(String username, String address) {
        this.userInfo = new UserInfo(username, address);
    }

    @JsonCreator
    public RunningInformation(@JsonProperty("userInfo") UserInfo userInfo) {
        this.userInfo = userInfo;
    }

}
