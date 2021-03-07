package jdbc;

/**
 * @author zms
 * @date 2021/03/05 18:26
 */
public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Ingredient findOne(String id);

    Ingredient save(Ingredient ingredient);
}
