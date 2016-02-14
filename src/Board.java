import java.util.HashMap;

public class Board {

	public static void displayBoardOutput(int colSize, int rowSize,
			HashMap<Integer, HashMap<Integer, Character>> rowToColMap) {

		for (int i = rowSize; i >= 1; i--) {
			HashMap<Integer, Character> rowToValueMap = rowToColMap.get(i);
			if (rowToValueMap == null) {
				rowToValueMap = new HashMap<>();
			}
			for (int j = 1; j <= rowSize; j++) {
				if (rowToValueMap.get(j) != null) {
					System.out.print(rowToValueMap.get(j));
				} else {
					System.out.print("-");
				}
				
			}
			System.out.println();
		}
	}

	public static boolean isColNumberValid(int columnNumber, int colSize) {
		if (columnNumber >= 1 && columnNumber <= colSize) {
			return true;
		}
		return false;
	}

	public static boolean isBoardColumnFull(HashMap<Integer, HashMap<Integer, Character>> colToRowMap, int column,
			int rowSize) {
		if (colToRowMap.get(column) == null) {
			// No entry yet
			return false;
		}

		HashMap<Integer, Character> rowToValueMap = colToRowMap.get(column);
		if (rowToValueMap.size() < rowSize) {
			return false;
		}

		return true;

	}

	public static int addBallToBoard(int rowSize, char turn, int column,
			HashMap<Integer, HashMap<Integer, Character>> colToRowMap,
			HashMap<Integer, HashMap<Integer, Character>> rowToColMap) {
		HashMap<Integer, Character> rowToValueMap = new HashMap<>();
		if (colToRowMap.get(column) != null) {
			rowToValueMap = colToRowMap.get(column);
		}
		int rowNumber = 1;
		while (rowNumber <= rowSize) {
			if (rowToValueMap.get(rowNumber) == null) {
				rowToValueMap.put(rowNumber, turn);
				colToRowMap.put(column, rowToValueMap); // Updated columnHashMap

				if (rowToColMap.get(rowNumber) != null) {
					HashMap<Integer, Character> colToValueMap = rowToColMap.get(rowNumber);
					colToValueMap.put(column, turn);
					rowToColMap.put(rowNumber, colToValueMap);
				} else {
					HashMap<Integer, Character> colToValueMap = new HashMap<Integer, Character>();
					colToValueMap.put(column, turn);

					rowToColMap.put(rowNumber, colToValueMap);
				}
				return rowNumber;
			}
			++rowNumber;

		}

		return -1;
	}
}
