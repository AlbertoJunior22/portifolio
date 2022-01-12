package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants.DatabaseMessage;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.converters.BaseConverter;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.factories.ExceptionFactory;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.factories.LocaleMessageFactory;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.models.BaseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BaseService<R extends JpaRepository, E extends BaseEntity, D extends IDTO>
    extends BaseConverter<E, D> {

    @Autowired
    protected R repository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ExceptionFactory exceptionFactory;

    @Autowired
    private LocaleMessageFactory localeMessageFactory;

    public D retrieveById(Long id) {
        Optional<E> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent())
            return fromEntity(optionalEntity.get());

        throw exceptionFactory.throwDataBase(DatabaseMessage.notFound);
    }

    public List<D> retrieveAll() {
        List<E> entities = repository.findAll();
        if (entities.isEmpty())
            throw exceptionFactory.throwDataBase(DatabaseMessage.noRecordsFound);

        return entities.stream().map(this::fromEntity).collect(Collectors.toList());
    }

    public D create(D dto) {
        E entity = toEntity(dto);
        repository.save(entity);
        return fromEntity(entity);
    }

    public D update(D dto) {
        if (repository.existsById(dto.getId())) {
            E entity = toEntity(dto);
            repository.save(entity);
            return fromEntity(entity);
        }
        throw exceptionFactory.throwDataBase(DatabaseMessage.notFound);
    }

    public void remove(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw exceptionFactory.throwDataBase(DatabaseMessage.notFound);
    }
}
