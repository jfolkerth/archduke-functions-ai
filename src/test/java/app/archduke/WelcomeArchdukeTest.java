package app.archduke;

import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WelcomeArchdukeTest {
    private WelcomeArchduke function;

    @Mock
    private HttpRequest request;

    @Mock
    private HttpResponse response;

    @BeforeEach
    public void setUp() {
        function = new WelcomeArchduke();
    }

    @Test
    public void testService() throws IOException {
        StringWriter responseWriter = new StringWriter();
        BufferedWriter bufferedWriter = new BufferedWriter(responseWriter);

        System.out.println("response: " + response.toString());

        when(response.getWriter()).thenReturn(bufferedWriter);

        function.service(request, response);

        bufferedWriter.flush();

        verify(response).getWriter();
        assertEquals("Welcome to Archduke", responseWriter.toString());
    }
}
