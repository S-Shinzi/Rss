window.addEventListener('load', () => {
	displayParsesTable();
});

function displayParsesTable() {
	const url = "/api/db/parses";
	const xhr = new XMLHttpRequest();
	
	const parseList = document.getElementById('parseList');
	
	xhr.open('GET', url, true);
	
	xhr.addEventListener('load', () => {
		const parseJson = JSON.parse(xhr.responseText);
		let html = "";
		
		parseJson.forEach(function(parse) {
			html += '<tr id="parseList_' + parse.id + '">';
			html += '<td>' + parse.id + '</td>';
			html += '<td><div>' + parse.site_id + '</div><div style="display: none;"><input type="number" name="site_id" placeholder="' + parse.site_id + '" value="' + parse.site_id + '" form="update-Parses_' + parse.id + '" required/></div></td>';
			html += '<td><div>' + parse.element_parse + '</div><div style="display: none;"><input type="text" name="element_parse" placeholder="' + parse.element_parse + '" value="' + parse.element_parse + '" form="update-Parses_' + parse.id + '" required/></div></td>';
			html += '<td><div>' + parse.attribute_parse + '</div><div style="display: none;"><input type="text" name="attribute_parse" placeholder="' + parse.attribute_parse + '" value="' + parse.attribute_parse + '" form="update-Parses_' + parse.id + '" required/></div></td>';
			html += '<td>' + parse.created_at + '</td>';
			html += '<td>' + parse.updated_at + '</td>';
			html += '<td><form action="/api/db/remove-parses" method="post"><input type="hidden" name="id" value="' + parse.id + '"><input class="btn btn-primary" type="submit" value="remove"></form></td>';
			html += '<td><div><input class="btn btn-primary" onclick="displayUpdateParseForm(`parseList_' + parse.id + '`)" type="button" value="update"></div><div style="display: none;"><input type="hidden" name="id" value="' + parse.id + '" form="update-Parses_' + parse.id + '"><input class="btn btn-danger" onclick="updateParses(' + parse.id + ')" type="submit" value="submit?" form="update-Parses_' + parse.id + '"><form id="update-Parses_' + parse.id + '" action="/api/db/update-parses" method="post"></form></div></td>';
			html += '</tr>';
		});
		parseList.innerHTML = html;
	});
	xhr.send();
}

function displayUpdateParseForm(id){
	const targetRecord = document.getElementById(id);
	
	let html = "";

	for (let i = 1; i < targetRecord.childNodes.length; i++){
		if (i >= 4 && i <= 6) {
			continue;
		}
		
		const data = targetRecord.childNodes.item(i).childNodes.item(0);
		const input = targetRecord.childNodes.item(i).childNodes.item(1);
		
		data.style.display = "none";
		input.style.display = "block";
	}
}