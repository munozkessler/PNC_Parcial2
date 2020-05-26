package com.uca.capas.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema="public",name="cat_libro")
public class Libro {
	
	@Id
	@GeneratedValue(generator="cat_libro_c_libro_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "cat_libro_c_libro_seq", sequenceName = "public.cat_libro_c_libro_seq", allocationSize = 1)
	@Column(name="c_libro")
	private Integer c_libro;
	
	@Column(name="s_titulo")
	@Size(max=500,message="El campo sobrepasa la cantidad de 500 caracteres")
	@NotEmpty(message="El campo no puede estar vacio")
	private String s_titulo;
	
	@Column(name="s_autor")
	@Size(max=150,message="El campo sobrepasa la cantidad de 150 caracteres")
	@NotEmpty(message="El campo no puede estar vacio")
	private String s_autor;
	
	@Column(name="s_isbn")
	@Size(max=10,message="El campo sobrepasa la cantidad de 10 caracteres")
	@NotEmpty(message="El campo no puede estar vacio")
	private String s_isbn;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "c_categoria")
    private Categoria categoria;
	
	@Transient
	private Integer c_categoriafk;
	
	@Column(name="f_ingreso")
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm aa")
	@Temporal(TemporalType.DATE)
	private Date f_ingreso;
	
	public String getS_isbn() {
		return s_isbn;
	}

	public void setS_isbn(String s_isbn) {
		this.s_isbn = s_isbn;
	}
	
	private Boolean b_estado;
	
	public Boolean getB_estado() {
		return b_estado;
	}

	public void setB_estado(Boolean b_estado) {
		this.b_estado = b_estado;
	}

	public Integer getC_categoriafk() {
		return c_categoriafk;
	}

	public void setC_categoriafk(Integer c_categoriafk) {
		this.c_categoriafk = c_categoriafk;
	}

	public Libro() {
		super();
	}

	public Integer getC_libro() {
		return c_libro;
	}

	public void setC_libro(Integer c_libro) {
		this.c_libro = c_libro;
	}

	public String getS_titulo() {
		return s_titulo;
	}

	public void setS_titulo(String s_titulo) {
		this.s_titulo = s_titulo;
	}

	public String getS_autor() {
		return s_autor;
	}

	public void setS_autor(String s_autor) {
		this.s_autor = s_autor;
	}


	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Date getF_ingreso() {
		return f_ingreso;
	}

	public void setF_ingreso(Date f_ingreso) {
		this.f_ingreso = f_ingreso;
	} 
	
	public String getFechaIngresoDelegate(){
		if(this.f_ingreso == null){
			return "";
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
			String shortdate = sdf.format(this.f_ingreso.getTime());
			return shortdate;
		}
	}

}