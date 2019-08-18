layui.config({
	base : "js/"
}).use(['form','element','layer','jquery'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		element = layui.element(),
		$ = layui.jquery;

	$(".panel a").on("click",function(){
		window.parent.addTab($(this));
	})
	
	//用户总数
	$.ajax({
			url:"/PLANET_MUSIC/user/allUser",
			success : function(data){
				$(".userAll span").text(data.list.length);
			},
			dataType : "json",
			type :"POST"
		});
	
	//新消息总数
	$.ajax({
		url:"/PLANET_MUSIC/user/FindfeedbackCount",
		success : function(data){
			if(data.state == 200){
				$(".newMessage span").text(data.count);
			}
		},
		dataType : "json",
		type :"POST"
	});
	//公告总数
	$.ajax({
		url:"/PLANET_MUSIC/admin/FindNoticeCount",
		success : function(data){
			if(data.state == 200){
				$(".allNews span").text(data.count);
			}
		},
		dataType : "json",
		type :"POST"
	});

	//数字格式化
	$(".panel span").each(function(){
		$(this).html($(this).text()>9999 ? ($(this).text()/10000).toFixed(2) + "<em>万</em>" : $(this).text());	
	})


})
