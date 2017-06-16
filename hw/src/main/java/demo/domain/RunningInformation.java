package demo.domain;
        import com.fasterxml.jackson.annotation.JsonCreator;
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonProperty;
        import lombok.Data;

        import javax.persistence.*;
        import java.util.Date;
        import java.util.Random;

/**
 * Created by yefeiw on 6/8/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
//According to HW requirement
@Table(name = "RUNNING_INFORMATION")
public class RunningInformation {
    public enum HealthWarningLevel {
            LOW,NORMAL,HIGH;
    }

    @Id
    @GeneratedValue
    private Long id;


    @Embedded
    private final UserInfo userInfo;
    private HealthWarningLevel healthWarningLevel;
    private String runningId;
    private double latitude;
    private double longitude;
    private double runningDistance;
    private double totalRunningTime;
    private int heartRate;
    private Date timestamp  = new Date();
    public RunningInformation() {
        this.userInfo = null;
    }

    public RunningInformation(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public RunningInformation(String username, String address) {
        this.userInfo = new UserInfo(username, address);
    }
    @JsonCreator
    public RunningInformation(
            @JsonProperty("runningId") String runningId,
            @JsonProperty("latitude") String latitude,
            @JsonProperty("longitude") String longitude,
            @JsonProperty("runningDistance") String runningDistance,
            @JsonProperty("totalRunningTime") String totalRunningTime,
            @JsonProperty("heartRate") String heartRate,
            @JsonProperty("timestamp") String timestamp,
            @JsonProperty("userInfo") UserInfo userInfo) {

        this.runningId = runningId;
        this.latitude= Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
        this.runningDistance = Double.parseDouble(runningDistance);
        this.totalRunningTime = Double.parseDouble(totalRunningTime);
        this.heartRate = this.generateHeartRate();
        this.timestamp = new Date();
        this.userInfo = userInfo;
        //generate the warning level according to the heart rate
        this.healthWarningLevel = getHealthWarningLevel(this.heartRate);



        System.out.println("created userInfo with runningId" + this.runningId + " and  heartRate " + this.heartRate);
    }
    public String getUsername() {
        return this.userInfo == null ? null : this.userInfo.getUsername();
    }

    public String getAddress() {
        return this.userInfo == null ? null : this.userInfo.getAddress();
    }

    private HealthWarningLevel getHealthWarningLevel(int heartRate) {
        if (heartRate > 120) {
            return HealthWarningLevel.HIGH;
        } else if (heartRate > 75) {
            return HealthWarningLevel.NORMAL;
        } else if (heartRate >= 60) {
            return HealthWarningLevel.LOW;
        } else {
            return HealthWarningLevel.LOW;
        }
    }
    private int generateHeartRate() {
        final int min = 60;
        final int max = 200;
        Random random  =new Random();
        return min + random.nextInt(max - min);
    }
}
