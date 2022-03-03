package com.codeup.springblog;

import com.codeup.springblog.models.Author;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.AuthorRepository;
import com.codeup.springblog.repositories.BookRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringblogApplication.class)
@AutoConfigureMockMvc
public class BooksIntegrationTests{

    private User testUser;
    private HttpSession httpSession;

    @Autowired
    private MockMvc mvc;

    @Autowired
    BookRepository userDao;

    @Autowired
    BookRepository bookDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Before
    public void setup() throws Exception{
        testUser = userDao.findByUserName("testUser");

        //creates the test if not exists
        if(testUser == null){
            User newUser = new User();
            newUser .SetUsername(testUser);
            newUser .SetPassword(testUser);
            newUser .SetEmail("testUser@codeup.com");
            testUser=userDao.save(newUser);
            //testUser = userDao.save(newUser);


        }
    }

}
