<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="util.AutoCast" %>
<%@ page import="control.Show_InfController" %>
<%@ page import="entity.Access" %>
<%@ page import="entity.Link_Click" %>
<%
List<Access> accessList = AutoCast.automaticCast(request.getAttribute("AccessListForDisplay"));
List<Link_Click> linkList = AutoCast.automaticCast(request.getAttribute("Link_ClickListForDisplay"));
List<String> yearList = AutoCast.automaticCast(request.getAttribute("yearListForDisplay"));
String[] selectList = AutoCast.automaticCast(request.getAttribute("selectListForDisplay"));
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
var cnt = 0;
function functionName(){
	var select1 = document.forms.formName.Month;
	var select2 = document.forms.formName.Day;
	var select3 = document.forms.formName.Year;
	select2.options.length = 0;
	var element = document.getElementById("day");
	var day = element.title;

	//30日（4月6月8月10月12月）
	if(select1.options[select1.selectedIndex].value == "4" || select1.options[select1.selectedIndex].value == "6"
			|| select1.options[select1.selectedIndex].value == "8" || select1.options[select1.selectedIndex].value == "10"
			|| select1.options[select1.selectedIndex].value == "12"){
		for(var i = 1; i < 31; i++){
			select2.options[i] = new Option(i);
		}
	}
	//31日（1月3月5月7月9月11月）
	if(select1.options[select1.selectedIndex].value == "1" || select1.options[select1.selectedIndex].value == "3"
		|| select1.options[select1.selectedIndex].value == "5" || select1.options[select1.selectedIndex].value == "7"
		|| select1.options[select1.selectedIndex].value == "9" || select1.options[select1.selectedIndex].value == "11"){
		for(var i = 1; i < 32; i++){
			select2.options[i] = new Option(i);
		}
	}
	//2月
	if(select1.options[select1.selectedIndex].value == "2"){
		var year = select3.options[select3.selectedIndex].value;
		if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0 )){
			//閏年(29日)
			for(var i = 1; i < 30; i++){
				select2.options[i] = new Option(i);
			}
		}else{
			//NOT閏年(28日)
			for(var i = 1; i < 29; i++){
				select2.options[i] = new Option(i);
			}
		}
	}
	select2.options[day].selected="selected";
}

</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/canvasjs/1.7.0/canvasjs.min.js"></script>
	<script src="app.js"></script>
	<link rel="stylesheet" href="top.css">
    <meta charset="UTF-8">
    <title>Yamazaki</title>
    <meta name="viewport" content="width=device-width">
</head>
<body>
	<body onLoad="functionName()">
	<form name="formName" method="post" action="Show_InfController">
	<div id="day" title="<%= selectList[2] %>"></div>
	<select name="Year" onChange="functionName()">
		<%
		String selectyear = selectList[0];
		for(int i = 0; i < yearList.size(); ++i) {
			String year = yearList.get(i);
			%>
			<option value="<%= year %>"<% if(year.equals(selectyear)){ %><%= "selected"%><% } %>><%= year %></option>
		<% } %>
	</select>
	<select name="Month" onChange="functionName()">
		<%
		String selectmonth = selectList[1];
		for(int i= 1; i < 13; i++){
			String month = String.valueOf(i);
			%>
			<option value="<%= month %>"<% if(month.equals(selectmonth)){ %><%= "selected" %><% } %>><%= month %></option>
		<% } %>
	</select>
	<select name="Day">
	</select>
	<input type="submit" id="button" value="検索" />
	</form>
	<p>wa</p>
	<%
	for(Link_Click bean : linkList){
		String colum = bean.getLink_Colum();
		String count = bean.getLink_Count();
	%>
	<p><%= colum %> : <%= count %></p>
	<% } %>
	<%
	for(Access bean : accessList){
		String hour = bean.getAccess_Hour();
		String count = bean.getAccess_Count();
	%>
	<p><%= hour %> : <%= count %></p>
	<% } %>
	<div id="chartContainer"></div>
</body>
</html>
