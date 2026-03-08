import java.util.*;

public class EventManager {
    private Map<String, List<EventListeners>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        Arrays.stream(operations).forEach(operation -> {
            listeners.put(operation, new ArrayList<>());
        });
    }

    public void subscribe(String eventType, EventListeners listener) {
        listeners.get(eventType).add(listener);
    }

    public void unsubscribe(String eventType, EventListeners listener) {
        listeners.get(eventType).remove(listener);
    }

    public void notify(String eventType, String data) {
        listeners.get(eventType)
                .forEach(subscriber -> {
                    subscriber.update(data);
                });
    }
}
