
public class PegGame {

    enum direction {UP, DOWN, LEFT, RIGHT};
    enum pegState {OCCUPIED, BLANK, MOVEOUT, MOVEINTO};

    private int pegCount;
    private pegState[][] pegMatrix;
    
    public void move(int i, int j, direction d) throws IllegalStateException{
        // check Movability
        // OCCUPIED -> MOVEOUT
        // BLANK -> MOVEINTO
    }

    private void updateBoard() {
        // MOVEOUT -> BLANK
        // MOVEIN -> OCCUPIED
        // update the pegCount
    }

    public boolean canMoveThisWay(int i, int j, direction d) {}

    public boolean unitCanMove(int i, int j) {}

    public boolean isDone() {}

    public int getPegCount() {}

    public pegState[][] getPegMatrix() {}

}