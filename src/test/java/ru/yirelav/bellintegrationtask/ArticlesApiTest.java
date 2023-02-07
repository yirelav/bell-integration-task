package ru.yirelav.bellintegrationtask;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;
import ru.yirelav.bellintegrationtask.utils.TestUtils;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@EnableAutoConfiguration
class ArticlesApiTest extends BaseApiTest {


    @WithMockUser(value = "test_user")
    @Test
    void givenValidCreateArticleReq_shouldCreatedWith201() throws Exception {
        assertEquals(0, articleRepository.count());
        String createArticleReq = TestUtils.loadFile("json/create_article_valid.json");
        mockMvc.perform(MockMvcRequestBuilders.post("/articles")
                        .contentType("application/json")
                        .content(createArticleReq))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());

        assertEquals(1, articleRepository.count());
    }

    @WithMockUser(value = "test_user")
    @Test
    void givenCreateArticleReqWithVeryLongTitle_shouldReturnBadRequest403WithSimpleErrorBody() throws Exception {
        String createArticleReq = TestUtils.loadFile("json/create_article_non_valid_title.json");
        mockMvc.perform(MockMvcRequestBuilders.post("/articles")
                        .contentType("application/json")
                        .content(createArticleReq))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                .andDo(MockMvcResultHandlers.print());
        assertEquals(0, articleRepository.count());
    }

    @WithMockUser(value = "test_user")
    @Test
    void givenArticlesReq_shouldReturn200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/articles")
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @WithMockUser(value = "test_user")
    @Test
    void givenPageReq_shouldReturnWith200() throws Exception {
        entityCreator.createNArticles(15);
        mockMvc.perform(MockMvcRequestBuilders.get("/articles")
                        .contentType("application/json")
                        .queryParam("page", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.page").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content", hasSize(5)))
                .andDo(MockMvcResultHandlers.print());
        assertEquals(15, articleRepository.count());
    }

    @Test
    void givenUnauthenticatedReq_shouldUnauthorizedWith401() throws Exception {
        String createArticleReq = TestUtils.loadFile("json/create_article_valid.json");
        mockMvc.perform(MockMvcRequestBuilders.post("/articles")
                        .contentType("application/json")
                        .content(createArticleReq))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized())
                .andDo(MockMvcResultHandlers.print());

        assertEquals(0, articleRepository.count());
    }

}
