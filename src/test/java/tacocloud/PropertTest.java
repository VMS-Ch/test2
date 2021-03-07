package tacocloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zms
 * @date 2021/03/04 19:43
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PropertTest {
    @Value("${myEnv.name}")
    private String name;

    @Test
    public void get() {
        System.out.println(name);
    }
}
