package food.delivery.domain;

import food.delivery.RiderApplication;
import food.delivery.domain.DeliveryCompleted;
import food.delivery.domain.DeliveryStarted;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Rider_table")
@Data
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {
        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    public static RiderRepository repository() {
        RiderRepository riderRepository = RiderApplication.applicationContext.getBean(
            RiderRepository.class
        );
        return riderRepository;
    }

    //<<< Clean Arch / Port Method
    public static void riderPick(Cooked cooked) {
        /** Example 1:  new item 
        Rider rider = new Rider();
        repository().save(rider);

        */

        /** Example 2:  finding and process
        
        repository().findById(cooked.get???()).ifPresent(rider->{
            
            rider // do something
            repository().save(rider);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
