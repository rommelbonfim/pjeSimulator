package com.icev.pjesimulator.dto;

import com.icev.pjesimulator.models.Profile;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProfileDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    
    @NotNull(message = "Nome não pode ser vazio") @NotEmpty
    private String name;
    
    @Email @NotNull(message = "Email não pode ser vazio") @NotEmpty
    private String email;
    
    @NotNull(message = "Período não pode ser vazio") @NotEmpty
    private String period;
    
    private String registrationNumber;
    
    @NotNull(message = "Cpf não pode ser vazio") @NotEmpty
    private String cpf;
    
    @NotNull(message = "Senha não pode ser vazia") @NotEmpty
    private String password;

    public ProfileDto(Long id, String name, String email, String period, String registrationNumber, String cpf, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.period = period;
        this.registrationNumber = registrationNumber;
        this.cpf = cpf;
        this.password = password;
    }
    public ProfileDto(Profile entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.period = entity.getPeriod();
        this.registrationNumber = entity.getRegistrationNumber();
        this.cpf = entity.getCpf();
        this.password = entity.getPassword();
    }
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPeriod() {
		return period;
	}
	
	public void setPeriod(String period) {
		this.period = period;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileDto entity = (ProfileDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.cpf, entity.cpf) &&
                Objects.equals(this.password, entity.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, password);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "cpf = " + cpf + ", " +
                "password = " + password + ")";
    }
}
