package com.demo.survey.dto.mapper;

import java.util.Collection;
import java.util.List;

public interface Mapper<E,D> {

    public static final Integer CANTIDAD_ESCALONES=1;

    public D getDto(E entity);

    public D getDto(E entity, Integer escalones);

    public E fillEntity(E entity, D dto);

    public List<D> getDto(Collection<E> entities);

    public List<D> getDto(Collection<E> entities, Integer escalones);

}
