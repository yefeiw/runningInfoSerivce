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
    private Date tiemstamp  = new Date();
    private UserInfo userInfo;
    private HealthWarningLevel healthWarningLevel;

}
