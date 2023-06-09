public class Map {

    static Board board1 = new Board(12,12);
    static BoardWindow boardWindow = new BoardWindow(board1, "Archaeology Adventure", 50);

    public static void createMap1() {
        boardWindow.getBoard().setCell(5, 5, CellType.CURRENT_ROOM);
        boardWindow.getBoard().setCell(4, 5, CellType.STANDARD);
        boardWindow.getBoard().setCell(4, 4, CellType.STANDARD);
        boardWindow.getBoard().setCell(3, 5, CellType.STANDARD);
        boardWindow.getBoard().setCell(3, 6, CellType.STANDARD);
        boardWindow.getBoard().setCell(3, 7, CellType.STANDARD);
        boardWindow.getBoard().setCell(2, 7, CellType.STANDARD);
        boardWindow.getBoard().setCell(4, 7, CellType.STANDARD);
    }

    public static void createMap2() {
        boardWindow.getBoard().setCell(6, 7, CellType.STANDARD);
        boardWindow.getBoard().setCell(7, 7, CellType.STANDARD);
        boardWindow.getBoard().setCell(7, 6, CellType.STANDARD);
        boardWindow.getBoard().setCell(8, 6, CellType.STANDARD);
        boardWindow.getBoard().setCell(8, 7, CellType.STANDARD);
        boardWindow.getBoard().setCell(9, 7, CellType.STANDARD);
        boardWindow.getBoard().setCell(7, 8, CellType.STANDARD);
    }

    public static void removeCurrentMap(Room oldRoom) {
        int oldRow = oldRoom.row;
        int oldColumn = oldRoom.column;
        boardWindow.getBoard().setCell(oldRow, oldColumn, CellType.VISITED);
        boardWindow.repaint();
    }

    public static void addNewMap(Room newRoom) {
        int newRow = newRoom.row;
        int newColumn = newRoom.column;
        boardWindow.getBoard().setCell(newRow, newColumn, CellType.CURRENT_ROOM);
        boardWindow.repaint();
    }
}
