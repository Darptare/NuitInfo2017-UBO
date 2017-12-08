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

	private string[] statuts= {"green", "orange", "red"};
	private int actualStatut = 0; 

	[SerializeField]
	private FeuPieton feuPieton;

	private Material green;
	private Material orange;
	private Material red;




	// Use this for initialization
	void Start () {

		green = this.transform.Find("group1 pSphere1").gameObject.GetComponent<Renderer>().material;
		orange = this.transform.Find("group1 pSphere2").gameObject.GetComponent<Renderer>().material;
		red = this.transform.Find("group1 pSphere3").gameObject.GetComponent<Renderer>().material;


		redStatut();
	}
	
	// Update is called once per frame
	void Update () {

		if(greenCooldown > 0){
			greenCooldown -= Time.deltaTime;
			if(greenCooldown <= 0){
				greenStatut();
			}

		}else if(orangeCooldown > 0){
			orangeCooldown -= Time.deltaTime;
			if(orangeCooldown <= 0){
				orangeStatut();
			}

		}else if (redCooldown > 0){
			redCooldown -= Time.deltaTime;
			if(redCooldown <= 0){
				redStatut();
			}
		}

	}

	
	private void greenStatut(){
		actualStatut = 0;


		Debug.Log("Je passe au vert");

		green.SetColor("_Color", Color.green);
		orange.SetColor("_Color", Color.black);
		red.SetColor("_Color", Color.black);

		feuPieton.setRed();

		initOrangeCooldown();
	}

	private void redStatut(){
		actualStatut = 2;

		Debug.Log("Je passe au rouge");

		green.SetColor("_Color", Color.black);
		orange.SetColor("_Color", Color.black);
		red.SetColor("_Color", Color.red);

		feuPieton.setGreen();

		initGreenCooldown();
	}

	private void orangeStatut(){
		actualStatut = 1;

		Debug.Log("Je passe au orange");

		green.SetColor("_Color", Color.black);
		orange.SetColor("_Color", Color.yellow);
		red.SetColor("_Color", Color.black);

		initRedCooldown();
	}

	private void initOrangeCooldown(){
		orangeCooldown = timeForGreenToOrange;
	}

	private void initGreenCooldown(){
		greenCooldown = timeForRedToGreen;
	}

	private void initRedCooldown(){
		redCooldown = timeForOrangeToRed;
	}

	public string getStatut(){
		return statuts[actualStatut];
	}
}
