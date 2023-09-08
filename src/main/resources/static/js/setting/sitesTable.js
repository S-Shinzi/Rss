window.addEventListener('load', () => {
	displaySitesTable();
});

function displaySitesTable() {
	const url = "/api/db/sites";
	const xhr = new XMLHttpRequest();
	
	const siteList = document.getElementById('siteList');
	
	xhr.open('GET', url, true);
	
	xhr.addEventListener('load', () => {
		const sitesJson = JSON.parse(xhr.responseText);
		let html = "";
		
		sitesJson.forEach(function(site) {
			html += '<tr>';
			html += '<td>' + site.id + '</td>';
			html += '<td>' + site.name + '</td>';
			html += '<td>' + site.rss_link + '</td>';
			html += '<td>' + site.created_at + '</td>';
			html += '<td>' + site.updated_at + '</td>';
			html += '</tr>';
		});
		siteList.innerHTML = html;
	});
	xhr.send();
}