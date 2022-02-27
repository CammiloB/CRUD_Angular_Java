package co.com.pts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.pts.mappers.RolMapper;
import co.com.pts.models.RolModel;

@RestController
public class RolServices {
	
	@Autowired
	RolMapper rolMapper;
	
	@CrossOrigin
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ResponseEntity<List<RolModel>> getUsers(){
		List<RolModel> roles = rolMapper.findAll();
		return new ResponseEntity<List<RolModel>>(roles, HttpStatus.OK);
	}

}
