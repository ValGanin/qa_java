import com.example.Animal;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalTest {

    Animal animal = new Animal();

    static Object[][] typeProvider() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @ParameterizedTest
    @MethodSource("typeProvider")
    @DisplayName("Get food test")
    public void getFoodTest(String food, List<String> menu) throws Exception {
        Assertions.assertEquals(menu, animal.getFood(food));
    }

    @Test
    @DisplayName("Constructor exception test")
    void differentTypeExceptionTest() {
        assertThrows(Exception.class, () -> animal.getFood("Газообразное"));
    }

    @Test
    @DisplayName("Get family test")
    void getFamilyTest() {
        Assertions.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", animal.getFamily());
    }
}