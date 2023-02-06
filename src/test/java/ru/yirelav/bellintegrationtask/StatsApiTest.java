package ru.yirelav.bellintegrationtask;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.hasSize;

@EnableAutoConfiguration
class StatsApiTest extends BaseApiTest {

    @BeforeEach
    void BeforeEach() {
        articleRepository.deleteAll();
    }

//    @WithMockUser(value = "test_admin")
    @Test
    void givenDailyStatsReq_shouldReturn200() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/backoffice/articles/stats")
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

//    @WithMockUser(value = "test_user")
    @Test
    void givenDailyStatsReqFromUser_shouldReturnForbiddenWith403() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/backoffice/articles/stats")
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isForbidden())
                .andDo(MockMvcResultHandlers.print());
    }

}
