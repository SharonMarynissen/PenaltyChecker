package domain.messages;

import domain.CommunicationException;

/**
 * Abstraction for the conversion of incoming message strings to MessageDTO's
 */
public interface MessageFormatter {
    /**
     * Convert a message from a string based wire format to a {@link MessageDTO}
     * @param messageString
     * @return
     * @throws CommunicationException
     */
    MessageDTO format(String messageString) throws CommunicationException;
}
