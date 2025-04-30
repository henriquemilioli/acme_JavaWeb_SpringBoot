USE Infnet;

INSERT INTO Produto (nome, descricao, preco, dataCadastro)
VALUES
    ('Detergente', 'Detergente líquido pH neutro', 5.50, '2025-01-01'),
    ('Papel A4',    'Pacote com 500 folhas',     25.00, '2025-02-15');

INSERT INTO Cotacao (produto_id, dataCotacao, fornecedor, valor)
VALUES
    (1, '2025-03-10', 'Fornecedor A', 5.40),
    (1, '2025-03-12', 'Fornecedor B', 5.60),
    (2, '2025-03-15', 'Fornecedor C', 24.80);
