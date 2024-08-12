using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class OceanController : MonoBehaviour
{
    public Boundary boundary;
    public float horizontalSpeed;
    // Start is called before the first frame update
    void Start()
    {
        ResetGameObject();
    }
    // Update is called once per frame
    void Update()
    {
        Move();
        CheckBounds();
    }

    void ResetGameObject()
    {
        transform.position = new Vector3(0.0f, boundary.max, 0.0f);
    }

    void CheckBounds()
    {
        if (transform.position.y <= boundary.min)
        {
            ResetGameObject();
        }
    }
    void Move()
    {
        transform.position += new Vector3(0.0f, -horizontalSpeed * Time.deltaTime, 0.0f);
    }
}