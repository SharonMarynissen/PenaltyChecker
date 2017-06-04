package domain.violations;

import domain.messages.LincensePlate;

import java.time.LocalTime;

/**
 * Created by Sharon on 3/06/2017.
 */
public class Violation {
    private String type;
    private LocalTime timestamp;
    private LincensePlate lincensePlate;
    private String nationalNumber;
    private String location;
}
