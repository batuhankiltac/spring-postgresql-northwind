package com.batuhankiltac.northwind.service;

import com.batuhankiltac.northwind.core.entity.User;
import com.batuhankiltac.northwind.core.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void it_should_save_user() {
        // Given
        final User user = User.builder()
                .userId(1)
                .email("test@test.com")
                .password("123456")
                .build();

        // When
        when(userServiceImpl.add(user)).thenReturn(user);

        // Then
        assertThat(user.getUserId()).isNotNull();
        assertThat(user.getEmail()).isEqualTo("test@test.com");
    }

    @Test
    public void it_should_delete_user() {
        // Given
        final User user = User.builder().build();

        // When
        userServiceImpl.delete(user);

        // Then
        verify(userRepository).delete(user);
    }

    @Test
    public void it_should_get_all_users() {
        // Given
        final User user1 = User.builder()
                .userId(1)
                .email("test1@test.com")
                .password("123456")
                .build();
        final User user2 = User.builder()
                .userId(2)
                .email("test2@test.com")
                .password("123456")
                .build();
        final List<User> all = new ArrayList<>();
        all.add(user1);
        all.add(user2);

        // When
        when(userServiceImpl.getAll()).thenReturn(all);

        // Then
        assertThat(user1.getUserId()).isNotEqualTo(user2.getUserId());
        assertThat(user2.getEmail()).isEqualTo("test2@test.com");
    }
}