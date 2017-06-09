package demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by yefeiw on 6/8/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
public class UserInfo {
    private String username;
    //TODO: make this a location class in the future
    private String address;

    public UserInfo() {
        //empty constructor
    }

    public UserInfo(String username, String address) {
        this.username = username;
        this.address = address;
    }
}
