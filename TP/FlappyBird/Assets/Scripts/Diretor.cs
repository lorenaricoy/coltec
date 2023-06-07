using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Diretor : MonoBehaviour {
	[SerializeField] private GameObject imgGameOver;
	private Aviao aviao;
	private Pontuacao pontuacao;

	private void Start(){
		this.aviao= GameObject.FindObjectOfType<Aviao>();
		this.pontuacao=GameObject.FindObjectOfType<Pontuacao>();
	}

	public void FinalizaJogo(){
		Time.timeScale=0;
		this.imgGameOver.SetActive(true);
	}

	private void DestruirObstaculos(){
		obstaculo[] Obstaculos = FindObjectsOfType<obstaculo>();
		foreach (obstaculo Obstaculo in Obstaculos){
			Destroy(Obstaculo);
		}
	}

	public void ReiniciaJogo(){
		this.imgGameOver.SetActive(false);
		Time.timeScale = 1;
		this.aviao.Reiniciar();
		this.DestruirObstaculos();
		this.pontuacao.Reiniciar();
	}
}
