$(function(){
	$.ajax({
		url:'../res/init',
		async:false,
		success:function(data){
			var sidebar = $("#sideBar");
			var htmlContent = "";
			$.each(data,function(index,value){
				htmlContent=htmlContent+"<li class=\"layui-nav-item\"><a data-url="+value.resHref+" name=\"plateBuid\" data-type=\"tabAdd\" id="+value.buid+"><cite>"+value.resCnTitle+"</cite><em>"+value.resEngTitle+"</em></a></li>";
			});
			sidebar.html(htmlContent);
			var buid="";
			var htmlSonContent = "<dl class=\"layui-nav-child\">";
			$.each(data,function(index,value){
				if(value.sonResource.length>0){
					buid=value.buid;
					$.each(value.sonResource,function(idx,val){
						htmlSonContent=htmlSonContent+"<dd><a data-url="+val.resHref+" data-type=\"tabAdd\" id="+val.buid+" name=\"plateBuid\">&nbsp;<cite>"+val.resCnTitle+"</cite><em>"+val.resEngTitle+"</em></a></dd>";
					});
				}
			});
			htmlSonContent=htmlSonContent+"</dl>";
			$("#"+buid).parent().append(htmlSonContent);
			$("#sideBar li:has(dl)").children("a").removeAttr("data-type").removeAttr("name");
		}
	});
	/*$("[name=plateBuid]").click(function(){
		sessionStorage.setItem("plateBuid",$(this).attr("id"));
		return true;
	});*/
	
});
