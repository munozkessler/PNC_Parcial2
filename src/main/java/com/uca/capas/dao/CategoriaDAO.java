package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Categoria;

public interface CategoriaDAO {

	public List<Categoria> findAll() throws DataAccessException;

	public Categoria findOne(Integer code) throws DataAccessException;
	
	public void save(Categoria categoria) throws DataAccessException;
	
	
}
