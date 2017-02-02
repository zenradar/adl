$(document).ready(function(){
    $("a").click(function(){
    	$.ajax({ 
            type: 'GET',
            dataType: 'JSON',
            url: 'borrowed/' + $(this).data('user'), 
            success: function (data) { 
            	$('#result').html(display(data));
            }
        });
    	
    });
    
    $('table.table-striped tbody tr').on('click', function () {
        $(this).closest('table').find('td').removeClass('bg');
        $(this).find('td').addClass('bg');
    });
    
});

function display(data) {
	var i =0;
	
	if (data.length == 0) {
		return "No books are on loan";
	}
	
	var output = "<table class=\"table\"><tr><th>Title</th><th>Author</th><th>ISBN</th></tr>";
	while (data[i]) {
		var book = data[i++];
	  	output += "<tr><td>" + book.title + "</td><td>" + book.author + "</td><td>" + book.isbn + "</td></tr>";
	}
    output += "</table>";
    return output;
}