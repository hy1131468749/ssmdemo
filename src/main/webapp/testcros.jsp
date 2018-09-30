<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% 
Cookie cookie = new Cookie("aaa","bbbb");
response.addCookie(cookie);
response.addCookie(new Cookie("token","d2053d5b-fffd-4f8f-964e-e9f5463dd955"));

Cookie[]  cookies =  request.getCookies();

if(cookies != null){
	for(Cookie c : cookies ){
		System.out.println(c.getName()+":"+c.getValue());
	}
}

%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/public/jquery-2.2.4.min.js"></script>
<script src="/public/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<script src="/public/vue.min.js"></script>
<script src="/public/layer-v3.1.1/layer/layer.js"></script>
<script src="/public/bootstrap-table/src/bootstrap-table.js"></script>
<script
	src="/public/bootstrap-table/src/locale/bootstrap-table-zh-CN.js"></script>
<script src="/public/axios.min.js"></script>

<script>

	function testcors(){
	
	  $.ajax({
          type:'post',
          url:'http://localhost:8080/EMGD/test/testSubject',
          data:{"data":"1"},
          cache:false,
          dataType:'json',
          xhrFields: {
              withCredentials: true // 携带跨域cookie
          },
          success:function(data){
             console.log(data);
          }
      });
	}



</script>

</head>
<body>
<button onclick="testcors()">测试</button>
</body>
</html>