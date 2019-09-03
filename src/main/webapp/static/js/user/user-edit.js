$(function () {
    $('#myDatepicker').datetimepicker({
        format: 'yyyy-mm-dd hh:ii',
        language: 'zh-CN',
        todayBtn: true,
        startDate: (new Date()).toLocaleDateString(),
        weekStart: 1,
    })
});

