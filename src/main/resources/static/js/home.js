$(document).ready(function () {
    $("#myButton").click(function () {
        $("#helloWorldDiv").html("Home JQuery Hello world example");
    });
    loadAllTheTables();

    $("#search-form").submit(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        fire_ajax_submit();
    });
});

function loadAllTheTables() {
    console.log('loadAllTheTables==========');

}

function fire_ajax_submit() {
    var search = {}
    search["mandal"] = $("#mandal").val();
    $("#btn-search").prop("disabled", true);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/csv/byMandal",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (response) {
            //var json = "<h4>Ajax Response</h4>&lt;pre&gt;"+ JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
            //$('#feedback').html(json);
            //console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

            $('#example').dataTable( {
                data : response.result,
                columns: [
                    {"data" : "nameOfTheBeneficiary"},
                    {"data" : "villageName"},
                    {"data" : "categoryLoaneeNonLoanee"},
                    {"data" : "crop"},
                    {"data" : "claimAmountRs"}
                ],
                searching : true,
                bDestroy: true
            });
        },
        error: function (e) {
            var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
                + e.responseText + "&lt;/pre&gt;";
            $('#feedback').html(json);
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);
        }
    });
}