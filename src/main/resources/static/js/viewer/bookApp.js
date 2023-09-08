$(function(){
	displayBook();
});

function displayBook(){
	const param = getParam("url");
	
	const url = "/api/image?url=" + param;
	const xhr = new XMLHttpRequest();
	
	debug("urlParametar" ,param);
	debug("ApiURL", url);
	
	if (param != null && param != "") {
		xhr.open('GET', url, false);
	
		xhr.addEventListener('load', () => {
			const json = JSON.parse(xhr.responseText);
			page = json.length;
			let html = "";
			
			debug("imageJson", json)
			debug("display", display)
			debug("page", page)
			
			json.forEach((value) => {
				html += '<div class="c_i">';
				html += '<div><img data-lazy="' + value.url + '"></div>';
				html += '</div>'
			});
			debug("html", html);
			$('#last_page').before(html);
		});
		xhr.send();
	}
}

function switchSlide(){
	console.log("click");
	if (display === 0) {
		display = 1;
		console.log("set 1");
	} else {
		display = 0;
		console.log("set 0");
	}
	
	//Slick reInit
	let width = $(window).width();
	let num = 1;
	
	//firstpage hidden
	if(display === 1){
        $("#slick-slide00").css('display', 'none');
    } else {
		$("#slick-slide00").css('display', 'block');
	}
	
	//set param
	if(width <= 768){ //768px以下のとき
    } else {//769px以上のとき
        if(display === 1){ //右ページ始まりの時
            if (num % 2 == 0) {// 偶数の処理
            }
            else {// 奇数の処理
                num = num - 1;
            }
        }else { //左ページ始まりの時
            if (num % 2 == 0) {// 偶数の処理
            }
            else {// 奇数の処理
                num = num + 1;	
            }
        }
    }
    
    //Slick option update
    $slider = $('.slider');
	if(width <= 768){ //768px以下のときのslickオプション＆イベント
            $slider.slick('slickSetOption', {
                accessibility: false,
                dots:true,
                appendDots:$('.dots'),
                prevArrow: '<div class="slide-arrow prev-arrow"><span></span></div>',
                nextArrow: '<div class="slide-arrow next-arrow"><span></span></div>',
                slidesToShow:1,
                slidesToScroll:1,
                touchThreshold: 10,
                lazyLoad: 'progressive',
                infinite:false,
                rtl:true,
                initialSlide:num,
            });
            $slider.slick('slickRemove',true); //一枚目削除
        } else { //769px以上のときのslickオプション＆イベント
           $slider.slick('slickSetOption', {
                dots:true,
                appendDots:$('.dots'),
                prevArrow: '<div class="slide-arrow prev-arrow"><span></span></div>',
                nextArrow: '<div class="slide-arrow next-arrow"><span></span></div>',
                slidesToShow:2,
                slidesToScroll:2,
                touchThreshold: 10,
                lazyLoad: 'progressive',
                infinite:false,
                rtl:true,
                initialSlide:num,
            });
        }
        deebug("num", num)
};

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