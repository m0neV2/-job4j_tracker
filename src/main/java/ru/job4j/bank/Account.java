package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает банковский счет.
 * Содержит реквизиты и текущий баланс.
 */
public class Account {
    /**
     * Реквизиты счёта (уникальный идентификатор).
     */
    private String requisite;

    /**
     * Баланс счёта.
     */
    private double balance;

    /**
     * Конструктор для создания счёта с реквизитами и балансом.
     *
     * @param requisite реквизиты счёта
     * @param balance   текущий баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает два счёта по реквизитам.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Возвращает хеш-код на основе реквизитов.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
