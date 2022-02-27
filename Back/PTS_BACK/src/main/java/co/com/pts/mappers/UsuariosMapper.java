package co.com.pts.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import co.com.pts.models.UsuarioModel;

@Mapper
public interface UsuariosMapper {

	@Select("select * from usuario")
	List<UsuarioModel> findAll();
	
	@Select("select * from usuario WHERE usuario.nombre = #{nombre}")
	List<UsuarioModel> getUser(UsuarioModel user);
	
	@Insert("INSERT INTO usuario(id_rol, nombre, activo) VALUES (#{id_rol}, #{nombre}, #{activo})")
	void addUser(UsuarioModel user);
	
	@Update("UPDATE usuario SET id_rol = #{id_rol}, nombre = #{nombre}, activo = #{activo}"
			+ "WHERE usuario.id_usuario = #{id_usuario}")
	void updateUser(UsuarioModel user);
	
	@Delete("DELETE FROM usuario WHERE usuario.id_usuario = #{id}")
	void deleteUser(int id);
	
}
