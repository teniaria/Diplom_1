import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredientSauce, ingredientFilling;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientSauce);
        assertTrue(burger.ingredients.contains(ingredientSauce));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        assertEquals(2, burger.ingredients.size());
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientFilling);
        burger.addIngredient(ingredientSauce);
        burger.moveIngredient(0,1);
        assertEquals(ingredientFilling, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        when(bun.getPrice()).thenReturn(50f);
        when(ingredientFilling.getPrice()).thenReturn(15f);
        when(ingredientSauce.getPrice()).thenReturn(5f);
        float expectedPrice = (50f * 2) + 15f + 5f;
        System.out.println(expectedPrice);
        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientSauce);
        burger.addIngredient(ingredientFilling);
        String expectedReceipt = "(==== burger ====)\r\n" +
                "= sauce ingredientSauce =\r\n" +
                "= filling ingredientFilling =\r\n" +
                "(==== burger ====)\r\n" +
                "\r\n" +
                "Price: 120,000000\r\n";
        when(bun.getName()).thenReturn("burger");
        when(ingredientSauce.getName()).thenReturn("ingredientSauce");
        when(ingredientFilling.getName()).thenReturn("ingredientFilling");
        when(bun.getPrice()).thenReturn(50f);
        when(ingredientSauce.getPrice()).thenReturn(5F);
        when(ingredientFilling.getPrice()).thenReturn(15F);
        when(ingredientSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientFilling.getType()).thenReturn(IngredientType.FILLING);
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}