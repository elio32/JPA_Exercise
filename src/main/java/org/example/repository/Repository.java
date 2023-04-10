package org.example.repository;

import java.util.List;
import java.util.Optional;

public interface Repository <ENTITY,ID>{
    Optional<ENTITY> findById(ID id);
    List<ENTITY> findAll();
    List<ENTITY> save(ENTITY entity);
    List<ENTITY> delete(ENTITY entity);
}
