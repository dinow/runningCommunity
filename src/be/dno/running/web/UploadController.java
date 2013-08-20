package be.dno.running.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/upload_activity")
public class UploadController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postUpload(MultiPartFileUpload upload, HttpServletRequest request) {
		System.out.println("postUpload");
        if (upload.getFile().getSize() != 0) {
            String fileContent = new String(upload.getFile().getBytes());
            fileContent = fileContent.replaceAll("&", "&amp;");
            fileContent = fileContent.replaceAll(">", "&gt;");
            fileContent = fileContent.replaceAll("<", "&lt;");
            
            return new ModelAndView("file_uploaded" , "fileContent", fileContent);
        }
	    return new ModelAndView("fail");
	}
}
