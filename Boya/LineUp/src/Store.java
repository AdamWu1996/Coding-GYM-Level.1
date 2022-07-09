import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Customer> queueStatus = new ArrayList<>();
    private String name;
    private MonitoringSystem monitoringSystem;

    public Store(MonitoringSystem monitoringSystem) {
        this.monitoringSystem = monitoringSystem;
    }

    public List<Customer> getQueueStatus() {
        return queueStatus;
    }

    public void enterQueue(Customer customer) {
        queueStatus.add(customer);
    }

    public void leaveQueue(Customer customer) {
        queueStatus.remove(customer);
    }

    public void updateToSystem() {
        monitoringSystem.updateStoreInfo(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
