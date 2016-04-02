$(function(){
	
	$('#fenye').panel({
		
		width:500,    
		height:150,    
		title: 'My Panel',    
		  tools: [{    
		    iconCls:'icon-add',    
		    handler:function(){alert('new')}    
		  },{    
		    iconCls:'icon-save',    
		    handler:function(){alert('save')}    
		  }]    

	});
	
	
	$('#tree').tree({
		
		url:'../js/tree_data1.json',
		onClick:function(node){
			$('#tt').tabs({ 
				fit:true,
				plain:true,
			    border:false    
			}); 
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
		}

	});
	
	
	
	
	
});