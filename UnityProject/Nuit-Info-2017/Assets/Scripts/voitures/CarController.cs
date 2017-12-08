using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CarController : MonoBehaviour {

    [SerializeField]
    private float speed;

	public GameObject passagePieton;

	private Detector detector;

	public bool isCool = true;

	public bool right = false;

	private float distancePassage = 0.5f;

	private float maxSpeed;

	[SerializeField]
	private bool yolo = false;

	private bool enArret = false;

	private bool enArretVoiture = false;


	// Use this for initialization
	void Start () {

		detector = GetComponent<Detector>();
		if(detector == null){
			Debug.LogError("pas de détector trouvé");
		}

		maxSpeed = speed;

		Destroy(this.gameObject, 15);
		
	}
	
	// Update is called once per frame
	void Update () {

				if(yolo)
			Debug.Log(maxSpeed);

		if(isCool){
			GameObject obj = detector.detected();
			//si il c'est soit le passage pieton ou le joueur
			if(obj != null){
				//si c'est le joueur, on s'arrete directement
				if(obj.tag == "Player"){
					maxSpeed = 0;
				//si l'objet est un passage pieton, et que le feu est autre que vert, on s'arrete
				} else if(obj.tag == "Car"){
					maxSpeed = 0;
				}

			}else if(enArret){
				if(passagePieton.GetComponent<PassagePieton>().getEtatFeuxTricolore() == "green"){
					maxSpeed = speed;
				}
			}else if (!enArretVoiture){
				maxSpeed = speed;
			}
		}else{
			maxSpeed = speed;
		}

		
		this.gameObject.transform.Translate(0.0f, 0.0f, 0.001f * maxSpeed);
	}



	private void arretOnPassagePieton(){

		if (passagePieton.GetComponent<PassagePieton>().getEtatFeuxTricolore() != "green"){
			if(passagePieton){

			}
		}



	}

	/// <summary>
	/// OnTriggerEnter is called when the Collider other enters the trigger.
	/// </summary>
	/// <param name="other">The other Collider involved in this collision.</param>
	void OnTriggerEnter(Collider other)
	{

		Debug.Log(other.gameObject.tag);
		if(other.gameObject.tag == "passage"){
			Debug.Log(other.gameObject.GetComponent<PassagePieton>().getEtatFeuxTricolore());
			if(other.gameObject.GetComponent<PassagePieton>().getEtatFeuxTricolore() != "green"){
				enArret = true;
				maxSpeed = 0;
			}
		}
	}

}
