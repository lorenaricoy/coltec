using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class obstaculo : MonoBehaviour {
	
	[SerializeField] private float velocidade;
	private Vector3 posicaoDoAviao;
	private bool pontuei = false;
	private Pontuacao pontuacao;

	private void Start (){
		this.posicaoDoAviao=GameObject.FindObjectOfType<Aviao>().transform.position;
	}

	private void Update () {
		this.transform.Translate(Vector3.left*this.velocidade);
		if(!this.pontuei && this.transform.position.x < this.posicaoDoAviao.z){
			this.pontuei = true;
			this.pontuacao.adicionaPontos();
		}
	}

	private void Awake(){
		this.transform.Translate(Vector3.up * Random.Range(-1,1));
	}
	
	private void OnTriggerEnter2D(Collider2D obj){
		GameObject.Destroy(this.gameObject);
	}
}
