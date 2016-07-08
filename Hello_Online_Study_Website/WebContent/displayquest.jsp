<%@page import="com.superz.study.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Hello!考研</title>
	<link rel="stylesheet" type="text/css"
		href="./forum_files/style_1_common.css" />
	<link rel="stylesheet" type="text/css"
		href="./forum_files/style_1_forum_forumdisplay.css" />
	<link rel="stylesheet" id="css_widthauto" type="text/css"
		href="./forum_files/style_1_widthauto.css" />
<script src="./forum_files/forum.js" type="text/javascript"></script>
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<%@ include file="/WEB-INF/include/base.jsp"%>

</head>

<body>
	<div id="header">
	<img class="logo_img" alt="" src="static/img/logo.png"  style="width: 300px;height: 90px;">
		<%@ include file="/WEB-INF/include/manager-info.jsp" %>
	</div>

	<div id="main">
	 
	<div id="threadlist" class="tl bm bmw">
          <div class="th">
            <table cellspacing="0" cellpadding="0">
              <tbody>
                <tr>
                  <td colspan="3" style="width: 600px;">问题</td>
                  <td style="width: 80px;">提问人</td>
                  <td style="width: 100px;">时间时间</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="bm_c">
            <div id="forumnew" style="display:none"></div>
              <table summary="forum_17" cellspacing="0" cellpadding="0" id="threadlisttableid">
                <s:if test="#request.allQuestion==null||#request.allQuestion.empty">
                	<h3>您尚未有提问！</h3>
                </s:if>
                
                <s:iterator value="#request.allQuestion">

	                <tbody>
	                  <tr>
	                	<td class="icn" style="width: 10px;"> <img src="./forum_files/folder_new.gif" /> </td>
	                    <th colspan="2"  style="width: 590px;">
		                     <s:a href="quest_displayAnswerAction.action?id=%{id}" style="color: #EE1B2E;"  class="s xst">
		                     	<s:property value="content"/>
							</s:a> 
						 </th>
						 <td style="width: 80px;"><s:property value="student.username"/></td>
	                    <td style="width: 100px;">
			                 <s:date name="createTime" format="yyyy-MM-dd HH:mm"/>
	                     </td>
	                  </tr>
	                </tbody>
                </s:iterator>
              </table>
             
          </div>
        </div>
		
	</div>

	<div id="bottom">
	
	</div>
</body>

</html>