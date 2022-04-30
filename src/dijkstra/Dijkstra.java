package dijkstra;

import java.util.ArrayList;

public class Dijkstra {
		
	public static final PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		
		Previous previous = new Previous();
		
		Pi pi = new Pi();

		// A = {r}
		ASet a = new ASet();
		a.add(r);
		
		// initialise le pivot
		VertexInterface pivot = r;
		pi.setPi(r, 0);
		
		// Tableau de tous les sommets du graphe
		ArrayList<VertexInterface> allVertices = g.getAllVertices() ;
		
		for(VertexInterface vertex : allVertices) {
			if(vertex != r) {
				pi.setPi(vertex, Integer.MAX_VALUE);
			}
		}
		
		for(int j=0; j < allVertices.size() - 1; j++) {
			ArrayList<VertexInterface> successors = g.getSuccessors(pivot);
			for(VertexInterface vertex : successors) {
				if (! a.contains(vertex)) {
					if (pi.value(pivot) + 1 < pi.value(vertex)) {
						pi.setPi(vertex, pi.value(pivot) + 1);
						previous.newFather(vertex, pivot);
					}
				}
			}
			
			pivot = pi.newPivot(g, a);
			
			// Pour éviter un 'bug'
			if (pivot == null) 
				return previous;
			
			a.add(pivot);
		}
		
		return previous;
	}

}
