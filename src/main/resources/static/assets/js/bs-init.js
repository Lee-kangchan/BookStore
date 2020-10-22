$(document).ready(function(){
	$('[data-bs-hover-animate]')
		.mouseenter( function(){ var elem = $(this); elem.addClass('animated ' + elem.attr('data-bs-hover-animate')) })
		.mouseleave( function(){ var elem = $(this); elem.removeClass('animated ' + elem.attr('data-bs-hover-animate')) });
});
		$(document).ready(function(){
		    $('.count123').prop('disabled', true);
   			$(document).on('click','.plus',function(){
				$('.count123').val(parseInt($('.count123').val()) + 1 );
    		});
        	$(document).on('click','.minus',function(){
    			$('.count123').val(parseInt($('.count123').val()) - 1 );
    				if ($('.count123').val() == 0) {
						$('.count123').val(1);
					}
    	    	});
 		});