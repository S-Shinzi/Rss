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
			html += '<tr id="siteList_' + site.id + '">';
			html += '<td>' + site.id + '</td>';
			html += '<td><div>' + site.name + '</div><div style="display: none;"><input type="text" name="name" placeholder="' + site.name + '" value="' + site.name + '" form="update-Sites_'+ site.id + '" required/></div></td>';
			html += '<td><div>' + site.rss_link + '</div><div style="display: none;"><input type="text" name="rss_link" placeholder="' + site.rss_link + '" value="' + site.rss_link + '" form="update-Sites_' + site.id + '" required/></div></td>';
			html += '<td>' + site.created_at + '</td>';
			html += '<td>' + site.updated_at + '</td>';
			html += '<td><form action="/api/db/remove-sites" method="post"><input type="hidden" name="id" value="' + site.id + '"><input class="btn btn-primary" type="submit" value="remove"></form></td>';
			html += '<td><div><input class="btn btn-primary" onclick="displayUpdateSiteForm(`siteList_' + site.id + '`)" type="button" value="update"></div><div style="display: none;"><input type="hidden" name="id" value="' + site.id + '" form="update-Sites_' + site.id + '"><input class="btn btn-danger" onclick="updateSites(' + site.id + ')" type="submit" value="submit?" form="update-Sites_' + site.id + '"><form id="update-Sites_' + site.id + '" action="/api/db/update-sites" method="post"></form></div></td>';
			html += '</tr>';
		});
		siteList.innerHTML = html;
	});
	xhr.send();
}

function displayUpdateSiteForm(id){
	const targetRecord = document.getElementById(id);

	for (let i = 1; i < targetRecord.childNodes.length; i++){
		if (i >= 3 && i <= 5) {
			continue;
		}
		
		const data = targetRecord.childNodes.item(i).childNodes.item(0);
		const input = targetRecord.childNodes.item(i).childNodes.item(1);
		
		data.style.display = "none";
		input.style.display = "block";
	}
}