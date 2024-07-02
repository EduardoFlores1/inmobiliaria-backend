package com.quevedo.api.inmobiliaria_backend.domain.repositories;

import java.util.List;
import java.util.Optional;

public interface ICommonRepository <E>{
    List<E> readAll();
    Optional<E> readById(Integer id);
    E save(E e);
    void delete(int id);
}
