package org.zerock.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.AirVO;
import org.zerock.domain.ImageVO;
import org.zerock.persistence.AirDAO;
import org.zerock.persistence.ImageDAO;
/**
 * Handles requests for the application home page.
 */


@Controller
@RequestMapping("/image/*")




public class ImageController {	
	
	
	//private String uploadPath = "C:\\zzz\\upload";
	private String uploadPath = "/usr/zzz/upload";
	@Inject
	private ImageDAO imagedao;
	
	private static final Logger logger = LoggerFactory.getLogger(ImageController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public String ingGet(AirVO air, Model model, HttpSession session) throws Exception{
		
		Object membervo = session.getAttribute("MemberVO");
		
		
		String s_membervo = membervo.toString();
		System.out.println(""+membervo);

		int start = s_membervo.indexOf("uhome=")+6;
		int end = s_membervo.indexOf(", ux");
		
		s_membervo = s_membervo.substring(start, end);
		
		model.addAttribute("uhome", s_membervo);
		
		
		return "img/imgGet";
	}
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public void imgPost(MultipartFile file, ImageVO imagevo, Model model) throws Exception{
		
		//logger.info("original name : "+ file.getOriginalFilename());
		
		String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
		
		String dbSavedName = savedName.replace(uploadPath, "");
		
		imagevo.setImageName(dbSavedName);		
		imagevo.setUhome(imagevo.getUhome());
		imagedao.create(imagevo);
		logger.info(imagevo.getUhome());
		
		model.addAttribute("savedName", savedName);
		//return "air/airGetSuccess";
		
	}
	
	
	private String uploadFile(String originalName, byte[] fileData) {
		UUID uid = UUID.randomUUID();
		
		String savedName = uid.toString() + "_" + originalName;
		
		//String savedPath = calcPath(uploadPath);
		
		File target = new File(uploadPath , savedName);
		
		try {
			FileCopyUtils.copy(fileData, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		logger.info(uploadPath + "/"+ savedName);
		
		return uploadPath + "/"+ savedName;
	}
	
	
	@RequestMapping(value="/imageView", method= RequestMethod.GET)
	public String imageView(String filename, Model model) throws Exception{
		
		
		
		
		model.addAttribute("filename",filename);
		
		return "img/imageView";
	
		
	}
	
	@RequestMapping(value = "/sendImage/{uhome}", method = RequestMethod.GET)
	
	public ResponseEntity<List<ImageVO>> sendAir(@PathVariable("uhome") String uhome){		
		
		ResponseEntity<List<ImageVO>> entity = null;
		System.out.println("uhome = "+ uhome);

		try {
			entity = new ResponseEntity<>(
					imagedao.read(uhome) , HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String filename)throws Exception{
		
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		
		HttpHeaders headers = new HttpHeaders();
		
		in = new FileInputStream(uploadPath+"/"+filename);
		
		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, 
				HttpStatus.CREATED);
		logger.info("FILE get success");
		in.close();
		
		return entity;
	}
	
	@RequestMapping("/deleteFile")
	public String deleteFile() {
		
		return "redirect:indivisual/viewAll";
	}
	

}








