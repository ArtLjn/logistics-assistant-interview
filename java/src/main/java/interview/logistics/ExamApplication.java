package interview.logistics;

import com.fasterxml.jackson.databind.JsonNode;
import java.nio.file.Path;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class ExamApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
    }
}

@RestController
class AskController {
    @GetMapping("/")
    ModelAndView index() {
        return new ModelAndView("forward:/web/index.html");
    }

    @PostMapping("/ask")
    ResponseEntity<Map<String, String>> ask(@RequestBody JsonNode payload) {
        // 在此接入候选人实现的问答流程。
        return ResponseEntity.status(501).body(Map.of("message", "请实现 POST /ask"));
    }
}

@Configuration
class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/web/**")
            .addResourceLocations(Path.of("web").toAbsolutePath().toUri().toString() + "/");
    }
}
