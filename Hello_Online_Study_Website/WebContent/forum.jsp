<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0039)http://www.cskaoyan.com/forum-17-1.html -->
<html xmlns="http://www.w3.org/1999/xhtml" class=" widthauto">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Hello!考研</title>
	<base href="." />
	<link rel="stylesheet" type="text/css"
		href="./forum_files/style_1_common.css" />
	<link rel="stylesheet" type="text/css"
		href="./forum_files/style_1_forum_forumdisplay.css" />
	<link rel="stylesheet" id="css_widthauto" type="text/css"
		href="./forum_files/style_1_widthauto.css" />
<script src="./forum_files/forum.js" type="text/javascript"></script>
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function() {
		$(".px").change(function(){
			window.location.href = "thread_listThreadAction.action?pageNo="+this.value ;
		});
		/* $("#newspecialtmp").click(function(){ 
			if(${sessionScope.user }==null){
				alert("${sessionScope.user }");
				return false;
			}
		}); */
	});
</script>
</head>
<body id="nv_forum" class="pg_forumdisplay" onkeydown="if(event.keyCode==27) return false;" >
<div id="append_parent">
  <div id="ls_fastloginfield_ctrl_menu" class="sltm" style="display: none; width: 40px;">
    <ul>
      <li class="current">用户名</li>
      <li>Email</li>
    </ul>
  </div>
</div>
<div id="ajaxwaitid"></div>
<div id="toptb" class="cl">
</div>
<div id="hd">
  <div class="wp">
    <div class="hdc cl">
      <h2>
      <a href="thread_listThreadAction.action?pageNo=1" title="Hello！考研,专注于计算机考研的点点滴滴！">
      <img src="static/img/logo.png" alt="Hello！考研,专注于计算机考研的点点滴滴！" border="0">
      </a></h2>
      <form method="post" autocomplete="off" id="lsform" action="pages/user/login.jsp" onsubmit="pwmd5(&#39;ls_password&#39;);return lsSubmit();">
        <div class="fastlg cl">
      <s:if test="#session.user==null">
          <div class="y pns">
            <table cellspacing="0" cellpadding="0">
              <tbody>
              	<tr>
              		<td></td>
              		<td></td>
              	</tr>
                <tr>
                  <td class="fastlg_l"><button type="submit" class="pn vm" tabindex="904" style="width: 75px;"><em>登录</em></button></td>
                  <td class="fastlg_l"><a href="pages/user/regist.jsp" class="xi2 xw1">注册</a></td>
                </tr>
              </tbody>
            </table>
            <input type="hidden" name="quickforward" value="yes">
            <input type="hidden" name="handlekey" value="ls">
          </div>
          </s:if>
	      <s:if test="#session.user!=null">
	      <div class="y pns">
	      	欢迎<s:property value="#session.user.username"/> <%@ include file="/WEB-INF/include/manager-info.jsp" %>
	      </div>
	      </s:if>
        </div>
      </form>
      <script src="./forum_files/md5.js" type="text/javascript" reload="1"></script>
    </div>
    <div id="nv">
      <ul>
        <li class="a" id="mn_forum"><a href="http://www.cskaoyan.com/forum.php" hidefocus="true" title="BBS">论坛<span>BBS</span></a></li>
      </ul>
    </div>
    <div class="p_pop h_pop" id="mn_userapp_menu" style="display: none"></div>
    <div id="mu" class="cl"> </div>
    <div id="scbar" class="scbar_narrow cl">
      <form id="scbar_form" method="post" autocomplete="off" onsubmit="searchFocus($(&#39;scbar_txt&#39;))" action="http://www.cskaoyan.com/search.php?searchsubmit=yes" target="_blank">
        <input type="hidden" name="mod" id="scbar_mod" value="search">
        <input type="hidden" name="formhash" value="934f7da2">
        <input type="hidden" name="srchtype" value="title">
        <input type="hidden" name="srhfid" value="17">
        <input type="hidden" name="srhlocality" value="forum::forumdisplay">
      </form>
    </div>
    <ul id="scbar_type_menu" class="p_pop" style="display: none;">
      <li><a href="javascript:;" rel="curforum" fid="17">本版</a></li>
      <li><a href="javascript:;" rel="user">用户</a></li>
    </ul>
  </div>
</div>
<div id="wp" class="wp">
  <div class="boardnav">
    <div id="ct" class="wp cl">
      <div class="mn">
        <div id="pgt" class="bm bw0 pgs cl">
         <span id="fd_page_top">
          <div class="pg">
          		<div class="pg">
             		
        			<s:if test="#request.threadPage.pageNo>1">
		             	<s:a href="thread_listThreadAction.action?pageNo=1" class="nxt">首&nbsp;页</s:a>
		             	<s:a href="thread_listThreadAction.action?pageNo=%{#request.threadPage.pageNo-1}" class="nxt">上一页</s:a>
        			</s:if>
        			<label>
        				<s:textfield name="custompage" cssClass="px" size="2" title="输入页码，按回车快速跳转" value="%{#request.threadPage.pageNo}" ></s:textfield>
             			<span title="共 451 页"> /<s:property value="#request.threadPage.totalPage"/>页</span>
             		</label>
        			<s:if test="#request.threadPage.pageNo<#request.threadPage.totalPage ">
		             	<s:a href="thread_listThreadAction.action?pageNo=%{#request.threadPage.pageNo+1}" class="nxt">下一页</s:a>
		             	<s:a href="thread_listThreadAction.action?pageNo=%{#request.threadPage.totalPage}" class="nxt">末&nbsp;页</s:a>
       					
        			</s:if>
        			</div>
          </div>
        </span> </div>
        <div id="threadlist" class="tl bm bmw">
          <div class="th">
            <table cellspacing="0" cellpadding="0">
              <tbody>
                <tr>
                  <td></td>
                  <td class="by">作者</td>
                  <td class="num">回复/查看</td>
                  <td class="by">最后发表时间</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="bm_c">
            <script type="text/javascript">var lasttime = 1460991856;var listcolspan= '5';</script>
            <div id="forumnew" style="display:none"></div>
            <form method="post" autocomplete="off" name="moderate" id="moderate" action="http://www.cskaoyan.com/forum.php?mod=topicadmin&amp;action=moderate&amp;fid=17&amp;infloat=yes&amp;nopost=yes">
              <input type="hidden" name="formhash2" value="934f7da2" />
              <input type="hidden" name="listextra" value="page%3D1" />
              <table summary="forum_17" cellspacing="0" cellpadding="0" id="threadlisttableid">
                <script type="text/javascript">hideStickThread();</script>
                
                
                <s:iterator value="#request.threadPage.content">

	                <tbody>
	                  <tr>
	                	<td class="icn"> <img src="./forum_files/folder_new.gif" /> </td>
	                    <th class="new">
		                     <s:a href="reply_listReplyAction.action?pageNo=1&id=%{id}" style="color: #EE1B2E;"  class="s xst">
		                     	<s:property value="title"/>
							</s:a> 
						 </th>
	                    <td class="by">
		                    <cite> 
			                    <span c="1" style="color: blue;" mid="card_8450">
			                  		<s:property value="author.username"/>
			                    </span>
		                    </cite> 
		                    <em>
			                    <span>
			                   		<s:date name="createTime" format="yyyy-MM-dd HH:mm"/>
			                    </span>
		                    </em>
	                     </td>
	                    <td class="num">
		                    <a class="xi2">
		                   		 <s:property value="replyCount"/>	
		                    </a>
		                    <em>
		                   		<s:property value="hit"/>	
		                    </em>
	                    </td>
	                    <td class="by">
		                    <cite>
			                    <a c="1" mid="card_2637">
			                  		  <s:property value="authorLastReplied.username"/>	
			                    </a>
		                    </cite> 
		                    <em>
			                    <a>
			                    	<s:date name="dateLastReplied" format="yyyy-MM-dd HH:mm"/>
			                    </a>
		                    </em>
	                     </td>
	                  </tr>
	                </tbody>
                </s:iterator>
              </table>
              <!-- end of table "forum_G[fid]" branch 1/3 -->
            </form>
          </div>
        </div>
        <div id="filter_special_menu" class="p_pop" style="display:none" change="location.href=&#39;forum.php?mod=forumdisplay&amp;fid=17&amp;filter=&#39;+$(&#39;filter_special&#39;).value">
        </div>
        <script src="./forum_files/autoloadpage.js" type="text/javascript"></script>
  	 	  <div class="bm bw0 pgs cl"> 
  	 	  	<span id="fd_page_bottom">
         		<div class="pg">
             		
        			<s:if test="#request.threadPage.pageNo>1">
		             	<s:a href="thread_listThreadAction.action?pageNo=1" class="nxt">首&nbsp;页</s:a>
		             	<s:a href="thread_listThreadAction.action?pageNo=%{#request.threadPage.pageNo-1}" class="nxt">上一页</s:a>
        			</s:if>
        			<label>
        				<s:textfield name="custompage" cssClass="px" size="2" title="输入页码，按回车快速跳转" value="%{#request.threadPage.pageNo}" ></s:textfield>
             			<span title="共 451 页"> /<s:property value="#request.threadPage.totalPage"/>页</span>
             		</label>
        			<s:if test="#request.threadPage.pageNo<#request.threadPage.totalPage ">
		             	<s:a href="thread_listThreadAction.action?pageNo=%{#request.threadPage.pageNo+1}" class="nxt">下一页</s:a>
		             	<s:a href="thread_listThreadAction.action?pageNo=%{#request.threadPage.totalPage}" class="nxt">末&nbsp;页</s:a>
       					
        			</s:if>
        			</div>
		        </span>
		         
		          <a href="thread_toAddThreadAction.action" id="newspecialtmp"   title="发新帖"><img src="./forum_files/pn_post.png" alt="发新帖" /></a>
		        </div>

        <div id="diyfastposttop" class="area"></div>


      </div>
    </div>
  </div>
  <div class="wp mtn">
    <div id="diy3" class="area"></div>
  </div>
</div>
<div id="ft" class="cl">
</div>
<div id="scrolltop" style="left: auto; right: 0px; visibility: hidden;"> <span hidefocus="true"><a title="返回顶部" onclick="window.scrollTo(&#39;0&#39;,&#39;0&#39;)" class="scrolltopa"><b>返回顶部</b></a></span> <span> <a href="http://www.cskaoyan.com/forum.php" hidefocus="true" class="returnboard" title="返回版块"><b>返回版块</b></a> </span> </div>
<div id="discuz_tips" style="display:none;"></div>
</body>
</html>
