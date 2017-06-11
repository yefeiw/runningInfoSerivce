package demo.domain;
        import com.fasterxml.jackson.annotation.JsonCreator;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import lombok.Data;

        import javax.persistence.AttributeOverride;
        import javax.persistence.AttributeOverrides;
        import javax.persistence.Column;
        import javax.persistence.Embedded;
        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.Id;
        import java.util.Date;
        import java.util.Random;

/**
 * Created by yefeiw on 6/8/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
public class RunningInformation {
    enum HealthWarningLevel {
            LOW,MEDIUM,HIGH;
    }

    @Id
    @GeneratedValue
        private Long runningId;

    private String latitude;
    private String longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate;
    private Date timestamp  = new Date();
    private Random rand;
    @Embedded
    @AttributeOverrides({
          @AttributeOverride(name = "username",column = @Column(name = "user_username")),
            @AttributeOverride(name = "address",column = @Column(name = "user_address"))
    })
    private UserInfo userInfo;
    private HealthWarningLevel healthWarningLevel;

    public RunningInformation() {
        this.userInfo = null;
        this.rand = new Random();
        this.heartRate = 60+rand.nextInt(60);
    }

    public RunningInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
        this.rand = new Random();
        this.heartRate = 60 + rand.nextInt(60);
    }
}
