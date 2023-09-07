window.onwheel = function(event){
	if(event.deltaY < 0){
	    debug("wheel up");
	    document.dispatchEvent(new KeyboardEvent("keydown", {
	        "key": "ArrowRight",
	        "keyCode": 39,
	        "which": 39,
	        "code": "ArrowRight",
	        "location": 0,
	        "altKey": false,
	        "ctrlKey": false,
	        "metaKey": false,
	        "shiftKey": false,
	        "repeat": false
	    }));
	}else{
	    debug("wheel down");
	    document.dispatchEvent(new KeyboardEvent("keydown", {
	        "key": "ArrowLeft",
	        "keyCode": 37,
	        "which": 37,
	        "code": "ArrowLeft",
	        "location": 0,
	        "altKey": false,
	        "ctrlKey": false,
	        "metaKey": false,
	        "shiftKey": false,
	        "repeat": false
	    }));
    }
};

function debug(dataDesc, data = null) {
	const param = getParam("debug");
	
	if (param == "1"){
		console.log(dataDesc + ": ");
		if (data != null) {
			console.log(data);	
		}
	}
}