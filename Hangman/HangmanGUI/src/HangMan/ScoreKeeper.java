
package HangMan;


public class ScoreKeeper 
{
    private int win = 0;
    private int lose = 0;
    private int correctGuess = 0;
    private int wrongGuess = 0;
    
    public void addWin ()
    {
        win++;
    }
    
    public void addLose ()
    {
        lose++;
    }
    
    public void addCorrectGuess()
    {
        correctGuess++;
    }
    
    public void addWrongGuess()
    {
        wrongGuess++;
    }
    
    public void resetScore()
    {
        win = 0;
        lose = 0;
        correctGuess = 0;
        wrongGuess = 0;
    }
    
    public String getScore()
    {
        String score = "";
        double winRatio = (double)win/(win+lose);
        double guessRatio = (double) correctGuess / (correctGuess+wrongGuess);
        
        winRatio = winRatio > 0 ? winRatio : 0;
        guessRatio = guessRatio > 0 ? guessRatio : 0;
        
        score  = "Win / Lose                : " + win + " / " + lose + " (" + String.format("%,.2f%%", winRatio*100)  + ")\n";
        score += "Correct/Wrong Guess : " + correctGuess + " / " + wrongGuess + " (" + String.format("%,.2f%%", guessRatio*100)  + ")\n";
        
        return score;
    }
    
}
