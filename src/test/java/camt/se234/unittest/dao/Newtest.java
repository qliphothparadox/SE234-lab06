package camt.se234.unittest.dao;

import camt.se234.unittest.entity.User;
import camt.se234.unittest.exception.OldManException;
import camt.se234.unittest.service.UserServiceImpl;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by CAMT on 3/27/2017.
 */
public class Newtest {
    @Test
    public void testLogin(){
        UserDao userDao=mock(UserDao.class);
        when(userDao.getUsers())
                .thenReturn(Arrays.asList(
                        new User("Prayuth","1234","Tu", LocalDate.of(1979,2,14),"08612345678"),
                        new User("Tucky","5675","Tuckung", LocalDate.of(1999,8,30),"08687654321"),
                        new User("Honey","aabbcc","Honey", LocalDate.of(2012, 11, 13),"0000000000"),
                        new User("None","none","NoName", LocalDate.of(2112, 1, 1),"9999999999")
                        )
                );
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        assertThat(userService.login("Prayuth", "1234"), is(new User("Prayuth", "1234", "Tu",
                LocalDate.of(1979, 2, 14), "08612345678")));

        assertThat(userService.login("Abc", "1234"), is(nullValue()));
//        assertThat(userDao.getUsers(),
//                hasItems(new User("Prayuth", "1234", "Tu",
//                                LocalDate.of(1979, 2, 14), "08612345678"),
//                        new User("Tucky", "5675", "Tuckung",
//                                LocalDate.of(1999, 8, 30), "08687654321"),
//                        new User("Honey", "aabbcc", "Honey",
//                                LocalDate.of(2012, 11, 13), "0000000000"),
//                        new User("None", "none", "NoName",
//                                LocalDate.of(2112, 1, 1), "9999999999")
//
//                ));
    }

    @Test
    public void testPuballow(){
        List<User> list = new ArrayList<>();
        list.add(new User("Prayuth", "1234", "Tu",
                LocalDate.of(1979, 2, 14), "08612345678"));
        UserDao userDao = mock(UserDao.class);
//        when(userDao.getPubAllowanceUser(LocalDate.of(2019,4,4)))
//                .thenReturn(list);
        when(userDao.getUsers())
                .thenReturn(list);
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        assertThat(userService.getPubAllowanceUser(LocalDate.of(2019, 4, 4)), is(list));
    }
    @Test
    public void testIsAbleTogotopub(){
        UserDao userDao = mock(UserDao.class);
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        assertThat(userService.isAbleToGoToPub(new User("Prayuth","1234","Tu",LocalDate.of(2016,12,28),"08612345678"),LocalDate.of(2036,12,29)),is(true));

        assertThat(userService.isAbleToGoToPub(new User("Prayuth","1234","Tu",LocalDate.of(2016,12,28),"08612345678"),LocalDate.of(2036,12,28)),is(true));

        assertThat(userService.isAbleToGoToPub(new User("Prayuth","1234","Tu",LocalDate.of(2016,12,28),"08612345678"),LocalDate.of(2036,12,27)),is(false));

        assertThat(userService.isAbleToGoToPub(new User("Prayuth","1234","Tu",LocalDate.of(2016,12,28),"08612345678"),LocalDate.of(2017,12,29)),is(false));
    }

    @Test
    public void loginn(){
        UserDao userDao = mock(UserDao.class);
        UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(userDao);
        List<User> list = new ArrayList<>();
        list.add(new User("Prayuth", "1234", "Tu",
                LocalDate.of(1979, 2, 14), "08612345678"));
        when(userDao.getUsers()).thenReturn(Arrays.asList(new User("Prayuth", "1234", "Tu", LocalDate.of(1979, 2, 14), "08612345678")));



        assertThat(userService.login("Prayuth", "1234"), is(new User("Prayuth", "1234", "Tu",
                LocalDate.of(1979, 2, 14), "08612345678")));

        assertThat(userService.login("Abc", "1234"), is(nullValue()));
    }










}
