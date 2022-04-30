package maze;

public class MazeReadingException extends Exception {
	
	private static final long serialVersionUID = 3245085453866468235L;

	public MazeReadingException(String fileName, int line) {
		super("Erreur à la ligne " + line + " du fichier " + fileName);
	}
}
