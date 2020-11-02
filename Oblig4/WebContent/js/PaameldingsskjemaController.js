"use strict"

class PaameldingsskjemaController {
	
	constructor() {
		this.run = this.run.bind(this);
		this.musOverPassord = this.musOverPassord.bind(this);
	}
	
	run() {
	document.getElementById("passord").addEventListener("onmouseover",this.musOverPassord,true);
}

	musOverPassord() {
		document.alert("Passordstyrke regnes etter lengde. 0-7 karakterer er ugyldig,\n8-15 karakterer er svakt, over 16 karakterer er sterkt.");
	}
	
}

const controller = new PaameldingsskjemaController()
document.addEventListener("DOMContentLoaded",controller.run,true);