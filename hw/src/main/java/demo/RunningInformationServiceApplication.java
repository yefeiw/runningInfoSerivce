package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by yefeiw on 6/9/17.
 */
@SpringBootApplication
@EnableTransactionManagement
public class RunningInformationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RunningInformationServiceApplication.class,args);
    }
}
