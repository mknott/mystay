window.templateParams = {}; // Global, so we can execute them again (like when the current chat gets refreshed after posting a message)	

$(document).ready(function() {
	var $body = $('body');
	//Cache this for performance

	var setBodyScale = function() {
		var scaleSource = $body.width(), scaleFactor = 0.25, maxScale = 600, minScale = 30;
		//Tweak these values to taste

		var fontSize = scaleSource * scaleFactor;
		//Multiply the width of the body by the scaling factor:

		if (fontSize > maxScale)
			fontSize = maxScale;
		if (fontSize < minScale)
			fontSize = minScale;
		//Enforce the minimum and maximums

		$('body').css('font-size', fontSize + '%');
	}

	$(window).resize(function() {
		//setBodyScale();
	});

	//Fire it when the page first loads:
	//setBodyScale();
	
	$('#active-chatservice').trigger('refresh');
	setInterval(function(){
		$('#active-chatservice').trigger('refresh');
	},10000);
	
}); 

// Function to dynamically resize images in iScroll to width of viewport
function carouselResize(carouselId) {
	var viewportWidth = $(window).width(),
		carouselRoot = $('#' + carouselId);
	//console.log(viewportWidth);
	carouselRoot.find('.scrollItems > li').css('width', viewportWidth);
	// Dynamically sizes #scroller
	carouselRoot.css('width', viewportWidth * carouselRoot.find(".scrollItems > li").length);
}

var Carousel = function(selector){
	var DOMelement = $(selector),
		paneSelector = '.scrollItems > li',
		panes = DOMelement.find(paneSelector),
		scroller = {}, // This is the iScroll object
		currPane = 0;
	
	var init = function(){
		scroller = new iScroll(DOMelement, {
			snap: true,
			momentum: false,
			hScrollbar: false,
			vScroll: false,
			vScrollbar: false,
			desktopCompatibility: true,
			onScrollEnd: function () {
				currPane = (typeof this.pageX !== undefined) ? (isNaN(this.pageX) ? 0 : this.pageX) : 0;
				panes.find('.indicator > li.active').removeClass('active');
				DOMelement.find('.indicator > li:nth-of-type(' + (currPane + 1) + ')').addClass('active');
				panes.find('li.current').removeClass('current');
				panes.find('li:nth-of-type(' + (currPane + 1) + ')').addClass('current');
			}
		});
		
		// On Orientation Change, Do Something
		$(window).bind('resize', function () {
			
			/* Make sure it fits the new window */
			this.resize(DOMelement);
			
			/* Then Refresh it because iScroll says so */
			setTimeout(function() {
				scroller.refresh();
			}, 0);
			
			// iScroll doesn't update the value in time, need to force the update
			scroller.maxScrollX = -(((scroller.maxPageX) * $(window).width()));
			scroller.scrollToElement(paneSelector + '.current', '0s');
		});
		
	};
	
	this.resize = function(){
		var viewportWidth = $(window).width();
		panes.css('width', viewportWidth);
		DOMelement.css('width', viewportWidth * panes.length);
	};
	
	init();
	
	return this;
}

window.MS = new function(){
	this.homepage = function(){
		console.log('homepage pageload');
		
		$('.getgeo').click(function(e){
			e.preventDefault();
			navigator.geolocation.getCurrentPosition(
				function(pos){
					var lat = pos.coords.latitude;
					var lon = pos.coords.longitude;
					$('.getgeo').html(lat + ', ' + lon);
				},
				function(){
					$('.getgeo').html('Could not determine location');
				}
			);
		});
		/*==========================================================
		iScroll / imagecarousel
		==========================================================*/
		var myScroll, iScrollCurrPage = 0,
			carouselRoot = $('#wrapper'),
			scrollItems = carouselRoot.find('.scrollItems'),
			initmyScroll = function () {
				return myScroll = new iScroll('scroller', {
					snap: true,
					momentum: false,
					hScrollbar: false,
					vScroll: false,
					vScrollbar: false,
					desktopCompatibility: true,
					onScrollEnd: function () {
						iScrollCurrPage = (typeof this.pageX !== undefined) ? (isNaN(this.pageX) ? 0 : this.pageX) : 0;
						// Adds active class to indicator for carousel
						carouselRoot.find('.indicator > li.active').removeClass('active');
						carouselRoot.find('.indicator > li:nth-of-type(' + (iScrollCurrPage + 1) + ')').addClass('active');
						// Adds current class to scrollItems li for carousel
						scrollItems.find('li.current').removeClass('current');
						scrollItems.find('li:nth-of-type(' + (iScrollCurrPage + 1) + ')').addClass('current');
					}
				});
			};
			
		// Jquery for iScroll in the carousel
		if ($('#myScroll.imagecarousel').find('.scrollItems > li').length) {
			// Instanciate iScroll here
			initmyScroll();
			// Shows scroller and carousel nav after page loads
			$('#scroller .scrollItems, .carouselNav').removeClass('hidden');
			carouselResize('scroller'); // Triggers when document first loads
			myScroll.refresh();
			if ((/Android/i.test(navigator.userAgent) && /Linux/i.test(navigator.userAgent)) || typeof window.blackberry !== 'undefined') {
				var repeatCheck = setInterval(function () {
					if ($('#myScroll').parents('.triggerTarget').css('display') === 'block') {
						myScroll.refresh();
						clearInterval(repeatCheck);
					}
				}, 750);
			}
			// On Orientation Change, Do Something
			$(window).bind('resize', function () {
				carouselResize('scroller');
				setTimeout(function () {
					myScroll.refresh();
				}, 0);
				// iScroll doesn't update the value in time, need to force the update
				myScroll.maxScrollX = -(((myScroll.maxPageX) * $(window).width()));
				myScroll.scrollToElement('.scrollItems > li.current', '0s');
			});
		}
		// init 'next' button
		carouselRoot.find('.next').fadeIn();
		carouselRoot.find('.prev').fadeIn();
		// init indicators
		buildIndicators(carouselRoot.find('.scrollItems > li'), carouselRoot.find('.indicator'), myScroll);
		window.myScrollObj = myScroll;

		// Function that dynamically assembled the dot indicators for iCarousel
		function buildIndicators(matchArray, indicator, inst) {
			var width = 0;
			for (var i = 0, j = matchArray.length, k = 1; i < j; i++, k++) {
				var dot = $('<li' + (!i ? ' class="active"' : '') + '>' + k + '</li>');
				if (inst) {
					dot.bind('click', (function (i) {
						return function () {
							inst.scrollToPage(i, 0);
							return false;
						};
					})(i));
				}
				indicator.append(dot);
				width += dot.width();
			}
			indicator.width(width * 2);
		}


		carouselResize('scroller');
		
		$('#scroller .bubble').on('tap',function(e){
			e.stopPropogation();
		})
	};

	this.ldp = function(){
		console.log('Location Detail Page loaded');
	};
	
	this.service = function(){
		console.log('Room Service Template Loaded');
	};
	
	this.chat = function(){
		console.log('Chat Template Loaded');
		$('#chat_scroll_wrapper').each(function(){
			/*==========================================================
			iScroll / imagecarousel
			==========================================================*/
			var myScroll, iScrollCurrPage = 0,
				carouselRoot = $('#chat_scroll_wrapper'),
				scrollItems = carouselRoot.find('.scrollItems'),
				initmyScroll = function () {
					return myScroll = new iScroll('chat_scroller', {
						snap: true,
						momentum: false,
						hScrollbar: false,
						vScroll: false,
						vScrollbar: false,
						desktopCompatibility: true,
						onScrollEnd: function () {
							iScrollCurrPage = (typeof this.pageX !== undefined) ? (isNaN(this.pageX) ? 0 : this.pageX) : 0;
							// Adds active class to indicator for carousel
							carouselRoot.find('.indicator > li.active').removeClass('active');
							carouselRoot.find('.indicator > li:nth-of-type(' + (iScrollCurrPage + 1) + ')').addClass('active');
							// Adds current class to scrollItems li for carousel
							scrollItems.find('li.current').removeClass('current');
							scrollItems.find('li:nth-of-type(' + (iScrollCurrPage + 1) + ')').addClass('current');
						}
					});
				};
				
			// Jquery for iScroll in the carousel
			if (carouselRoot.find('.scrollItems > li').length) {
				// Instanciate iScroll here
				initmyScroll();
				// Shows scroller and carousel nav after page loads
				$('#chat_scroller .scrollItems, .carouselNav').removeClass('hidden');
				carouselResize('chat_scroller'); // Triggers when document first loads
				myScroll.refresh();
				if ((/Android/i.test(navigator.userAgent) && /Linux/i.test(navigator.userAgent)) || typeof window.blackberry !== 'undefined') {
					var repeatCheck = setInterval(function () {
						if ($('#chat_scroller').parents('.triggerTarget').css('display') === 'block') {
							myScroll.refresh();
							clearInterval(repeatCheck);
						}
					}, 750);
				}
				// On Orientation Change, Do Something
				$(window).bind('resize', function () {
					carouselResize('chat_scroller');
					setTimeout(function () {
						window.chatScrollObj.refresh();
					}, 0);
					// iScroll doesn't update the value in time, need to force the update
					window.chatScrollObj.maxScrollX = -(((myScroll.maxPageX) * $(window).width()));
					window.chatScrollObj.scrollToElement('.scrollItems > li.current', '0s');
				});
			}
			// init 'next' button
			carouselRoot.find('.next').fadeIn();
			carouselRoot.find('.prev').fadeIn();
			// init indicators
			buildIndicators(carouselRoot.find('.scrollItems > li'), carouselRoot.find('.indicator'), myScroll);
			window.chatScrollObj = myScroll;
	
			// Function that dynamically assembled the dot indicators for iCarousel
			function buildIndicators(matchArray, indicator, inst) {
				var width = 0;
				for (var i = 0, j = matchArray.length, k = 1; i < j; i++, k++) {
					var dot = $('<li' + (!i ? ' class="active"' : '') + '>' + k + '</li>');
					if (inst) {
						dot.bind('click', (function (i) {
							return function () {
								inst.scrollToPage(i, 0);
								return false;
							};
						})(i));
					}
					indicator.append(dot);
					width += dot.width();
				}
				indicator.width(width * 2);
			}
	
			carouselResize('chat_scroller');
			
		});
		
	};

	
	this.getactivechats = new function(){
		var currentData = {};
		this.get = function(){
			$.ajax({
				url: '/json/reservations/new.json/',
				dataType: 'json',
				success: function(data){
					if (JSON.stringify(data) != JSON.stringify(currentData)) {
						$('#pendingRes').html($("#pendingReservation").tmpl(data));
						currentData = data;
						JTW.list.setDefaults();
						JTW.list.updateWaitCount('#acceptedRes,#readyRes');
					}
				}
			});
		}
		return this;
	}; // getactive-chats
	
}; //MS

/*
$('[type="text/x-jquery-tmpl"]').each(function(){
	
	var getData = function(){
		console.log('rob');
	};
	
	$(this).bind('refresh',function(){ getData(); });
});

$('#active-chats').trigger('refresh');
 */


$.fn.bindTemplate = function(isotope){
	return this.each(function() {
		var $template = $(this),
			jsonService = $(this).attr('data-jsonService'),
			$target = $($(this).attr('data-output')),
			currentData = {};
		
		var getData = function(event,params,callback){
			currentData = {};
			$.ajax({
				url: jsonService,
				dataType: 'json',
				data: params,
				success: function(data){
					if (JSON.stringify(data) != JSON.stringify(currentData)) {
						//$target.append($template.tmpl(data));
						
						/* Remove & replace any chat ID's which come back in the request */
						for (var i = 0;i<data.length;i++) {
							$target.isotope( 'remove', $target.find('[data-chatid="'+ data[i].userId +'"]'))
						}
						
						if (isotope) {
							$target.isotope( 'insert', $template.tmpl(data) );
						} else {
							$target.html($template.tmpl(data));
						}
						
						currentData = data;
					}
				},
				error: function(e) {
					console.dir(e);
				}
			});
		};
		
		if (typeof callback === 'function') { callback(); }
		
		$(this).bind('refresh',getData);
	});
};

$('[type="text/x-jquery-tmpl"]').each(function(){
	var useIsotope = $(this).attr('data-isotope') || false;
	$(this).bindTemplate(useIsotope);
});

$('#active-chats .list').isotope({
	layoutMode: 'straightDown',
	animationOptions: {
		duration: 750,
		easing: 'linear',
		queue: false
	},
	getSortData : {
  		username : function ( $elem ) {
			return $elem.find('.username').text();
		},
		pendingMsg: function ( $elem ) {
			return parseInt( $elem.find('.badge').text(), 10 );
		}
	},
	sortBy: 'pendingMsg',
	sortAscending : false
});

$('#active-chats .list').on('click','li',function(){
	//$('#chat-details').load('/json/chat-details.json?id=' + $(this).attr('id'));
	window.templateParams.userid = $(this).attr('data-chatid');
	$('#individualChatService').trigger('refresh',window.templateParams);
});

$(document).on('submit','form[data-ajax="true"]',function(e){
	e.preventDefault();
	var data = $(this).serialize(),
		action = $(this).attr('action').toString();
	$.ajax({
		url: action,
		type: 'POST',
		data: data,
		success: function(data){
			//console.log('success');
		},
		complete: function(){
			//console.log('complete');
			$('#individualChatService').trigger('refresh',templateParams);
			$('#chat-details').scrollTo('form');
		}
	});
})


$(window).resize(function(){
	resize();
});

function resize() {
	$('#active-chats, #chat-details').css('height',function(){
		return $(document).outerHeight() - $('.header-container').outerHeight() - $('.footer-container').outerHeight();
	});
	$('#chat-details').css('width',function(){
		return $(document).outerWidth() - $('#active-chats').outerWidth();
	});
}
resize();

$('body').on('click','.modal',function(e) {
	e.preventDefault();
	e.stopImmediatePropagation();
	$.mobile.showPageLoadingMsg();
	
	$('#modal_content').empty().load($(this).attr('href'),function(){
		$(this).trigger('create');
		$.mobile.hidePageLoadingMsg();
		$(this).prepend('<a class="close-reveal-modal"></a>').reveal({
			dismissmodalclass: 'close-reveal-modal, .modal-close' //First one doesn't have the dot . because it's added in the plugin
		});
	});
});	

/*
var data = [
	{
		"lastName": "Vail",
		"pendingMsg": "3",
		"chatType": "Room Service",
		"userId": "admin",
		"roomNo": "201"
	}, {
		"lastName": "Vail",
		"pendingMsg": "3",
		"chatType": "Room Service",
		"userId": "@4001_puchu",
		"roomNo": "201"
	}, {
		"lastName": "Vail",
		"pendingMsg": "3",
		"chatType": "Room Service",
		"userId": "rm101_vbbbn",
		"roomNo": "201"
	}
];
$('#active-chats').html($("#active-chatservice").tmpl(data));


 */


/* Make sure to clean up any modals when we leave the page */
try {
	$('div:jqmData(role="page")').live('pagebeforeshow',function(){ 
		$('#modal_content').css({'visibility':'hidden'});
		$('.reveal-modal-bg').css({'display':'none'});
	});
} catch(e){
	
}

$(document).on('pageshow',function(){
	if (window.myScrollObj) { 
		// http://stackoverflow.com/a/7545298
		window.myScrollObj.refresh(); 
	}
	if (window.chatScrollObj) { 
		// http://stackoverflow.com/a/7545298
		window.chatScrollObj.refresh();
	}
});

$(document).on('pageinit',function(){ // All pages
	MBP.hideUrlBarOnLoad();
});




$(document).on('pageinit','[data-template="homepage"]',MS.homepage);
$(document).on('pageinit','[data-template="ldp"]',MS.ldp); // Location Detail Page
$(document).on('pageinit','[data-template="service"]',MS.service); // Room Service
$(document).on('pageinit','[data-template="chat"]',MS.chat); // Room Service