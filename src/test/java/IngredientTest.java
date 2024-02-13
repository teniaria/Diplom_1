import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final static RandomStringUtils randomStringUtils = new RandomStringUtils();
    private final static Random random = new Random();
    private final IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunNameTest() {
        return new Object[][]{
                {IngredientType.SAUCE, randomStringUtils.randomAlphabetic(10), random.nextFloat()},
                {IngredientType.FILLING, randomStringUtils.randomAlphabetic(10), random.nextFloat()}
        };
    }

    @Test
    public void ingredientTypeTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("ФР!=ОР. Ошибка в типе ингредиента", type, ingredient.getType());
    }

    @Test
    public void ingredientNameTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("ФР!=ОР. Ошибка в названии ингредиента.", name, ingredient.getName());
    }

    @Test
    public void ingredientPriceTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("ФР!=ОР. Ошибка в цене ингредиента.", price, ingredient.getPrice(), 0.0f);
    }
}