package com.alberto.portfolio.monolitic.spring.springangularstore.bundle.services;

import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.constants.BusinessDatabaseMessage;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.factories.ExceptionFactory;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.factories.LocaleMessageFactory;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IDTO;
import com.alberto.portfolio.monolitic.spring.springangularstore.bundle.interfaces.IEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BaseService<R extends JpaRepository, E extends IEntity, D extends IDTO> {

    @Autowired
    private R repository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ExceptionFactory exceptionFactory;

    @Autowired
    private LocaleMessageFactory localeMessageFactory;

    protected Type entityType;
    protected Type dtoType;

    public D recoveryById(Long id) {
        Optional<E> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent())
            return toDto(optionalEntity.get());

        throw exceptionFactory.throwDataBase(BusinessDatabaseMessage.notFound);
    }

    public List<D> recoveryAll() {
        List<E> entities = repository.findAll();
        if (entities.isEmpty())
            throw exceptionFactory.throwDataBase(BusinessDatabaseMessage.noRecordsFound);

        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public D create(D dto) {
        E entity = toEntity(dto);
        repository.save(entity);
        return toDto(entity);
    }

    public D updateProduct(D dto) {
        if (repository.existsById(dto.getId())) {
            E entity = toEntity(dto);
            repository.save(entity);
            return toDto(entity);
        }
        throw exceptionFactory.throwDataBase(BusinessDatabaseMessage.notFound);
    }

    public void remove(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return;
        }
        throw exceptionFactory.throwDataBase(BusinessDatabaseMessage.notFound);
    }

    private E toEntity(D dto) {
        if (dto != null)
            return mapper.map(dto, entityType);
        return null;
    }

    private D toDto(E p) {
        if (p != null)
            return mapper.map(p, dtoType);
        return null;
    }
}
