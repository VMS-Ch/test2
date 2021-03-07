package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zms
 * @date 2021/03/05 19:47
 */
@Repository
public class JdbcTacoRepository implements TacoRepository {
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public Taco save(Taco taco) {
        long tacoId = saveTacoInfo(taco);  //保存taco，得到ID
        taco.setId(tacoId);
        for (Ingredient ingredient : taco.getIngredients()) {
            saveIngredientToTaco(ingredient, tacoId);  // 插入
        }
        return taco;
    }

    private void saveIngredientToTaco(Ingredient ingredient, long tacoId) {
        jdbc.update("insert into Taco_Ingredients (taco,ingredient) values (?,?)",
                tacoId, ingredient.getId());
    }

    private long saveTacoInfo(Taco taco) {
        taco.setCreatedAt(new Date());
        PreparedStatementCreator preparedStatementCreator = new PreparedStatementCreatorFactory(
                "insert into Taco(name,createAt) values (?,?)",
                Types.VARCHAR, Types.VARCHAR).newPreparedStatementCreator(
                Arrays.asList(
                        taco.getName(),
                        new Timestamp(taco.getCreatedAt().getTime()))); // 得到预处理对象
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder(); // 生成的新key值
        jdbc.update(preparedStatementCreator, keyHolder); // 执行更新
        return keyHolder.getKey().longValue(); // 返回key
    }
}
