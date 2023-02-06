package ru.yirelav.bellintegrationtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import ru.yirelav.bellintegrationtask.config.PostgresTestContainersInitializer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ContextConfiguration(
        initializers = {
                PostgresTestContainersInitializer.class
        }
)
public abstract class BaseApiTest {

    @Autowired
    protected MockMvc mockMvc;

}
