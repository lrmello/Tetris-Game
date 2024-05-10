import java.awt.*;
import java.util.Random;

public class TetrisController {
	private static final Color[] COLORS = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW};
	private static final int[][][] SHAPES = {
			{{1, 1, 1, 1}},
			{{1, 1, 0}, {0, 1, 1}},
			{{0, 1, 1}, {1, 1, 0}},
			{{1, 1 ,1}, {0 , 1, 0}},
			{{1, 1}, {1 ,1}}
	};

	private TetrisPiece currentPiece;
	private int currentX, currentY;

	public TetrisController(){
		generateNewPiece();
	}

	public TetrisPiece getCurrentPiece(){
		return currentPiece;
	}

	public int getCurrentX() {
		return currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public void moveL(){
		currentX--;
	}

	public void moveR(){
		currentX++;
	}

	public void moveDown(){
		currentY++;
	}

	public void generateNewPiece(){
		Random random = new Random();
		int index = random.nextInt(COLORS.length);
		Color color = COLORS[index];
		int [][] shape = SHAPES[random.nextInt(SHAPES.length)];

		currentPiece = new TetrisPiece(shape, color);
		currentX = 5;
		currentY = 0;
	}
}
