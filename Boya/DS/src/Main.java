import java.util.*;
//https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java
//https://openhome.cc/zh-tw/java/generics/syntax/
//https://openhome.cc/Gossip/JavaEssence/Foreach.html

/**
 * 學習目標：泛型、Comparator、iterator
 * <p>
 * 你已經使用過內建的許多資料結構 如：ArrayList, Stack, Set, Map ...
 * 每個資料結構在Java都支援泛型，
 * 現在你必須實作出自己的泛型資料結構：
 * <p>
 * 一種特殊的資料結構─
 * <p>
 * 此資料結構至少要提供以下功能：
 * <p>
 * push 放進一個資料
 * pop 取出下一個資料
 * 使用者必須 在實體化此資料結構的建構子中 提供Comparator來定義如何排序
 * 讓你的資料結構能夠使用 foreach 的方式走訪
 * 如果已經沒有資料了還pop 會拋出 例外
 * 以下說明此資料結構必須達到的特性：
 * <p>
 * 以下皆以int 作為資料的示範，實際情況以實作資料結構時使用者宣告的類型為主。
 * <p>
 * 每當使用者放入一個資料時，他會將資料加入結構中並且維持資料流的順序 (由小到大)。
 * image
 * <p>
 * 這個資料結構將資料排出的順序是很特殊的(意即走訪順序) =>頭尾輪流：
 * 即第一次會先pop掉位於順位最小的資料，第二次則會pop掉順位最大的資料，如此類推，頭尾不斷輪流，直到把所有資料排出為止。
 * <p>
 * image
 * <p>
 * 此題目有個限制：只能使用陣列，不能使用內建的資料結構例如ArrayList, Stack, Collections ...
 * 達到以上要求後在main中寫出測試碼即可，
 * 測試功能 1. push 2. pop 3. foreach 4. 例外
 * <p>
 * 可能像是如此：
 * <p>
 * public static void main(String[] args) {
 * Comparator<Student> myComparator = new MyComparator();  //自製 Comparator
 * WaterballStack<Student> myStack = new WaterballStack<Student>(myComparator);  //宣告
 * <p>
 * try{
 * for ( int i = 0 ; i < 10 ; i ++ )  //放入1~10 學生
 * myStack.push(new Student(i));
 * <p>
 * for (Student student : myStack)  // for-each走訪印出
 * System.out.print(student + " ");
 * <p>
 * System.out.println();
 * <p>
 * while(true)  //故意無限 pop 來觸發例外
 * {
 * Student nextStudent = myStack.pop();
 * System.out.print(nextStudent + " ");  //看看是否跟走訪的順序一樣
 * }
 * <p>
 * }catch(StackEmptyException err){
 * System.out.println(err.getMessage());
 * }
 * <p>
 * }
 */

public class Main {
    public static void main(String[] args) {
        CustomStack<Integer> customStack = new CustomStack<>();
        customStack.push(1);
        customStack.push(9);
        customStack.push(2);
        customStack.push(8);
        customStack.show();
//        customStack.pop();
//        customStack.show();
//        customStack.pop();
//        customStack.show();
//        customStack.pop();
//        customStack.show();
        for (Integer integer : customStack) {
            System.out.println(integer);
        }
    }
}