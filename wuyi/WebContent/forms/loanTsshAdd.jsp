<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<title>香港台山商会助学金申请</title>

<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="assets/css/colorbox.css" />

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

			<div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a data-toggle="tab" href="#base"> <i class="green ace-icon fa fa-tags bigger-120"></i> 香港台山商会助学金申请
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
								<label class="col-sm-1 control-label no-padding-right"> 身份证号码 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="idCard" value="${user.idcard}" readOnly="readOnly" />
								</div>
																
								<label class="col-sm-1 control-label no-padding-right"> 班别 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="classes" value="${user.classes.id}" readOnly="readOnly" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 是否获得奖学金、何种奖学金 </label>
								<div class="col-sm-11">
									<input type="text" class="col-xs-12 col-sm-12" name="jxj" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 家庭户口 </label>
								<div class="col-sm-7">
									<select class="col-xs-12 col-sm-12" name="nativeType" >
										<option>城镇</option>		
										<option>农村</option>																
									</select>
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 家庭总人口 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="totalCount" />
								</div>
								
							</div>
							
							<div class="form-group">		
								<label class="col-sm-1 control-label no-padding-right"> 家庭年总收入 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="totalIncome" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 人均月收入 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="peopleIncome" />
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 收入来源 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="incomeFrom" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 家庭住址 </label>
								<div class="col-sm-7">
									<input type="text" class="col-xs-12 col-sm-12" name="addr" />
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 家庭联系电话 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="tel" />
								</div>
								
							</div>
							
							<h5 class="header smaller lighter green"> 家庭成员1 </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 姓名 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyName1" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 年龄 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyAge1" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 与本人关系 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyRelate1" />
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 工作或学习单位 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyUnit1" />
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 家庭成员2 </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 姓名 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyName2" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 年龄 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyAge2" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 与本人关系 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyRelate2" />
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 工作或学习单位 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyUnit2" />
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 家庭成员3 </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 姓名 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyName3" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 年龄 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyAge3" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 与本人关系 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyRelate3" />
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 工作或学习单位 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyUnit3" />
								</div>
							</div>
							
							<h5 class="header smaller lighter green"> 家庭成员4 </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 姓名 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyName4" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 年龄 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyAge4" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 与本人关系 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyRelate4" />
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 工作或学习单位 </label>
								<div class="col-sm-2">
									<input type="text" class="col-xs-12 col-sm-12" name="familyUnit4" />
								</div>
							</div>
							
							
							<h5 class="header smaller lighter green"> 贷款信息 </h5>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 申请贷款理由 </label>
								<div class="col-sm-11">
									<textarea class="col-xs-12 col-sm-12" rows="5" name="reason" ></textarea>
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
								url:"manageLoanTssh.do",
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