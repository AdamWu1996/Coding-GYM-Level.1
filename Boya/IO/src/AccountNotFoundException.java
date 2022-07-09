public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException() {
        super("帳號不符");
    }
}
