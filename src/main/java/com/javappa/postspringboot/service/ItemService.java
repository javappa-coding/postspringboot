package com.javappa.postspringboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javappa.postspringboot.dto.ItemDTOResponse;

@Service
public interface ItemService {

	List<ItemDTOResponse> getItems();
}
