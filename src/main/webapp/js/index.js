$(document).ready(function(){
	
	
//	$('#weltab').panel({
//		fit:true,
//		border:false,
//		noheader:true,
//		href:'../welcome/welcome.htm'
//	});
	
	$('#fenye').click(function(){
		
		$('#tt').tabs('add',{
			title:'分页实例',
			closable:true
		});
		   
		$('#tt').append($.parser.parse($('<div><table id="data"></table></div>')));
		console.log('1');
		$('#data').datagrid({
			
			url:'../easyui/listCountry.htm',
			title:'Country',
			fitColumns:true,
			striped:true,
			columns:[[  
			          {field:'id',title:'ID',width:80},    
			          {field:'countryname',title:'国家名称',width:80},    
			          {field:'countrycode',title:'国家代码',width:100},    
			      ]],
			pagePosition:'bottom',
			pagination:true,
			pageNumber:1,
			pageSize:10,
			pageList:[10,20,30,40,50]

		});
	});
});

/**
 * 
 * @param name 标题
 * @param url	访问地址
 */
<<<<<<< HEAD
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
=======
var addTab = function(subtitle,url){
	
	if(!$('#tt').tabs('exists',subtitle)){
		$('#tt').tabs('add',{
			title:subtitle,
			closable:true
		});
	}else{
		//如果tabs已创建则选中
		$('#tt').tabs('select',subtitle);
	}
	
	
function fenye(){
	
	
	console.log('1');
}	
>>>>>>> refs/remotes/origin/dev1
	
}
