package dijkstra;

import java.util.ArrayList;

public interface PreviousInterface {

	// pere(y) <- pivot
	public void newFather(VertexInterface y, VertexInterface pivot);
	
	// Renvoie pere(vertex)
	public VertexInterface getFather(VertexInterface vertex);
	
	// Renvoie le plus court chemin vers vertex sous forme d'un tableau
	public ArrayList<VertexInterface> shortestPath(VertexInterface vertex);
	
}
