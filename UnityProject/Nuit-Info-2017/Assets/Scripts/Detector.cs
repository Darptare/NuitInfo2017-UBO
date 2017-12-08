using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[AddComponentMenu("Custom/Detector")]
public class Detector : MonoBehaviour {

	[SerializeField] [Range(0f, 360f)] private float visionAngle;
	[SerializeField] private float visionDistance;
	[SerializeField] private float height;
	[SerializeField] public GameObject[] objetADetecter;
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}

	/// <summary>
	/// Callback to draw gizmos that are pickable and always drawn.
	/// </summary>
	void OnDrawGizmos()
	{
		//getting x and z position of the destination vector
		float x1;
		float z1;

		float x2;
		float z2;

		//getting coordonates for the left side of the angle  
		// (90 => make a 90° rotation to aline the local z-axis with the detection cone)
		x1 = transform.position.x + Mathf.Cos( (90-transform.rotation.eulerAngles.y + visionAngle/2) * Mathf.Deg2Rad) * visionDistance;
		z1 = transform.position.z + Mathf.Sin( (90-transform.rotation.eulerAngles.y + visionAngle/2) * Mathf.Deg2Rad) * visionDistance;

		//getting coordonates for the right side of the angle
		x2 = transform.position.x + Mathf.Cos( (90-transform.rotation.eulerAngles.y - visionAngle/2) * Mathf.Deg2Rad) * visionDistance;
		z2 = transform.position.z + Mathf.Sin( (90-transform.rotation.eulerAngles.y - visionAngle/2) * Mathf.Deg2Rad) * visionDistance;

		//vectors representing the angle of the detector
		Vector3 v1 = new Vector3(x1, transform.position.y + height, z1);
		Vector3 v2 = new Vector3(x2, transform.position.y + height, z2);

		// drawing the cone
		Gizmos.DrawLine(new Vector3(transform.position.x, transform.position.y + height, transform.position.z), v1);
		Gizmos.DrawLine(new Vector3(transform.position.x, transform.position.y + height, transform.position.z), v2);

		// drawing the max distance
		Gizmos.DrawLine(v1, v2);

	}

	//fonctionnement :
	//pour chaque objet que l'on cherche à détecter
	//	on récupre la position de l'obj, puis on vérifie si il se trouve dans l'angle et la distance de détection
	//  si oui, on lance un rayon, et on vérifie si il entre en contact avec l'objet voulu
	public GameObject detected(){
		GameObject res = null;

		foreach(GameObject obj in objetADetecter){
			if(obj != null){
				// get the direction vector3 between the monster and the player
				Vector3 heading = obj.transform.position - transform.position;
				float distance = heading.magnitude;
				Vector3 direction = heading / distance;
				direction.y = 0;
				float monterPlayerAngle = Vector3.Angle(transform.forward, direction);
				
				//we cast a ray if the angle is within the vision angle / 2 and within the distance of sight
				if(monterPlayerAngle <= visionAngle / 2 && distance <= visionDistance){

					res = obj;
				}
			}
		}

		return res;
	}

}
