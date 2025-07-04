package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает пользователя банка.
 * Содержит паспорт и имя пользователя.
 */
public class User {
    /**
     * Паспортные данные пользователя (уникальный идентификатор).
     */
    private String passport;

    /**
     * Имя пользователя.
     */
    private String username;

    /**
     * Конструктор для создания пользователя.
     *
     * @param passport паспортные данные
     * @param username имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает пользователей по паспортным данным.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хеш-код на основе паспорта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
