window.onload = function() {
	const url = "/api/rss";
	const xhr = new XMLHttpRequest();
	
	const rssList = document.getElementById('rssList');
	
	xhr.open('GET', url, true);
	
	xhr.addEventListener('load', () => {
		const json = JSON.parse(xhr.responseText);
		let html = "";
		
		console.log(json);
		let count = 1;
		for (let elements in json) {
			html += '<div class="d-inline-block align-top w-25 mb-3" id="' + count + '">'
			html += '<div class="card mx-2" style="min-width: 400px">';
			html += '<div class="card-header bg-card-head">' + elements + '</div>';
			html += '</div>'
			html += '</div>';
			
			count++;
		};
		rssList.innerHTML = html;
	});
	xhr.send();
};