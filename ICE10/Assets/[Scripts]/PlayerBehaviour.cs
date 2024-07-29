using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerBehaviour : MonoBehaviour
{
    public float min;
    public float max;
    public float horizontalSpeed;
    
    void Move()
    {
        var x = Input.GetAxis("Horizontal") * horizontalSpeed * Time.deltaTime;
        transform.position += new Vector3(x, 0.0f, 0.0f);
    }
    void Update()
    {
        Move();
        CheckBounds();
    }

    void CheckBounds()
    {
        if (transform.position.x >= max)
        {
            transform.position = new Vector3(max, transform.position.y, transform.position.z);
        }
        else if (transform.position.x <= min)
        {
            transform.position = new Vector3(min, transform.position.y, transform.position.z);
        }
    }
}