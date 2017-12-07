using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Player : MonoBehaviour {

    [SerializeField]
    private float speed;

    [SerializeField]
    private bool dead = false;

    private Rigidbody rb;

    void Start()
    {
        rb = GetComponent<Rigidbody>();
        dead = false;
    }


    void FixedUpdate()
    {

        if (!dead)
        {
            float moveVertical = Input.GetAxis("Vertical");
            Vector3 movement = new Vector3(0.0f, 0.0f, moveVertical);
            rb.AddForce(movement * speed);
        }
    }

    void OnCollisionEnter(Collision col)
    {
        if (col.gameObject.tag == "Car")
        {
            if (!dead)
            {
                rb.constraints = RigidbodyConstraints.None;
                rb.drag = 0;
                rb.angularDrag = 0;
                rb.AddForce(50.0f, 50.0f, 50.0f);

                dead = true;
            }
            
        }
    }
}
