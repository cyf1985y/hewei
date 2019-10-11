function getTaskListByDate() {
	location.href = "../tasks/list?date=" + $("#selectedDate").val();
};

function newTaskWeight() {
	$('form').attr('action','../taskWeight/newTaskWeight');
	$('form').submit();
};

function taskWeightComplete() {
	$('form').attr('action','../taskWeight/taskWeightComplete');
	$('form').submit();
};

function taskWeightComplete() {
	$('form').attr('action','../taskWeight/taskWeightComplete');
	$('form').submit();
};

//輸入車子重量時，如果值為0修正為空白，如果秤重人員無值且載貨司機有值修正為載貨人員姓名
function weightTextclick(obj) {
	if(obj.value == '0'){
		obj.value = '';
		var temp = "select[id$='" + obj.id + "Id" + "']";
		if($(temp).val() == '' && $('#empId').val() != ''){
			$(temp).val($('#empId').val());
		}
	}
};
