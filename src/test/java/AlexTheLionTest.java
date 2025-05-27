import com.example.AlexTheLion;
import com.example.Feline;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AlexTheLionTest {


    @Mock
    Feline feline;

    private AlexTheLion alex;
    @BeforeEach
    public void setUp() throws Exception {
        alex = new AlexTheLion(feline);
    }

    @Test
    @DisplayName("get kittens test")
    public void getKittensTest() {
        assertEquals(0, alex.getKittens());

    }

    @Test
    @DisplayName("get friends test")
    public void getFriendsTest() {
        assertEquals(List.of("Marty", "Glory", "Melman"), alex.getFriends());
    }

    @Test
    @DisplayName("Get homeland test")
    public void getHomelandTest() {
        assertEquals("newYorkZoo", alex.getHomeLand());
    }
}