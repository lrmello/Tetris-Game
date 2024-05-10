import java.awt.*;

public class TetrisPiece {
	private Color color;
	private int[][] shape;

	public TetrisPiece(int[][] shape, Color color) {
		this.shape = shape;
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public int[][] getShape() {
		return shape;
	}
}
