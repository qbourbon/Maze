package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

public class Pi implements PiInterface {

	private final Hashtable<VertexInterface, Integer> pi;
	
	public Pi() {
		this.pi = new Hashtable<VertexInterface, Integer>();
	}

	@Override
	public final int value(VertexInterface vertex) {
		return pi.get(vertex);
	}

	@Override
	public final void setPi(VertexInterface vertex, int newLength) {
		pi.put(vertex, newLength);
	}

	@Override
	public final VertexInterface newPivot(GraphInterface g, ASetInterface a) {
		
		// On cherche le minimum non dans a

		// Initialisation
		VertexInterface newPivot= null;
		int min= Integer.MAX_VALUE;
		
		ArrayList<VertexInterface> allVertices = g.getAllVertices();
		
		for (VertexInterface vertex : allVertices) {
			// On cherche parmis les sommets non dans a
			if (! a.contains(vertex)) { 
				int piVertex = this.value(vertex);
				if (piVertex < min) {
					newPivot = vertex;
					min = piVertex;
				}
			}
		}	
		
	    return newPivot;
	}

}
