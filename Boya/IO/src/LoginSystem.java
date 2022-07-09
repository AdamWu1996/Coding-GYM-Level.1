import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.io.File.separator;

public class LoginSystem {
    private static final String PATH = String.join(separator, "Boya", "IO", "resource", "account.txt");
    private static final Scanner INPUT = new Scanner(System.in);

    private final List<User> users = new ArrayList<>();

    public LoginSystem() {
        loadAccounts();
    }

    public void start() {
        int choice = 0;
        while (choice != 2) {
            choice = showWelcomeMsg();
            switch (choice) {
                case 0 -> login(inputAccount(), inputPassword());
                case 1 -> register(inputNickName(), inputAccount(), inputPassword());
            }
        }
    }

    public void loadAccounts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String[] accountInfo = reader.readLine().split(" ");
            String nickName = accountInfo[0];
            String account = accountInfo[1];
            String password = accountInfo[2];
            users.add(new User(nickName, account, password));
        } catch (FileNotFoundException ex) {
            System.out.println("查無檔案 account.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int showWelcomeMsg() {
        System.out.println("(0) 登入 (1) 註冊帳密 (2) 離開:");
        return INPUT.nextInt();
    }

    public void login(String account, String password) {
        for (User user : users) {
            if (account.equals(user.getAccount())) {
                if (password.equals(user.getPassword())) {
                    System.out.println("登入成功" + user);
                } else {
                    System.out.println("密碼不符合");
                }
            }
        }
        System.out.println("查無帳號");
    }

    public void register(String nickName, String account, String password) {
        try {
            if (registerValidation(account)) {
                writeAccount(nickName, account, password);
                users.add(new User(nickName, account, password));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeAccount(String nickName, String account, String password) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true))) {
            writer.write(String.join(" ", nickName, account, password));
            writer.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("查無檔案 account.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String inputNickName() {
        System.out.println("輸入暱稱:");
        return INPUT.nextLine();
    }

    public String inputAccount() {
        System.out.println("輸入帳號:");
        return INPUT.nextLine();
    }

    public String inputPassword() {
        System.out.println("輸入密碼:");
        return INPUT.nextLine();
    }

    public boolean registerValidation(String account) {
        for (User user : users) {
            if (user.getAccount().equals(account)) {
                return false;
            }
        }
        return true;
    }
}
