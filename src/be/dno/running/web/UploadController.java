package be.dno.running.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.dno.running.entities.xml.garmin.tcx.TrainingCenterDatabase;
import be.dno.running.xml.XmlToJavaConverter;

@Controller
@RequestMapping(value = "/upload_activity")
public class UploadController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView postUpload(MultiPartFileUpload upload, HttpServletRequest request) {
        if (upload.getFile().getSize() != 0) {
            String fileContent = new String(upload.getFile().getBytes());
            String fileCategory = getFileCategory(fileContent);
            String jspName = "file_uploaded";
            if (fileCategory.contains("TCX")){
            	jspName += "_tcx";
            }else if (fileCategory.contains("GPX")){
            	jspName += "_gpx";
            }
            Object tcd = XmlToJavaConverter.convert(fileContent,fileCategory);   
            return new ModelAndView(jspName , "fileContent", tcd);
        }
	    return new ModelAndView("fail");
	}

	private String getFileCategory(String fileContent) {
		if(fileContent.contains("<TrainingCenterDatabase")){
			return "TCX_GARMIN";
		}
		
		if(fileContent.contains("<gpx")){
			return "GPX_GARMIN";
		}
		
		return "UNKNOWN";
	}
}
