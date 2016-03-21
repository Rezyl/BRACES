package cz.uhk.braces.model.register;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Lukas Rezner
 * Date: 20.3.16
 */
@Entity
@Table
public class RegisterItem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column(unique = true)
	@org.hibernate.annotations.Index(name = "registerItemCodeIndex")
	private String code;
	@Column
	private String name;

	@Column
	@Enumerated(EnumType.STRING)
	@org.hibernate.annotations.Index(name = "registerIndex")
	Register register;

	public RegisterItem() {
	}

	public RegisterItem(String code, String name, Register register) {
		this.code = code;
		this.name = name;
		this.register = register;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Register getRegister() {
		return register;
	}

	public void setRegister(Register register) {
		this.register = register;
	}

	@Override
	public String toString() {
		return "RegisterItem{" +
				"id=" + id +
				", code='" + code + '\'' +
				", name='" + name + '\'' +
				", register=" + register +
				'}';
	}
}
