package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.controllers;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants.ControllerStatusMessage;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.dto.DefaultStatus;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.factories.LocaleMessageFactory;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class BaseController<R extends BaseService, D extends IDTO> {

    @Autowired
    protected R service;

    @Autowired
    private LocaleMessageFactory messageFactory;

    @GetMapping("/{id}")
    public ResponseEntity<?> retrieveProductById(@PathVariable Long id) {
        return ResponseEntity.ok(service.recoveryById(id));
    }

    @GetMapping
    public ResponseEntity<List<?>> retrieveAllProducts() {
        return ResponseEntity.ok(service.recoveryAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody D dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id , @Valid @RequestBody D dto) {
        if (dto.getId() != id) {
            String message = messageFactory.create(ControllerStatusMessage.differenteIdBetweenParameterAndBody);
            DefaultStatus status = DefaultStatus.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message(message)
                    .success(false).build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(status);
        }
        return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.remove(id);
        String message = messageFactory.create(ControllerStatusMessage.deleteRecordSuccessful);
        DefaultStatus status = DefaultStatus.builder()
                .code(HttpStatus.OK.value())
                .success(true)
                .message(message).build();
        return ResponseEntity.ok(status);
    }
}
