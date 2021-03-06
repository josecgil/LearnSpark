$(function () {

    var doingAnimation=false;
    var numberOfClaimBoxes=$(".claim-box-wrap").length;

    $(".js-generate-claim").on("click", function (event) {
        event.preventDefault();
        if (doingAnimation) return;
        doingAnimation=true;
        $(".claim-box-wrap").each(function (index, claimBox) {
            setTimeout(function () {
                $(claimBox).addClass("is-flipped");
            }, 150*index);
        });
        setTimeout(function() {
        		$.getJSON("/claims/select/"+numberOfClaimBoxes, function(claims) {
        			$(".claim-box-wrap").each(function(index, claimBox) {
        				$(claimBox).find("h3").html(claims[index]);
        			});        			
        			$(".claim-box-wrap").removeClass("is-flipped");
            		$.getJSON("/claims/count", function(claimsCount) {
                    $(".claimcount").html(claimsCount);
            		});
                doingAnimation=false;
        		});
        }, 250*numberOfClaimBoxes);
    });
});
