package com.joveo.mock.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
    @Mock
    private UserRepository userRepository;
    private UserRepositoryTestData userRepositoryTestData;

    @BeforeAll
    public void setup(){
        userRepositoryTestData = new UserRepositoryTestData();
    }

    @Test
    public void testFindByUserName(){
        ArrayList<User> usersData = new ArrayList<>();
        usersData.add(userRepositoryTestData.getUser());
        Mockito.when(userRepository.findByUserName("Santosh")).thenReturn(usersData);
        ArrayList<User> users = userRepository.findByUserName("Santosh");
        Mockito.verify(userRepository,Mockito.times(1)).findByUserName(
                "Santosh");
        Assertions.assertTrue(users.size()!=0);
        Assertions.assertTrue(users.get(0).getName().compareTo("Santosh")==0);

    }
}
