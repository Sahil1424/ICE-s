using System.Collections;
using System.Collections.Generic;
using UnityEngine;
public class PlayerBehaviour : MonoBehaviour
{
    public float max;
    public float min;

    public AudioSource yaySound;
    public AudioSource thunderSound;
    
    public float horizontalSpeed;
    public float verticalPosition;

    // Start is called before the first frame update
    void Start()
    {
        transform.position = new Vector3(0.0f, verticalPosition, 0.0f);
    }
    
    // Update is called once per frame

    void Update()
    {
        Move();
        CheckBounds();
    }

    void Move()
    {
        if (Input.touchCount > 0)
        {
            var x = Input.touches[0].position.x;
            var horizontalPosition = Camera.main.ScreenToWorldPoint(new Vector3(x, 0.0f, 0.0f)).x;
            transform.position = new Vector3(horizontalPosition, verticalPosition, 0.0f);
        }

        
    }

    void CheckBounds()
    {
        if (transform.position.x <= min)
        {
            transform.position = new Vector3(min, verticalPosition, 0.0f);
        }
        else if (transform.position.x >= max)
        {
            transform.position = new Vector3(max, verticalPosition, 0.0f);
        }
    }

    void OnTriggerEnter2D(Collider2D other)
    {
        if (other.gameObject.CompareTag("Island"))
        {
            yaySound.Play();
        }
        else if (other.gameObject.CompareTag("Cloud"))
        {
            thunderSound.Play();
        }
    }
}