package dijkstra;

public interface PiInterface {

	
	// Retourne la valeur pi(vertex)
	public int value(VertexInterface vertex);
	
	// pi(vertex) <- newLength
	public void setPi(VertexInterface vertex, int newLength);
	
	// retourne le nouveau pivot
	public VertexInterface newPivot(GraphInterface g, ASetInterface aset);	
}
