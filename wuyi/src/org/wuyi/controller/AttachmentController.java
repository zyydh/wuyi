package org.wuyi.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.wuyi.common.CommonUtil;
import org.wuyi.entity.Attachment;
import org.wuyi.entity.WorkFlow;
import org.wuyi.entity.WorkFlowItem;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.AttachmentService;
import org.wuyi.service.WorkFlowItemService;


/**
 * 表单附件
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class AttachmentController {

	@Autowired
	private AttachmentService attachmentService;
	@Autowired
	private WorkFlowItemService workFlowItemService;
	
	/**
	 * 进入列表界面
	 */
	@RequestMapping("attachmentList")
	@RequireLogin
	public String list(@RequestParam(value="id", required=true) Integer id, @RequestParam(value="name", required=false) String name, Model model) {
		
		List<Attachment> attachments = attachmentService.listByItem(id);
		WorkFlowItem item = workFlowItemService.getEntity(id);
		
		model.addAttribute("attachments", attachments);
		model.addAttribute("itemId", id);
		model.addAttribute("wfName", name);
		model.addAttribute("wfId", item.getWorkFlow().getId());
		
		return "forms/attachmentList";
	}
	
	@RequestMapping("/attachmentFileUpload")
	@ResponseBody
	public void fileUpload(
			@RequestParam(value = "itemId", required = true) Integer itemId,
			@RequestParam(value = "file", required = true) MultipartFile file,
			HttpServletResponse res) {
		HashMap<String, String> result = new HashMap<String, String>();
		
		String realPath = CommonUtil.getFilePath("/files/attachmentFile");
		String newFileName = UUID.randomUUID()
				+ CommonUtil.getFileExt(file.getOriginalFilename());
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					realPath, newFileName));
			Attachment attachment = new Attachment();
			WorkFlowItem item = new WorkFlowItem();
			item.setId(itemId);
			attachment.setWorkFlowItem(item);
			attachment.setName(file.getOriginalFilename());
			attachment.setPath(newFileName);
			attachmentService.add(attachment);
			
			result.put("message", "上传成功");
			result.put("status", "OK");
			result.put("id", String.valueOf(attachment.getId()));
			
		} catch (IOException e) {
			e.printStackTrace();
			result.put("message", "上传失败");
			result.put("status", "ERR");
		}
		
		try {
			res.getWriter().write(JSONObject.toJSONString(result));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@RequestMapping("/attachmentFileDownload")   
	public ResponseEntity<byte[]> download(@RequestParam int id, HttpServletRequest request) throws UnsupportedEncodingException  
	{
		Attachment entity = attachmentService.getEntity(id);
		
		if (entity != null)
		{
			String realPath = CommonUtil.getFilePath("/files/attachmentFile/");
			
		    HttpHeaders headers = new HttpHeaders();   
		    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		    headers.setContentDispositionFormData("attachment", URLEncoder.encode(entity.getName(), "UTF-8"));   
		    try {
		    	File file = new File(realPath+entity.getPath());
				if(file.exists())
				{
					return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		HttpHeaders headers = new HttpHeaders();   
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", URLEncoder.encode("未知文件", "UTF-8"));
	    return new ResponseEntity<byte[]>(null, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping("/attachmentDel")
	@ResponseBody
	public void attachmentDel(
			@RequestParam(value = "id", required = true) Integer id,
			HttpServletResponse res) {
		Attachment entity = attachmentService.getEntity(id);
		if (entity != null) {
			attachmentService.delete(entity);
			String realPath = CommonUtil.getFilePath("/files/attachmentFile/" + entity.getPath());
			File file = new File(realPath);
			if (file != null && file.exists()) {
				file.delete();
			}
		}
	}
	
}
