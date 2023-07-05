using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class obstaculo : MonoBehaviour {
	
	[SerializeField] private float velocidade;
	private Vector3 posicaoDoAviao;
	public bool pontuei = false;
	private Pontuacao pontuacao;

	private void Start (){
		this.posicaoDoAviao=GameObject.FindObjectOfType<Aviao>().transform.position;
		this.pontuacao= GameObject.FindObjectOfType<Pontuacao>();
	}

	private void Update () {
		this.transform.Translate(Vector3.left*this.velocidade *Time.deltaTime);


		if(!this.pontuei && this.transform.position.x < this.posicaoDoAviao.z - 12){
			this.pontuei = true;
			this.pontuacao.AdicionaPontos();
		}
	}

	private void Awake(){
		this.transform.Translate(Vector3.up * Random.Range(-1,1));
	}
	
	private void OnTriggerEnter2D(Collider2D obj){
		GameObject.Destroy(this.gameObject);
	}
}
