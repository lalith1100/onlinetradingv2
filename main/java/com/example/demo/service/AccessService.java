package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Access;
import com.example.demo.repository.AccessRepository;
import java.util.List;

@Service
public class AccessService {
	@Autowired
	AccessRepository stRepo;
	
	public Access saveDetails(Access e)
	{
		return stRepo.save(e);
	}
	
	public List<Access> getDetails(){
		return stRepo.findAll();
	}
	
	public Access updateDetails(Access e1)
	{
		return stRepo.saveAndFlush(e1);
	}
	
	public void deleteDetails(long Id)
	{
		stRepo.deleteById(Id);
	}
	
	public List<Access> getSorted(String field) {
		return stRepo.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public List<Access> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
		Page<Access> page =stRepo.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	public List<Access> getWithSortAndPagination(int offset, int pageSize, String field) {
	    PageRequest pageRequest = PageRequest.of(offset, pageSize, Sort.by(field));
	    Page<Access> page = stRepo.findAll(pageRequest);
	    return page.getContent();
	}

	
}
