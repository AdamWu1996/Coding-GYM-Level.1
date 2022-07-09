import java.util.*;

public class MonitoringSystem {
    ArrayList<Store> stores = new ArrayList();
    private Scanner scanner = new Scanner(System.in);

    public void createStores() {
        String[] input = scanner.nextLine().split(" ");
        for (String storeName : input) {

        }
    }

    //若輸入客戶排隊訊息是系統職責
    public void inputCustomer() {
        while(true){
            var input = scanner.nextLine().split(" ");
            if(input.equals("0")){
                break;
            }
            else {
                String storeName = input[0];
                String customerName = input[1];
                String choice = input[2];

                switch (choice){
                    case "A":
                        //把客戶放進排隊隊伍
                        //需要隊伍的queue List
                        //stores.put(storeName, )
                        break;

                    case "R":
                        break;
                }
            }
        }
    }

    public void updateStoreInfo(Store store) {
        for (var entry : stores.entrySet()) {
            var storeName = entry.getKey();
            if (storeName.equals(store)) {
                stores.replace(storeName, store.getQueueStatus());
            }
        }
    }

    public void enterQueue(String storeName, String customerName){

    }

    public void leaveQueue(String storeName, String customerName){

    }

    public Store getStoreByName(String storeName){
        for (var entry : stores.entrySet()) {
            var name = entry.getKey();
            var customers = entry.getKey();
            if (storeName.equals(storeName)) {
                return customers;
            }
        }
        return null;
    }
}
