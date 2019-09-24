// JS код который сработает после всех
$(document).ready(function(){
    $('select').niceSelect();

    // В душе не знаю почему, но это работает
    $('.nice-select').on('click', function(){
        var self = $(this);
        setTimeout(function(){
            self.addClass('open');
        },10);
    });

    $('.nice-select .option').on('click', function(){
        var self = $(this);
        setTimeout(function(){
            self.parent().parent().removeClass("open");
        },15);
    });

});