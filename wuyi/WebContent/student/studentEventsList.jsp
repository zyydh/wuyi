<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>学生突发事件查询</title>

<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="assets/css/ui.jqgrid.css" />

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

		<div class="widget-box">

			<div class="widget-header">
				<h4 class="smaller">学生突发事件查询</h4>
			</div>

			<div class="widget-body">
			
			
			
			<form class="form-search">
				<div class="form-actions" style="margin-top: 0px; margin-bottom: 0px;background-color: #FFFFE0; padding: 10px 20px 10px;">
					<div class="input-group">
					<c:if test="${LoginedCustomer.userType!='学生'}">
						<a class="btn btn-success btn-sm" href="index.do#page/studentEventsAdd">
							<i class="ace-icon fa fa-plus icon-on-right bigger-110"></i> 新增 
						</a>
						<a class="btn btn-success btn-sm" href="index.do#page/studentEdit" id="edit">
							<i class="ace-icon fa fa-pencil-square-o icon-on-right bigger-110"></i> 修改
						</a>
						<button type="button" class="btn btn-success btn-sm" id="delete">
							<i class="ace-icon fa fa-trash-o icon-on-right bigger-110"></i> 删除
						</button>
					</c:if>
					
						<a class="btn btn-danger btn-sm" href="index.do#page/studentEventsDetail" id="detail">
							<i class="ace-icon fa fa-eye icon-on-right bigger-110"></i> 事件详情
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
	
	
	
		jQuery(grid_selector).jqGrid({
			url: "allStudentEvents.do",
			datatype: "json",
			height: 450,
			colNames:['ID', '事件类别', '报送单位', '学生姓名', '班导师', '事发地点', '事发时间', '死亡人数', '受伤人数'],
			colModel:[
				{name:'id', hidden: true},
				{name:'eventType',index:'eventType', width:120},
				{name:'unitName',index:'unitName', width:150},
				{name:'studentName',index:'studentName', width:120},
				{name:'instructor',index:'instructor', width:120},
				{name:'eventAddr',index:'eventAddr', width:200},
				{name:'eventTime',index:'eventTime', width:100},
				{name:'dieCount',index:'dieCount', width:100},
				{name:'hurtCount',index:'hurtCount', width:100}
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
												url:"manageStudentEvents.do",
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
							
							$("#edit").click(function() {
								var id = $(grid_selector).jqGrid("getGridParam","selrow");
								if(id==null) {
									$(this).attr("href", "#");
									bootbox.alert("请选择一条记录");
								}else {
									var rowData = $(grid_selector).jqGrid("getRowData",id);
									$(this).attr("href","index.do#page/studentEventsEdit.do?id="+rowData.id);
								}
							});
							
							$("#detail").click(function() {
								var id = $(grid_selector).jqGrid("getGridParam","selrow");
								if(id==null) {
									$(this).attr("href", "#");
									bootbox.alert("请选择一条记录");
								}else {
									var rowData = $(grid_selector).jqGrid("getRowData",id);
									$(this).attr("href","index.do#page/studentEventsDetail.do?id="+rowData.id);
								}
							});
						});
	
					});
	
		
</script>
