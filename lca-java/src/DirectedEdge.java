/**
 * @author  Samuel Alarco Cantos
 * @since   31/3/2021
 */
public class DirectedEdge implements Comparable<DirectedEdge> {
    public final int from, to;
    public final double weight;

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

	@Override
	public int compareTo(DirectedEdge o) {
		if (this.from < o.from) return -1;
		if (this.from > o.from) return 1;
		
		if (this.to < o.to) return -1;
		if (this.to > o.to) return 1;
		
		if (this.weight < o.weight) return -1;
		if (this.weight > o.weight) return 1;
		
		return 0;
	}
}
