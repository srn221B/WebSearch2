<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="util.AutoCast" %>
<%@ page import="control.Show_InfController" %>
<%
List<String> yearList = AutoCast.automaticCast(request.getAttribute("yearListForDisplay"));
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function functionName(){
	var select1 = document.forms.formName.Month;
	var select2 = document.forms.formName.Day;
	var select3 = document.forms.formName.Year;
	select2.options.length = 0;

	//30日（4月6月8月10月12月）
	if(select1.options[select1.selectedIndex].value == "4" || select1.options[select1.selectedIndex].value == "6"
			|| select1.options[select1.selectedIndex].value == "8" || select1.options[select1.selectedIndex].value == "10"
			|| select1.options[select1.selectedIndex].value == "12"){
		for(var i = 0; i < 30; i++){
			select2.options[i] = new Option(i+1);
		}
	}
	//31日（1月3月5月7月9月11月）
	if(select1.options[select1.selectedIndex].value == "1" || select1.options[select1.selectedIndex].value == "3"
		|| select1.options[select1.selectedIndex].value == "5" || select1.options[select1.selectedIndex].value == "7"
		|| select1.options[select1.selectedIndex].value == "9" || select1.options[select1.selectedIndex].value == "11"){
		for(var i = 0; i < 31; i++){
			select2.options[i] = new Option(i+1);
		}
	}
	//2月
	if(select1.options[select1.selectedIndex].value == "2"){
		var year = select3.options[select3.selectedIndex].value;
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0 )){
			//閏年(29日)
			for(var i = 0; i < 29; i++){
				select2.options[i] = new Option(i+1);
			}
		}else{
			//NOT閏年(28日)
			for(var i = 0; i < 28; i++){
				select2.options[i] = new Option(i+1);
			}
		}
	}
}
</script>
	<link rel="stylesheet" href="top.css">
    <meta charset="UTF-8">
    <title>Yamazaki</title>
    <meta name="viewport" content="width=device-width">
</head>
<body>
	<body onLoad="functionName()">
	<form name="formName" method="post" action="Show_InfController">
	<select name="Year" onChange="functionName()">
		<%
		for(int i = 0; i < yearList.size(); ++i) {
			String year = yearList.get(i);
			%>
			<option value="<%= year %>"><%= year %></option>
		<% } %>
	</select>
	<select name="Month" onChange="functionName()">
		<option value = "1">1</option>
		<option value = "2">2</option>
		<option value = "3">3</option>
		<option value = "4">4</option>
		<option value = "5">5</option>
		<option value = "6">6</option>
		<option value = "7">7</option>
		<option value = "8">8</option>
		<option value = "9">9</option>
		<option value = "10">10</option>
		<option value = "11">11</option>
		<option value = "12">12</option>
	</select>
	<select name="Day">
	</select>
	<input type="submit" id="button" value="検索" />
	</form>
<p>wa</p>
</body>
</html>
