<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<title>学生就业情况登记</title>

<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="assets/css/colorbox.css" />

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

			<div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a data-toggle="tab" href="#base"> <i class="green ace-icon fa fa-tags bigger-120"></i> 学生就业情况登记
					</a></li>
					<li><a data-toggle="tab" href="#flow"> <i class="green ace-icon fa fa-truck bigger-120"></i> 提交流程
					</a></li>
				</ul>

				<div class="tab-content">
					<div id="base" class="tab-pane fade in active">
						<form class="form-horizontal" role="form" id="formid">
							<!-- #section:elements.form -->
							<input type="hidden" id="form-field-0" name="oper" value="add"/>
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 姓名 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="name" value="${user.name}" readOnly="readOnly"/>
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 性别  </label>
								<div class="col-sm-3">
									<select class="col-xs-12 col-sm-12" name="sex" disabled="disabled">
										<option <c:if test="${user.sex=='男'}">selected="selected"</c:if>>男</option>		
										<option <c:if test="${user.sex=='女'}">selected="selected"</c:if>>女</option>																			
									</select>
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 学号 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="userId" value="${user.userId}" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 户藉地址 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="nativeAddr" value="${item.nativeAddr }" readOnly="readOnly"/>
								</div>
																
								<label class="col-sm-1 control-label no-padding-right"> 邮政编码 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="zipCode" value="${item.zipCode }" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 家庭地址 </label>
								<div class="col-sm-11">
									<input type="text" class="col-xs-12 col-sm-12" name="addr" value="${item.addr }" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 身份证号码 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="idCard" value="${user.idcard}" readOnly="readOnly" />
								</div>
																
								<label class="col-sm-1 control-label no-padding-right"> 婚姻状况 </label>
								<div class="col-sm-3">
									<select class="col-xs-12 col-sm-12" name="marry" disabled="disabled">
										<option <c:if test="${item.marry=='未婚'}">selected="selected"</c:if>>未婚</option>		
										<option <c:if test="${item.marry=='已婚'}">selected="selected"</c:if>>已婚</option>																
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 家庭固定电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="tel" value="${item.tel}" readOnly="readOnly" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 个人移动电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="mobile" value="${item.mobile}" readOnly="readOnly" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> QQ </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="qq"  value="${item.qq}" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 家庭总人口 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="totalCount" value="${item.totalCount}" readOnly="readOnly"/>
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 家庭年总收入 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="totalIncome" value="${item.totalIncome}" readOnly="readOnly"/>
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 人均月收入 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="peopleIncome" value="${item.peopleIncome}" readOnly="readOnly"/>
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 父亲（或法定监护人） </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 父亲姓名（或法定监护人） </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="fatherName" value="${item.fatherName}" readOnly="readOnly"/>
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 身份证号码 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="fatherIdcard" value="${item.fatherIdcard}" readOnly="readOnly"/>
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 移动电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="fatherMobile" value="${item.fatherMobile}" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 工作单位及职务 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="fatherWork" value="${item.fatherWork}" readOnly="readOnly"/>
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 单位电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="fatherTel" value="${item.fatherTel}" readOnly="readOnly"/>
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 母亲（或法定监护人） </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 母亲姓名（或法定监护人） </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="motherName" value="${item.motherName}" readOnly="readOnly"/>
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 身份证号码 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="motherIdcard" value="${item.motherIdcard}" readOnly="readOnly"/>
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 移动电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="motherMobile" value="${item.motherMobile}" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 工作单位及职务 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="motherWork" value="${item.motherWork}" readOnly="readOnly"/>
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 单位电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="motherTel" value="${item.motherTel}" readOnly="readOnly"/>
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 联系亲属 </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 联系亲属姓名 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="otherName" value="${item.otherName}" readOnly="readOnly"/>
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 身份证号码 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="otherIdcard" value="${item.otherIdcard}" readOnly="readOnly"/>
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 移动电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="otherMobile" value="${item.otherMobile}" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 工作单位及职务 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="otherWork" value="${item.otherWork}" readOnly="readOnly"/>
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 单位电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="otherTel" value="${item.otherTel}" readOnly="readOnly"/>
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 贷款信息 </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 申请贷款理由 </label>
								<div class="col-sm-11">
									<textarea class="col-xs-12 col-sm-12" rows="5" name="reason" readOnly="readOnly">${item.reason}</textarea>
								</div>
											
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 申请贷款类型 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="type" value="${item.type}" readOnly="readOnly"/>
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 申请贷款总额 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="amount" value="${item.amount}" readOnly="readOnly"/>
								</div>
							</div>
							
								<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											
											<a class="btn btn-success btn-sm" href="index.do#page/workFlowItemBack?back=${back}&wfId=${wfId }">
												<i class="ace-icon fa fa-arrow-up bigger-110"></i>
												返回上一页
											</a>
										</div>
									</div>

							
						</form>
					</div>
					
					
					
					<div id="flow" class="tab-pane fade in">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 当前状态 </label>
								<div class="col-sm-9">
									<input type="text" class="col-xs-10 col-sm-5" value="${item.status}" readOnly="readOnly"/>
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 创建 </h5>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 创建人 </label>
								<div class="col-sm-9">
									<input type="text" class="col-xs-10 col-sm-5" value="${item.maker.name}" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 创建时间 </label>
								<div class="col-sm-9">
									<input type="text" class="col-xs-10 col-sm-5" value="<fmt:formatDate value="${item.makeDate}" pattern="yyyy-MM-dd"/>" readOnly="readOnly"/>
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 检查 </h5>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 检查人 </label>
								<div class="col-sm-9">
									<input type="text" class="col-xs-10 col-sm-5" value="${item.reviewer.name}" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 检查时间 </label>
								<div class="col-sm-9">
									<input type="text" class="col-xs-10 col-sm-5" value="<fmt:formatDate value="${item.reviewDate}" pattern="yyyy-MM-dd"/>" readOnly="readOnly"/>
								</div>
							</div>
							<!-- 
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 检查意见 </label>
								<div class="col-sm-9">
									<textarea readOnly="readOnly" class="col-xs-10 col-sm-5" >
										${item.reviewRemark}
									</textarea>
								</div>
							</div>
							 -->
							<h5 class="header smaller lighter green"> 审批 </h5>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 最终审批人 </label>
								<div class="col-sm-9">
									<input type="text" class="col-xs-10 col-sm-5" value="${item.approver.name}" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 最终审批时间 </label>
								<div class="col-sm-9">
									<input type="text" class="col-xs-10 col-sm-5" value="<fmt:formatDate value="${item.approveDate}" pattern="yyyy-MM-dd"/>" readOnly="readOnly"/>
								</div>
							</div>
							<!-- 
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 审批意见 </label>
								<div class="col-sm-9">
									<textarea readOnly="readOnly" class="col-xs-10 col-sm-5" >
										${item.approveRemark}
									</textarea>
								</div>
							</div>
							 -->
							<h5 class="header smaller lighter green"> 拒绝 </h5>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 拒绝人 </label>
								<div class="col-sm-9">
									<input type="text" class="col-xs-10 col-sm-5" value="${item.rejecter.name}" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 拒绝时间 </label>
								<div class="col-sm-9">
									<input type="text" class="col-xs-10 col-sm-5" value="<fmt:formatDate value="${item.rejectDate}" pattern="yyyy-MM-dd"/>" readOnly="readOnly"/>
								</div>
							</div>
							<!-- 
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"> 拒绝意见</label>
								<div class="col-sm-9">
									<textarea readOnly="readOnly" class="col-xs-10 col-sm-5" >
										${item.rejectRemark}
									</textarea>
								</div>
							</div>
							 -->
								<div class="clearfix form-actions">
											<div class="col-md-offset-3 col-md-9">
											<a class="btn btn-success btn-sm" href="index.do#page/workFlowItemBack?back=${back}&wfId=${wfId }">
												<i class="ace-icon fa fa-arrow-up bigger-110"></i>
												返回上一页
											</a>
										</div>
									</div>

							
						</form>
					</div>
				</div>
	
			<script type="text/javascript">
			var $path_base = "../..";//in Ace demo this will be used for editurl parameter
		</script>

			<!-- PAGE CONTENT ENDS -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</div>
	<script src="assets/js/jquery-ui.custom.min.js"></script>
	<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="assets/js/chosen.jquery.min.js"></script>
	<script src="assets/js/fuelux/fuelux.spinner.min.js"></script>
	<script src="assets/js/date-time/bootstrap-datepicker.min.js"></script>
	<script src="assets/js/date-time/bootstrap-timepicker.min.js"></script>
	<script src="assets/js/date-time/moment.min.js"></script>
	<script src="assets/js/date-time/daterangepicker.min.js"></script>
	<script src="assets/js/date-time/bootstrap-datetimepicker.min.js"></script>
	<script src="assets/js/bootstrap-colorpicker.min.js"></script>
	<script src="assets/js/jquery.knob.min.js"></script>
	<script src="assets/js/jquery.autosize.min.js"></script>
	<script src="assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
	<script src="assets/js/jquery.maskedinput.min.js"></script>
	<script src="assets/js/bootstrap-tag.min.js"></script>
	<script src="assets/js/typeahead.jquery.min.js"></script>
	

	<!-- page specific plugin scripts -->
	<script type="text/javascript">
	var scripts = [null,"assets/js/jquery.colorbox-min.js", null]
	ace.load_ajax_scripts(scripts, function() {
			jQuery(function($){
				
				$("#save").click(function() {
					$.ajax({
								type:'post',
								url:"manageLoanStudent.do",
								data:$('#formid').serialize(),
								success:function(result){
									if(true==result){
										bootbox.alert('添加成功');
									}else {
										bootbox.alert("添加失败")
									}
								},		
								error:function(XmlHttpRequest,textStatus,errorThrown){
									bootbox.alert("添加失败");
								}
							})
				});
			});
	});
	    
</script>