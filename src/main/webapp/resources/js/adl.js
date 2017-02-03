$(document).ready(function(){

    $("a.fetch-books").click(function(){
      $(this).closest('table').find('td.name-link').removeClass('bg');
      $(this).closest('td.name-link').addClass('bg');

      $.ajax({
            type: 'GET',
            dataType: 'JSON',
            url: 'borrowed/' + $(this).data('user'),
            success: function (data) {
              $('#memberloans').html(displayMemberLoans(data));
            }
        });
    });
});


function displayMemberLoans(data) {
	var i =0;

	if (data.length == 0) {
		return "No books are on loan to this member";
	}

	var output = "<table class=\"table\"><tr><th>Title</th><th>Author</th><th>ISBN</th></tr>";
	while (data[i]) {
		var book = data[i++];
	  	output += "<tr><td>" + book.title + "</td><td>" + book.author + "</td><td>" + book.isbn + "</td></tr>";
	}
    output += "</table>";
    return output;
}
