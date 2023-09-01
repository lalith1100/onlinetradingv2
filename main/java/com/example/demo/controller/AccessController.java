package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Access;
import com.example.demo.repository.AccessRepository;
import com.example.demo.service.AccessService;

import java.util.List;

@RestController
public class AccessController {

	@Autowired
	AccessService stuService;
	@PostMapping("/addDetails")
	public Access addinfo(@RequestBody Access st) {
		return stuService.saveDetails(st);
	}
	
	@GetMapping("/showDetails")
	public List<Access> fetchDetails(){
		return stuService.getDetails();
	}
	
	private final AccessRepository accessRepository;
	
    @Autowired
    public AccessController(AccessRepository accessRepository) {
        this.accessRepository = accessRepository;
    }

	
    @GetMapping("/{assetId}")
    public Access getAccessByAssetId(@PathVariable Long assetId) {
        return accessRepository.findByAssetId(assetId);
    }
	
	@PutMapping("/updateDetails")
	public Access updateInfo(@RequestBody Access st1) {
		return stuService.updateDetails(st1);
	}
	
	@DeleteMapping("/deleteDetails/{sid}")
	public String deleteInfo(@PathVariable("sid") int sid) {
		stuService.deleteDetails(sid);

		return "Details is Deleted Successfully";
		//return stuService.getDetails();
	  
	}
	
			//sorting
			@GetMapping("/sort/{field}")
			public List<Access> getWithSort(@PathVariable String field) {
				return stuService.getSorted(field);
			}

			// pagination
			@GetMapping("/page/{offset}/{pageSize}")
			public List<Access> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
				return stuService.getWithPagination(offset, pageSize);
			}
			
			// sorting and pagination
			@GetMapping("/page/{offset}/{pageSize}/{field}")
			public List<Access> getWithSortAndPagination(
					@PathVariable int offset, 
					@PathVariable int pageSize,
					@PathVariable String field) {
				return stuService.getWithSortAndPagination(offset, pageSize, field);
				
			}
	
}