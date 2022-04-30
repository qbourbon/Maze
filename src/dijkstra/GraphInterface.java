package dijkstra;
import java.util.ArrayList;

public interface GraphInterface {

	/** Renvoie les sommets accessible d'une case dans une ArrayList
	 * 
	 * @param pivot Le sommmet dont on souhaite connaitre ses possibles successeurs
	 * @return Les sommets accessibles sous forme d'ArrayList 
	 */
	public ArrayList<VertexInterface> getSuccessors(VertexInterface pivot);
	
	/** Renvoie tous les sommets dans une ArrayList
	 * 
	 * @return Tous les sommets dans une ArrayList
	 */
	public ArrayList<VertexInterface> getAllVertices();
}