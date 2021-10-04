import org.junit.Test;
import static org.junit.Assert.assertNull;

public class LCATest {

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyTree() {
        new LCA(0, 0, null);
    }
   
}
