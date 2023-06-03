package mypackage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mypackage.model.Admin;
import mypackage.services.AdminServices;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = "*")
public class AdminController {

	@Autowired
	AdminServices adminServices;
	
	@GetMapping("api/admin/{id}")
	public Admin GetAdminById(@PathVariable("id")int id) {
		return adminServices.GetAdminById(id);
	}
	
	@GetMapping("api/admin")
	public List<Admin>GetAllAdmins(){
		return adminServices.GetAllAdmins();
	}
	
	@PostMapping("api/admin")
	public Admin AddNewAdmin(@RequestBody Admin admin) {
		return adminServices.AddNewAdmin(admin);
	}
	
	@PutMapping("api/admin")
	public Admin UpdateAdmin(@RequestBody Admin admin) {
		return adminServices.UpdateAdmin(admin);
	}
	
	@DeleteMapping("api/admin/{id}")
	public Admin DeleteAdmin(@PathVariable("id")int id) {
		return adminServices.DeleteAdmin(id);
	}
}
