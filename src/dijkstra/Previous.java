package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

public class Previous implements PreviousInterface {

	// (y, père de y)
	private final Hashtable<VertexInterface, VertexInterface> previous;
	
	public Previous() {
		this.previous = new Hashtable<VertexInterface, VertexInterface>();
	}

	@Override
	public final void newFather(VertexInterface y, VertexInterface pivot) {
		previous.put(y, pivot);
	}

	@Override
	public final VertexInterface getFather(VertexInterface vertex) {
		return previous.get(vertex);
	}

	@Override
	public final ArrayList<VertexInterface> shortestPath(VertexInterface vertex) {
		
		ArrayList<VertexInterface> path = new ArrayList<VertexInterface>(); 
		
		while (vertex != null) {
			path.add(vertex);
			vertex = getFather(vertex);
		}
		
		return path;
	}

}
