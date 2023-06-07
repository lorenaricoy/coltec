using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Pontuacao : MonoBehaviour {
	private int pontos;
	[SerializeField] private Text textoPontuacao;

	public void adicionaPontos(){
		this.pontos++;
		this.textoPontuacao.text = this.pontos.ToString();
	}

	public void Reiniciar(){
		this.pontos=0;
		this.textoPontuacao.text = this.pontos.ToString();
	}
}

