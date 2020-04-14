package pl.nogacz.allegro.sender;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import pl.nogacz.allegro.AllegroApplication;

@Component
@AllArgsConstructor
public class MessageSender {
    private JmsTemplate jmsTemplate;

    public void send(final boolean redundancy) {
        jmsTemplate.convertAndSend(AllegroApplication.DESTINATION, "Sender sent value: " + redundancy,
                messagePostProcessor -> {
                    messagePostProcessor.setBooleanProperty("IS_REDUNDANCY_ENABLED", redundancy);
                    messagePostProcessor.setJMSType("Topic");
                    return messagePostProcessor;
                });
    }
}