$(function() {
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});

$('body').scrollspy({
    target: '.navbar-fixed-top'
})

$('.navbar-collapse ul li a').click(function() {
    $('.navbar-toggle:visible').click();
});

$(document).ready(function () {
    (function ($) {
        $.fn.writeText = function (content) {
            var contentArray = content.split(""),
                current = 0,
                elem = this;
            setInterval(function () {
                if (current < contentArray.length) {
                    elem.text(elem.text() + contentArray[current++]);
                }
            }, 120);
        };
    })(jQuery);

    $("#writeText").writeText(introHead);

    $('#contactForm').submit(function(event) {
        event.preventDefault();

        const name = $('#name').val().trim();
        const email = $('#email').val().trim();
        const subject = $('#subject').val().trim();
        const message = $('#message').val().trim();

        const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;

        var errorMessage = '';
        if (!name) {
            errorMessage = nameValidateMsg;
        } else if (!email) {
            errorMessage = emailValidateMsg;
        } else if (!emailPattern.test(email)) {
            errorMessage = emailPatternErrorMsg;
        } else if (!subject) {
            errorMessage = subjectValidateMsg;
        } else if (!message) {
            errorMessage = textValidateMsg;
        }

        if (errorMessage) {
            alert(errorMessage);
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/api/sendmail',
            contentType: 'application/json',
            data: JSON.stringify({
                name: name,
                from: email,
                subject: subject,
                text: message
            }),
            success: function(response) {
                alert(sendSuccessMsg);
                window.location.href = redirectUrl;
            },
            error: function(xhr, status, error) {
                alert(sendFailMsg);
                window.location.href = redirectUrl;
            }
        });
    });

});
