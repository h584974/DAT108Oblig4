"use strict"

class PaameldingsskjemaController {
	
	constructor() {
		this.run.bind(this);
		this.melding.bind(this);
	}

	run() {
		const passdiv = document.getElementById("passorddiv");
		const passinput = passdiv.querySelector("#passord");
		passinput.addEventListener("mouseover",this.melding,true);
	}

	melding() {
		alert("Lima");
	}

}

const controller = new PaameldingsskjemaController();
document.addEventListener("DOMContentLoaded",controller.run,true);