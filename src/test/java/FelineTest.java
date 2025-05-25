import com.example.Feline;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void setFelineKittensToFive() {
        Assertions.assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void setFelineKittensToDefault() {
        Assertions.assertEquals(1, feline.getKittens());
    }

    @Test
    public void setFelineKittensNoParamToCheckAmount() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void isFelinePredator() throws Exception {
        Assertions.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.getFood("Хищник"));
    }
    @Test
    @DisplayName("Eat meat test")
    public void eatMeatTest() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        Assertions.assertEquals(expectedFood, actualFood);
    }

    @Test
    @DisplayName("Get family test")
    public void getFamilyTest() {
        Assertions.assertEquals("Кошачьи", feline.getFamily());
    }
}