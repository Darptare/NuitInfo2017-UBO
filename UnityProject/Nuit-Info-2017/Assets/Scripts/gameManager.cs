using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class gameManager : MonoBehaviour {

	public GameObject player;

	private Vector3 savePosPlayer;
	private Quaternion saveRotPlayer;

	private float timer = 2;
	private float cooldown = 0;
	private RigidbodyConstraints constraints;
	private float drag;
	private float angularDrag;
	[SerializeField]
	private Canvas canvas;


	// Use this for initialization
	void Start () {
		
		savePosPlayer = player.transform.position;
		saveRotPlayer = player.transform.rotation;

		Rigidbody r = player.GetComponent<Rigidbody>();

		constraints = r.constraints;
		drag = r.drag;
		angularDrag = r.angularDrag;
		
		canvas.enabled = false;

	}
	
	// Update is called once per frame
	void Update () {
		
		if(cooldown > 0){
			cooldown -= Time.deltaTime;
			if(cooldown <= 0){
				reset();
			}
		}
	}

	public void onDead(){
		cooldown = timer;
	}

	private void reset(){
		GameObject[] list = GameObject.FindGameObjectsWithTag("Car"); 
		foreach(GameObject obj in list){
			Destroy(obj);
		}

		player.transform.position = savePosPlayer;
		player.transform.rotation = saveRotPlayer;
		player.GetComponent<Rigidbody>().velocity = Vector3.zero;
		player.GetComponent<Rigidbody>().constraints = constraints;
		player.GetComponent<Rigidbody>().drag = drag;
		player.GetComponent<Rigidbody>().angularDrag = angularDrag;

		player.GetComponent<Player>().dead = false;

	}
	
	 /// <summary>
	/// OnTriggerEnter is called when the Collider other enters the trigger.
	/// </summary>
	/// <param name="other">The other Collider involved in this collision.</param>
	void OnTriggerEnter(Collider other)
	{
		if(other.tag == "Player"){
			canvas.enabled = true;
		}


	}
}
