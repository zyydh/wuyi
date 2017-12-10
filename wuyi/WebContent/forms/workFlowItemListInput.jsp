<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>表单提交</title>

<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="assets/css/ui.jqgrid.css" />

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

		<div class="widget-box">

			<div class="widget-header">
				<h4 class="smaller">表单提交 - ${wf.name }</h4>
			</div>

			<div class="widget-body">
			
			<form class="form-search">
				<div class="form-actions" style="margin-top: 0px; margin-bottom: 0px;">
						<div class="input-group col-xs-12 col-sm-6">
							<div class="col-sm-6">
								<label class="control-label no-padding-right col-sm-4" for="status" style="padding-left:10px;">表单状态 </label>
								<select class="form-control" style="width:160px;" name="status" id="status">
									<option value="正在编辑" checked="checked">正在编辑</option>
									<option value="已经拒绝">已经拒绝</option>
									<option value="等待检查">等待检查</option>
									<option value="等待审批">等待审批</option>
									<option value="审批通过">审批通过</option>
								</select>
							</div>
						</div>
				</div>
				<div class="form-actions" style="margin-top: 0px; margin-bottom: 0px;background-color: #FFFFE0; padding: 10px 20px 10px;">
					<div class="input-group">
						<a class="btn btn-success btn-sm" href="index.do#page/workFlowItemAdd?wfId=${wf.id }">
							<i class="ace-icon fa fa-plus icon-on-right bigger-110"></i> 新增 
						</a>
						<a class="btn btn-success btn-sm" href="index.do#page/workFlowItemEdit" id="edit">
							<i class="ace-icon fa fa-pencil-square-o icon-on-right bigger-110"></i> 修改
						</a>
						<button type="button" class="btn btn-success btn-sm" id="delete">
							<i class="ace-icon fa fa-trash-o icon-on-right bigger-110"></i> 删除
						</button>
						<button type="button" class="btn btn-warning btn-sm" id="submit">
							<i class="ace-icon fa fa-check-square-o icon-on-right bigger-110"></i> 提交
						</button>
						<a class="btn btn-primary btn-sm" href="index.do#page/templateForInputList?id=${wf.id }">
							<i class="ace-icon fa fa-arrow-circle-o-down icon-on-right bigger-110"></i> 模板下载 
						</a>
						<button type="button" class="btn btn-primary btn-sm" id="attachment">
							<i class="ace-icon fa fa-arrow-circle-o-up icon-on-right bigger-110"></i> 附件上传
						</button>
						<a class="btn btn-danger btn-sm" href="index.do#page/workFlowItemDetail" id="detail">
							<i class="ace-icon fa fa-eye icon-on-right bigger-110"></i> 表单详情
						</a>
					</div>
				</div>
			</form>


			<table id="grid-table"></table>

			<div id="grid-pager"></div>
		
			</div>
		</div>

		<script type="text/javascript">
			var $path_base = "../..";//in Ace demo this will be used for editurl parameter
		</script>

		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->

<!-- page specific plugin scripts -->
<script type="text/javascript">
	var scripts = [null,"assets/js/jqGrid/jquery.jqGrid.min.js","assets/js/jqGrid/i18n/grid.locale-cn.js", null]
	ace.load_ajax_scripts(scripts, function() {
	
	jQuery(function($) {
		var grid_selector = "#grid-table";
		var pager_selector = "#grid-pager";
		
		//resize to fit page size
		$(window).on('resize.jqGrid', function () {
			$(grid_selector).jqGrid( 'setGridWidth', $(".page-content").width() );
	    })
		//resize on sidebar collapse/expand
		var parent_column = $(grid_selector).closest('[class*="col-"]');
		$(document).on('settings.ace.jqGrid' , function(ev, event_name, collapsed) {
			if( event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed' ) {
				//setTimeout is for webkit only to give time for DOM changes and then redraw!!!
				setTimeout(function() {
					$(grid_selector).jqGrid( 'setGridWidth', parent_column.width() );
				}, 0);
			}
	    })
	
		var status = $("#status").val();
		
		jQuery(grid_selector).jqGrid({
			url: "workFlowItemListInputData.do?wfId=${wf.id}",
			postData:{'status':status},	
			datatype: "json",
			height: 450,
			colNames:['ID','当前状态','创建人','创建时间','检查人','检查时间','最终审批人','最终审批时间','拒绝人','拒绝时间'],
			colModel:[
				{name:'id', hidden: true},
				{name:'status',index:'status', width:150},
				{name:'maker.name',index:'maker.name', width:150},
				{name:'makeDate',index:'makeDate', formatter:"date",formatoptions: {srcformat:'Y-m-d',newformat:'Y-m-d'},width:150},
				{name:'reviewer.name',index:'reviewer.name', width:150},
				{name:'reviewDate',index:'reviewDate', formatter:"date",formatoptions: {srcformat:'Y-m-d',newformat:'Y-m-d'},width:150},
				{name:'approver.name',index:'approver.name', width:150},
				{name:'approveDate',index:'approveDate', formatter:"date",formatoptions: {srcformat:'Y-m-d',newformat:'Y-m-d'},width:150},
				{name:'rejecter.name',index:'rejecter.name', width:150},
				{name:'rejectDate',index:'rejectDate', formatter:"date",formatoptions: {srcformat:'Y-m-d',newformat:'Y-m-d'},width:150}
			], 
	
			rowNum:15,
			rowList:[15,30],
			pager : pager_selector,
			loadonce:true,
			altRows: true,
			multiselect: false,
	
			loadComplete : function() {
				var table = this;
				setTimeout(function(){
					updatePagerIcons(table);
				}, 0);
			},

			editurl: "",//nothing is saved
			autowidth: false
		});
		
		
	$(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size

							
	//replace icons with FontAwesome icons like above
							function updatePagerIcons(table) {
								var replacement = {
									'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
									'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
									'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
									'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
								};
								$(
										'.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon')
										.each(
												function() {
													var icon = $(this);
													var $class = $.trim(icon
															.attr('class')
															.replace('ui-icon',
																	''));

													if ($class in replacement)
														icon
																.attr(
																		'class',
																		'ui-icon '
																				+ replacement[$class]);
												})
							}

							$(document).on('ajaxloadstart', function(e) {
								$(grid_selector).jqGrid('GridUnload');
								$('.ui-jqdialog').remove();
							});
							
							$("#status").change(function() {
								$(grid_selector).jqGrid('setGridParam',{  
						            datatype:'json',  
						            postData:{'status':$("#status").val()}, //发送数据  
						            page:1  
						        }).trigger("reloadGrid"); //重新载入
							});
							
							$("#submit").click(function() {
								var id = $(grid_selector).jqGrid("getGridParam","selrow");
								if (id != null) {
									bootbox.confirm("确定要提交吗?", function(result){
										if(result) {
											var rowData = $(grid_selector).jqGrid("getRowData",id);
											var delRow = {id:rowData.id,
														  oper:"submit"};
											$.ajax({
												type:'post',
												url:"manageWorkFlowItem.do",
												data:delRow,
												success:function(result){
													if(true==result){
														$(grid_selector).jqGrid("delRowData");
														$(grid_selector).jqGrid('setGridParam',{  
												            datatype:'json',  
												            postData:{'status':$("#status").val()}, //发送数据  
												            page:1  
												        }).trigger("reloadGrid"); //重新载入
													}else {
														bootbox.alert("表单当前状态不允许执行提交操作");
													}
												},		
												error:function(XmlHttpRequest,textStatus,errorThrown){
													bootbox.alert("系统出错，请联系管理员");
												}
											})
										}
									});
								} else {
									bootbox.alert("请选择一条记录");
								}
							});
							
							$("#delete").click(function() {
								var id = $(grid_selector).jqGrid("getGridParam","selrow");
								if (id != null) {
									bootbox.confirm("确定要删除吗?", function(result){
										if(result) {
											var rowData = $(grid_selector).jqGrid("getRowData",id);
											var delRow = {id:rowData.id,
														  oper:"del"};
											$.ajax({
												type:'post',
												url:"manageWorkFlowItem.do",
												data:delRow,
												success:function(result){
													if(true==result){
														$(grid_selector).jqGrid("delRowData", id); 
													}else {
														bootbox.alert("删除失败");
													}
												},		
												error:function(XmlHttpRequest,textStatus,errorThrown){
													bootbox.alert("系统出错，请联系管理员");
												}
											})
										}
									});
								} else {
									bootbox.alert("请选择一条记录");
								}
							});
							
							$("#attachment").click(function() {
								var id = $(grid_selector).jqGrid("getGridParam","selrow");
								if (id != null) {
									var rowData = $(grid_selector).jqGrid("getRowData",id);
									window.location.href = "index.do#page/attachmentList.do?id="+rowData.id+"&name=${wf.name }";
									
								} else {
									bootbox.alert("请选择一条记录");
								}
							});
							
							$("#edit").click(function() {
								var id = $(grid_selector).jqGrid("getGridParam","selrow");
								if(id==null) {
									$(this).attr("href", "#");
									bootbox.alert("请选择一条记录");
								}else {
									var rowData = $(grid_selector).jqGrid("getRowData",id);
									$(this).attr("href","index.do#page/workFlowItemEdit.do?id="+rowData.id);
								}
							});
							
							$("#detail").click(function() {
								var id = $(grid_selector).jqGrid("getGridParam","selrow");
								if(id==null) {
									$(this).attr("href", "#");
									bootbox.alert("请选择一条记录");
								}else {
									var rowData = $(grid_selector).jqGrid("getRowData",id);
									$(this).attr("href","index.do#page/workFlowItemDetail.do?back=input&id="+rowData.id);
								}
							});
						});
	
					});
	
		
</script>
