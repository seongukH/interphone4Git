package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.AirVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ImageVO;
import org.zerock.domain.SearchCriteria;

@Repository
public class ImageDAOImpl implements ImageDAO {

  @Inject
  private SqlSession session;

  private static String namespace = "org.zerock.mapper.imageMapper";

  
  public void create(ImageVO vo) throws Exception {
    session.insert(namespace + ".create", vo);
  }

  
  public List<ImageVO> read(String uhome) throws Exception {
    return session.selectList(namespace + ".search", uhome);
  }

  public void delete(String imageName) throws Exception{
	  session.delete(namespace + ".delete", imageName);
  }
 
  
/*
  
  public List<AirVO> listAll() throws Exception {
    return session.selectList(namespace + ".listAll");
  }

  */
  

}
