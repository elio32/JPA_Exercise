package org.example.repository.impl;

import org.example.configuration.EntityManagerConfiguration;
import org.example.model.entity.User;
import org.example.repository.UserRepository;
import org.example.util.Queries;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    public UserRepositoryImpl() {
        entityManager = EntityManagerConfiguration.getEntityManager();
    }


    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class,id));
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> result = entityManager.createQuery(Queries.FIND_ALL_USERS, User.class);
        return result.getResultList();
    }

    @Override
    public List<User> save(User user) {
        if (user.getId()!=null){
            entityManager.getTransaction().begin();
            user.setUsername(user.getUsername());
            user.setRole(user.getRole());
            user.setPassword(user.getPassword());
            entityManager.getTransaction().commit();
            System.out.println("User updated");
        }
        else {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            System.out.println("User added");
        }
        return (List<User>) user;
    }

    @Override
    public List<User> delete(User user) {
        if (user.getId() != null){
            entityManager.getTransaction().begin();
            findById(user.getId()).ifPresent(entityManager::remove);
            entityManager.getTransaction().commit();
        }
        return (List<User>) user;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        TypedQuery<User> result = entityManager.createQuery(Queries.FIND_USER_BY_USERNAME_SECOND_METHOD, User.class);
        result.setParameter("username", username);
        return Optional.ofNullable(result.getSingleResult());
    }
}
