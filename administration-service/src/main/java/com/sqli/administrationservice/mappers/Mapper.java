package com.sqli.administrationservice.mappers;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper <D,E>{
    D entityToDto(E entity);

    E dtoToEntity(D dto);

    default List<E> dtoToEntityList(List<D> dtoList){
        return dtoList.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());
    }

    default List<D> entityToDtoList(List<E> entities){
        return entities.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}
