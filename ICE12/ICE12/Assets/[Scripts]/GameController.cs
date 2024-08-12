using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

public class GameController : MonoBehaviour
{
    [Header("Scoreboard")]
    public TMP_Text livesLabel;
    public TMP_Text scoreLabel;
        private int m_score;
    private int m_lives;
    // Start is called before the first frame update
    void Start()
    {
        SetScoreLabel(0);
        SetLivesLabel(5); 
    }

    public void SetLivesLabel(int lives){
        livesLabel.text = "Lives: " + lives;
        m_lives = lives;
    }

    public int GetLives()
    {
        return m_lives;
    }
    public void AddScore(int score)
    {
        m_score += score;
        SetScoreLabel(m_score);
    }

    public void LoseLife()
    {
        m_lives--;
        SetLivesLabel(m_lives);
    }

    public int GetScore()   
    {
        return m_score;
    }
    public void SetScoreLabel(int score){
        scoreLabel.text = "Score: " +score;
        m_score = score;
    }
}
