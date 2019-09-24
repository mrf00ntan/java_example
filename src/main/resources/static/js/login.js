$(document).ready( function() {
    if($("#error").length > 0) $.notify($("#error").val(), {
        style: "wrong"
    });
    if($("#logout").length > 0) $.notify($("#logout").val(), {
        style: "success"
    });
})
