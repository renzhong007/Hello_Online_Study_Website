<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%--管理员登录时显示 --%>
<s:if test="#session.user.status==1">
	<div class="left_list">
		<img class="user_img" alt="" src="static/img/default.jpg" /><br>
		<span>欢迎${sessionScope.user.username }</span><br><br>
		<a href="thread_listAllThreadAction.action">管理帖子</a><br>
		<a href="thread_listThreadAction.action?pageNo=1">返回论坛</a><br>
		<a href="displayStudentAction.action">学生账户管理</a><br><!-- ok -->
		<a href="displayTeacherAction.action">教师账户管理</a><br><!-- ok -->
		<a href="item_displayItemAction.action?num=0">题库管理</a><br>
		<a href="user_logoutAction.action">注销</a><br><!-- //ok -->
	</div>
</s:if>
<%--教师登录时显示 --%>
<s:if test="#session.user.status==2">
	<div class="left_list">
		<img class="user_img" alt="" src="${pageContext.request.contextPath}${sessionScope.user.img }" /><br>
		<span>欢迎${sessionScope.user.username }</span><br><br>
		<a href="user_editAction.action">修改/完善个人信息</a><br>
		<a href="thread_listThreadAction.action?pageNo=1">返回论坛</a><br>
		<a href="thread_toAddThreadAction.action">创建帖子</a><br>
		<a href="quest_displayAllQuestionAction.action">查看询问</a><br>       <!-- 获取最后一条或者是最新一条 -->
		<a href="exam_toAddItemAction.action">上传试题</a><br>
		<a href="user_logoutAction.action">注销</a><br>
	</div>
	<div id="que_2">
		<div>
		<s:form action="quest_addAnswerAction.action" theme="simple">
		<s:hidden name="id" value="%{#request.lastQuestion.id}"></s:hidden>
		<table>
			<tr>
				<td colspan="4">最近回复</td>
				
			</tr>
			<tr>
				<td>
					<img alt="" src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}${requestScope.lastQuestion.student.img}" style="width: 80px;height: 80px;"><br/>
					<s:property value="#request.lastQuestion.student.username"/>
				</td>
				<td colspan="3" style="height: 100px">
					<s:property value="#request.lastQuestion.content"/>
				</td>
			</tr>
			<tr>
				<td colspan="3"><s:textarea cssStyle="width: 500px;height: 50px;resize: none;" name="content"></s:textarea></td>
				<td><s:submit value="快速回复"></s:submit></td>
			</tr>
		</table>
		</s:form>
	</div>
	<hr>
	
	<div>
		<table>
			<center>题库详情</center>
			<tbody>
				<tr>
					<td>已有科目数</td>
					<td>题目总数</td>
					<td>已检测次数</td>
					<td>平均分</td>
				</tr>
				<tr>
					<td style="height: 120px;"><h1 style="color: red"><s:property value="#request.itemsInfo.subjectCount"/></h1></td>
					<td><h1 style="color: red"><s:property value="#request.itemsInfo.totleCount"/></h1></td>
					<td><h1 style="color: red"><s:property value="#request.itemsInfo.doCount"/></h1></td>
					<td><h1 style="color: red"><s:property value="#request.itemsInfo.avgGrade"/></h1></td>
				</tr>
			</tbody>
		</table>
	</div>
	
</s:if>
<%--学生登录以后显示 --%>
<s:if test="#session.user.status==3">
<s:form>
		<div class="left_list">
			<img class="user_img" alt="" src="${pageContext.request.contextPath}${sessionScope.user.img }" /><br>
			<span>欢迎${sessionScope.user.username }</span><br><br>
			<s:a href="user_editAction.action">修改/完善个人信息</s:a><br>
			<a href="thread_listThreadAction.action?pageNo=1">返回论坛</a><br>
			<a href="thread_toAddThreadAction.action">创建帖子</a><br>
			<a href="quest_displayAllQuestionAction.action" class="stu_que">查看回复</a><br>
			<a href="#" class="stu_exam">自我检测</a><br><!-- ok -->
			<a href="user_logoutAction.action">注销</a><br>
		</div>
</s:form>
		
		<!-- 提问 -->
		<div id="que_2">
			<s:form action="quest_submitAction.action"  theme="simple" cssClass="que">
				<center>提出问题<br></center>
				<s:textarea name="content" cssStyle="width: 600px;height: 100px;resize: none;" placeholder="请输入您的问题" ></s:textarea><br>
				<s:submit value="提交"></s:submit>
			</s:form>
		</div>
		<hr/>
		<!-- 检测开始 -->
		<div id="stu_2"  hidden="true">
			<s:form action="exam_getTitleBillAction.action" method="post" theme="simple">
			<table class="tab">
			<tr>
				<td>
					<s:select list="#request.allSubject" name="subject" listKey="id" listValue="name"></s:select>
				</td>
			</tr>
			<tr>
				<td>
					<s:submit value="开始检测"></s:submit>
				</td>
			</tr>
			</table>
			</s:form>
		</div>
		<!-- 成绩展示 -->
		<div id="stu_1">
		<center >
		<br>测试成绩
		</center>
		<s:if test="#request.grades==null||#request.grades.empty">
			
			<table class="tab">
				<tr>
					<td>时间</td>
					<td>科目</td>
					<td>成绩</td>
					<td></td>
				</tr>
				<tr><td colspan="4">您尚未有上传成绩！</td></tr>
			</table>
		</s:if>
		<s:else>
			<s:form action="exam_displayAllGradesAction.action" theme="simple">
				<table class="tab">
					<tr>
						<td>时间</td>
						<td>科目</td>
						<td>成绩</td>
						<td rowspan="4">
							<s:submit value="显示全部" ></s:submit>
						</td>
					</tr>
					<s:iterator value="#request.grades">
						<tr>
							<td><s:date name="date" format="yyyy-MM-dd"/></td>
							<td><s:property value="subject.name"/></td>
							<td><s:property value="grade"/></td>
						</tr>
					</s:iterator>
				</table>
			</s:form>
		</s:else>
		</div>
	
</s:if>
