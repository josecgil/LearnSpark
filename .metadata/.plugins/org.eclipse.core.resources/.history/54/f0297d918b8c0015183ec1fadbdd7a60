$(function () {

    var doingAnimation=false;

    $(".js-generate-claim").on("click", function (event) {
        event.preventDefault();
        if (doingAnimation) return;
        doingAnimation=true;
        $(".claim-box-wrap").each(function (index, element) {
            setTimeout(function () {
                $(element).addClass("is-flipped");
            }, 150*index);
        });
        var claimCount=$(".claim-box-wrap").length;
        setTimeout(function() {
            //Update
            $(".claim-box-wrap").removeClass("is-flipped");
            $(".claimcount").html("1000");
            doingAnimation=false;
        }, 250*claimCount);
    });
});
