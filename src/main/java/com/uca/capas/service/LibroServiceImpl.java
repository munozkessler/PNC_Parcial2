package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	LibroDAO libroDao;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDao.findAll();
	}

	@Override
	@Transactional
	public void save(Libro libro) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDao.save(libro);
	}

	@Override
	@Transactional
	public void delete(Integer codigo) throws DataAccessException {
		libroDao.delete(codigo);
		
	}

} 	 
