package com.batuhankiltac.northwind.service;

import com.batuhankiltac.northwind.entity.User;
import com.batuhankiltac.northwind.repository.UserRepository;
import com.batuhankiltac.northwind.service.user.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Mock
    private UserRepository userRepository;

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
        final List<User> users = Arrays.asList(user1, user2);

        // When
        userServiceImpl.getAll();

        // Then
        verify(userRepository).findAll();
        assertThat(users).isNotEmpty();
        assertThat(user1.getUserId()).isNotEqualTo(user2.getUserId());
        assertThat(user2.getEmail()).isEqualTo("test2@test.com");
    }

    @Test
    public void it_should_save_user() {
        // Given
        final User user = User.builder()
                .userId(1)
                .email("test@test.com")
                .password("123456")
                .build();

        // When
        userServiceImpl.add(user);

        // Then
        verify(userRepository).save(user);
        assertThat(user.getUserId()).isNotNull();
        assertThat(user.getEmail()).isEqualTo("test@test.com");
    }

    @Test
    public void it_should_update_user() {
        // Given
        final User user1 = User.builder()
                .userId(1)
                .email("test@test1.com")
                .password("123456")
                .build();
        final User user2 = User.builder()
                .userId(1)
                .email("test@test2.com")
                .password("1234567")
                .build();
        when(userRepository.findById(user1.getUserId())).thenReturn(Optional.of(user2));

        // When
        userServiceImpl.update(user1);

        // Then
        verify(userRepository).findById(user1.getUserId());
        verify(userRepository).save(user2);
    }

    @Test
    public void it_should_delete_user() {
        // Given
        final User user = User.builder()
                .userId(123)
                .build();

        // When
        userServiceImpl.delete(user.getUserId());

        // Then
        verify(userRepository).deleteById(user.getUserId());
    }
}