$(function(){
	displayImage();
	$('.flexslider').flexslider({
	    slideshow: false,
	    animationSpeed: 0,
	    controlNav: false,
		directionNav: false,
		mousewheel: true,
	});
});

function displayImage() {
	const param = getParam("url");
	
	const url = "/api/image?url=" + param;
	const xhr = new XMLHttpRequest();
	
	const target = document.getElementById('target');
	
	debug("urlParametar", param);
	debug("ApiURL", url);
	
	if (param != null && param != "") {
		xhr.open('GET', url, false);
	
		xhr.addEventListener('load', () => {
			const json = JSON.parse(xhr.responseText);
			let html = "";
			
			debug("imageJson", json)
			
			json.forEach((value) => {
				html += '<li data-origin-url=' + value.url + '>';
				html += '<img src=\"' + value.url + '">';
				html += '</li>'
			});
			target.innerHTML = html;
		});
		xhr.send();
	}
}

function getParam(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

function debug(dataDesc, data = null) {
	const param = getParam("debug");
	
	if (param == "1"){
		console.log(dataDesc + ": ");
		if (data != null) {
			console.log(data);	
		}
	}
}

function SerchAscii2d() {
	//get element
	var element = document.getElementsByClassName("flex-active-slide");
	
	//get customData
	var originUrl = $(element).data('origin-url');

	//open window
	open("https://ascii2d.net/search/url/" + originUrl);

}