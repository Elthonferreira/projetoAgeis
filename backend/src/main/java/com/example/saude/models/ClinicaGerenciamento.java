package com.example.saude.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clinicaGerenciamento")
public class ClinicaGerenciamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public ClinicaGerenciamento() {
        super();
    }

    public ClinicaGerenciamento(Long id) {
        super();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
