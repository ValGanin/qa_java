import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    Feline feline;

    private Lion maleLion;

    static Object[][] genderProvider() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @BeforeEach
    void setUp() throws Exception {
        maleLion = new Lion("Самец", feline);

    }

    @Test
    @DisplayName("Get kittens lion test")
    public void getKittensTest() {
        maleLion.getKittens();
        verify(feline).getKittens();
    }

    @Test
    @DisplayName("Get food lion test")
    public void getFoodTest() throws Exception {
        maleLion.getFood();
        verify(feline).getFood("Хищник");
    }

    @Test
    @DisplayName("Kittens counter test")
    public void testGetKittensWithFiveTest() {
        Feline feline = new Feline();
        int result = feline.getKittens(5);
        assertEquals(5, result, "Количество котят некорректное, должно быть  5");
    }

    @ParameterizedTest
    @MethodSource("genderProvider")
    @DisplayName("Mane test")
    public void maneTest(String gender, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(gender, feline);
        assertEquals(expectedHasMane, lion.doesHaveMane(), "Грива у льва должна соответствовать его полу");

    }

    @Test
    @DisplayName("Constructor exception test")
    void differentGenderExceptionTest() {
        assertThrows(Exception.class, () -> new Lion("Ягодка", feline));
    }
}