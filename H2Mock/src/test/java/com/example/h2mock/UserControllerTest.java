package com.example.h2mock;
import com.example.h2mock.controller.UserController;
import com.example.h2mock.entity.User;
import com.example.h2mock.services.IUserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Collections;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 使用mock测试UserControllerTest
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * 使用mock测试
     */
    @MockBean
    private IUserService userService;

    /**
     * test find all user.
     *
     * @throws Exception exception
     */
    @Test
    @DisplayName("Test findAll()")
    public void list() throws Exception {
        Mockito.when(userService.findAll()).thenReturn(
                Collections.singletonList(new User(1, "pdai.tech", "1221111")));

        mockMvc.perform(MockMvcRequestBuilders.get("/user/list")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService, times(1)).findAll();
    }
}
