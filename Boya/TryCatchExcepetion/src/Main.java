public class Main {
    /**
     * 學習目標: 常數 (final) 靜態變數(static) 例外處理
     * <p>
     * 你要撰寫一個登入系統類別
     * 此類別提供讓使用者輸入帳號與密碼的介面，
     * 並處理相關邏輯或例外。
     * <p>
     * 預設值是: 帳號: "123" ， 密碼: "567" (請設定為常數 final static)
     * 如果使用者輸入不符合的話，依照以下規則丟出"自定義例外"：
     * <p>
     * 帳號 不符合 throw AccountNotFoundException 印出"帳密不符合"
     * 密碼 不符合 throw PasswordNotFoundException 印出"密碼不符合"
     * 帳密都不符合 throw PairInfoNotFoundException 印出"帳密不符合"
     * 在main中接取例外並印出例外訊息
     * <p>
     * 若帳密皆符合 則直接印出"登入成功"
     * <p>
     * EXAMPLE:
     * <p>
     * 輸入帳號: 000
     * 輸入密碼: 567
     * <p>
     * 密碼不符合
     * <p>
     * 輸入帳號: 000
     * 輸入密碼: 000
     * <p>
     * 帳密不符合
     * <p>
     * 輸入帳號: 123
     * 輸入密碼: 567
     * <p>
     * 登入成功
     * <p>
     * (如果把例外軌跡印出來的話...)
     */
    public static void main(String[] args) {
        LoginSystem loginSystem = new LoginSystem();
        loginSystem.login();
    }
}
