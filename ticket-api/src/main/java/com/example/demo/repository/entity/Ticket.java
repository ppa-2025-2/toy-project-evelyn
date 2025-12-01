package com.example.demo.repository.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// Banco de Dados -> Entidade
// POO: Programação Orientada a Objetos (POO)
// Entidade: objeto que tem IDENTIDADE (muda com o tempo
// O/R M: Object/Relational Mapping
// Mapeamento Objeto/Relacional
// Problema da Diferença de Representação
// Impedance Mismatch (diferença de impedância)
// Entity: DDD (Domain-Driven Design)

// <<entidade>> -> stereotype -> estereótipo
// Entity -> Metadata
@Entity // anotação/annotation
@Table(name = "tickets")
public class Ticket {

    // creator VARCHAR(255),
    // destinatary VARCHAR(255),
    // technician VARCHAR(255),
    // item VARCHAR(255),
    // to_do VARCHAR(255),
    // details VARCHAR(255),
    // place VARCHAR(255),
    // created_at TIMESTAMP DEFAULT NOW(),
    // updated_at TIMESTAMP,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "creator")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "destinatary")
    private User destinatary;

    @ManyToOne
    @JoinColumn(name = "technician")
    private User technician;

    @Column(nullable = false, length = 255)
    private String item;

    @Column(nullable = false, length = 255)
    private String to_do;

    @Column(nullable = false, length = 255)
    private String details;

    @Column(nullable = false, length = 255)
    private String place;

    @Column(nullable = true)
    private String status = "ANALISE";

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "ticket_observers", 
        joinColumns = @JoinColumn(name = "ticket_id", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "observer_id", referencedColumnName = "ID")
    )
    private Set<User> observers = new HashSet<>();

    @Column(nullable = true)
    private Timestamp created_at = Timestamp.valueOf(LocalDateTime.now());

    @Column(nullable = true)
    private Timestamp updated_at;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getDestinatary() {
        return destinatary;
    }

    public void setDestinatary(User destinatary) {
        this.destinatary = destinatary;
    }

    public User getTechnician() {
        return technician;
    }

    public void setTechnician(User technician) {
        this.technician = technician;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Set<User> getObservers() {
        return observers;
    }

    public void setObservers(Set<User> observers) {
        this.observers = observers;
    }

    public String getTo_do() {
        return to_do;
    }

    public void setTo_do(String to_do) {
        this.to_do = to_do;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

}
