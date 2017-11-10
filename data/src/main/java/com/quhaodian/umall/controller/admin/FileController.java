/*
 * 
 * 
 * 
 */
package com.quhaodian.umall.controller.admin;

import com.quhaodian.plug.Message;
import com.quhaodian.plug.data.service.StorageService;
import com.quhaodian.plug.data.vo.FileInfo;
import com.quhaodian.umall.data.vo.FileResponse;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Controller - 文件处理
 * 
 * 
 * 
 */
@Controller
@RequestMapping("/admin/file")
public class FileController   {

    @Autowired
    StorageService storageService;

	public String uploadLocal(FileInfo.FileType fileType, MultipartFile multipartFile) {
		return storageService.uploadLocal(fileType,multipartFile);
	}

	/**
	 * 上传
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public FileResponse upload(FileInfo.FileType fileType, MultipartFile file, HttpServletResponse response) {

        FileResponse result=new FileResponse();
		Map<String, Object> data = new HashMap<String, Object>();
		String url = storageService.upload(fileType, file);
        result.setUrl(url);
		return result;
	}


}