package ktminithteam.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import ktminithteam.PublisherApplication;
import ktminithteam.domain.BookPublished;
import lombok.Data;

@Entity
@Table(name = "Publish_table")
@Data
//<<< DDD / Aggregate Root
public class Publish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long publishId;

    private Long manuscriptId;

    private Long authorId;

    private String title;

    private String content;

    private String category;

    private String summaryUrl;

    private String coverUrl;

    private Long cost;

    private Boolean isAccept;


    public static PublishRepository repository() {
        PublishRepository publishRepository = PublisherApplication.applicationContext.getBean(
            PublishRepository.class
        );
        return publishRepository;
    }

    //<<< Clean Arch / Port Method
    public static void publishProcess(
        PublishRequestedEvent publishRequestedEvent
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Publish publish = new Publish();
        repository().save(publish);

        */

        /** Example 2:  finding and process
        

        repository().findById(publishRequestedEvent.get???()).ifPresent(publish->{
            
            publish // do something
            repository().save(publish);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
