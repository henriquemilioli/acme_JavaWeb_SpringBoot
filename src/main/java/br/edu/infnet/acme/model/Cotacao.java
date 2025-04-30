package br.edu.infnet.acme.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Cotacao")
public class Cotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Produto é obrigatório")
    @ManyToOne(fetch = FetchType.LAZY) //estabele a FK de produto_id
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @NotNull(message = "Data de cotação é obrigatória")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dataCotacao", nullable = false)
    private LocalDate dataCotacao;

    @NotBlank(message = "Fornecedor é obrigatório")
    @Size(max = 100, message = "Fornecedor deve ter até 100 caracteres")
    @Column(nullable = false, length = 100)
    private String fornecedor;

    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.01", message = "Valor deve ser positivo")
    @Digits(integer = 8, fraction = 2, message = "Formato inválido para valor")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    public Cotacao() {}

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}

    public Produto getProduto() {return produto;}
    public void setProduto(Produto produto) {this.produto = produto;}

    public LocalDate getDataCotacao() {return dataCotacao;}
    public void setDataCotacao(LocalDate dataCotacao) {this.dataCotacao = dataCotacao;}

    public String getFornecedor() {return fornecedor;}
    public void setFornecedor(String fornecedor) { this.fornecedor = fornecedor;}

    public BigDecimal getValor() {return valor;}
    public void setValor(BigDecimal valor) {this.valor = valor;}
}
