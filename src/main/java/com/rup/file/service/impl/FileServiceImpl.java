package com.rup.file.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rup.file.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {
		
		String filename = file.getOriginalFilename();
		
		String randomId = UUID.randomUUID().toString();
		String newFileName = randomId.concat(filename.substring(filename.lastIndexOf(".")));
		
		String filePath= path+File.separator+newFileName;
		
		File f = new File(path);
		
		if(!f.exists()) {
			f.mkdir();
		}
		
		Files.copy(file.getInputStream(), Paths.get(filePath));
		return newFileName;
	}

}
