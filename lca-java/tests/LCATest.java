import org.junit.Test;
import static org.junit.Assert.*;

public class LCATest {

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyGraph() {
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph();
        new LCA(graph);
    }

    
   
}
