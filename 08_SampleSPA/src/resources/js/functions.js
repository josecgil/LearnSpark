$(function () {

    var doingAnimation=false;

    $(".js-generate-claim").on("click", function (event) {
        event.preventDefault();
        if (doingAnimation) return;
        doingAnimation=true;
        $(".claim-box-wrap").each(function (index, claimBox) {
            setTimeout(function () {
                $(claimBox).addClass("is-flipped");
            }, 150*index);
        });
        var claimCount=$(".claim-box-wrap").length;
        setTimeout(function() {
        		$.getJSON("/claims/create", function(claims) {
        			$(".claim-box-wrap").each(function(index, claimBox) {
        				$(claimBox).find("h3").html(claims[index]);
        			});        			
                $(".claim-box-wrap").removeClass("is-flipped");
                $(".claimcount").html("1000");
                doingAnimation=false;
        		});
        		
        	
        }, 250*claimCount);
    });
});
