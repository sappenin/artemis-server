package org.artemis.server.controllers.api;

import org.artemis.db.repositories.PointerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class PointerController {

    private final PointerRepository pointerRepository;

    @Autowired
    public PointerController(final PointerRepository pointerRepository) {
        this.pointerRepository = Objects.requireNonNull(pointerRepository);
    }

//    @RequestMapping(
//        path = "/pointers/{in}",
//        method = RequestMethod.PUT,
//        consumes = {APPLICATION_JSON_VALUE},
//        produces = {APPLICATION_JSON_VALUE, MediaTypes.PROBLEM_VALUE}
//    )
//    public ResponseEntity<ArtemisPaymentPointer> createOrUpdatePaymentPointer(
//        @PathVariable("in") String in,
//        @RequestBody ArtemisPaymentPointer artemisPaymentPointer
//    ) {
//        if (!artemisPaymentPointer.in().equalsIgnoreCase(in)) {
//            throw new RuntimeException("in MUST not be changed!");
//        }
//
//        PointerEntity pointerEntity = new PointerEntity(artemisPaymentPointer);
//
//        // TODO:
//        this.pointerRepository.save(pointerEntity);
//
//        final HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        return new ResponseEntity(artemisPaymentPointer, headers, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(
//        path = "/pointers/{in}",
//        method = RequestMethod.DELETE,
//        produces = {APPLICATION_JSON_VALUE, MediaTypes.PROBLEM_VALUE}
//    )
//    public ResponseEntity<List<ArtemisPaymentPointer>> updatePointer(@PathVariable("in") String pointerId) {
//        pointerRepository.deleteById(pointerId);
//
//        final HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        return new ResponseEntity(null, headers, HttpStatus.NO_CONTENT);
//    }

}
