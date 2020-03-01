<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="control.Show_HistoryController" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
//アクセス時
window.onload = function(){
	if(sessionStorage.getItem('access3') == null){
		sessionStorage.setItem('access3','1');
		document.open1.submit();
	}else{
		//アクセス済み
	}
}
//Yahoo!LinkClick
function yahooOpen(){
	document.my_open.submit();
	return true;
}
//楽天LinkClick
function rakutenOpen(){
	document.my_open2.submit();
	return true;
}
//TwitterLinkClick
function TwitterOpen(){
	document.my_open3.submit();
	return true;
}
//FacebookLinkClick
function FacebookOpen(){
	document.my_open4.submit();
	return true;
}
</script>
	<link rel="stylesheet" href="top.css">
    <meta charset="UTF-8">
    <title>Yamazaki</title>
    <meta name="viewport" content="width=device-width">
</head>
<body>
        <h1>Welcome!!</h1>
        <form name="open1" action="Show_HistoryController" method="post">
        <input type="hidden" name="dao" value="Access"/>
        </form>

        <div class="section">
        <h2>お店概要</h2>
        <form name="my_open" action="Show_HistoryController" method="post">
        	<input type="hidden" name="dao" value="Link"/>
        	<input type="hidden" name="colum" value="yahoo"/>
        	<p><a href="https://shironatan.github.io/" onclick="yahooOpen()" target="_blank">Yahooショッピング</a></p>
        </form>
        <form name="my_open2" action="Show_HistoryController" method="post">
        	<input type="hidden" name="dao" value="Link"/>
        	<input type="hidden" name="colum" value="Rakuten"/>
        	<p><a href="https://shironatan.github.io/" onclick="rakutenOpen()" target="_blank">楽天ショッピング</a></p>
        </form>
        <h2>SNS</h2>
        <form name="my_open3" action="Show_HistoryController" method="post">
        	<input type="hidden" name="dao" value="Link"/>
        	<input type="hidden" name="colum" value="Twitter"/>
        	<p><a href="https://shironatan.github.io/" onclick="TwitterOpen()" target="_blank">Twitter</a></p>
        </form>
        <form name="my_open4" action="Show_HistoryController" method="post">
        	<input type="hidden" name="dao" value="Link"/>
        	<input type="hidden" name="colum" value="Facebook"/>
        	<p><a href="https://shironatan.github.io/" onclick="FacebookOpen()" target="_blank">Facebook</a></p>
        </form>
        <h2>ほか</h2>
        </div>
        <br>

        <br>
</body>
</html>
