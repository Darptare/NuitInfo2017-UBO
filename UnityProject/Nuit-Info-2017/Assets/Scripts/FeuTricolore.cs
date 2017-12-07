using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FeuTricolore : MonoBehaviour {

	[SerializeField]
	private float timeForRedToGreen = 5;

	[SerializeField]
	private float timeForGreenToOrange = 8;

	[SerializeField]
	private float timeForOrangeToRed = 2;

	private float greenCooldown = 0;
	private float orangeCooldown = 0;
	private float redCooldown = 0;

	private string[] statuts= {"vert", "orange", "rouge"};
	private int actualStatut; 



	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}

	public string getStatut(){


	}
}
