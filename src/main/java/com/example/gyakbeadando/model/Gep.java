package com.example.gyakbeadando.model;

import jakarta.persistence.*;

@Entity
public class Gep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // ezt a DB generálja

    private String gyarto;
    private String tipus;
    private Double kijelzo;         // "15,6" -> 15.6
    private Integer memoria;        // MiB
    private Integer merevlemez;     // GB
    private String videovezerlo;
    private Integer ar;             // HUF
    private Integer dbMennyiseg;    // "db" oszlop

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Processzor processzor;  // fk: processzorid

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Oprendszer oprendszer;  // fk: oprendszerid

    public Gep() {}

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getGyarto() { return gyarto; }
    public void setGyarto(String gyarto) { this.gyarto = gyarto; }
    public String getTipus() { return tipus; }
    public void setTipus(String tipus) { this.tipus = tipus; }
    public Double getKijelzo() { return kijelzo; }
    public void setKijelzo(Double kijelzo) { this.kijelzo = kijelzo; }
    public Integer getMemoria() { return memoria; }
    public void setMemoria(Integer memoria) { this.memoria = memoria; }
    public Integer getMerevlemez() { return merevlemez; }
    public void setMerevlemez(Integer merevlemez) { this.merevlemez = merevlemez; }
    public String getVideovezerlo() { return videovezerlo; }
    public void setVideovezerlo(String videovezerlo) { this.videovezerlo = videovezerlo; }
    public Integer getAr() { return ar; }
    public void setAr(Integer ar) { this.ar = ar; }
    public Integer getDbMennyiseg() { return dbMennyiseg; }
    public void setDbMennyiseg(Integer dbMennyiseg) { this.dbMennyiseg = dbMennyiseg; }
    public Processzor getProcesszor() { return processzor; }
    public void setProcesszor(Processzor processzor) { this.processzor = processzor; }
    public Oprendszer getOprendszer() { return oprendszer; }
    public void setOprendszer(Oprendszer oprendszer) { this.oprendszer = oprendszer; }
}
