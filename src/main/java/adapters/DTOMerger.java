package adapters;

import adapters.messageDTOs.ViolationMessageDTO;
import domain.MessageMerger;
import domain.messages.IncommingMessageDTO;
import domain.messages.MessageDTO;

import java.util.Collection;

/**
 * Created by Sharon on 4/06/2017.
 */
public class DTOMerger implements MessageMerger {

    @Override
    public MessageDTO mergeMessageDTOs(Collection<MessageDTO> messageDTOs) {
        ViolationMessageDTO violationMessageDTO = new ViolationMessageDTO();

        for (MessageDTO dto : messageDTOs){
        }

        return violationMessageDTO;
    }
}
