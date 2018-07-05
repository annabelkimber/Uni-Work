$('#comment_form').submit(function (e) {
    e.preventDefault(); 
    this.submit(); // use native js submit

    setTimeout(function () {
        $('#add_comments').val('');
    });
});