package org.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class NotificationServiceTest {

    @Test
    public void testSendNotificationCalledWithCorrectArgument() {
        System.out.println("Creating mock NotificationApi...");
        NotificationApi mockApi = mock(NotificationApi.class);

        NotificationService service = new NotificationService(mockApi);
        System.out.println("Triggering notification...");
        service.triggerNotification();

        System.out.println("Verifying interaction...");
        verify(mockApi).sendNotification("Hello User");

        System.out.println("Method was called with expected argument.");
    }
}
