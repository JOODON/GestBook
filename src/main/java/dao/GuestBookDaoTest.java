package dao;

import config.ApplicationConfig;
import dto.Guestbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class GuestBookDaoTest {
    public static void main(String[] args) {
        ApplicationContext ac=new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestBookDao guestBookDao=ac.getBean(GuestBookDao.class);

        Guestbook guestbook=new Guestbook();
        guestbook.setName("주동호");
        guestbook.setContent("안녕하세요 테스트입니다");
        guestbook.setRegdate(String.valueOf(new Date()));
        Long id= guestBookDao.insert(guestbook);
        System.out.println("ID:"+id);

    }
}
