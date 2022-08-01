package com.celes.photoClone.downloadController;

import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.celes.photoClone.dto.Photo;
import com.celes.photoClone.service.PhotozService;

@RestController
public class DownloadController {

private final PhotozService photozService;
	
	public DownloadController(PhotozService photozService) {
		this.photozService = photozService;
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable String id){
		Photo photo=photozService.get(id);
		if(photo==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		byte[]data=photo.getData();
		//byte[] data = new byte[0];
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.valueOf(photo.getContentType()));
		ContentDisposition build=ContentDisposition.builder("attachment").filename(photo.getFileName()).build();
		headers.setContentDisposition(build);
		return new ResponseEntity<>(data, headers, HttpStatus.OK);
	}
}
