package com.ross.cs504.runninganalysisservice.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
public class UserInfo {

    @Id
    @GeneratedValue
    private long id;

    private String username;
    private String address;

    public UserInfo() {

    }

    @JsonCreator
    public UserInfo(
            @JsonProperty("username") String username,
            @JsonProperty("address") String address) {
        this.username = username;
        this.address = address;
    }
}