public class Move{
    int rowIndex;
    int colIndex;
    public Move(int rowI, int colI){
        this.rowIndex = rowI;
        this.colIndex = colI;
    }
    public String display(){
        String str = Integer.toString(this.rowIndex) + " " + Integer.toString(this.colIndex);
        return str;
    }
}