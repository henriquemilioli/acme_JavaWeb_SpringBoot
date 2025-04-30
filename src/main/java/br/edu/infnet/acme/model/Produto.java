package br.edu.infnet.acme.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Produto") //Marca a classe como tabela do banco
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremento da chave primaria
    private int id;

    // @ com as validações de formulario para validação com msgs claras
    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter até 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @Size(max = 255, message = "Descrição deve ter até 255 caracteres")
    @Column(length = 255)
    private String descricao;

    @NotNull(message = "Preço é obrigatório")
    @DecimalMin(value = "0.01", message = "Preço deve ser positivo")
    @Digits(integer = 8, fraction = 2, message = "Formato inválido para preço")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    @NotNull(message = "Data de cadastro é obrigatória")
    @PastOrPresent(message = "Data de cadastro não pode ser futura")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dataCadastro", nullable = false)
    private LocalDate dataCadastro;

    public Produto() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro (LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }

}
