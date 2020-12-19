/**
 * 
 */
$(document).ready(function(){
	console.log('Ready...');
	$('.alert').alert();
	
    // click on button submit
    $("#createTaxFrm").submit(function(e){
    	e.preventDefault(); // avoid to execute the actual submit of the form.
    	console.log('Create Tax form submitted...');
    	send();
    	
    });
    
    $('.accordion-toggle').click(function(){
		$('.hiddenRow').hide();
		var $elm = $(this).next('tr').find('.hiddenRow');
		if($($elm).is(":visible")){
			$elm.hide();
			$elm.find('div').hide();
		}else{
			$elm.show();
			$elm.find('div').show();
		}
	});
});

function extractTaxForm(){
	var $frm = $("#createTaxFrm");
	return {
	    "sno": $frm.find('#inputSno').val(),
	    "demandNo": $frm.find('#inputDemandNo').val(),
	    "doorNo": $frm.find('#inputDoorNo').val(),
	    "houseType": $frm.find('#inputHouseTyp').val(),
	    "name": $frm.find('#inputOwnerNm').val(),
	    "fhName": $frm.find('#inputFHname').val(),
	    "height": $frm.find('#inputHeight').val(),
	    "length": $frm.find('#inputLength').val(),
	    "total": $frm.find('#inputTotal').val(),
	    "taxAccount": [
	        {
	            "taxType": "REQUIRED",
	            "houseTaxArrear": $frm.find('#taxReq #inputHouseTaxArrear').val(),
	            "houseTaxCurrent": $frm.find('#taxReq #inputHouseTaxCurrent').val(),
	            "libertyTaxArrear": $frm.find('#taxReq #inputLibertyTaxArrear').val(),
	            "libertyTaxCurrent": $frm.find('#taxReq #inputLibertyTaxCurrent').val(),
	            "totalTaxArrear": $frm.find('#taxReq #inputTotalTaxArrear').val(),
	            "totalTaxCurrent": $frm.find('#taxReq #inputTotalTaxCurrent').val()
	        },
	        {
	            "taxType": "RECEIVED",
	            "houseTaxArrear": $frm.find('#taxRec #inputHouseTaxArrear').val(),
	            "houseTaxCurrent": $frm.find('#taxRec #inputHouseTaxCurrent').val(),
	            "libertyTaxArrear": $frm.find('#taxRec #inputLibertyTaxArrear').val(),
	            "libertyTaxCurrent": $frm.find('#taxRec #inputLibertyTaxCurrent').val(),
	            "totalTaxArrear": $frm.find('#taxRec #inputTotalTaxArrear').val(),
	            "totalTaxCurrent": $frm.find('#taxRec #inputTotalTaxCurrent').val()
	        },
	        {
	            "taxType": "REQUIRED_BALANCE",
	            "houseTaxArrear": $frm.find('#taxReqPend #inputHouseTaxArrear').val(),
	            "houseTaxCurrent": $frm.find('#taxReqPend #inputHouseTaxCurrent').val(),
	            "libertyTaxArrear": $frm.find('#taxReqPend #inputLibertyTaxArrear').val(),
	            "libertyTaxCurrent": $frm.find('#taxReqPend #inputLibertyTaxCurrent').val(),
	            "totalTaxArrear": $frm.find('#taxReqPend #inputTotalTaxArrear').val(),
	            "totalTaxCurrent": $frm.find('#taxReqPend #inputTotalTaxCurrent').val()
	        }
	    ]
	};
}

function send() {
    var newTax = extractTaxForm();
    
    $.ajax({
        url: '/api/tax/create',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
        	alert(data.message);
        	$('div#newTaxEntryCreatedAlert').removeClass('d-none');
        	$('div#newTaxEntryCreatedAlert').addClass('d-block');
        },
        error: function (request, status, error) {
            alert(request.responseText);
        },
        data: JSON.stringify(newTax)
    });
}
