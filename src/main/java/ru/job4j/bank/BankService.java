package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковский сервис.
 * Управляет пользователями и их счетами.
 */
public class BankService {
    /**
     * Хранит пользователей и список их счетов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет нового пользователя, если его ещё нет в системе.
     *
     * @param user пользователь, которого нужно добавить
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удаляет пользователя по номеру паспорта.
     *
     * @param passport паспортные данные пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавляет счёт пользователю по номеру паспорта.
     * Если пользователь найден и такого счёта ещё нет — он добавляется.
     *
     * @param passport паспорт пользователя
     * @param account  счёт, который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Ищет пользователя по номеру паспорта.
     *
     * @param passport паспортные данные
     * @return пользователь или null, если не найден
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Ищет счёт по паспорту и реквизитам.
     *
     * @param passport  паспорт пользователя
     * @param requisite реквизиты счёта
     * @return счёт или null, если не найден
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Переводит деньги с одного счёта на другой.
     *
     * @param sourcePassport      паспорт отправителя
     * @param sourceRequisite     реквизиты отправителя
     * @param destinationPassport паспорт получателя
     * @param destinationRequisite реквизиты получателя
     * @param amount              сумма перевода
     * @return true, если перевод успешен, иначе false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        if (sourcePassport != null && sourceRequisite != null
                && destinationPassport != null && destinationRequisite != null
                && amount > 0) {

            Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
            Account destAccount = findByRequisite(destinationPassport, destinationRequisite);

            if (sourceAccount != null && destAccount != null
                    && sourceAccount.getBalance() >= amount) {
                sourceAccount.setBalance(sourceAccount.getBalance() - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
                result = true;
            }
        }
        return result;
    }

    /**
     * Возвращает список счетов пользователя.
     *
     * @param user пользователь
     * @return список его счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
