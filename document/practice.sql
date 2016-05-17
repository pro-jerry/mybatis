SELECT menu.* FROM role,USER,user_role,menu,role_menu  
	WHERE 
	role.`id` = user_role.`roleId` AND user.`id` = user_role.`userId` 
	AND role.`id` = role_menu.`roleId` AND menu.`id`= role_menu.`menuId`
	AND user.`id`=4
	