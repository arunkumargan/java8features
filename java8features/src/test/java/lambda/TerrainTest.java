package lambda;

import org.junit.Test;
import static org.junit.Assert.*;

public class TerrainTest {

	@Test
	public void infiniteTerrain() {
		Terrain infiniteTerrain = (pos) -> true;
	}

	@Test
	public void terrainFunctionTest() {
		char[][] arr = {
			{'-','-','-'},
			{'-','o','-'},
			{'-','o','-'},
			{'-','o','-'},
			{'-','-','-'}
		};
		Terrain terrain = terrainFunction(arr);
		assertTrue(terrain.isAccessible(new Pos(1, 1)));
	}

	public Terrain terrainFunction(char[][] arr) {
		return (pos) -> {
			if (pos.x > arr.length - 1 || pos.y > arr[0].length - 1 || pos.x < 0 || pos.y < 0) {
				return false;
			} else {
				char ch = arr[pos.x][pos.y];
				return ch == 'o';
			}
		};
	}
}

class Pos {
	final int x;
	final int y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Pos pos = (Pos) o;

		if (x != pos.x) return false;
		if (y != pos.y) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}
}
interface Terrain {
	public boolean isAccessible(Pos pos);
}

