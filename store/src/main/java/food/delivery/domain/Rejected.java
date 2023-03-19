package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Rejected extends AbstractEvent {

    private Long id;
    private Long foodId;
    private Long orderId;
    private Long customerId;
    private String address;
    private String status;

    public Rejected(Store aggregate) {
        super(aggregate);
    }

    public Rejected() {
        super();
    }
}
