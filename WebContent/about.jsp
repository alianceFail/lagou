﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:wb="http://open.weibo.com/wb">
<head>
<script id="allmobilize" charset="utf-8" src="style/js/allmobilize.min.js"></script>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate" media="handheld"  />
<!-- end 云适配 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>关于我们-拉勾网-最专业的互联网招聘平台</title>
<meta property="qc:admins" content="23635710066417756375" />
<meta content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网" name="description">
<meta content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招" name="keywords">
<meta name="baidu-site-verification" content="QIQ6KC1oZ6" />

<!-- <div class="web_root"  style="display:none">http://www.lagou.com</div> -->
<script type="text/javascript">
var ctx = "http://www.lagou.com";
console.log(1);
</script>
<link rel="Shortcut Icon" href="http://www.lagou.com/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="style/css/style.css"/>
<link rel="stylesheet" type="text/css" href="style/css/external.min.css"/>
<link rel="stylesheet" type="text/css" href="style/css/popup.css"/>
<script src="style/js/jquery.1.10.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/jquery.lib.min.js"></script>
<script src="style/js/ajaxfileupload.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/additional-methods.js"></script>
<!--[if lte IE 8]>
    <script type="text/javascript" src="style/js/excanvas.js"></script>
<![endif]-->
<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script type="text/javascript" src="style/js/conv.js"></script>
</head>
<body>
<div id="body">
	<div id="header">
    	<div class="wrapper">
    		<a href="index.html" class="logo">
    			<img src="style/images/logo.png" width="229" height="43" alt="拉勾招聘-专注互联网招聘" />
    		</a>
    		<ul class="reset" id="navheader">
    			<li class="current"><a href="index.jsp">首页</a></li>
    			
    			<c:if test="${u.type==null}">
    			<li ><a href="companylist.jsp" >公司</a></li>
    			<li ><a href="#" target="_blank">论坛</a></li>
    			<li ><a href="login.jsp" rel="nofollow">我的简历</a></li>
    			<li ><a href="login.jsp" rel="nofollow">发布职位</a></li>
    			</c:if>

				<c:if test="${u.type==0}">
	    		<li ><a href="companylist.jsp" >公司</a></li>
    			<li ><a href="#" target="_blank">论坛</a></li>
    			<li ><a href="jianli.jsp" rel="nofollow">我的简历</a></li>
	    		</c:if>
    				    			
    			<c:if test="${u.type==1}">
				    	<li ><a href="companylist.jsp" >公司</a></li>
    					<li ><a href="#" target="_blank">论坛</a></li>	
    					<li ><a href="create.jsp" rel="nofollow">发布职位</a></li>	
				 </c:if>
	    		    		</ul>
	    		    		
	    		<c:choose>	    		
	    			<c:when test="${u.account!=null}">
	    			
	    				<dl class="collapsible_menu">
            	<dt>
           			<span>欢迎${u.account}&nbsp;</span> 
            		<span class="red dn" id="noticeDot-0"></span>
            		<i></i>
            	</dt>
            					
            					<c:if test="${u.type==0}">
                                	<dd><a rel="nofollow" href="jianli.jsp">我的简历</a></dd>
                                	<dd><a href="collections.html">我收藏的职位</a></dd>
                	                <dd class="btm"><a href="subscribe.html">我的订阅</a></dd>
                                </c:if>               	                	
                				<c:if test="${u.type==1}">
                				<dd><a href="create.html">我要招人</a></dd>
                				</c:if>
                                                <dd><a href="accountBind.html">帐号设置</a></dd>
                                <dd class="logout"><a rel="nofollow" href="exit">退出</a></dd>
           			 </dl>
           			 
        		   </c:when>
	    			<c:otherwise>
						    <ul class="loginTop">
					            	<li><a href="login.jsp" rel="nofollow">登录</a></li> 
					            	<li>|</li>
					            	<li><a href="register.html" rel="nofollow">注册</a></li>
					        </ul>
	    			</c:otherwise>
	    		</c:choose>
            </ul>
                                </div>
    </div><!-- end #header -->
    <div id="container">
        	
        <div class="content_mid">
        	<dl class="c_section c_section_mid">
        		<dt>
                    <h2><em></em>联系我们</h2>
                </dt>
                <dd class="aboutus"> 
                	<img alt="拉勾网团队" src="style/images/aboutus.jpg" width="186" height="186" />
                	<div>
                		<span>拉勾网（隶属于北京拉勾网络技术有限公司）是专注互联网职业机会的招聘网站，以众多优质互联网资源为依托，发布圈内招聘信息，为求职者提供人性化、个性化、专业化的信息服务，以让优质人才和优秀企业及时相遇为己任。</span>
						<span>我们是一个热爱互联网的年轻团队，我们用责任来做这件事情，致力于打造最专业的互联网招聘平台。</span>
                	</div>
                	<ul class="reset contact_box">
	                	<li class="cli1">
	                			<p>商务合作：</p>
								邮箱：<a href="mailto:pqzhao@lagou.com">pqzhao@lagou.com</a>

								地址：北京市海淀区海淀西大街70号
	                		</li>
	                	<li class="cli2">
                			增值服务：<br />
							邮箱：<a href="mailto:bill@lagou.com">bill@lagou.com</a><br />
                		</li>
                		<li class="cli3">
                			客服邮箱：<a href="mailto:vivi@lagou.com">vivi@lagou.com</a><br />
							电话：010-57286997(9:30-21:00)<br />
							<span>
								<!-- WPA Button Begin -->
								<script charset="utf-8" type="text/javascript" src="http://wpa.b.qq.com/cgi/wpa.php?key=XzgwMDA1NjM3OV8xNDUzODBfODAwMDU2Mzc5Xw"></script>
								<!-- WPA Button End -->
							</span>
                		</li>
                	</ul>
                </dd>
            </dl>
       	</div>
			<div class="clear"></div>
			<input type="hidden" id="resubmitToken" value="" />
	    	<a id="backtop" title="回到顶部" rel="nofollow"></a>
	    </div><!-- end #container -->
	</div><!-- end #body -->
	<div id="footer">
		<div class="wrapper">
			<a href="about.html" target="_blank" rel="nofollow">联系我们</a>
		    <a href="http://www.lagou.com/af/zhaopin.html" target="_blank">互联网公司导航</a>
		    <a href="http://e.weibo.com/lagou720" target="_blank" rel="nofollow">拉勾微博</a>
		    <a class="footer_qr" href="javascript:void(0)" rel="nofollow">拉勾微信<i></i></a>
			<div class="copyright">&copy;2013-2014 Lagou <a target="_blank" href="http://www.miitbeian.gov.cn/state/outPortal/loginPortal.action">京ICP备14023790号-2</a></div>
		</div>
	</div>

<script type="text/javascript" src="style/js/core.min.js"></script>
<script type="text/javascript" src="style/js/popup.min.js"></script>
<script type="text/javascript" src="style/js/tongji.js"></script>
<!--  -->
<script type="text/javascript" src="style/js/analytics.js"></script>
</body>
</html>