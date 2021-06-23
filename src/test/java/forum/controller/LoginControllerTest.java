package forum.controller;

import forum.Main;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void whenGetloginSuccess() {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("auth/login"));
    }

    @Test
    void whenAuthSuccess() {

    }

    @Test
    @SneakyThrows
    void whenGetlogoutPageSuccess() {
        this.mockMvc.perform(get("/logout"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?logout=true"));
    }
}