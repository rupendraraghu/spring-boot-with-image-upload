package com.rup.file.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rup.file.controller.payload.FileResponse;
import com.rup.file.service.FileService;

@RestController
@RequestMapping("/file")
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	@PostMapping("/upload")
	public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image){
		String uploadImage;
		try {
			uploadImage = fileService.uploadImage(path, image);
		} catch (IOException e) {
			return new ResponseEntity<FileResponse>(new FileResponse(null, "Image is not uploaded due to some error!"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseEntity.ok(new FileResponse(uploadImage, "Image is successfully uploaded!"));
	}

}
