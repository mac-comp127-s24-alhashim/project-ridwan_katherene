public class scoreboard {
    private int score;

    public Scoreboard(){
        score = 0;
    }
    public void increment(){
        score++;
    }
    public int getScore(){
        return score;
    }
    public void resetScore(){
        score = 0;
    }
    public void draw(Graphics g){
        g.drawString("Score:"+ score, 10, 20);
    }
}
