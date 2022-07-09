import java.util.Scanner;

/**
 * 學習目標: 物件陣列 , 排序
 * <p>
 * 你要寫一個學生資訊系統
 * <p>
 * 使用者首先輸入有幾個學生
 * <p>
 * 然後依序每一列輸入各個學生的
 * <p>
 * 「身高、體重、成績、學號」
 * <p>
 * 輸入完之後
 * <p>
 * 讓每個學生依照成績由小到大排序
 * 排序完後照順序印出全部學生資料
 * <p>
 * 限制：用物件導向存放學生資料
 * 並且在學生類別內定義印出自己資訊的函數
 * <p>
 * 輸入:
 * <p>
 * 5
 * 160 50 80 03360247
 * 176 85 100 03360296
 * 150 46 55 03362455
 * 166 72 32 03360222
 * 175 74 81 02360427
 * <p>
 * 輸出:
 * <p>
 * Student [height=166, weight=72, grades=32, id= 03360222]
 * Student [height=150, weight=46, grades=55, id= 03362455]
 * Student [height=160, weight=50, grades=80, id= 03360247]
 * Student [height=175, weight=74, grades=81, id= 02360427 ]
 * Student [height=176, weight=85, grades=100, id= 03360296]
 */

public class Main {
    public static void main(String[] args) {
        StudentInfoSystem studentInfoSystem = new StudentInfoSystem();
        studentInfoSystem.start();
        System.out.println(studentInfoSystem);
    }
}
