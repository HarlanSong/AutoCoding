package cn.songhaiqing.autoadmin.test;


import cn.songhaiqing.autoadmin.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestDemo {


    @Test
    public void test(){
        // 测试方法，可像Controller一样直接使用service
    }
}
