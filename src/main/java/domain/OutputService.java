package domain;

import domain.messages.MessageDTO;

/**
 * Created by Sharon on 4/06/2017.
 */
public interface OutputService {
    String sendMessage(MessageDTO messageDTO) throws CommunicationException;
}
