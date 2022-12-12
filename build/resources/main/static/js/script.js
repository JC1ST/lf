$(function(){
	var mob_menu = -1;
	$(".mob_header_btns, .mob_m_area > .menu_title > img").on("click", function(){
		mob_menu *= -1;
		if(mob_menu > 0) {
			$(".mob_header_btns > img").attr("src", "static/img/icon_x_close.png");
			$("footer").hide();
			$(".body_container").hide();
			$(".mob_m_area").slideDown();
		} else {
			$(".mob_header_btns > img").attr("src", "static/img/icon_mob_menu.png");
			$(".mob_m_area").slideUp(300, function(){
				$(".body_container").show();
				$("footer").show();
			});
		}
	});
});