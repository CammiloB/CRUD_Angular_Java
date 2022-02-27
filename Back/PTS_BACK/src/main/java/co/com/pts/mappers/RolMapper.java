package co.com.pts.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import co.com.pts.models.RolModel;

@Mapper
public interface RolMapper {
	
	@Select("select * from rol")
	List<RolModel> findAll();
	
	@Select("select nombre from rol where id_rol = #{idRol}")
	String findRol(Long idRol); 

}
