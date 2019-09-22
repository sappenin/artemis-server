package org.artemis.server.controllers.api;

import org.artemis.db.repositories.PointerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class PointersController {

    private final PointerRepository pointerRepository;

    @Autowired
    public PointersController(final PointerRepository pointerRepository) {
        this.pointerRepository = Objects.requireNonNull(pointerRepository);
    }

//    @RequestMapping(
//        path = "/pointers", method = RequestMethod.POST,
//        consumes = {APPLICATION_JSON_VALUE},
//        produces = {APPLICATION_JSON_VALUE, MediaTypes.PROBLEM_VALUE}
//    )
//    public ResponseEntity<Pointer> createPaymentPointer(
//        @RequestBody Pointer pointer
//    ) {
//        PointerEntity pointerEntity = new PointerEntity(pointer);
//
//        // TODO:
//        this.pointerRepository.save(pointerEntity);
//
//        final HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        return new ResponseEntity(pointer, headers, HttpStatus.CREATED);
//    }

//    @RequestMapping(
//        path = "/pointers", method = RequestMethod.GET,
//        produces = {APPLICATION_JSON_VALUE, MediaTypes.PROBLEM_VALUE}
//    )
//    public ResponseEntity<List<ArtemisPaymentPointer>> getPointers() {
//        // TODO: Add simple paging
//        List<ArtemisPaymentPointer> artemisPaymentPointers = Streams.stream(this.pointerRepository.findAll().iterator())
//            .map(pointerEntity -> ImmutableArtemisPaymentPointer.builder()
//                .in(pointerEntity.getPointerId())
//                .destinationAddress(pointerEntity.getDestinationAddress())
//                .destinationType(pointerEntity.getDestinationType())
//                .assetCode(pointerEntity.getAssetCode())
//                .assetScale(pointerEntity.getAssetScale())
//                .balance(pointerEntity.getBalance().toString())
//                .threshold(pointerEntity.getThreshold().toString())
//                .build()
//            ).collect(Collectors.toList());
//
//        final HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        return new ResponseEntity(artemisPaymentPointers, headers, HttpStatus.OK);
//    }

}
