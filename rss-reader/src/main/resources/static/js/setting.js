function sitesTable() {
	const url = "/api/sites";
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
			html += '<td>' + site.type_id + '</td>';
			html += '<td>' + site.created_at + '</td>';
			html += '<td>' + site.updated_at + '</td>';
			html += '</tr>';
		});
		siteList.innerHTML = html;
	});
	xhr.send();
}

function siteTypesTable() {
	const url = "/api/sitetypes";
	const xhr = new XMLHttpRequest();
	
	const siteTypeList = document.getElementById('site_typeList');
	
	xhr.open('GET', url, true);
	
	xhr.addEventListener('load', () => {
		const siteTypeJson = JSON.parse(xhr.responseText);
		let html = "";
		
		siteTypeJson.forEach(function(siteType) {
			html += '<tr>';
			html += '<td>' + siteType.id + '</td>';
			html += '<td>' + siteType.type + '</td>';
			html += '<td>' + siteType.created_at + '</td>';
			html += '<td>' + siteType.updated_at + '</td>';
			html += '</tr>';
		});
		siteTypeList.innerHTML = html;
	});
	xhr.send();
}

window.onload = function() {
	sitesTable();
	siteTypesTable();
}