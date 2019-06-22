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