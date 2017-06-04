package domain;

import domain.messages.IncommingMessageDTO;
import domain.messages.MessageDTO;

import java.util.Collection;

/**
 * A MessageMerger can combine a collection of  {@link IncommingMessageDTO} objects into one
 */
public interface MessageMerger {
    /**
     * Merge a collection of {@link IncommingMessageDTO} objects into one
     * @param messageDTOs
     */
    MessageDTO mergeMessageDTOs(Collection<MessageDTO> messageDTOs);
}
