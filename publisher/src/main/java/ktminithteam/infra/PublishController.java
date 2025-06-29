package ktminithteam.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import ktminithteam.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//<<< Clean Arch / Inbound Adaptor

@RestController
@RequestMapping(value="/publishes")
@Transactional
public class PublishController {

    @Autowired
    PublishRepository publishRepository;

    @PatchMapping("/{publishId}/accept")
    public ResponseEntity<EntityModel<Publish>> accept(
        @PathVariable Long publishId
    ) {
        ResponseEntity<EntityModel<Publish>> response = publishRepository.findById(publishId)
        .map(publish -> {
            publish.setIsAccept(true);
            publishRepository.save(publish);
            BookPublished bookPublished = new BookPublished(publish);
            bookPublished.publishAfterCommit();
            return ResponseEntity.ok(EntityModel.of(publish));
        }).orElse(ResponseEntity.notFound().build());
        return response;
    }

}
//>>> Clean Arch / Inbound Adaptor
