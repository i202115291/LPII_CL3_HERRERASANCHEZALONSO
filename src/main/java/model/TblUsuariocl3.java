package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_usuariocl3 database table.
 * 
 */
@Entity
@Table(name="tbl_usuariocl3")
@NamedQuery(name="TblUsuariocl3.findAll", query="SELECT t FROM TblUsuariocl3 t")
public class TblUsuariocl3 implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idusuariocl3;

	private String passwordcl3;

	private String usuariocl3;

	public TblUsuariocl3() {
	}

	public int getIdusuariocl3() {
		return this.idusuariocl3;
	}

	public void setIdusuariocl3(int idusuariocl3) {
		this.idusuariocl3 = idusuariocl3;
	}

	public String getPasswordcl3() {
		return this.passwordcl3;
	}

	public void setPasswordcl3(String passwordcl3) {
		this.passwordcl3 = passwordcl3;
	}

	public String getUsuariocl3() {
		return this.usuariocl3;
	}

	public void setUsuariocl3(String usuariocl3) {
		this.usuariocl3 = usuariocl3;
	}

}