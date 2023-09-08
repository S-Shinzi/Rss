window.onload = function() {
	const url = "/api/rss";
	const xhr = new XMLHttpRequest();
	
	const rssList = document.getElementById('rssList');
	
	xhr.open('GET', url, true);
	
	xhr.addEventListener('load', () => {
		const jsonRss = JSON.parse(xhr.responseText);
		
		let html = "";
		let count = 0;
		for (let elements in jsonRss) {
			const url = document.createElement('a');
			url.href = jsonRss[elements][0].link;
			html += '<div class="d-inline-block align-top w-25 mb-3" id="' + count + '">'
			html += '<div class="card mx-2" style="min-width: 400px">';
			html += '<div class="card-header bg-card-head"> <a class="text-body font-weight-bold" href ="' + url.protocol + "//" + url.host + '">' + elements + '</a></div>';
			html += '<ul class="list-group list-group-flush">';
			for (let element in jsonRss[elements]){
				html += '<li class="list-group-item bg-card-list"><a class="text-body font-weight-normal" href ="' + jsonRss[elements][element].link + '">' + jsonRss[elements][element].title + '</a><div class="text-right"><a class="f-08 text-body font-weight-normal" target="_blank" rel="noopener noreferrer" href="imageViewer?url='+ jsonRss[elements][element].link +'">View ImageViewer</a></div></li>';
			};
			html += '</ul>'
			html += '</div>'
			html += '</div>';
			
			count++;
		};
		rssList.innerHTML = html;
	});
	xhr.send();
};