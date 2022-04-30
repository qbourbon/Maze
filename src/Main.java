import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import maze.Maze;
import maze.MazeReadingException;

public class Main {

	public static void main(String[] args) throws MazeReadingException {
		
		// On charge le labyrinthe
		Maze maze = new Maze(10, 10);
		maze.initFromTextFile("data/labyrinthe.txt");
		
		// On applique Dijkstra
		PreviousInterface previous = Dijkstra.dijkstra(maze, maze.getDeparture());
		
		// On en tire le chemin vers la sortie
		ArrayList<VertexInterface> path = previous.shortestPath(maze.getArrival());
		
		// On sauve ce chemin
		maze.saveWithPath("data/solve.txt", path);
	}

}
