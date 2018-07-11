package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;

import org.zerock.domain.AirVO;
import org.zerock.domain.ImageVO;


public interface ImageDAO {

  public void create(ImageVO vo) throws Exception;

  public List<ImageVO> read(String uhome) throws Exception;
  
  public void delete(String imageName) throws Exception;
 
 // public List<AirVO> listAll() throws Exception;

  

  

  

}
