<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>模板附件</title>

<link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
<link rel="stylesheet" href="assets/css/ui.jqgrid.css" />
<!-- page specific plugin styles -->
<link rel="stylesheet" href="assets/css/dropzone.css" />

<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->

		<div class="widget-box">

			<div class="widget-header">
				<h4 class="smaller">模板附件 - ${wfName}</h4>
			</div>

			<div class="widget-body">
			
			<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div>
									<form action="templateFileUpload.do" class="dropzone" id="dropzone">
										<input type="hidden" name="wfId" value="${wfId}" />
										<div class="fallback">
											<input name="file" type="file" multiple="" />
											
										</div>
									</form>
								</div><!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
				</div>
				
				<c:forEach items="${templates}" var="t">
					<input type="hidden" name="oldFiles" id="${t.id}" value="${t.name}" />
				</c:forEach>
				
			<div class="clearfix form-actions" style="margin-bottom:0px !important;margin-top:0px !important;">
										<div class="col-md-9">
											<a class="btn btn-success btn-sm" href="index.do#page/workFlowList">
												<i class="ace-icon fa fa-arrow-up bigger-110"></i>
												返回上一页
											</a>
										</div>
									</div>
			
		
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
var scripts = [null,"assets/js/dropzone.min.js", null]
ace.load_ajax_scripts(scripts, function() {
	jQuery(function($) {
		Dropzone.autoDiscover = false;
		try {
		  var myDropzone = new Dropzone("#dropzone" , {
		    paramName: "file", // The name that will be used to transfer the file
		    maxFilesize: 10, // MB
		
			addRemoveLinks : false,
			dictDefaultMessage :
			'<span class="bigger-150 bolder"><i class="ace-icon fa fa-caret-right red"></i> 拖动文件到这里</span> <span class="smaller-80 grey">(或者单击)</span> <br /> <i class="upload-icon ace-icon fa fa-cloud-upload blue fa-3x"></i>',
			dictResponseError: 'Error while uploading file!',
			
			//change the previewTemplate to use Bootstrap progress bars
			previewTemplate: "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n  <img data-dz-thumbnail />\n  </div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage>/span></div>\n</div>",
		  
			init: function() {
		            this.on("removedfile", function(file) {
		            	$.ajax({
							type:'post',
							url:"templateDel.do",
							data:{id:file.id},
							success:function(result){
								
							},		
							error:function(XmlHttpRequest,textStatus,errorThrown){
								bootbox.alert("系统出错，请联系管理员");
							}
						})
		            });
		            
		            this.on("addedfile", function(file) {
						if (file.id != null) {
							// Create the remove button
			                var removeButton = Dropzone.createElement("<a class=\"dz-remove\" href=\"javascript:undefined;\" data-dz-remove=\"\">删除文件</a>");
			                var downloadButton = Dropzone.createElement("<a class=\"dz-remove\" href=\"templateFileDownload?id="+file.id+"\" data-dz-remove=\"\">下载文件</a>");

			                // Capture the Dropzone instance as closure.
			                var _this = this;

			                // Listen to the click event
			                removeButton.addEventListener("click", function(e) {
			                  // Make sure the button click doesn't submit the form:
			                  e.preventDefault();
			                  e.stopPropagation();

			                  // Remove the file preview.
			                  _this.removeFile(file);
			                  // If you want to the delete the file on the server as well,
			                  // you can do the AJAX request here.
			                });

			                // Add the button to the file preview element.
			                file.previewElement.appendChild(removeButton);
			                
			                // Add the button to the file preview element.
			                file.previewElement.appendChild(downloadButton);
						}
		                
		              });
		        }
		  });
		  
		  $("input:hidden").each(function() {
			  if ($(this).attr("name") == "oldFiles") {
				  myDropzone.emit("addedfile", {name: $(this).val(), id: $(this).attr("id")});
			  }
		  });
		  
		} catch(e) {
		  	alert('Dropzone.js does not support older browsers! :' + e);
		}
	});
});
</script>
