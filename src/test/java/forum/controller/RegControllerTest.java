package forum.controller;

import forum.Main;
import forum.model.User;
import forum.repository.UserRepository;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class RegControllerTest {

    @MockBean
    private UserRepository users;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    @WithAnonymousUser
    void whenGetRegSuccess() {
        this.mockMvc.perform(get("/reg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("auth/reg"));
    }

    @Test
    @SneakyThrows
    @WithAnonymousUser
    void whenPostRegSuccess() {
        this.mockMvc.perform(post("/reg")
                .param("username", "TestUser")
                .param("password", "test")
        )
                .andDo(print())
                .andExpect(status().is3xxRedirection());

        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(users).save(argument.capture());
        Assert.assertThat(argument.getValue().getUsername(), is("TestUser"));
    }
}