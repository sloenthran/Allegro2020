package pl.nogacz.allegro.listener;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import pl.nogacz.allegro.sender.MessageSender;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
class RedundancyTrueListenerTest {
    @Autowired
    private MessageSender sender;

    @Autowired
    private RedundancyTrueListener listener;

    @Test
    void listen() throws Exception {
        sender.send(true);

        listener.getLatch().await(2, TimeUnit.SECONDS);
        assertThat(listener.getLatch().getCount()).isEqualTo(0);
    }
}