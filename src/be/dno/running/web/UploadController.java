package be.dno.running.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.xml.TrainingCenterDatabase;
import be.dno.running.xml.XmlToJavaConverter;

@Controller
@RequestMapping(value = "/upload_activity")
public class UploadController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postUpload(MultiPartFileUpload upload, HttpServletRequest request) {
		System.out.println("postUpload");
        if (upload.getFile().getSize() != 0) {
            String fileContent = new String(upload.getFile().getBytes());
            TrainingCenterDatabase tcd = XmlToJavaConverter.convert(fileContent);   
            return new ModelAndView("file_uploaded" , "fileContent", tcd);
        }
	    return new ModelAndView("fail");
	}
}
