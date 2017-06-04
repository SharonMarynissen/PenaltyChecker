package adapters.messageDTOs;

import domain.messages.IncommingMessageDTO;
import domain.messages.MessageDTO;

/**
 * Created by Sharon on 4/06/2017.
 */
public class LicensePlateServiceMessageDTO implements MessageDTO {
    private String plateId;
    private String nationalNumber;
    private int euroNumber;

    public String getPlateId()          { return plateId; }
    public String getNationalNumber()   { return nationalNumber; }
    public int getEuroNumber()          { return euroNumber; }

    public void setPlateId(String plateId)                  { this.plateId = plateId; }
    public void setNationalNumber(String nationalNumber)    { this.nationalNumber = nationalNumber; }
    public void setEuroNumber(int euroNumber)               { this.euroNumber = euroNumber; }

    @Override
    public String toString() {
        return String.format("Nummerplaat '%s' van eigenaar '%s' heeft euronorm %d", plateId, nationalNumber, euroNumber);
    }
}
