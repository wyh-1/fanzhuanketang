<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page language="java"%>
<%@ page import="java.io.*,java.util.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PPT</title>
  <script>
		var currentPPT = "";
		var current = 0;
		var target;
		window.onload = function(){
			target = document.getElementById('target');
		};
	<%
	File allPPTDir = new File(this.getServletContext().getRealPath("/")+"ppt\\pptimgs\\");
	File[] dirs = allPPTDir.listFiles();
	if (dirs != null) {
		%>
		var imgs = {
		<%
		for (File dir : dirs) {
			if (dir.isDirectory()) {
				File[] imgs = dir.listFiles();
				if (imgs != null) {
				%>
					'<%=dir.getName()%>' : {
						'img' : [
						// 这个数组里放置图片路径
						<%
						for (File img : imgs) {
						%>
							'pptimgs/<%=dir.getName()%>/<%=img.getName()%>',
						<%
						}
						%>
						],
						'len' : <%=imgs.length%>
					},
				<%
				}
			}
		}
		%>
		};
		function setImg(pptID){
			if (current >= imgs[pptID].len) current = 0;
			target.src = imgs[pptID].img[current++];
		};
	<%
	}
	%>
		function changePPT(pptID) {
			currentPPT = pptID;
			if (currentPPT != '') {
				current = 0;
				setImg(currentPPT);
			} else {
				target.src = "";
			}
		}
    </script>
   <style>
#btn{
	background-color: #555;
	border: 1px solid #555;
	color: white;
	font-family: "微软雅黑";
	float: right;
}
   </style>
</head>
<body>
	<div>
        <select onchange="changePPT(this.options[this.options.selectedIndex].value)">
			<option></option>
		<%
		if (dirs != null) {
			for (File dir : dirs) {
				if (dir.isDirectory()) {
					%>
					<option><%=dir.getName()%></option>
					<%
				}
			}
		}
		%>
		</select>
    </div>
    <div style="text-align: center;">
    <img id ="target" src="#" alt="">
    </div>
    <div>
        <button id ="btn" onclick="if (currentPPT != '') setImg(currentPPT)">下一张</button>
    </div>
  
</body>

</html>