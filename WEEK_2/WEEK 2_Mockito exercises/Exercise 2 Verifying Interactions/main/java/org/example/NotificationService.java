package org.example;

public class NotificationService {
    private final NotificationApi api;

    public NotificationService(NotificationApi api) {
        this.api = api;
    }

    public void triggerNotification() {
        api.sendNotification("Hello User");
    }
}
