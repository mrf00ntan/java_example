$(document).foundation();

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
    xhr.setRequestHeader(header, token);
});

$(document).ready( function() {
    $.notify.defaults({
        autoHideDelay: 2000,
        globalPosition: 'top left',
        hideDuration: 50,
        showDuration: 50
    });

    $.notify.addStyle('wrong', {
        html: "<div><span data-notify-text/></div>",
        classes: {
            base: {
                "white-space": "nowrap",
                "color": "#fff",
                "background-color": "#fa8484",
                "box-shadow": "2px 3px 2px rgba(0, 0, 0, .1)",
                "padding": "7px 15px",
                "font-weight": "500",
                "border-radius": "0px"
            }
        }
    });

    $(document).on("input", ".numeric", function() {
        this.value = this.value.replace(/\D/g,'');
    });

    $('.mobile-phone').mask("+7 (999) 999 99 99");

    $.notify.addStyle('success', {
        html: "<div><span data-notify-text/></div>",
        classes: {
            base: {
                "white-space": "nowrap",
                "color": "#fff",
                "background-color": "#81de7a",
                "box-shadow": "2px 3px 2px rgba(0, 0, 0, .1)",
                "padding": "7px 15px",
                "font-weight": "500",
                "border-radius": "0px"
            }
        }
    });

    $.datepicker.regional['ru'] = {
        closeText: 'Закрыть',
        prevText: 'Пред',
        nextText: 'След',
        currentText: 'Сегодня',
        monthNames: ['Январь','Февраль','Март','Апрель','Май','Июнь',
            'Июль','Август','Сентябрь','Октябрь','Ноябрь','Декабрь'],
        monthNamesShort: ['Янв','Фев','Мар','Апр','Май','Июн',
            'Июл','Авг','Сен','Окт','Ноя','Дек'],
        dayNames: ['воскресенье','понедельник','вторник','среда','четверг','пятница','суббота'],
        dayNamesShort: ['вск','пнд','втр','срд','чтв','птн','сбт'],
        dayNamesMin: ['Вс','Пн','Вт','Ср','Чт','Пт','Сб'],
        weekHeader: 'Нед',
        dateFormat: 'dd.mm.yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''};
    $.datepicker.setDefaults($.datepicker.regional['ru']);
})