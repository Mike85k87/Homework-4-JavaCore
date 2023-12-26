import java.util.regex.Pattern;

public class Validator {
    private static final Pattern regex = Pattern.compile("^[A-Za-z0-9_]{0,20}$");

    public static void checkAuthentication(String login, String password, String confirmPassword) {
        checkLogin(login);
        checkPassword(password);
        equalsPassword(password, confirmPassword);
        System.out.println("Аутентификация выполнена");
    }

    private static void checkLogin(String login) {
        if (!login.matches(regex.pattern())) {
            try {
                throw new WrongLoginException("Неверно введен логин. Должны быть только латинские буквы, цифры и знак подчеркивания. " +
                        "Длина должна быть не более 20 символов");
            } catch (WrongLoginException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void checkPassword(String password) {
        if (!password.matches((regex.pattern()))) {
            try {
                throw new WrongPasswordException("Неверно введен пароль. Должны быть только латинские буквы, цифры и знак подчеркивания. " +
                        "Длина должна быть не более 20 символов");
            } catch (WrongPasswordException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void equalsPassword(String password, String confirmPassword){
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
