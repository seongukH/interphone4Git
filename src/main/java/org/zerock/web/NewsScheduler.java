package org.zerock.web;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.github.rcaller.rStuff.RCaller;
import com.github.rcaller.rStuff.RCode;

@Service
public class NewsScheduler {
	File file;
	
	@Scheduled(fixedDelay=1000*60)
    public void TestScheduler(){
		
		
		 try {
	         
	         RCaller caller = new RCaller();
	        // caller.setRscriptExecutable("C:\\Program Files\\R\\R-3.5.0\\bin\\x64\\Rscript.exe");
	         caller.setRscriptExecutable("/usr/bin/Rscript");

	         
	         
	         RCode code = new RCode();
	         code.clear();
	         
	         code.addRCode("x = c(1,2,3,4,5)"+
	        		 		"x");
	        
	         
	         code.clear();
	         
	         
	         file = code.startPlot();
	         System.out.println(file);

	       
	 		code.addRCode("t = Sys.time()\r\n" + 
	 				"\r\n" + 
	 				"t\r\n" + 
	 				"text = (\"ø¿¥√¿« ¥∫Ω∫ // \")\r\n" + 
	 				"\r\n" + 
	 				"out = paste(text, t)\r\n" + 
	 				"\r\n" + 
	 				"#write(out, \"C:/zzz/text/new.txt\")\r\n" + 
	 				"\r\n" + 
	 				"write(out, \"/usr/zzz/text/new.txt\")\r\n" + 
	 				"\r\n" + 
	 				"");
	 		code.endPlot();
	 		
	         caller.setRCode(code);
	         caller.runOnly();
	         
	       
	        // code.showPlot(file);
	         
	      } catch (Exception e) {
	         // TODO: handle exception
		         System.out.println("exception!");

	      }
		 
		 
    }

}
