using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class carGenerator : MonoBehaviour {

	[SerializeField]
	private GameObject[] listPrefabs;

	[SerializeField]
	private GameObject player;

	[SerializeField]
	private GameObject passagePieton;

	[SerializeField]
	private float spawnTimer = 5;
	private float spawnTimerCooldown;
	[SerializeField]
	private bool right = true;

	private GameObject lastCar = null;

	// Use this for initialization
	void Start () {

		spawnTimerCooldown = spawnTimer;

		player = GameObject.Find("manPhysical");
		passagePieton = GameObject.Find("passagePieton");

		if(passagePieton == null){
			Debug.LogError("passagePieton non trouvé");
		}
		
	}
	
	// Update is called once per frame
	void Update () {

		spawnTimerCooldown -= Time.deltaTime;

		if(spawnTimerCooldown <= 0){
			SpawnCar();
			spawnTimerCooldown = spawnTimer;
		}
		
	}

	private void SpawnCar(){

		int index;
		GameObject car;
		index = (int)Random.Range(0, listPrefabs.Length);

		car = Instantiate(listPrefabs[index]);
		car.transform.position = this.transform.position;
		if(!right){
			car.transform.Rotate(new Vector3(car.transform.rotation.eulerAngles.x, 180, car.transform.rotation.eulerAngles.x)) ;
		}
		GameObject[] list = {player, lastCar};
		car.GetComponent<Detector>().objetADetecter = list;
		car.GetComponent<CarController>().right = right;
		car.GetComponent<CarController>().passagePieton = passagePieton;

		lastCar = car;


	}
}
