CREATE DATABASE IF NOT EXISTS Infnet
  CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE Infnet;

CREATE TABLE Produto (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         descricao VARCHAR(255),
                         preco DECIMAL(10,2) NOT NULL,
                         dataCadastro DATE NOT NULL
);

CREATE TABLE Cotacao (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         produto_id INT NOT NULL,
                         dataCotacao DATE NOT NULL,
                         fornecedor VARCHAR(100) NOT NULL,
                         valor DECIMAL(10,2) NOT NULL,
                         FOREIGN KEY (produto_id)
                             REFERENCES Produto(id) ON DELETE CASCADE
);
