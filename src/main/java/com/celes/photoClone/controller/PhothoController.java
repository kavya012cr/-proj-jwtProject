package com.celes.photoClone.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.celes.photoClone.dto.Photo;
import com.celes.photoClone.service.PhotozService;

@RestController
public class PhothoController {
	
	@Autowired
	private final PhotozService photozService;
	
	public PhothoController(PhotozService photozService) {
		this.photozService = photozService;
	}
	/*
	 * private Map<String, Photo> db= new HashMap<String, Photo>(){{ put("1",new
	 * Photo("1", "hello.jpg")); }};
	 */
	
	@GetMapping("/hello1")
	public String hello() {
		return "hello world";
	}
		@GetMapping("/photoz")
		public  Collection<Photo> get(){
			return photozService.get();
			
		}
		@GetMapping("/photoz{id}")
		public Photo get(@PathVariable String id) {
			Photo photo=photozService.get(id);
			if(photo==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			return photo;
		}
		@DeleteMapping("/photoz{id}")
		public void del(@PathVariable String id) {
			Photo photo=photozService.remove(id);
			if(photo==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		@PostMapping("/photoz")
		public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
		/*
		 * Photo photo=new Photo(); photo.setId(UUID.randomUUID().toString());
		 * photo.setFileName(file.getOriginalFilename());
		 * photo.setData(file.getBytes());
		 */
			return photozService.put(file.getOriginalFilename(),file.getContentType(), file.getBytes());
			
			
		}
	}


