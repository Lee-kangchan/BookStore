$(document).ready(function(){
	$('[data-bs-hover-animate]')
		.mouseenter( function(){ var elem = $(this); elem.addClass('animated ' + elem.attr('data-bs-hover-animate')) })
		.mouseleave( function(){ var elem = $(this); elem.removeClass('animated ' + elem.attr('data-bs-hover-animate')) });
});
		$(document).ready(function(){
		    $('.count123').prop('disabled', true);
   			$(document).on('click','.plus',function(){
				$(this).prev().val(parseInt($(this).prev().val()) + 1 );
				var length = $(".bookSeq").length;
                money = 0;
                for(var i=0; i<length; i++){
                  money = money + (parseInt($(".count123").eq(i).val())*parseInt($(".bookPrice").eq(i).val()))
                }
                $("#money").text("상품 가격: "+ money)
    		});
        	$(document).on('click','.minus',function(){
    			$(this).next().val(parseInt($(this).next().val()) - 1 );
    				if ($(this).next().val() == 0) {
						$(this).next().val(1);
					}
					var length = $(".bookSeq").length;
                    money = 0;
                    for(var i=0; i<length; i++){
                      money = money + (parseInt($(".count123").eq(i).val())*parseInt($(".bookPrice").eq(i).val()))
                    }

                $("#money").text("상품 가격: "+ money)
    	    	});

 		});