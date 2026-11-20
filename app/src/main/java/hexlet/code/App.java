package hexlet.code;

import io.javalin.Javalin;

public class App {
    public static Javalin getApp() {

        return Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();

            String portEnv = System.getenv("PORT");
            if (portEnv != null && !portEnv.isEmpty()) {
                config.jetty.port = Integer.parseInt(portEnv);
            } else {
                config.jetty.port = 7070;
            }

            config.routes.get("/", ctx -> ctx.result("Hello World"));
        });
}

    public static void main(String[] args) {

        getApp().start();
    }
}
