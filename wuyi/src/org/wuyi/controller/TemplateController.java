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
import org.wuyi.entity.Template;
import org.wuyi.entity.WorkFlow;
import org.wuyi.security.RequireLogin;
import org.wuyi.service.TemplateService;


/**
 * 表单管理
 * @author lgm-dell
 *
 */
@Controller
@RequestMapping("/")
public class TemplateController {

	@Autowired
	private TemplateService templateService;
	
	/**
	 * 进入列表界面
	 */
	@RequestMapping("templateList")
	@RequireLogin
	public String list(@RequestParam(value="id", required=true) String id, @RequestParam(value="name", required=false) String name, Model model) {
		
		List<Template> templates = templateService.listByWf(id);
		
		model.addAttribute("templates", templates);
		model.addAttribute("wfId", id);
		model.addAttribute("wfName", name);
		
		return "system/templateList";
	}
	
	@RequestMapping("/templateFileUpload")
	@ResponseBody
	public void fileUpload(
			@RequestParam(value = "wfId", required = true) String wfId,
			@RequestParam(value = "file", required = true) MultipartFile file,
			HttpServletResponse res) {
		HashMap<String, String> result = new HashMap<String, String>();
		
		String realPath = CommonUtil.getFilePath("/files/templateFile");
		String newFileName = UUID.randomUUID()
				+ CommonUtil.getFileExt(file.getOriginalFilename());
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
					realPath, newFileName));
			Template template = new Template();
			WorkFlow wf = new WorkFlow();
			wf.setId(wfId);
			template.setWorkFlow(wf);
			template.setName(file.getOriginalFilename());
			template.setPath(newFileName);
			templateService.add(template);
			
			result.put("message", "上传成功");
			result.put("status", "OK");
			result.put("id", String.valueOf(template.getId()));
			
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
	
	@RequestMapping("/templateFileDownload")   
	public ResponseEntity<byte[]> download(@RequestParam int id, HttpServletRequest request) throws UnsupportedEncodingException  
	{
		Template entity = templateService.getEntity(id);
		
		if (entity != null)
		{
			String realPath = CommonUtil.getFilePath("/files/templateFile/");
			
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
	
	@RequestMapping("/templateDel")
	@ResponseBody
	public void templateDel(
			@RequestParam(value = "id", required = true) Integer id,
			HttpServletResponse res) {
		Template entity = templateService.getEntity(id);
		if (entity != null) {
			templateService.delete(entity);
			String realPath = CommonUtil.getFilePath("/files/templateFile/" + entity.getPath());
			File file = new File(realPath);
			if (file != null && file.exists()) {
				file.delete();
			}
		}
	}
	
}
