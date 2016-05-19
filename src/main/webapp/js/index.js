$(document).ready(function(){
	
	$('#weltab').panel({
		title:'New Tab',    
		fit:true,
		border:false,
		noheader:true,
		href:'../welcome/welcome.htm'
	});
});

/**
 * 
 * @param name 标题
 * @param url	访问地址
 */
var addTab = function(name,url){
	if(!$('#tt').tabs('exists',name)){
		
		$('#tt').tabs('add',{
			title:name,
			fit:true,
			content:'content',
		});
	}else{
		//如果tabs已创建则选中
		$('#tt').tabs('select',name);
	}
	
}
