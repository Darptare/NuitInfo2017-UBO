﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PassagePieton : MonoBehaviour {

	[SerializeField]
	private GameObject feuxTricolore;

	// Use this for initialization
	void Start () {

		if(feuxTricolore == null){
			Debug.LogError("le feu tricolore n'a pas été bindé");
		}

	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
