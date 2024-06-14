package ibf2023.csf.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ibf2023.csf.backend.models.PhotoDetails;
import ibf2023.csf.backend.repositories.ImageRepository;
import ibf2023.csf.backend.repositories.PictureRepository;

@Service
public class PictureService {

	@Autowired
	ImageRepository s3Repo;
	
	@Autowired
	PictureRepository pR;

	// TODO Task 5.1
	// You may change the method signature by adding parameters and/or the return type
	// You may throw any exception 

	   public boolean save(PhotoDetails p, MultipartFile file) {
		try{
        String s3FileId = s3Repo.save(file,p.getTitle());
        System.out.println("SaveWIthS3 >>> 11111" + s3FileId);
        
  		p.setUrl("sgp1.digitaloceanspaces.com" + s3FileId);
        System.out.println("SaveWIthS3 >>> 22222" +p.getUrl());
		pR.save(p, file);
		} catch (Exception e){
			e.printStackTrace();
			throw e;
		}
		return true;
 		

      }

}
