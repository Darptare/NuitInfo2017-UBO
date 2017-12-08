using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FeuPieton : MonoBehaviour {


	private bool isGreen = false;

	private Material green;
	private Material red;

	// Use this for initialization
	void Start () {
		
		green = this.transform.Find("group1 pSphere1").gameObject.GetComponent<Renderer>().material;
		red = this.transform.Find("group1 pSphere3.001").gameObject.GetComponent<Renderer>().material;

		if(green == null){
			Debug.Log("RIEN DU TOUT POUR GREEN");
		}

		if(red == null){
			Debug.Log("RIEN DU TOUT POUR RED");
		}
	}
	
	// Update is called once per frame
	void Update () {
		
	}

	public void setGreen(){
		green.SetColor("_Color", Color.green);
		red.SetColor("_Color", Color.black);
	}

	public void setRed(){
		green.SetColor("_Color", Color.black);
		red.SetColor("_Color", Color.red);
	}
}
