package com.uca.capas.dao;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO{
	
	@PersistenceContext(unitName="parcial2")
	private EntityManager entityManager;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb =  new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query  query = entityManager.createNativeQuery(sb.toString(),Libro.class);
		List<Libro>resultset=query.getResultList();
		return resultset;
	}

	@Override
	public Libro findOne(Integer code) throws DataAccessException {
		Libro libro = entityManager.find(Libro.class,code);
		return libro;
	}

	@Override
	@Transactional
	public void save(Libro libro) throws DataAccessException {
		try {
			if(libro.getC_libro() == null) 
			{
				long millis=System.currentTimeMillis();  
				libro.setF_ingreso(new Timestamp(Calendar.getInstance().getTime().getTime()));
				entityManager.persist(libro);
			}
			else 
			{
				entityManager.merge(libro);
				entityManager.flush();
			}
		}catch(Throwable e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void delete(Integer codigo) throws DataAccessException {
		Libro libro = entityManager.find(Libro.class, codigo);
		entityManager.remove(libro);
		
	}

}
