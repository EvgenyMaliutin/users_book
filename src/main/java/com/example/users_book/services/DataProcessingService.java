package com.example.users_book.services;

import com.example.users_book.domain.User;
import com.example.users_book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Сервис работы с хранилищем пользователей.
 */
@Service
public class DataProcessingService {
    /**
     * Поле с репозиторием пользователей.
     */
    @Autowired
    private UserRepository repository;

    /**
     * Сортировка пользователей по возрасту.
     * @param users список пользователей.
     * @return отсортированный список пользователей.
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Фильтрация списка пользователей по возрасту.
     * @param users список пользователей.
     * @param age возраст для поиска.
     * @return список содержащий пользователей с заданным возрастом.
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Получение среднего возраста пользователей.
     * @param users список пользователей.
     * @return средний возраст пользователей.
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Добавление пользователя в БД.
     * @param user объект пользователя.
     */
    public void addUser(User user) {
        repository.save(user);
    }
    public List<User> getAllUsers(){
        return repository.findAll();
    }
}
