package ibf2023.csf.backend.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ibf2023.csf.backend.models.PhotoDetails;
import ibf2023.csf.backend.services.PictureService;
import jakarta.json.Json;

// You can add addtional methods and annotations to this controller. 
// You cannot remove any existing annotations or methods from UploadController
@Controller
@RequestMapping(path="/api")
public class UploadController {


    @Autowired
    PictureService empSvc;


	// TODO Task 5.2
	// You may change the method signature by adding additional parameters and annotations.
	// You cannot remove any any existing annotations and parameters from postUpload()
	@PostMapping(path="/image/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> postUpload( @RequestParam("image") MultipartFile myimage, 
        @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
        @RequestParam("email") String email) throws IOException {
        System.out.println("file >>>###############");
        PhotoDetails pd = new PhotoDetails();
		pd.setTitle(firstName);
		
             System.out.println("file >>> " + pd.toString());
        
		Boolean result = empSvc.save(pd, myimage);
		if (result) {
		return ResponseEntity.ok(
			Json.createObjectBuilder().build().toString()
		);
		} else {
		//	Map<String, String>error = new HashMap<String, String>();

         //   error.put("error", "Failed to create bundle");

            return ResponseEntity.status(500).body("Failed to create bundle");

		}
	}


	// public record Comment(String user, int photoId, String message) { }

// public record PhotoDetails(int gameId, String title, String image, String url, List<Comment> comments) { }

}
