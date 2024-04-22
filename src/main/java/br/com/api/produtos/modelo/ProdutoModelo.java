package br.com.api.produtos.modelo;

import javax.print.DocFlavor.STRING;

import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings({ "unused", "deprecation" })
@Entity
@Table(name= "produtos")
@Getter
@Setter

public class ProdutoModelo {

    @SuppressWarnings("deprecation")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotFound
    @NotNull
    @JsonIgnore
    private Long codigo;
    private String nome;
    private String marca;
    
}
