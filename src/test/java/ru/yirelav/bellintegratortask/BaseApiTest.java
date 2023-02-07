package ru.yirelav.bellintegratortask;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.yirelav.bellintegratortask.config.PostgresTestContainersInitializer;
import ru.yirelav.bellintegratortask.repository.ArticleRepository;
import ru.yirelav.bellintegratortask.service.EntityCreator;

import java.util.logging.Level;
import java.util.logging.LogManager;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ContextConfiguration(
        initializers = {
                PostgresTestContainersInitializer.class
        }
)
public abstract class BaseApiTest {
    static {
        // Postgres JDBC driver uses JUL;
        // disable it to avoid annoying, irrelevant, stderr logs during connection testing
        LogManager.getLogManager().getLogger("").setLevel(Level.OFF);
    }

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    EntityCreator entityCreator;

    @BeforeEach
    void reset() {
        articleRepository.deleteAll();
    }
}
