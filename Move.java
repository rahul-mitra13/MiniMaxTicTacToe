public class Move{
    int moveIndex;
    public Move(int index){
        this.moveIndex = index;
    }
    public String display(){
        String str = Integer.toString(this.moveIndex);
        return str;
    }
}