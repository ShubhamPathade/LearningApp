package mypackage.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mypackage.model.Admin;
import mypackage.repository.AdminRepository;

@Service
public class AdminServices {

	@Autowired
	AdminRepository adminRepo;
	
	// Add New Admin Account Function.
	public Admin AddNewAdmin(Admin am) {
		Admin a=adminRepo.save(am);
		return a;
	}
	// Get All Admin Accounts Function.
	public List<Admin>GetAllAdmins(){
		List<Admin>lst=new ArrayList<Admin>();
		for(Admin am:adminRepo.findAll()) {
			Admin a=new Admin(am.getAdmin_id(), am.getUser_name(), am.getPassword(), am.getFlag());
			lst.add(a);
		}
		return lst;
	}
	// Get Admin By Id Function.
	public Admin GetAdminById(int id) {
		Admin a=adminRepo.findById(id).get();
		Admin am=new Admin(a.getAdmin_id(), a.getUser_name(), a.getPassword(), a.getFlag());
		return am;
	}
	// Update Admin Account Function.
	public Admin UpdateAdmin(Admin am) {
		return adminRepo.save(am);
	}
	// Delete Admin Account By Id Function.
	public Admin DeleteAdmin(int id) {
		Admin a=GetAdminById(id);
		adminRepo.delete(a);
		return a;
	}
	
}
