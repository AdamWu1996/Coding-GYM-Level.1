import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.sleep;

/**
 * 訓練目的：執行緒之synchronized', 'notifyAll(), notify(), wait() 之使用
 * <p>
 * 模擬一間餐廳，餐廳有以下三個事件：
 * <p>
 * 上門點單： 每2~7秒鐘(隨機)會有一個客人上門並且隨機點一道菜 (上訂單)
 * 餐廳一共有5道菜，每道料理都有他所需的花費時間以及價格：
 * 漢堡 13秒 23$
 * 披薩 18秒 30$
 * 薯條 6秒 11$
 * 雞塊 8秒 13$
 * 雞腿 25秒 40$
 * 執行訂單： 餐廳中有5個廚師，只要尚有訂單未完成，就會有一個廚師去執行訂單 (開始製作訂單上的菜，並耗費該料理所需時間)。
 * 結單 若該訂單完成，客人就會結帳(此時才真正賺到錢)！並且離去！負責該訂單的廚師就此進入休閒狀態！
 * image
 * <p>
 * 因為會有五個廚師同時處理餐廳訂單，因此一定要有5個執行緒！越多廚師(執行緒)則效率越高！
 * 如果廚師進入休閒狀態，則廚師應該要立刻去查看是否有訂單！如果餐廳沒有訂單，那這些廚師應該要進入 wait 的狀態，而若有人上門點單則要使用 notify 呼叫其中一位廚師！
 * 同步要做好，若有人同時上門點單，則需要避免有多個廚師同時被喚醒並嘗試接收同一份訂單！
 * <p>
 * 印出餐廳的每一個事件以及狀態！2分鐘之後關閉程式！最後印出賺了多少錢！
 * <p>
 * 所以你必須有個執行緒負責計時，2分鐘後通知餐廳結業！
 * <p>
 * 印出越多資訊越好！才能感受到模擬餐廳的詳細情況！
 * 例如印出：
 * XXX客人點了一道XXX
 * XXX廚師開始製作XXX客人要求的XXX
 * XXX廚師完成了XXX客人要求的XXX，賺到了XX$
 * <p>
 * 此題目限制：禁止使用觀察者模式/BlockingQueue，但若你這題通過了，請去學如何使用BlockingQueue！
 * <p>
 * BlockingQueue 是個已經實作了 wait 和 notify 的佇列，非常好用，但請先別使用他！
 * <p>
 * 產生客人 1
 * 廚師 5
 */
public class Main {
    static void pause(int millis) {
        try {
            sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        var clerk = new Clerk();
        new Thread(new Producer(clerk)).start();
        new Thread(new Consumer(clerk)).start();
    }
}