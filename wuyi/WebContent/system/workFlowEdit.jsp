<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>表单管理</title>

<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="assets/css/colorbox.css" />

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

			<div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a data-toggle="tab" href="#base"> <i class="green ace-icon fa fa-tags bigger-120"></i> 表单信息
					</a></li>
				</ul>

				<div class="tab-content">
					<div id="base" class="tab-pane fade in active">
						<form class="form-horizontal" role="form" id="formid">
							<!-- #section:elements.form -->
							<input type="hidden" id="form-field-0" name="oper" value="edit"/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 表单编号 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-1" class="col-xs-10 col-sm-5" name="id" value="${wf.id }" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-2"> 表单名称</label>
								<div class="col-sm-9">
									<input type="text" id="form-field-2" class="col-xs-10 col-sm-5" name="name" value="${wf.name }"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-6"> 表单实体类名</label>
								<div class="col-sm-9">
									<input type="text" id="form-field-6" class="col-xs-10 col-sm-5" name="entityName" value="${wf.entityName }"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-7"> 新增URL</label>
								<div class="col-sm-9">
									<input type="text" id="form-field-7" class="col-xs-10 col-sm-5" name="addUrl" value="${wf.addUrl }"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-8"> 修改URL</label>
								<div class="col-sm-9">
									<input type="text" id="form-field-8" class="col-xs-10 col-sm-5" name="updateUrl" value="${wf.updateUrl }"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-9"> 详情URL</label>
								<div class="col-sm-9">
									<input type="text" id="form-field-9" class="col-xs-10 col-sm-5" name="detailUrl" value="${wf.detailUrl }"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-4"> 检查人 </label>
								<div class="col-sm-9">
									<select id="form-field-4" class="col-xs-10 col-sm-5" name="reviewer">
										<option value="无" <c:if test="${wf.reviewer=='无'}">selected="selected"</c:if>>无</option>
										<option value="班导师" <c:if test="${wf.reviewer=='班导师'}">selected="selected"</c:if>>班导师</option>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-5"> 最终审批人 </label>
								<div class="col-sm-9">
									<select id="form-field-5" class="col-xs-10 col-sm-5" name="approver">
										<option value="无" <c:if test="${wf.approver=='无'}">selected="selected"</c:if>>无</option>
										<option value="班导师" <c:if test="${wf.approver=='班导师'}">selected="selected"</c:if>>班导师</option>
										<option value="辅导员" <c:if test="${wf.approver=='辅导员'}">selected="selected"</c:if>>辅导员</option>
									</select>
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
											<a class="btn btn-success btn-sm" href="index.do#page/workFlowList">
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
								url:"manageWorkFlow.do",
								data:$('#formid').serialize(),
								success:function(result){
									if(true==result){
										bootbox.alert('修改成功');
									}else {
										bootbox.alert("修改失败")
									}
								},		
								error:function(XmlHttpRequest,textStatus,errorThrown){
									bootbox.alert("修改失败");
								}
							})
				});
			});
	});
	    
</script>