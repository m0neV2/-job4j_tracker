package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("Пользователь не валиден");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Имя пользователя содержит меньше 3 символов");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        } catch (UserInvalidException e) {
            e.printStackTrace();
        }
    }
}