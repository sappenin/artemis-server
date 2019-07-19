package org.artemis.server.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.artemis.Pointer;
import org.artemis.db.entities.PointerEntity;
import org.artemis.db.repositories.PointerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.problem.spring.common.MediaTypes;

import java.util.List;
import java.util.Objects;

@RestController
public class PointerController {

    private final PointerRepository pointerRepository;

    @Autowired
    public PointerController(final PointerRepository pointerRepository) {
        this.pointerRepository = Objects.requireNonNull(pointerRepository);
    }

    @RequestMapping(
        path = "/pointers/{in}",
        method = RequestMethod.PUT,
        consumes = {APPLICATION_JSON_VALUE},
        produces = {APPLICATION_JSON_VALUE, MediaTypes.PROBLEM_VALUE}
    )
    public ResponseEntity<Pointer> createOrUpdatePaymentPointer(
        @PathVariable("in") String in,
        @RequestBody Pointer pointer
    ) {
        if (!pointer.in().equalsIgnoreCase(in)) {
            throw new RuntimeException("in MUST not be changed!");
        }

        PointerEntity pointerEntity = new PointerEntity(pointer);

        // TODO:
        this.pointerRepository.save(pointerEntity);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(pointer, headers, HttpStatus.CREATED);
    }

    @RequestMapping(
        path = "/pointers/{in}",
        method = RequestMethod.DELETE,
        produces = {APPLICATION_JSON_VALUE, MediaTypes.PROBLEM_VALUE}
    )
    public ResponseEntity<List<Pointer>> updatePointer(@PathVariable("in") String pointerId) {
        pointerRepository.deleteById(pointerId);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity(null, headers, HttpStatus.NO_CONTENT);
    }

}
