package com.example.h2mock;
import com.example.h2mock.entity.User;
import com.example.h2mock.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * 使用mock测试userService
 */
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    /**
     * 使用mock测试
     */
    @Mock
    private UserServiceImpl userService;

    @Test
    public void findAll() {
        //Given
        Mockito.when(userService.findAll()).thenReturn(
                Collections.singletonList(new User(1, "pdai.tech", "1221111")));

        //When
        List<User> userDtoList = userService.findAll();

        //Then
        assertFalse(userDtoList.isEmpty());
        verify(userService, times(1)).findAll();
    }
}