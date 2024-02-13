import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private String name;
    private float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getBunNameTest() {
        return new Object[][] {
                {"Инопланетная", 1000},
                {"Super", 1500},
                {"ШоколаднаяLove123", 100},
                {"ШоколаднаяLove!@#$%^&*()-_=+", 43045},
                {"ШоколаднаяLove~9", 5000},
                {"ОченьдлинноеназваниебулочкиОченьдлинноеназваниебулочкиОченьдлинноеназваниебулочкиОченьдлинноеназваниебулочкиОченьдлинноеназваниебулочкиОченьдлинноеназваниебулочкиОченьдлинноеназваниебулочкиОченьдлинноеназваниебулочкиОченьдлинноеназваниебулочкиОченьдлинноеназваниебулочкиОченьдлинноеназваниебулочки", 234},
                {null, 1250},
                {" ", 5357833},
                {"1", 15},
                {"*", 500},
                {"А", -1},
                {"Сладкая Сладкая", 0},
                {"Солёная", Float.MIN_VALUE},
                {"кРоШечНаЯ", 1},
                {"карамельная", Float.MAX_VALUE},
                {"mini", Float.NaN}
        };
    }

    @Test
    public void bunNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals("ФР!=ОР. Название булочки неверное.", name, bun.getName());
    }

    @Test
    public void bunPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals("ФР!=ОР. Цена булочки неправильная.", price, bun.getPrice(), 0.0f);
    }
}