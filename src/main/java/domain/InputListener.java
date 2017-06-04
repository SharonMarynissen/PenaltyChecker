package domain;

import domain.messages.MessageDTO;

/**
 * Call back interface for incoming messages
 */
public interface InputListener {
    /**
     * Methode called every time a message is received
     * @param messageDTO
     */
    void onReceive(MessageDTO messageDTO);
}
