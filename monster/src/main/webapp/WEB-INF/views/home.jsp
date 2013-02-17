<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>黄金迷城战斗掉落速查 by 小狼</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="黄金迷城" />
<meta http-equiv="description" content="黄金迷城战斗掉落速查" />
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load("jquery", "1.6.2");
</script>
<script type="text/javascript"
	src="http://jquery-json.googlecode.com/files/jquery.json-2.2.min.js"></script>

<script src="resources/js/elastic.js" type="text/javascript"
	language="javascript" charset="utf-8"></script>
<script src="resources/js/jquery.boxy.js" type="text/javascript"
	language="javascript" charset="utf-8"></script>

<link rel="stylesheet" type="text/css" media="all"
	href="resources/css/elastic.css" />
<link rel="stylesheet" type="text/css" media="all"
	href="resources/css/boxy.css" />
<style type="text/css">
.subm {
	width: 50px;
	line-height: 1.5em;
}

.main DIV,.footer DIV,.header {
	width: 100%;
	text-align: center;
	margin-top: 1em;
}

IMG.eggHead {
	width: 50px;
	margin: 0 5px;
}

.mytips DIV {
	color: #666666;
	font-size: 9px;
	text-align: right;
}
a {
	cursor: pointer
}

a:link {
	color: #369;
	text-decoration: none
}

a:visited {
	color: #369;
	text-decoration: none
}

a:hover {
	color: #BA2636;
	text-decoration: none;
}

.footer{
	overflow:hidden;
}
</style>

<script type="text/javascript">
	var PROJECT_NAME = "<%=this.getServletContext().getContextPath()%>";
	$(document).ready(function() {
		var generateEggImageHTML = function(enemy){
			var _html = '';
			_html += '<img class="eggHead" src="resources/images/Pet_head_';
			_html += enemy.num;
			_html += '.png" alt="'+enemy.num+'" title="'+enemy.num+'" />';
			return _html;
		};
		$('#subm').click(function() {
			var queryModel = {};
			queryModel['battleresume'] = $('#battleresume').val();
			var jsonQueryModel = $.toJSON(queryModel);
			//alert(jsonQueryModel);
			$.ajax({
				type : 'POST',
				contentType : "application/json; charset=utf-8",
				url : PROJECT_NAME + '/analysis',
				data : jsonQueryModel,
				dataType : 'json',
				success : function(data) {
					var eggHTML = '';
					//alert(data.enemies.length);
					if(data.enemies.length > 0){
						$.each(data.enemies, function(i) {
							eggHTML += generateEggImageHTML(this);
						});
						//$('#eggs').html(eggHTML);
						Boxy.alert(eggHTML,function(){
							$('#battleresume').val('');
						},{title:"本次战斗的掉落!"});
					}else{
						Boxy.alert('脸黑了，这次战斗你没拿到任何蛋蛋！');
					}
				},
				error : function(data) {
					Boxy.alert("error");
				}
			});
		});
	});
</script>

<script type="text/javascript">
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?7105ea3412bb5f383e103f645ea86355";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>


</head>
<body>
	<div class="unit header" id="header">
		<h1>黄金迷城战斗掉落速查</h1>
	</div>
	<div class="unit body">
		<div class="columns on-3 same-height">
			<div class="column elastic">
				<div class="container">&nbsp;</div>
			</div>
			<div class="column fixed" style="width: 500px">
				<div class="container main">
					<div>
						<textarea id="battleresume" name="battleresume"
							style="width: 100%; height: 300px;"></textarea>
					</div>
					<div class="mytips">
						<div style="text-align: left;">温馨提示:</div>
						<div>
							请把黄金迷城Monster目录的Documents/BattleResume.lua文件内容拷贝到上面的输入框。
							lua文件可以用文本工具打开。
						</div>
					</div>
					<div>
						<input class="subm" type="button" id="subm" value="提交" />
					</div>
					<div id="eggs"></div>
				</div>
			</div>
			<div class="column elastic elastic-row-last">
				<div class="container">&nbsp;</div>
			</div>
		</div>
	</div>
	<div class="unit footer" id="footer">
		<div class="container copyright" id="copyright">
			Copyright &copy; 2013 <a
				href="http://bbs.maoren8.com/u.php?uid=19540" target="_blank">小狼@猫人吧</a>
		</div>
	</div>
</body>
</html>
