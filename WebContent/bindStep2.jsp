<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html xmlns:wb="http://open.weibo.com/wb"><head>
</script><script type="text/javascript" async="" src="style/js/conversion.js"></script><script src="style/js/allmobilize.min.js" charset="utf-8" id="allmobilize"></script><style type="text/css"></style>
<meta content="no-siteapp" http-equiv="Cache-Control">
<link  media="handheld" rel="alternate">
<!-- end 云适配 -->
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<title>开通招聘服务-拉勾网-最专业的互联网招聘平台</title>
<meta content="23635710066417756375" property="qc:admins">
<meta name="description" content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网">
<meta name="keywords" content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招">
<meta content="QIQ6KC1oZ6" name="baidu-site-verification">

<!-- <div class="web_root"  style="display:none">h</div> -->
<script type="text/javascript">
var ctx = "h";
console.log(1);
</script>
<link href="h/images/favicon.ico" rel="Shortcut Icon">
<link href="style/css/style.css" type="text/css" rel="stylesheet">
<link href="style/css/external.min.css" type="text/css" rel="stylesheet">
<link href="style/css/popup.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="style/js/jquery.1.10.1.min.js"></script>
<script src="style/js/jquery.lib.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/ajaxfileupload.js"></script>
<script src="style/js/additional-methods.js" type="text/javascript"></script>
<!--[if lte IE 8]>
    <script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script src="style/js/conv.js" type="text/javascript"></script>
<script src="style/js/ajaxCross.json" charset="UTF-8"></script></head>
<body>
<div id="body">
	<div id="header">
    	<div class="wrapper">
    		<a href="index.html" class="logo">
    			<img src="style/images/logo.png" width="229" height="43" alt="拉勾招聘-专注互联网招聘" />
    		</a>
    		<ul class="reset" id="navheader">
    		
    		
    			<li class="current"><a href="index.jsp">首页</a></li>
    			
    			<c:if test="${login.type==null}">
    			<li ><a href="companylist.jsp" >公司</a></li>
    			<li ><a href="#" target="_blank">论坛</a></li>
    			<li ><a href="login.html" rel="nofollow">我的简历</a></li>
    			<li ><a href="login.html" rel="nofollow">发布职位</a></li>
    			</c:if>

				<c:if test="${login.type==0}">
	    		<li ><a href="companylist.jsp" >公司</a></li>
    			<li ><a href="#" target="_blank">论坛</a></li>
    			<li ><a href="jianli.jsp" rel="nofollow">我的简历</a></li>
	    		</c:if>
    				    			
    			<c:if test="${login.type==1}">
				    	<li ><a href="companylist.jsp" >公司</a></li>
    					<li ><a href="#" target="_blank">论坛</a></li>	
    					<li ><a href="create.jsp" rel="nofollow">发布职位</a></li>	
				 </c:if>
	    		    		</ul>
	    		    		
	    		<c:choose>	    		
	    			<c:when test="${login.account!=null}">
	    			
	    				<dl class="collapsible_menu">
            	<dt>
           			<span>欢迎${login.account}&nbsp;</span> 
            		<span class="red dn" id="noticeDot-0"></span>
            		<i></i>
            	</dt>
            					
            					<c:if test="${login.type==0}">
                                	<dd><a rel="nofollow" href="jianli.jsp">我的简历</a></dd>
                                	<dd><a href="collections.html">我收藏的职位</a></dd>
                	                <dd class="btm"><a href="subscribe.html">我的订阅</a></dd>
                                </c:if>               	                	
                				<c:if test="${login.type==1}">
                				<dd><a href="create.html">我要招人</a></dd>
                				<dd><a href="select?lid=${login.id}">公司主页</a></dd>
                				</c:if>
                                                <dd><a href="accountBind.jsp">帐号设置</a></dd>
                                <dd class="logout"><a rel="nofollow" href="exit">退出</a></dd>
           			 </dl>
           			 
        		   </c:when>
	    			<c:otherwise>
						    <ul class="loginTop">
					            	<li><a href="login.html" rel="nofollow">登录</a></li> 
					            	<li>|</li>
					            	<li><a href="register.html" rel="nofollow">注册</a></li>
					        </ul>
	    			</c:otherwise>
	    		</c:choose>	
	    		    		
	    	
            
            
            
            
        


                                </div>
    </div><!-- end #header -->
    <div id="container">
            <style>.ui-autocomplete{max-height:160px;overflow-y:scroll;}</style>
    <div class="content_mid">
        <!--form-->  
            <dl class="c_section c_section_service">
                <dt>
                    <h2><em></em>开通招聘服务</h2>
                </dt>
                <dd>
                	<div class="os_step_2"></div>
               <form class="corp_form"  id="companyNameForm" action="addbind2" method="post" > 
	                 	<input type="hidden" value="3a9b3124ee0a4adca922f2c9756d1ac1" id="resubmitToken">
	                 	<input type="hidden" value="${tel}" id="tel" name="tel">
	                 	<input type="hidden" value="${email}" id="email" name="email">
	                 	<input type="hidden" value="${c.id}" name="cid" id="cid" />
	                 	<h3><em class="redstar">*</em>公司全称  <span class="explain">（请输入与公司营业执照一致的公司全称，审核通过后不可更改）</span></h3> 
	                   	<span role="status" aria-live="polite" class="ui-helper-hidden-accessible">测试公司</span><input type="text" value="" placeholder="请输入与公司营业执照一致的公司全称" name="holeName" id="holeName" class="valid ui-autocomplete-input" autocomplete="off">	
	                   	<input type="submit" value="提 交" >
	                   	<a class="goback" href="bindstep1.jsp">返回修改邮箱地址</a>
                    </form>
                                        <div class="contactus">如有问题，请致电：010-57286997或写信给：<a href="mailto:vivi@lagou.com">vivi@lagou.com</a>，我们会尽快为你解决。</div>
                </dd>
            </dl>
       	</div>
<div class="dn" id="loadingDiv" style="display: none;"><img width="32" height="32" src="style/images/ajax-loader.gif"></div>
<script src="style/js/services.min.js" type="text/javascript"></script>
			<div class="clear"></div>
			<input type="hidden" value="3a9b3124ee0a4adca922f2c9756d1ac1" id="resubmitToken">
	    	<a rel="nofollow" title="回到顶部" id="backtop"></a>
	    </div><!-- end #container -->
	</div><!-- end #body -->
	<div id="footer">
		<div class="wrapper">
			<a rel="nofollow" target="_blank" href="h/about.html">联系我们</a>
		    <a target="_blank" href="h/af/zhaopin.html">互联网公司导航</a>
		    <a rel="nofollow" target="_blank" href="http://e.weibo.com/lagou720">拉勾微博</a>
		    <a rel="nofollow" href="javascript:void(0)" class="footer_qr">拉勾微信<i></i></a>
			<div class="copyright">&copy;2013-2014 Lagou <a href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action" target="_blank">京ICP备14023790号-2</a></div>
		</div>
	</div>

<script src="style/js/core.min.js" type="text/javascript"></script>
<script src="style/js/popup.min.js" type="text/javascript"></script>

<!--  -->


<div id="cboxOverlay" style="display: none;"></div><div id="colorbox" class="" role="dialog" tabindex="-1" style="display: none;"><div id="cboxWrapper"><div><div id="cboxTopLeft" style="float: left;"></div><div id="cboxTopCenter" style="float: left;"></div><div id="cboxTopRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxMiddleLeft" style="float: left;"></div><div id="cboxContent" style="float: left;"><div id="cboxTitle" style="float: left;"></div><div id="cboxCurrent" style="float: left;"></div><button type="button" id="cboxPrevious"></button><button type="button" id="cboxNext"></button><button id="cboxSlideshow"></button><div id="cboxLoadingOverlay" style="float: left;"></div><div id="cboxLoadingGraphic" style="float: left;"></div></div><div id="cboxMiddleRight" style="float: left;"></div></div><div style="clear: left;"><div id="cboxBottomLeft" style="float: left;"></div><div id="cboxBottomCenter" style="float: left;"></div><div id="cboxBottomRight" style="float: left;"></div></div></div><div style="position: absolute; width: 9999px; visibility: hidden; display: none;"></div></div><ul class="ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all" id="ui-id-1" tabindex="0" style="display: none; top: 356px; left: 377.5px; width: 590px;"><li class="ui-menu-item" role="presentation"><a id="ui-id-3" class="ui-corner-all" tabindex="-1">创建名为"测试公司"的新公司</a></li></ul></body></html>