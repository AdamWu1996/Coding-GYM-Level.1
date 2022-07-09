/**
 * 學習目標: 基本物件導向 函數 變數 輸入輸出
 *
 * 寫一個計算面積的程式
 *
 * 使用者首先決定要計算何種形狀的面積：
 * (1) 三角形 (2) 矩形 (3) 圓形
 *
 * 然後針對各個形狀 輸入該有的參數 例如：
 * 選擇矩形
 *
 * 輸入長、寬：
 * 10 , 20
 *
 * 面積：200
 *
 * 限制：使用物件導向....
 *
 * 因此物件導向的世界中 三角形 矩形 圓形 應該都要是一個類別
 * 而他們的建構子應該要接收一些參數 像是圓形的建構子 要給予半徑
 */

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(1.5f);
        Rectangle rectangle = new Rectangle(10, 20);
        Triangle triangle = new Triangle(10, 5);

        System.out.println(circle.getArea());
        System.out.println(rectangle.getArea());
        System.out.println(triangle.getArea());

    }
}
