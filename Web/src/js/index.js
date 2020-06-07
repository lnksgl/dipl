var elements = $('.modal-overlay, .modal');

$('a').click(function(){
    elements.addClass('active');
});

$('.close-modal').click(function(){
    elements.removeClass('active');
});