import java.util.regex.Pattern;

public class Validator {
    private static final Pattern regex = Pattern.compile("^[A-Za-z0-9_]{0,20}$");

    public static void checkAuthentication(String login, String password, String confirmPassword) throws WrongLoginException {
        checkLogin(login);
        checkPassword(password);
        equalsPassword(password, confirmPassword);
        System.out.println("Аутентификация выполнена");
    }

    private static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(regex.pattern())) {
            throw new WrongLoginException("Неверно введен логин. Должны быть только латинские буквы, цифры и знак подчеркивания. " +
                    "Длина должна быть не более 20 символов");
        }
    }

    private static void checkPassword(String password) {
        if (!password.matches((regex.pattern()))) {
            throw new WrongPasswordException("Неверно введен пароль. Должны быть только латинские буквы, цифры и знак подчеркивания. " +
                    "Длина должна быть не более 20 символов");
        }
    }

    private static void equalsPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
