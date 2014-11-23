$(function() {
    //Datemask dd/mm/yyyy
    $("#datemask").inputmask("dd/mm/yyyy", {"placeholder": "dd/mm/yyyy"});
    //Datemask2 mm/dd/yyyy
    $("#datemask2").inputmask("mm/dd/yyyy", {"placeholder": "mm/dd/yyyy"});
    //Money Euro
    $("[data-mask]").inputmask();

    //Date range picker
    $('#reservation').daterangepicker();
    //Date range picker with time picker
    $('#reservationtime').daterangepicker({timePicker: true, timePickerIncrement: 30, format: 'MM/DD/YYYY h:mm A'});
    //Date range as a button
    $('#daterange-btn').daterangepicker(
            {
                ranges: {
                    'Today': [moment(), moment()],
                    'Yesterday': [moment().subtract('days', 1), moment().subtract('days', 1)],
                    'Last 7 Days': [moment().subtract('days', 6), moment()],
                    'Last 30 Days': [moment().subtract('days', 29), moment()],
                    'This Month': [moment().startOf('month'), moment().endOf('month')],
                    'Last Month': [moment().subtract('month', 1).startOf('month'), moment().subtract('month', 1).endOf('month')]
                },
                startDate: moment().subtract('days', 29),
                endDate: moment()
            },
    function(start, end) {
        $('#reportrange span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
    }
    );

    jQuery.validator.addMethod('positiveNumber',
            function(value) {
                if (value.length > 0) {
                    return Number(value) >= 0;
                }
                return true;
            }, 'Enter a positive number.');

    jQuery.validator.addMethod('floatNumber',
            function(value) {
                if (value.length > 0) {
                    if (/[\.]/.test(value)){
                            return false;
                    }
                }
                return true;
            }, 'Enter a decimal number.');

    $("#dialog_active").click(function() {
        $("#dialog").fadeIn();
    });
    $(".box-footer").find("button:reset").click(function() {
        $("#dialog").fadeOut();
        var validator = $("#form").validate();
        validator.resetForm();
    });
});