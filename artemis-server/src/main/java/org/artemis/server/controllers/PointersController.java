package org.artemis.server.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.google.common.collect.Streams;
import org.artemis.ImmutablePointer;
import org.artemis.Pointer;
import org.artemis.db.repositories.PointerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.problem.spring.common.MediaTypes;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @RequestMapping(
        path = "/pointers", method = RequestMethod.GET,
        produces = {APPLICATION_JSON_VALUE, MediaTypes.PROBLEM_VALUE}
    )
    public ResponseEntity<List<Pointer>> getPointers() {
        // TODO: Add simple paging
        List<Pointer> pointers = Streams.stream(this.pointerRepository.findAll().iterator())
            .map(pointerEntity -> ImmutablePointer.builder()
                .in(pointerEntity.getPointerId())
                .destinationAddress(pointerEntity.getDestinationAddress())
                .destinationType(pointerEntity.getDestinationType())
                .assetCode(pointerEntity.getAssetCode())
                .assetScale(pointerEntity.getAssetScale())
                .balance(pointerEntity.getBalance().toString())
                .threshold(pointerEntity.getThreshold().toString())
                .build()
            ).collect(Collectors.toList());

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(pointers, headers, HttpStatus.OK);
    }

}
