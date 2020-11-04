"use strict"

class PaameldingsskjemaController {
	
	constructor() {
		this.run.bind(this);
		this.melding.bind(this);
	}

	run() {
		const root = document.gegElementById("rootform");
		const passdiv = document.querySelector("#passorddiv");
		const passinput = passdiv.querySelector("#passord");
		passinput.addEventListener("eventinput",valider(passinput.textContent),true);
	}

	valider(passord) {
		if(passord.length < 8) {
			passinput.style.border = "solid red";
		}
		else if(passord.length < 16) {
			passinput.style.border = "solid yellow";
		}
		else {
			passinput.style.border = "solid green";
		}
	}

}

const controller = new PaameldingsskjemaController();
document.addEventListener("DOMContentLoaded",controller.run,true);