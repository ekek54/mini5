package ktminithteam.domain;

import ktminithteam.infra.AbstractEvent;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookPublished extends AbstractEvent {

    private Long publishId;
    private Long authorId;
    private String title;
    private String content;
    private String summaryUrl;
    private String coverUrl;
    private String category;
    private Long cost;

    public BookPublished(Publish aggregate) {
        super(aggregate);
    }

    public BookPublished() {
        super();
    }
}
//>>> DDD / Domain Event
