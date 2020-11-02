$(document).ready(function(){
	$('[data-bs-hover-animate]')
		.mouseenter( function(){ var elem = $(this); elem.addClass('animated ' + elem.attr('data-bs-hover-animate')) })
		.mouseleave( function(){ var elem = $(this); elem.removeClass('animated ' + elem.attr('data-bs-hover-animate')) });
});
		$(document).ready(function(){
		    $('.count123').prop('disabled', true);
   			$(document).on('click','.plus',function(){
				$(this).prev().val(parseInt($(this).prev().val()) + 1 );
    		});
        	$(document).on('click','.minus',function(){
    			$(this).next().val(parseInt($(this).next().val()) - 1 );
    				if ($(this).next().val() == 0) {
						$(this).next().val(1);
					}
    	    	});
 		});