package dev.java10x.MagicFridgeAI.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotenvConfig {
    static {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("API_KEY", dotenv.get("API_KEY", ""));
    }
}