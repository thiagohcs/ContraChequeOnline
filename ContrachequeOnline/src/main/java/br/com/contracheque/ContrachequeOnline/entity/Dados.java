package br.com.contracheque.ContrachequeOnline.entity;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Dados
 *
 */
@Entity

public class Dados implements Serializable {

	   
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 7)
	private String folhaCompetencia;
	
	@Column(nullable = false, length = 11)
	private String cpfFuncionario;
	
	@Column(nullable = false, length = 150)
	private String nomeCompleto;
	
	@Column(nullable = false)
	private int tipoCodigo;
	
	@Column(nullable = false, length = 150)
	private String descricao;
	
	@Column(nullable = false)
	private double salario;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dtNascimento;
	
	@Column(nullable = false, length = 30)
	private String cargo;
	
	@Column(nullable = false)
	private double folhaValor;
	
	private static final long serialVersionUID = 1L;

	public Dados() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getFolhaCompetencia() {
		return this.folhaCompetencia;
	}

	public void setFolhaCompetencia(String folhaCompetencia) {
		this.folhaCompetencia = folhaCompetencia;
	}   
	public String getCpfFuncionario() {
		return this.cpfFuncionario;
	}

	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}   
	public String getNomeCompleto() {
		return this.nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}   
	public int getTipoCodigo() {
		return this.tipoCodigo;
	}

	public void setTipoCodigo(int tipoCodigo) {
		this.tipoCodigo = tipoCodigo;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}   
	public Date getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}   
	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}   
	public double getFolhaValor() {
		return this.folhaValor;
	}

	public void setFolhaValor(double folhaValor) {
		this.folhaValor = folhaValor;
	}
   
}
