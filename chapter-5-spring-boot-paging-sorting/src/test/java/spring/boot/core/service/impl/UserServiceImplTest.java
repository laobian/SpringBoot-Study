package spring.boot.core.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;
import spring.boot.core.domain.User;
import spring.boot.core.service.UserService;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Service
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void findByPage() {
        PageRequest request = new PageRequest(0,2);
        Page<User> result = userService.findByPage(request);
        result.getContent();
        Assert.assertNotNull(result);
    }

    @Test
    public void insertByUser() {
        User user = new User();
        user.setAge(18);
        user.setName("jpl");
        user.setBirthday("1996,08,15");
        user.setId(1L);

        User result =  userService.insertByUser(user);

        Assert.assertNotNull(result);
    }
}