package pl.nogacz.allegro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class AllegroApplication {
    public final static String DESTINATION = "SANDBOX.provider.terminator.masterdata.library.1.0.dummy.REQUEST";

    public static void main(String[] args) {
        SpringApplication.run(AllegroApplication.class, args);
    }



}
