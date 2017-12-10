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
				</ul>

				<div class="tab-content">
					<div id="base" class="tab-pane fade in active">
						<form class="form-horizontal" role="form" id="formid">
							<!-- #section:elements.form -->
							<input type="hidden" id="form-field-0" name="oper" value="add"/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 学号 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-1" class="col-xs-10 col-sm-5" name="userId" value="${user.userId}" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-3"> 姓名 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-3" class="col-xs-10 col-sm-5" name="name" value="${user.name}" readOnly="readOnly"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-4"> 班级 </label>
								<div class="col-sm-9">
									<select id="form-field-4" class="col-xs-10 col-sm-5" name="classesId" disabled="disabled">
										<c:forEach items="${classesList }" var="t">
											<option value="${t.id}" <c:if test="${user.classes.id==t.id}">selected="selected"</c:if>>${t.id }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-5"> 毕业去向  </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-5" class="col-xs-10 col-sm-5" name="go" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-7"> 单位组织机构代码</label>
								<div class="col-sm-9">
									<input type="text" id="form-field-7" class="col-xs-10 col-sm-5" name="unitCode" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-8"> 具体就业单位 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-8" class="col-xs-10 col-sm-5" name="unitName"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-9"> 单位类型 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-9" class="col-xs-10 col-sm-5" name="unitType" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-10"> 单位所属行业 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-10" class="col-xs-10 col-sm-5" name="unitIndustry"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-11"> 单位所属地区</label>
								<div class="col-sm-9">
									<input type="text" id="form-field-11" class="col-xs-10 col-sm-5" name="unitArea" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-12"> 单位联系人 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-12" class="col-xs-10 col-sm-5" name="unitContacts" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-13"> 单位联系电话 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-13" class="col-xs-10 col-sm-5" name="unitTel" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-14"> 职业类型 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-14" class="col-xs-10 col-sm-5" name="type" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-15"> 薪酬 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-15" class="col-xs-10 col-sm-5" name="payment" /> 元/月
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="datepicker"> 签约时间 </label>
								<div class="col-sm-9">
									<input type="text" id="datepicker" class="col-xs-10 col-sm-5" name="date" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-16"> 使用意图 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-16" class="col-xs-10 col-sm-5" name="reason" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-17"> 是否专业对口 </label>
								<div class="col-sm-9">
									<select id="form-field-17" class="col-xs-10 col-sm-5" name="match" >
										<option>是</option>		
										<option>否</option>																		
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-18"> 是否就业困难 </label>
								<div class="col-sm-9">
									<select id="form-field-18" class="col-xs-10 col-sm-5" name="hard" >
										<option>否</option>		
										<option>是</option>																		
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
								url:"manageJob.do",
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