$(function(){
		$.getJSON("doGetUser",function(result){
			var username=result.data.username;
			if (username!=null) {
				$("#loginUser").html(username);
			} 
			
		});
	});