import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CatTest {

    @Mock
    Feline feline;
    private Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat(feline);
    }

    @Test
    @DisplayName("getSound returns 'Мяу'")
    void getSoundTest() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    @DisplayName("getFood returns the list from Feline.eatMeat()")
    void getFoodTest() throws Exception {
        // Подготовка
        List<String> expected = List.of("Мыши", "Птицы");
        when(feline.eatMeat()).thenReturn(expected);

        // Проверка
        List<String> actual = cat.getFood();
        assertEquals(expected, actual);

        // Убедимся, что метод вызывался
        verify(feline, times(1)).eatMeat();
    }
}
