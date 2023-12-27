public class Main {
    public static void main(String[] args) {
        try {
            Validator.checkAuthentication("java_skypro_go", "password", "password");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}
