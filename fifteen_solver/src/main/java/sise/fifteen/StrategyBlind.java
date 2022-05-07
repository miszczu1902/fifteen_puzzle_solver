//package sise.fifteen;
//
//import java.time.Clock;
//import java.util.Calendar;
//
//public abstract class StrategyBlind {
//    protected int reachedDepth = 0;
//    protected int maxDepth = 20;
//    protected final Calendar calendar = Calendar.getInstance();
//    protected long startTime = 0;
//    protected long endTime = 0;
//    protected State state;
//    protected Board board;
//    protected int width;
//    protected int height;
//
//    public StrategyBlind(State state) {
//        super();
//        this.state = state;
//        this.board = state.getBoard();
//        this.height = this.board.getHeight();
//        this.width = this.board.getWidth();
//    }
//
//    public int getReachedDepth() {
//        return reachedDepth;
//    }
//
//    public void setReachedDepth(int reachedDepth) {
//        this.reachedDepth = reachedDepth;
//    }
//
//    public long getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(long startTime) {
//        this.startTime = startTime;
//    }
//
//    public long getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(long endTime) {
//        this.endTime = endTime;
//    }
//
//    public State getState() {
//        return state;
//    }
//
//    public void setState(State state) {
//        this.state = state;
//    }
//
//    public Board getBoard() {
//        return board;
//    }
//
//    public void setBoard(Board board) {
//        this.board = board;
//    }
//
//    public int getWidth() {
//        return width;
//    }
//
//    public void setWidth(int width) {
//        this.width = width;
//    }
//
//    public int getHeight() {
//        return height;
//    }
//
//    public void setHeight(int height) {
//        this.height = height;
//    }
//
//    public abstract boolean check();
//}
