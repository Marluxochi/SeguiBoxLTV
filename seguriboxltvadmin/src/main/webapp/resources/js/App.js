$(document).ready(function () {
    $("#listaHsmKey").sortable({
        connectWith: "#listaHsmKey"
    });
    $("#btn-addToList").click(function () {
        if ($("#txt-hsm").val() !== "") {
            $("#listaHsmKey").append("<li class='list-group-item'>" + $("#txt-hsm").val() + "</li>");
            $("#txt-hsm").val('').focus();
            $("#listaHsmKey").sortable('refresh');
        }
    });
    
    $("#btn-typeGroup").click(function () {
        if ($("#typeUser").val() === "admin") {
            location.href="AdminGroupPermissions.html";
        } else {
            location.href="AdminGroupHSMKey.html";
        }
        
    });

    $("#datepicker").datepicker({
        dateFormat: "yy-mm-dd"
    });
    
    $("#datepicker2").datepicker({
        dateFormat: "yy-mm-dd"
    });
    
    $("#btn-date1").click(function () {
        var monthComplete;
        var today = new Date();
        var day = today.getUTCDate();
        var month = today.getUTCMonth();
        month += 1;
        if(month < 10) {
             monthComplete = "0" + month;
        } else {
            monthComplete = month;
        }
        var year = today.getFullYear();
        document.getElementById("datepicker").value = year + "-" + monthComplete + "-" + day;
    });
    
    $("#btn-date2").click(function () {
        var monthComplete;
        var today = new Date();
        var day = today.getUTCDate();
        var month = today.getUTCMonth();
        month += 1;
        if(month < 10) {
             monthComplete = "0" + month;
        } else {
            monthComplete = month;
        }
        var year = today.getFullYear();
        document.getElementById("datepicker2").value = year + "-" + monthComplete + "-" + day;
    });

    $(window).load(function() {
        $('.blueberry').blueberry();
    });

});