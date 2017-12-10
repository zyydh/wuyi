<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<title>国家助学贷款申请</title>

<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="assets/css/colorbox.css" />

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

			<div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a data-toggle="tab" href="#base"> <i class="green ace-icon fa fa-tags bigger-120"></i> 国家助学贷款申请
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
									<input type="text" class="col-xs-12 col-sm-12" name="nativeAddr" />
								</div>
																
								<label class="col-sm-1 control-label no-padding-right"> 邮政编码 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="zipCode" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 家庭地址 </label>
								<div class="col-sm-11">
									<input type="text" class="col-xs-12 col-sm-12" name="addr" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 身份证号码 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="idCard" value="${user.idcard}" readOnly="readOnly" />
								</div>
																
								<label class="col-sm-1 control-label no-padding-right"> 婚姻状况 </label>
								<div class="col-sm-3">
									<select class="col-xs-12 col-sm-12" name="marry" >
										<option>未婚</option>		
										<option>已婚</option>																
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 家庭固定电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="tel" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 个人移动电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="mobile" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> QQ </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="qq" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 家庭总人口 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="totalCount" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 家庭年总收入 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="totalIncome" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 人均月收入 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="peopleIncome" />
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 父亲（或法定监护人） </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 父亲姓名（或法定监护人） </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="fatherName" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 身份证号码 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="fatherIdcard" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 移动电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="fatherMobile" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 工作单位及职务 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="fatherWork" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 单位电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="fatherTel" />
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 母亲（或法定监护人） </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 母亲姓名（或法定监护人） </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="motherName" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 身份证号码 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="motherIdcard" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 移动电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="motherMobile" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 工作单位及职务 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="motherWork" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 单位电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="motherTel" />
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 联系亲属 </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 联系亲属姓名 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="otherName" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 身份证号码 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="otherIdcard" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 移动电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="otherMobile" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 工作单位及职务 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="otherWork" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 单位电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="otherTel" />
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 贷款信息 </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 申请贷款理由 </label>
								<div class="col-sm-11">
									<textarea class="col-xs-12 col-sm-12" rows="5" name="reason" ></textarea>
								</div>
											
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 申请贷款类型 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="type" value="学费和住宿费贷款"/>
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 申请贷款总额 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="amount" />
								</div>
							</div>
							
								<div class="clearfix form-actions">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-info btn-sm" type="button" id="save">
												<i class="ace-icon fa fa-check bigger-110"></i>
												保存
											</button>

											&nbsp; &nbsp; &nbsp;
											<button class="btn btn-sm" type="reset">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												重置
											</button>
											
											&nbsp; &nbsp; &nbsp;
											<a class="btn btn-success btn-sm" href="index.do#page/workFlowItemListInput?wfId=${wfId }">
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
				
				$('#datepicker').datepicker({
				    format: 'yyyy-mm-dd'
				});
				
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