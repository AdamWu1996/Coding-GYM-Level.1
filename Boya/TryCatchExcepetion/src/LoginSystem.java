import java.util.Scanner;

public class LoginSystem {
    private static final String ACCOUNT = "123";
    private static final String PASSWORD = "567";
    private static final Scanner INPUT = new Scanner(System.in);
    private String userInputAccount;
    private String userInputPassword;

    public void login() {
        inputAccount();
        inputPassword();
        validateAccountInfo();
    }

    public void inputAccount() {
        System.out.println("輸入帳號:");
        setUserInputAccount(INPUT.nextLine());
    }

    public void inputPassword() {
        System.out.println("輸入密碼:");
        setUserInputPassword(INPUT.nextLine());
    }

    public void validateAccountInfo() {
        boolean isCorrectAccount = ACCOUNT.equals(getUserInputAccount());
        boolean isCorrectPassword = PASSWORD.equals(getUserInputPassword());
        if (!isCorrectAccount && isCorrectPassword) {
            throw new PairInfoNotFoundException();
        }

        if (!isCorrectAccount) {
            throw new AccountNotFoundException();
        }

        if (!isCorrectPassword) {
            throw new PasswordNotFoundException();
        }

        System.out.println("登入成功");
    }

    public String getUserInputAccount() {
        return userInputAccount;
    }

    public void setUserInputAccount(String userInputAccount) {
        this.userInputAccount = userInputAccount;
    }

    public String getUserInputPassword() {
        return userInputPassword;
    }

    public void setUserInputPassword(String userInputPassword) {
        this.userInputPassword = userInputPassword;
    }
}
