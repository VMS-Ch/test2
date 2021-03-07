package tacocloud;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zms
 * @date 2021/03/04 19:55
 */
@Component
@ConfigurationProperties(prefix = "personinfo")
@Data
public class GetPersonInfoProperties {
    String name;
    int age;
}
