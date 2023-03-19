package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private String address;
    private String status;

    public DeliveryCompleted(Rider aggregate) {
        super(aggregate);
    }

    public DeliveryCompleted() {
        super();
    }
}
