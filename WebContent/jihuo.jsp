<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script id="allmobilize" charset="utf-8" src="style/js/allmobilize.min.js"></script>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate" media="handheld"  />
<!-- end 云适配 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册-拉勾网-最专业的互联网招聘平台</title>
<meta property="qc:admins" content="23635710066417756375" />
<meta content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网" name="description">
<meta content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招" name="keywords">

<meta name="baidu-site-verification" content="QIQ6KC1oZ6" />

<!-- <div class="web_root"  style="display:none">h</div> -->
<script type="text/javascript">


var ctx = "h";
console.log(1);
</script>
<link rel="Shortcut Icon" href="h/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="style/css/style.css"/>

<script src="style/js/jquery.1.10.1.min.js" type="text/javascript"></script>

<script type="text/javascript" src="style/js/jquery.lib.min.js"></script>
<script type="text/javascript" src="style/js/core.min.js"></script>


<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script type="text/javascript" src="style/js/conv.js"></script>
</head>
<body id="login_bg">
	<div class="login_wrapper">
		<div class="login_header">
        	<a href="h/"><img src="style/images/logo_white.png" width="285" height="62" alt="拉勾招聘" /></a>
            <div id="cloud_s"><img src="style/images/cloud_s.png" width="81" height="52" alt="cloud" /></div>
            <div id="cloud_m"><img src="style/images/cloud_m.png" width="136" height="95"  alt="cloud" /></div>
        </div>
        
    	<input type="hidden" id="resubmitToken" value="9b207beb1e014a93bc852b7ba450db27" />		
		<div class="login_box">
		
		<div><strong style="size: 60px;color: green;">欢迎注册拉勾用户：</strong>确认点击激活</div><br>
		
          <form action="addUser" method="post"  id="loginForm">
            	<label class="fl registerJianJu" for="checkbox">
            		<input type="checkbox" id="checkbox" name="checkbox"  checked  class="checkbox valid" />我已阅读并同意<a href="h/privacy.html" target="_blank">《拉勾用户协议》</a>
           		</label>
                <input type="submit" id="submitLogin"   value="激 &nbsp; &nbsp; 活" />
                
                <input type="hidden" id="callback" name="callback" value="${user.account}"/>
                <input type="hidden" id="authType" name="authType" value="${user.pass}111"/>
                <input type="hidden" id="signature" name="signature" value="${user.pass}222"/>
                <input type="hidden" id="timestamp" name="timestamp" value="${user.pass}123"/>
            </form>
            <div class="login_right">
            	<div>已有拉勾帐号</div>
            	<a  href="login.html"  class="registor_now">直接登录</a>
                <div class="login_others">使用以下帐号直接登录:</div>
                <a  href="h/ologin/auth/sina.html"  target="_blank" class="icon_wb" title="使用新浪微博帐号登录"></a>
               	<a  href="h/ologin/auth/qq.html"  class="icon_qq" target="_blank" title="使用腾讯QQ帐号登录" ></a>
            </div>
        </div>
        <div class="login_box_btm"></div>
    </div>
    
    <script type="text/javascript">
    
 $(document).ready(function() {

	 
	 $('#checkbox').change(function(){
		 var b=$('#checkbox').is(':checked');
		 if(b==true)
			 {
			 $('#submitLogin').attr("disabled", false);
			 }else
				 {
				 $('#submitLogin').attr("disabled", true);
				 }
	  });
    	
    	});
    </script>
</body>
</html>
