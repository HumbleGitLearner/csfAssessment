package ibf2023.csf.backend.repositories;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

@Repository
public class ImageRepository {

	@Autowired
    private AmazonS3 s3;
    
	@Value("${s3.bucket.name}")
    private String bucketName;


	// TODO Task 4.1
	// You may change the method signature by adding parameters and/or the return type
	// You may throw any exception 
		// IMPORTANT: Write the native mongo query in the comments above this method
    public String save(MultipartFile uploadFile, String username) {

        String id = UUID.randomUUID().toString().substring(0, 8);
        
        try {
            Map<String, String> userData = new HashMap<>();
            userData.put("name", username);
            userData.put("filename", uploadFile.getOriginalFilename());

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(uploadFile.getContentType());
            metadata.setContentLength(uploadFile.getSize());
            metadata.setUserMetadata(userData);


            PutObjectRequest putRequest = new PutObjectRequest(this.bucketName, "%s".formatted(id), uploadFile.getInputStream(),
                    metadata);
            putRequest.withCannedAcl(CannedAccessControlList.PublicRead);

            PutObjectResult result = s3.putObject(putRequest);
            System.out.println("PutObjectResult: " + result.getMetadata().toString());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return id;
    }

}
