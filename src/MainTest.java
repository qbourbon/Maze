import java.util.ArrayList;

import dijkstra.Dijkstra;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import maze.MBox;
import maze.Maze;
import maze.MazeReadingException;

public class MainTest {

	public static void main(String[] args) throws MazeReadingException {
		
		/*// On charge le labyrinthe
		Maze maze = new Maze(10, 10);
		maze.initFromTextFile("data/labyrinthe.txt");
		
		// On applique Dijkstra
		PreviousInterface previous = Dijkstra.dijkstra(maze, maze.getStart());
		
		// On en tire le chemin vers la sortie
		ArrayList<VertexInterface> path = previous.shortestPath(maze.getEnd());
		
		// On sauve ce chemin
		maze.saveWithPath("data/solve.txt", path);
		
		maze.initFromTextFile("data/solve.txt");
		
		maze.saveToTextFile("data/labyrinthe2.txt");*/
		
		// Test pour générer le labyrinthe
		/*Maze maze = new Maze(10, 10);
		maze.reset();
		MBox[] DA = maze.generateDepartureArrival();
		ArrayList<MBox> path = maze.generatePath(DA[0], DA[1]);
		System.out.println(path.size());*/
	}
}
