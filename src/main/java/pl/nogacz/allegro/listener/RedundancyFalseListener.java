package pl.nogacz.allegro.listener;

import lombok.Getter;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pl.nogacz.allegro.AllegroApplication;

import java.util.concurrent.CountDownLatch;

@Component
@Getter
public class RedundancyFalseListener {
    private CountDownLatch latch = new CountDownLatch(1);

    @JmsListener(destination = AllegroApplication.DESTINATION, selector = "IS_REDUNDANCY_ENABLED = false")
    public void listen(final String message) {
        System.out.println("[FalseListener] " + message);
        latch.countDown();
    }
}
