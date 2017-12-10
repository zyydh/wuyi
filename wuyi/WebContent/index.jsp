<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>学生管理与教学质量信息系统</title>

		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
		
		<!-- text fonts -->
		<link rel="stylesheet" href="assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" id="main-ace-style" />

		<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

		<!-- ace settings handler -->
		<script src="assets/js/ace-extra.min.js"></script>

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

		<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
		<!-- 自定义的css样色表 -->
		<link rel="stylesheet" href="assets/css/myStyle.css" />
	</head>

	<body class="no-skin mob-safari">
		<div id="full-window-box">
			<div id="table-box">
				<i id="restore-ico"></i>
			</div>
		</div>
		<!-- #section:basics/navbar.layout -->
		<div id="navbar" class="navbar navbar-default">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container" style="padding-right: 0px;">
				<!-- #section:basics/sidebar.mobile.toggle -->
				<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
					<span class="sr-only">Toggle sidebar</span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>

					<span class="icon-bar"></span>
				</button>

				<!-- /section:basics/sidebar.mobile.toggle -->
				<div class="navbar-header pull-left">
					<!-- #section:basics/navbar.layout.brand -->
					<a href="#" class="navbar-brand">
						<small>
							学生管理与教学质量信息系统
						</small>
					</a>

					<!-- /section:basics/navbar.layout.brand -->

					<!-- #section:basics/navbar.toggle -->

					<!-- /section:basics/navbar.toggle -->
				</div>
				
			<!-- #section:basics/navbar.dropdown -->
				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li>
									<a href="logout.do">
										<i class="ace-icon fa fa-power-off"></i>
										退出系统
									</a>
						</li>

						<!-- /section:basics/navbar.user_menu -->
					</ul>
				</div>
				
				<div class="navbar-buttons navbar-header pull-right" >
				<ul class="nav ace-nav">
						<li style="color:#fff;padding-right:20px;">
					<span>
						${LoginedCustomer.name}【${LoginedCustomer.userType}】
					</span>
					</li>
				</ul>
				</div>
				
				<!-- /section:basics/navbar.dropdown -->
			</div><!-- /.navbar-container -->
		</div>

		<!-- /section:basics/navbar.layout -->
		<div class="main-container" id="main-container">
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<!-- #section:basics/sidebar -->
			<div id="sidebar" class="sidebar                  responsive">
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
<!-- 					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large"> -->
<!-- 						<button class="btn btn-success"> -->
<!-- 							<i class="ace-icon fa fa-signal"></i> -->
<!-- 						</button> -->

<!-- 						<button class="btn btn-info"> -->
<!-- 							<i class="ace-icon fa fa-pencil"></i> -->
<!-- 						</button> -->

<!-- 						#section:basics/sidebar.layout.shortcuts -->
<!-- 						<button class="btn btn-warning"> -->
<!-- 							<i class="ace-icon fa fa-users"></i> -->
<!-- 						</button> -->

<!-- 						<button class="btn btn-danger"> -->
<!-- 							<i class="ace-icon fa fa-cogs"></i> -->
<!-- 						</button> -->

<!-- 						/section:basics/sidebar.layout.shortcuts -->
<!-- 					</div> -->

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span>

						<span class="btn btn-info"></span>

						<span class="btn btn-warning"></span>

						<span class="btn btn-danger"></span>
					</div>
				</div><!-- /.sidebar-shortcuts -->

				<ul class="nav nav-list">
				
					<li class="active">
						<a href="index.do">
							<i class="menu-icon fa fa-tachometer"></i>
							<span class="menu-text"> 首页面板 </span>
						</a>

						<b class="arrow"></b>
					</li>
					
				<li >
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-list-alt "></i>
							<span class="menu-text"> 学生日常事务 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>
						
						<b class="arrow"></b>
						
						<ul class="submenu">
							<li class="">
								<a data-url="page/towerLandData" href="index.do#page/studentEventsAdd">
									<i class="menu-icon fa fa-caret-right"></i>
									学生突发事件登记
								</a>
							</li>

							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/studentEventsList">
									<i class="menu-icon fa fa-caret-right"></i>
									学生突发事件查询
								</a>
							</li>
							
						</ul>
					</li>
					
					<c:if test="${LoginedCustomer.userType=='学生'}">
					<li >
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-pencil-square-o "></i>
							<span class="menu-text"> 表单提交 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>
						
						<b class="arrow"></b>
						
						<ul class="submenu">
							<li class="">
								<a data-url="page/towerLandData" href="index.do#page/workFlowItemListInput?wfId=YBCB">
									<i class="menu-icon fa fa-caret-right"></i>
									医保参保申请
								</a>
							</li>

							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListInput?wfId=XSJY">
									<i class="menu-icon fa fa-caret-right"></i>
									学生就业情况登记
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListInput?wfId=ZXDK">
									<i class="menu-icon fa fa-caret-right"></i>
									国家助学贷款
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListInput?wfId=SSZZ">
									<i class="menu-icon fa fa-caret-right"></i>
									膳食资助计划助学金
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListInput?wfId=HBL">
									<i class="menu-icon fa fa-caret-right"></i>
									黄炳礼助学金
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListInput?wfId=SD">
									<i class="menu-icon fa fa-caret-right"></i>
									史带助学金
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListInput?wfId=TSSH">
									<i class="menu-icon fa fa-caret-right"></i>
									香港台山商会助学金
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListInput?wfId=YJSH">
									<i class="menu-icon fa fa-caret-right"></i>
									阳江商会助学金
								</a>
							</li>
						</ul>
					</li>
					</c:if>
					
					<c:if test="${LoginedCustomer.userType=='教师'}">
					<li >
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-check-square-o "></i>
							<span class="menu-text"> 表单检查 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>
						
						<b class="arrow"></b>
						
						<ul class="submenu">
							<li class="">
								<a data-url="page/towerLandData" href="index.do#page/workFlowItemListReview?wfId=YBCB">
									<i class="menu-icon fa fa-caret-right"></i>
									医保参保申请
								</a>
							</li>

							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListReview?wfId=XSJY">
									<i class="menu-icon fa fa-caret-right"></i>
									学生就业情况登记
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListReview?wfId=ZXDK">
									<i class="menu-icon fa fa-caret-right"></i>
									国家助学贷款
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListReview?wfId=SSZZ">
									<i class="menu-icon fa fa-caret-right"></i>
									膳食资助计划助学金
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListReview?wfId=HBL">
									<i class="menu-icon fa fa-caret-right"></i>
									黄炳礼助学金
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListReview?wfId=SD">
									<i class="menu-icon fa fa-caret-right"></i>
									史带助学金
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListReview?wfId=TSSH">
									<i class="menu-icon fa fa-caret-right"></i>
									香港台山商会助学金
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerHouseData" href="index.do#page/workFlowItemListReview?wfId=YJSH">
									<i class="menu-icon fa fa-caret-right"></i>
									阳江商会助学金
								</a>
							</li>
						</ul>
					</li>
					</c:if>
					
					<c:if test="${LoginedCustomer.userType=='教师'}">
					<li >
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-gavel "></i>
							<span class="menu-text"> 表单审批 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>
						
						<b class="arrow"></b>
						
						<ul class="submenu">
							<li class="">
								<a data-url="page/towerLandData" href="index.do#page/workFlowItemListApprove?wfId=YBCB">
									<i class="menu-icon fa fa-caret-right"></i>
									医保参保申请
								</a>
							</li>

							<li class="">
								<a data-url="page/towerLandData" href="index.do#page/workFlowItemListApprove?wfId=ZXDK">
									<i class="menu-icon fa fa-caret-right"></i>
									国家助学贷款
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerLandData" href="index.do#page/workFlowItemListApprove?wfId=SSZZ">
									<i class="menu-icon fa fa-caret-right"></i>
									膳食资助计划助学金
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerLandData" href="index.do#page/workFlowItemListApprove?wfId=HBL">
									<i class="menu-icon fa fa-caret-right"></i>
									黄炳礼助学金
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerLandData" href="index.do#page/workFlowItemListApprove?wfId=SD">
									<i class="menu-icon fa fa-caret-right"></i>
									史带助学金
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerLandData" href="index.do#page/workFlowItemListApprove?wfId=TSSH">
									<i class="menu-icon fa fa-caret-right"></i>
									香港台山商会助学金
								</a>
							</li>
							
							<li class="">
								<a data-url="page/towerLandData" href="index.do#page/workFlowItemListApprove?wfId=YJSH">
									<i class="menu-icon fa fa-caret-right"></i>
									阳江商会助学金
								</a>
							</li>
							
						</ul>
					</li>
					</c:if>
					<c:if test="${LoginedCustomer.userType=='教师'}">
					<li >
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-bar-chart-o "></i>
							<span class="menu-text"> 报表查询 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>
						
						<b class="arrow"></b>
						
						<ul class="submenu">
							<li class="">
								<a data-url="page/towerLandData" href="frameset?__report=student.rptdesign" target="_blank">
									<i class="menu-icon fa fa-caret-right"></i>
									学生信息
								</a>
							</li>

						</ul>
					</li>
					</c:if>
					<c:if test="${LoginedCustomer.userType=='管理员'}">
					<li >
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-cogs"></i>
							<span class="menu-text"> 系统管理 </span>

							<b class="arrow fa fa-angle-down"></b>
						</a>

						<b class="arrow"></b>

						<ul class="submenu">
							<li class="">
								<a data-url="page/adminList" href="index.do#page/adminList">
									<i class="menu-icon fa fa-caret-right"></i>
									管理员管理
								</a>

								<b class="arrow"></b>
								
								<ul class="submenu hidden">
											<li class="">
												<a data-url="page/adminEdit" href="index.do#page/adminEdit">
													<i class="menu-icon fa fa-caret-right"></i>
													编辑
												</a>

												<b class="arrow"></b>
											</li>
								 </ul>
							</li>
							
							<li class="">
								<a data-url="page/teacherList" href="index.do#page/teacherList">
									<i class="menu-icon fa fa-caret-right"></i>
									教师管理
								</a>

								<b class="arrow"></b>
								
								<ul class="submenu hidden">
											<li class="">
												<a data-url="page/teacherEdit" href="index.do#page/teacherEdit">
													<i class="menu-icon fa fa-caret-right"></i>
													编辑
												</a>

												<b class="arrow"></b>
											</li>
								 </ul>
							</li>
						
							<li class="">
								<a data-url="page/studentList" href="index.do#page/studentList">
									<i class="menu-icon fa fa-caret-right"></i>
									学生管理
								</a>

								<b class="arrow"></b>
								
								<ul class="submenu hidden">
											<li class="">
												<a data-url="page/userEdit" href="index.do#page/studentEdit">
													<i class="menu-icon fa fa-caret-right"></i>
													编辑
												</a>

												<b class="arrow"></b>
											</li>
								 </ul>
							</li>
							
							<li class="">
								<a data-url="page/classesList" href="index.do#page/classesList">
									<i class="menu-icon fa fa-caret-right"></i>
									班级管理
								</a>

								<b class="arrow"></b>
								
								<ul class="submenu hidden">
											<li class="">
												<a data-url="page/classesEdit" href="index.do#page/classesEdit">
													<i class="menu-icon fa fa-caret-right"></i>
													编辑
												</a>

												<b class="arrow"></b>
											</li>
								 </ul>
							</li>

							<li class="">
								<a data-url="page/workFlowList" href="index.do#page/workFlowList">
									<i class="menu-icon fa fa-caret-right"></i>
									表单管理
								</a>

								<b class="arrow"></b>
								
								<ul class="submenu hidden">
											<li class="">
												<a data-url="page/workFlowEdit" href="index.do#page/workFlowEdit">
													<i class="menu-icon fa fa-caret-right"></i>
													编辑
												</a>

												<b class="arrow"></b>
											</li>
								 </ul>
							</li>
							
						</ul>
					</li>
					</c:if>

				</ul><!-- /.nav-list -->

				<!-- /section:basics/sidebar.layout.minimize -->
				<script type="text/javascript">
					try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
				</script>
			</div>

			<!-- /section:basics/sidebar -->
			<div class="main-content">
				<!-- #section:basics/content.breadcrumbs -->
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
					</script>

					<ul class="breadcrumb">
						<li>
							<i class="ace-icon fa fa-home home-icon"></i>
							<a href="#">首页</a>
						</li>
					</ul><!-- /.breadcrumb -->	
				</div>

				<!-- /section:basics/content.breadcrumbs -->
				<div class="page-content">
					

					<!-- /section:settings.box -->
					<div class="page-content-area">
						<!-- ajax content goes here -->
						
						<div class="alert alert-block alert-success">
									<button type="button" class="close" data-dismiss="alert">
										<i class="ace-icon fa fa-times"></i>
									</button>

									<i class="ace-icon fa fa-check green"></i>

									欢迎登录
									<strong class="green">学生管理与教学质量信息系统
									</strong>
								</div>
																
								<div class="widget-box transparent col-sm-12">
											<div class="widget-header widget-header-flat widget-header-small">
												<h5 class="widget-title">
													<i class="ace-icon fa fa-home"></i>
													快速链接
												</h5>
											</div>

											<div class="widget-body">
											<div class="widget-main">
						<div class="infobox infobox-green infobox-large infobox-dark" style="cursor:pointer" onclick="javascript: window.open('http://www.wyu.edu.cn');">
							<div class="infobox-icon">
								<i class="ace-icon fa fa-globe"></i>
							</div>
							<div class="infobox-data">
								<div class="infobox-content">五邑大学</div>
							</div>
						</div>
						
						<div class="infobox infobox-blue infobox-large infobox-dark" style="cursor:pointer" onclick="javascript: window.open('http://oa.wyu.edu.cn/Login.aspx?ReturnUrl=%2fdefault.aspx');">
							<div class="infobox-icon">
								<i class="ace-icon fa fa-globe"></i>
							</div>
							<div class="infobox-data">
								<div class="infobox-content">五邑大学OA系统</div>
							</div>
						</div>
						
						<div class="infobox infobox-grey infobox-large infobox-dark" style="cursor:pointer" onclick="javascript: window.open('http://job.wyu.edu.cn');">
							<div class="infobox-icon">
								<i class="ace-icon fa fa-globe"></i>
							</div>
							<div class="infobox-data">
								<div class="infobox-content">就业指导中心</div>
							</div>
						</div>
						
						<div class="infobox infobox-red infobox-large infobox-dark" style="cursor:pointer" onclick="javascript: window.open('http://xsc.wyu.cn');">
							<div class="infobox-icon">
								<i class="ace-icon fa fa-globe"></i>
							</div>
							<div class="infobox-data">
								<div class="infobox-content">学生工作部</div>
							</div>
						</div>
						
						<div class="infobox infobox-orange infobox-large infobox-dark" style="cursor:pointer" onclick="javascript: window.open('http://jwc.wyu.edu.cn/www/newslist.asp?id=52');">
							<div class="infobox-icon">
								<i class="ace-icon fa fa-globe"></i>
							</div>
							<div class="infobox-data">
								<div class="infobox-content">教务处</div>
							</div>
						</div>
						
						<div class="infobox infobox-pink infobox-large infobox-dark" style="cursor:pointer" onclick="javascript: window.open('http://jwc.wyu.edu.cn/sc');">
							<div class="infobox-icon">
								<i class="ace-icon fa fa-globe"></i>
							</div>
							<div class="infobox-data">
								<div class="infobox-content">第二课堂学分登记</div>
							</div>
						</div>
						</div>
						</div>
						</div>
						<p/>
						<p/>
						<p/>
						
						<c:if test="${LoginedCustomer.userType!='管理员'}">
						
						<div class="widget-box transparent col-sm-6" style="margin-top: 20px;">
											<div class="widget-header widget-header-flat widget-header-small">
												<h5 class="widget-title">
													<i class="ace-icon fa fa-signal"></i>
													我的表单状态
												</h5>
											</div>

											<div class="widget-body">
												<div class="widget-main">
													<!-- #section:plugins/charts.flotchart -->
													<div id="piechart-placeholder"></div>

													<!-- /section:plugins/charts.flotchart -->
													<div class="hr hr8 hr-double"></div>

													<div class="clearfix">
														<!-- #section:custom/extra.grid -->
														<div class="grid3">
															<span class="grey">
																<i class="ace-icon fa fa-circle fa-2x red"></i>
																&nbsp; 正在编辑
															</span>
															<h4 class="bigger pull-right" id="data1">0</h4>
														</div>

														<div class="grid3">
															<span class="grey">
																<i class="ace-icon fa fa-circle fa-2x red"></i>
																&nbsp; 等待检查
															</span>
															<h4 class="bigger pull-right" id="data2">0</h4>
														</div>
														
														<div class="grid3">
															<span class="grey">
																<i class="ace-icon fa fa-circle fa-2x red"></i>
																&nbsp; 等待审批
															</span>
															<h4 class="bigger pull-right" id="data3">0</h4>
														</div>
														
														<!-- /section:custom/extra.grid -->
													</div>
													
													<div class="clearfix">
														<!-- #section:custom/extra.grid -->
														
														<div class="grid3">
															<span class="grey">
																<i class="ace-icon fa fa-circle fa-2x red"></i>
																&nbsp; 审批通过
															</span>
															<h4 class="bigger pull-right" id="data4">0</h4>
														</div>
														
														<div class="grid3">
															<span class="grey">
																<i class="ace-icon fa fa-circle fa-2x red"></i>
																&nbsp; 已经拒绝
															</span>
															<h4 class="bigger pull-right" id="data5">0</h4>
														</div>
														
														<!-- /section:custom/extra.grid -->
													</div>
												</div><!-- /.widget-main -->
											</div><!-- /.widget-body -->
										</div><!-- /.widget-box -->
						
						</c:if>
						
					</div><!-- /.page-content-area -->
				</div><!-- /.page-content -->
			</div><!-- /.main-content -->

			<div class="footer">
				<div class="footer-inner">
					<!-- #section:basics/footer -->
					<div class="footer-content">
						<span>
							<span class="blue bolder">江门市五邑大学信息学院</span>
							学生管理与教学质量信息系统 &copy; 2017-2018
						</span>
					</div>

					<!-- /section:basics/footer -->
				</div>
			</div>

			<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
				<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
			</a>
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery.min.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery1x.min.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/index.js"></script>
		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		<script src="assets/js/bootbox.min.js"></script>
		<script src="assets/js/flot/jquery.flot.min.js"></script>
		<script src="assets/js/flot/jquery.flot.pie.min.js"></script>
		<script src="assets/js/flot/jquery.flot.resize.min.js"></script>
		<script type="text/javascript">
			//Load content via ajax
					jQuery(function($) {
						
						//chart	start
						
						$.ajax({
								type:'get',
								url:"myForm.do",
								success:function(data){
									
									$.each( data, function(index, content) { 
										if (content.label == "正在编辑") {
											$("#data1").html(content.data);
										} else if (content.label == "等待检查") {
											$("#data2").html(content.data);
										} else if (content.label == "等待审批") {
											$("#data3").html(content.data);
										} else if (content.label == "审批通过") {
											$("#data4").html(content.data);
										} else if (content.label == "已经拒绝") {
											$("#data5").html(content.data);
										}
									});
									
									var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'200px'});
									  
									  function drawPieChart(placeholder, data, position) {
									 	  $.plot(placeholder, data, {
											series: {
												pie: {
													show: true,
													tilt:0.8,
													highlight: {
														opacity: 0.25
													},
													stroke: {
														color: '#fff',
														width: 2
													},
													startAngle: 2
												}
											},
											legend: {
												show: true,
												position: position || "ne", 
												labelBoxBorderColor: null,
												margin:[-30,15]
											}
											,
											grid: {
												hoverable: true,
												clickable: true
											}
										 })
									 }
									 drawPieChart(placeholder, data);
									
									 /**
									 we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
									 so that's not needed actually.
									 */
									 placeholder.data('chart', data);
									 placeholder.data('draw', drawPieChart);
									
									
									  //pie chart tooltip example
									  var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
									  var previousPoint = null;
									
									  placeholder.on('plothover', function (event, pos, item) {
										if(item) {
											if (previousPoint != item.seriesIndex) {
												previousPoint = item.seriesIndex;
												var tip = item.series['label'] + " : " + item.series['percent']+'%';
												$tooltip.show().children(0).text(tip);
											}
											$tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
										} else {
											$tooltip.hide();
											previousPoint = null;
										}
										
									 });
								},		
								error:function(XmlHttpRequest,textStatus,errorThrown){
									
								}
						});
									  
						//chart end
						
						
						
						
						
						
						
					  if('enable_ajax_content' in ace) {
						var options = {
						  content_url: function(url) {
							//this is for Ace demo only, you should change it
							//please refer to documentation for more info
						
							if(!url.match(/^page\//)) return false;
							
							var path = document.location.pathname;
							
							//for Ace HTML demo version, convert index.do#page/gallery to > gallery.html and load it
							if(path.match(/index\.do/)) return path.replace(/index\.do/, url.replace(/^page\//, '')) ;
					
							//for Ace PHP demo version convert "page/dashboard" to "?page=dashboard" and load it
							return path + "?" + url.replace(/\//, "=");
						  },
						  default_url: ''//default url
						}
						ace.enable_ajax_content($, options)
						
					  }
					    
					})
		</script>
	</body>
</html>


