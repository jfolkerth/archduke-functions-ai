package app.archduke;

import com.google.cloud.functions.HttpFunction;
import com.google.cloud.functions.HttpRequest;
import com.google.cloud.functions.HttpResponse;

import java.io.IOException;

public class WelcomeArchduke implements HttpFunction {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        response.getWriter().write("Welcome to Archduke");
    }
}
