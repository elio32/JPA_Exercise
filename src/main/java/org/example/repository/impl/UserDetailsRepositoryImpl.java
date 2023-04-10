package org.example.repository.impl;

import org.example.configuration.EntityManagerConfiguration;
import org.example.model.entity.UserDetails;
import org.example.repository.UserDetailsRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserDetailsRepositoryImpl implements UserDetailsRepository {

    private final EntityManager entityManager;

    public UserDetailsRepositoryImpl() {
        entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<UserDetails> findById(Long id) {
        return Optional.ofNullable(entityManager.find(UserDetails.class,id));
    }

    @Override
    public List<UserDetails> findAll() {
        TypedQuery<UserDetails> result = entityManager.createQuery("SELECT e FROM UserDetails e",UserDetails.class);
        return result.getResultList();
    }

    @Override
    public List<UserDetails> save(UserDetails userDetails) {
        entityManager.getTransaction().begin();
        entityManager.persist(userDetails);
        entityManager.getTransaction().commit();
        System.out.println("UserDetails saved");
        return (List<UserDetails>) userDetails;
    }

    @Override
    public List<UserDetails> delete(UserDetails userDetails) {
        if (userDetails.getId() != null){
            entityManager.getTransaction().begin();
            findById(userDetails.getId()).ifPresent(entityManager::remove);
            entityManager.getTransaction().commit();
        }
        return (List<UserDetails>) userDetails;
    }
}
