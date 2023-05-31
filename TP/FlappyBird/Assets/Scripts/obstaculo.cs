using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class obstaculo : MonoBehaviour {
	
	[SerializeField] private float velocidade;

	// Update is called once per frame
	private void Update () {
		this.transform.Translate(Vector3.left*this.velocidade);
	}
	private void Awake(){
		this.transform.Translate(Vector3.up * Random.Range(-2,2));
	}
	private void OnTriggerEnter2D(Collider2D obj){
		GameObject.Destroy(this.gameObject);
	}
}
