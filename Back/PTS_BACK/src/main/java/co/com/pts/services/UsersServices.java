package co.com.pts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.pts.mappers.RolMapper;
import co.com.pts.mappers.UsuariosMapper;
import co.com.pts.models.DeleteResponse;
import co.com.pts.models.UsuarioModel;

@RestController
public class UsersServices {

	@Autowired
	UsuariosMapper usuariosMapper;

	@Autowired
	RolMapper rolMapper;

	@CrossOrigin
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioModel>> getUsers() {
		List<UsuarioModel> users = usuariosMapper.findAll();
		for (UsuarioModel user : users) {
			user.setRol(rolMapper.findRol(user.getId_rol()));
		}
		return new ResponseEntity<List<UsuarioModel>>(users, HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<UsuarioModel> addUser(@RequestBody UsuarioModel usuario) {
		List<UsuarioModel> users = usuariosMapper.getUser(usuario);
		if (users.size() == 0) {
			usuariosMapper.addUser(usuario);
			return new ResponseEntity<UsuarioModel>(usuario, HttpStatus.OK);
		}
		return new ResponseEntity<UsuarioModel>(usuario, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@CrossOrigin
	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public ResponseEntity<UsuarioModel> updateUser(@RequestBody UsuarioModel usuario) {

		usuariosMapper.updateUser(usuario);
		return new ResponseEntity<UsuarioModel>(usuario, HttpStatus.OK);

	}

	@CrossOrigin
	@RequestMapping(value = "/users", method = RequestMethod.DELETE)
	public ResponseEntity<DeleteResponse> deleteUser(@RequestParam int id) {
		usuariosMapper.deleteUser(id);
		DeleteResponse response = new DeleteResponse();
		response.setResponse("Usuario Borrado!");
		return new ResponseEntity<DeleteResponse>(response, HttpStatus.OK);
	}
}
