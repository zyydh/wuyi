<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>管理员管理</title>

<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="assets/css/ui.jqgrid.css" />
<link rel="stylesheet" href="assets/css/colorbox.css" />

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

			<div class="tabbable">
				<ul class="nav nav-tabs" id="myTab">
					<li class="active"><a data-toggle="tab" href="#base"> <i class="green ace-icon fa fa-tags bigger-120"></i> 管理信息
					</a></li>
				</ul>

				<div class="tab-content">
					<div id="base" class="tab-pane fade in active">
						<form class="form-horizontal" role="form" id="formid">
							<!-- #section:elements.form -->
							<input type="hidden" id="form-field-0" name="oper" value="add"/>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 编号 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-1" class="col-xs-10 col-sm-5" name="userId"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-2"> 登录密码</label>
								<div class="col-sm-9">
									<input type="password" id="form-field-2" class="col-xs-10 col-sm-5" name="password"/>
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-3"> 姓名 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-3" class="col-xs-10 col-sm-5" name="name"/>
								</div>
							</div>
							
						
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-4"> 性别  </label>
								<div class="col-sm-9">
									<select id="form-field-4" class="col-xs-10 col-sm-5" name="sex">
										<option>男</option>		
										<option>女</option>																		
									</select>
								</div>
							</div>
							
							
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-5"> 联系电话 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-5" class="col-xs-10 col-sm-5" name="tel"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="datepicker"> 出生年月 </label>
								<div class="col-sm-9">
									<input type="text" id="datepicker" class="col-xs-10 col-sm-5" name="birthday"/>
								</div>
							</div>
							
							
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-7"> 电子邮箱 </label>
								<div class="col-sm-9">
									<input type="text" id="form-field-7" class="col-xs-10 col-sm-5" name="mail"/>
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
											<a class="btn btn-success btn-sm" href="index.do#page/adminList">
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
								url:"manageAdmin.do",
								data:$('#formid').serialize(),
								success:function(result){
									if(true==result){
										bootbox.alert('添加成功');
									}else {
										bootbox.alert("添加失败，该用户已存在")
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