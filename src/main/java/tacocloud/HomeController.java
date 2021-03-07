package tacocloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author zms
 * @date 2021/03/03 19:39
 */
@RestController
public class HomeController {
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String getProduct(@PathVariable("id") int id) {
        System.out.println(id);
        return "product";
    }

    @RequestMapping("/user")
    public String produce(String username) {
        return "XXXX";
    }
}
