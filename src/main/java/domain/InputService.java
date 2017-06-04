package domain;

/**
 * An asynch service that can be used to retrieve messages from a communication channel
 */
public interface InputService {
    void initialize(InputListener listener) throws CommunicationException;
    void shutdown() throws CommunicationException;
}
