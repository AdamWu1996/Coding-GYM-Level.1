/**
 * @author - wally55077@gmail.com
 */
public class User {
    private final String nickName;
    private final String account;
    private final String password;

    public User(String nickName, String account, String password) {
        this.nickName = nickName;
        this.account = account;
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickName='" + nickName + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
