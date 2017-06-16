package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;

/**
 * Created by yefeiw on 6/8/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
@RequiredArgsConstructor
public class UserInfo {
    private String username;
    //TODO: make this a location class in the future
    private String address;

    @JsonCreator
    public UserInfo(@JsonProperty("username") String username,
                    @JsonProperty("address") String address) {
        this.username = username;
        this.address = address;
    }
}
