package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void deleteUser(String passport) {
        if (passport != null) {
            User user = findByPassport(passport);
            if (user != null) {
                users.remove(user);
            }
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (user == null) {
            return;
        }
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
             return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        List<Account> accounts;
        if (user != null) {
            accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        if (sourcePassport == null || sourceRequisite == null
                || destinationPassport == null || destinationRequisite == null
        || amount <= 0) {
            return result;
        }
        Account sourceaccount = findByRequisite(sourcePassport, sourceRequisite);
        if (sourceaccount == null) {
            return result;
        }
        Account destaccount = findByRequisite(destinationPassport, destinationRequisite);
        if (destaccount == null) {
            return result;
        }
        if (sourceaccount.getBalance() < amount) {
            return result;
        }
        sourceaccount.setBalance(sourceaccount.getBalance() - amount);
        destaccount.setBalance(destaccount.getBalance() + amount);
        result = true;
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}