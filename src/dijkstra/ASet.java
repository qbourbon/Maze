package dijkstra;

import java.util.HashSet;

public class ASet implements ASetInterface {

	private final HashSet<VertexInterface> a;
	
	// Initialise un a vide 
	public ASet() {
		this.a = new HashSet<VertexInterface>();
	}

	@Override
	public final void add(VertexInterface vertex) {
		a.add(vertex);
	}

	@Override
	public final boolean contains(VertexInterface vertex) {
		return a.contains(vertex);
	}

}
