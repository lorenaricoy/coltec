using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Carrossel : MonoBehaviour {

	[SerializeField] private float velocidade;
	private float tamanhoDaImagem;
	private Vector3 posicaoInicial;
	
	private void Awake(){
		this.posicaoInicial = this.transform.position;
		this.tamanhoDaImagem = this.GetComponent<SpriteRenderer>().size.x;
		float escala = this.transform.localScale.x;
		this.tamanhoDaImagem*=escala;
	}

	void Update () {
		float deslocamento = Mathf.Repeat(this.velocidade*Time.time,this.tamanhoDaImagem);
		this.transform.position = this.posicaoInicial + Vector3.left*deslocamento;
	}
}
