package com.javappa.postspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javappa.postspringboot.dto.ItemDTOResponse;
import com.javappa.postspringboot.service.ItemService;

@RestController
@RequestMapping("/api/items")
public class ItemController {

	private ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@PostMapping
	public ResponseEntity<Void> create() throws Exception {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping
	public ResponseEntity<List<ItemDTOResponse>> read() throws Exception {
		return new ResponseEntity<List<ItemDTOResponse>>(itemService.getItems(), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Void> update() throws Exception {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete() throws Exception {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
