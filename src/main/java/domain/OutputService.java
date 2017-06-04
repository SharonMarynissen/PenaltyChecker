package domain;

import domain.messages.IncommingMessageDTO;
import domain.messages.MessageDTO;

/**
 * Created by Sharon on 4/06/2017.
 */
public interface OutputService {
    MessageDTO sendMessage(MessageDTO messageDTO) throws CommunicationException;
}
