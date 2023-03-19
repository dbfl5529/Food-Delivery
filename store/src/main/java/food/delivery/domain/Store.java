package food.delivery.domain;

import food.delivery.StoreApplication;
import food.delivery.domain.Cooked;
import food.delivery.domain.Rejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Store_table")
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long foodId;

    private Long orderId;

    private Long customerId;

    private String address;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Cooked cooked = new Cooked(this);
        cooked.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();
    }

    public static StoreRepository repository() {
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(
            StoreRepository.class
        );
        return storeRepository;
    }

    //<<< Clean Arch / Port Method
    public static void payment(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void refund(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        Store store = new Store();
        repository().save(store);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(store->{
            
            store // do something
            repository().save(store);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
