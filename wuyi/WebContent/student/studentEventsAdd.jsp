<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<title>学生突发事件登记</title>

<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="assets/css/colorbox.css" />

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

			<div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a data-toggle="tab" href="#base"> <i class="green ace-icon fa fa-tags bigger-120"></i> 学生突发事件登记
					</a></li>
				</ul>

				<div class="tab-content">
					<div id="base" class="tab-pane fade in active">
						<form class="form-horizontal" role="form" id="formid">
							<!-- #section:elements.form -->
							<input type="hidden" id="form-field-0" name="oper" value="add"/>
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 报送单位 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="unitName" />
								</div>
																
								<label class="col-sm-1 control-label no-padding-right"> 联系人 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="unitContact" />
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 联系方式 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="unitTel" />
								</div>
							</div>
														
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 学生姓名 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="studentName" />
								</div>
																
								<label class="col-sm-1 control-label no-padding-right"> 籍贯 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="studentNative" />
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 性别 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="sex" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 出生年月</label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="birthday" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 联系方式 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="tel" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 班级 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="classes" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 家长姓名 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="fatherName" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 联系方式 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="fatherTel" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 班导师 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="instructor" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 事发地点 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="eventAddr" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 时 间</label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="eventTime" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 事件类别 </label>
								<div class="col-sm-3">
									<select id="form-field-5" class="col-xs-10 col-sm-5" name="eventType">
										<option>其它</option>		
										<option>意外</option>
										<option>失联</option>
										<option>离校出走</option>
										<option>斗殴</option>
										<option>聚众</option>
										<option>自杀</option>
										<option>交通事故</option>
										<option>食物中毒</option>
										<option>校园设施伤害</option>
										<option>偷盗</option>																		
									</select>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 家庭经济情况 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="familyDesc" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 学习情况 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="schoolDesc" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 精神状态 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="mentalStatus" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 是否买保险（险种） </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="hasProtect" />
								</div>
										
								<label class="col-sm-1 control-label no-padding-right"> 死亡人数 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="dieCount" />
								</div>
														
								<label class="col-sm-1 control-label no-padding-right"> 受伤人数 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="hurtCount" />
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 事件基本过程及原因 </label>
								<div class="col-sm-11">
									<textarea class="col-xs-12 col-sm-12" rows="5" name="eventDetail" ></textarea>
								</div>
											
							</div>
							
							<div class="form-group">
								<label class="col-sm-1 control-label no-padding-right"> 填表人 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="maker" value="${user.name }" readOnly="readOnly"/>
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 单位负责人 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="unitIncharg" />
								</div>
								
								<label class="col-sm-1 control-label no-padding-right"> 时间 </label>
								<div class="col-sm-3">
									<input type="text" class="col-xs-12 col-sm-12" name="submitTime" readOnly="readOnly"/>
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
											<a class="btn btn-success btn-sm" href="index.do#page/studentEventsList">
												<i class="ace-icon fa fa-arrow-up bigger-110"></i>
												返回事件列表
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
								url:"manageStudentEvents.do",
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