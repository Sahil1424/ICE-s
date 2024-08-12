
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class UIController : MonoBehaviour
{
    public void OnSceneButton_Pressed()
    {
        SceneManager.LoadScene("Main");
    }
}
