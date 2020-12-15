/**
 * 
 */
$(document).ready(function(){
	console.log('Ready...');
    // click on button submit
    $("#createBookFrm").submit(function(e){
    	e.preventDefault(); // avoid to execute the actual submit of the form.
    	console.log('Create book form submitted...');
    	send();
    	
    });
});

function send() {
    var book = {
    	title: $("#bookTitle").val(),
    	author:$("#bookAuthor").val()
    }

    var $frm = $("#createBookFrm #submit");
    
    $.ajax({
        url: '/api/books',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
            $('#target').html(data.msg);
            findAll();
        },
        data: JSON.stringify(book)
    });
}

function findAll(){
	$.ajax({ 
	    type: 'GET', 
	    url: '/api/books',  
	    dataType: 'json',
	    success: function (data) {
	    	var tbl = $('#bookTable tbody');
	    	tbl.empty();
	        $.each(data, function(index, element) {
	        	tbl.append('<tr>' +
	        		'<td>'+element.id+' </td> ' +
	        		'<td>'+element.title+' </td>' +
	        		'<td>'+element.author+' </td>' +
	        		'</tr>');
	        });
	    }
	});
}

$('.accordion-toggle').click(function(){
	$('.hiddenRow').hide();
	$(this).next('tr').find('.hiddenRow').show();
});