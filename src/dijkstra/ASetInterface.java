package dijkstra;

public interface ASetInterface {
	
	// Ajoute un sommet � A
	public void add(VertexInterface vertex); 
	
	// Retourne si un sommet est dans A
	public boolean contains(VertexInterface vertex);
	
}
