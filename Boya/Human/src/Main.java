import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 學習目標: 多型 繼承 ArrayList
 *
 * --多型--
 *
 * 撰寫一個 Human 類別 代表人
 * 在這裡我們有兩個衍伸類別 Man 與 Woman
 * 他們用不同的規則活著：
 * Man : 吃飯時 印出"好好吃" 睡覺時 印出"zzz"
 * Woman: 吃飯時 印出"Orzz" 睡覺時 印出":)"
 *
 * (印出代表用System.our.println(...))
 *
 * 使用者會輸入一個字串 代表 男人與女人 的順序 ( b -> 男 g -> 女 大小寫皆可)
 * 像是: bgGGBgb 代表 男人有3位 女人有4位 照這個順序排列 (左到右)
 *
 * 之後照著順序印出所有人 先 吃飯 之後 睡覺 的情況
 *
 * 需使用多型
 *
 * 沒頭緒的話就讀熟多型的章節
 *
 * Example
 *
 * Input
 * bgGGBgb
 *
 * output
 *
 * 輸入字串：
 * bgGGBgb
 * 好好吃
 * Orzz
 * Orzz
 * Orzz
 * 好好吃
 * Orzz
 * 好好吃
 * zzz
 * :)
 * :)
 * :)
 * zzz
 * :)
 * zzz
 */
public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static List<Human> humanList = new ArrayList<>();

    public static void main(String[] args) {

        for (char c : scanner.nextLine().toCharArray()) {
            if(Character.toLowerCase(c) == 'b')
                humanList.add(new Man());

            if(Character.toLowerCase(c) == 'g')
                humanList.add(new Woman());
        }

        for (Human human : humanList) {
            human.eat();
        }

        for (Human human : humanList) {
            human.sleep();
        }
    }
}
