public class PasswordNotFoundException extends RuntimeException {
    public PasswordNotFoundException() {
        super("密碼不符");
    }
}
