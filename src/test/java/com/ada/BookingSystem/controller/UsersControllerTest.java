package com.ada.BookingSystem.controller;

import com.ada.BookingSystem.controller.user.UserController;
import com.ada.BookingSystem.controller.user.UserDto;
import com.ada.BookingSystem.repository.entity.User;
import com.ada.BookingSystem.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
public class UsersControllerTest {

    final String BASE_URL = "/api/users";
    @MockBean
    private UserService userService;
    @Autowired
    private UserController userController;
    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = standaloneSetup(userController).build();
    }

    @Test
    public void getAllUser() throws Exception{
        List<User> users = Arrays.asList(
                new User(new UserDto("User Name","User Lastname", "user@example.com", "hashedPassword")),
                new User(new UserDto("User Name 2","User Lastname 2", "user2@example.com", "hashedPassword2"))
        );
        when(userService.all()).thenReturn(users);
        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findById_UserExists() {
        String userId = "123456";
        User user = new User(new UserDto("User Name","User Lastname", "user@example.com", "hashedPassword"));
        when(userService.findById(userId)).thenReturn(user);

        ResponseEntity<User> response = userController.findById(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("user@example.com", response.getBody().getEmail());
    }

    @Test
    public void findById_UserNotExists() {
        String userId = "123456";
        when(userService.findById(userId)).thenReturn(null);
        ResponseEntity<User> response = userController.findById(userId);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void createUser() throws Exception {
        UserDto userDto = new UserDto("User Name","User Lastname", "user@example.com", "hashedPassword");
        User user = new User(userDto);
        when(userService.create(any())).thenReturn(user);
        String json = "{\"id\":\"null\",\"name\":\"User Name\",\"lastName\":\"User LastName\",\"email\":\"user@example.com\",\"password\":\"hashedPassword\"}";

        mockMvc.perform(post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated());
        verify(userService, times(1)).create(any());
    }

    @Test
    public void updateUser() throws Exception {
        UserDto userDto = new UserDto("User Name","User Lastname", "user@example.com", "hashedPassword");
        User user = new User(userDto);
        when(userService.findById("1")).thenReturn(user);
        String json = "{\"id\":\"1\",\"name\":\"User Name\",\"lastName\":\"User LastName\",\"email\":\"user@example.com\",\"password\":\"hashedPassword\"}";
        mockMvc.perform(put(BASE_URL +"/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

        verify(userService, times(1)).update(userDto,"1");
    }

    @Test
    public void testDeleteExistingUser() throws Exception {
        UserDto userDto = new UserDto("User Name","User Lastname", "user@example.com", "hashedPassword");
        User user = new User(userDto);
        when(userService.findById("1")).thenReturn(user);

        String json = "{\"id\":\"1\",\"name\":\"User Name\",\"lastName\":\"User LastName\",\"email\":\"user@example.com\",\"password\":\"hashedPassword\"}";
        mockMvc.perform(delete(BASE_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());

        verify(userService, times(1)).deleteById("1");
    }
}
