-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 12/09/2024 às 03:07
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_mercado`
--
CREATE DATABASE IF NOT EXISTS `db_mercado` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `db_mercado`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `cargo`
--

CREATE TABLE `cargo` (
  `Cod_Cargo` int(11) NOT NULL,
  `Nome_Cargo` varchar(50) NOT NULL,
  `Desc_Cargo` varchar(255) NOT NULL,
  `Salario_Cargo` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cargo`
--

INSERT INTO `cargo` (`Cod_Cargo`, `Nome_Cargo`, `Desc_Cargo`, `Salario_Cargo`) VALUES
(1, 'Dono / Admnistrador', 'Dono do mercado, possui permissão para todo o sistema', 20000),
(2, 'Gerente', 'Capaz de gerenciar estoque, compras e clientes do minimercado', 10000),
(3, 'Operador de Caixa', 'Possui permissão para administrar Compras e cadastrar clientes no sistema', 2200);

-- --------------------------------------------------------

--
-- Estrutura para tabela `categoria_produto`
--

CREATE TABLE `categoria_produto` (
  `Cod_Categoria` int(11) NOT NULL,
  `Nome_Categoria` varchar(50) NOT NULL,
  `Desc_Categoria` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE `cliente` (
  `Cod_Cli` int(11) NOT NULL,
  `Nome_Cli` varchar(255) NOT NULL,
  `Ativo_Clube` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `clube_fidelidade`
--

CREATE TABLE `clube_fidelidade` (
  `Cod_Cli` int(11) NOT NULL,
  `CPF_Clube` varchar(11) NOT NULL,
  `Email_Clube` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `compra`
--

CREATE TABLE `compra` (
  `Cod_Compra` int(11) NOT NULL,
  `Cod_Func` int(11) NOT NULL,
  `Cod_Cli` int(11) NOT NULL,
  `Data_Compra` datetime NOT NULL,
  `Cod_Forma_Pag` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `fone_cli`
--

CREATE TABLE `fone_cli` (
  `Cod_Cli` int(11) NOT NULL,
  `Fone_Cli` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `fone_func`
--

CREATE TABLE `fone_func` (
  `Cod_Func` int(11) NOT NULL,
  `Fone_Func` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `forma_pag`
--

CREATE TABLE `forma_pag` (
  `Cod_Forma_Pag` int(11) NOT NULL,
  `Nome_Forma` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `Cod_Forn` int(11) NOT NULL,
  `Nome_Fantasia` varchar(100) NOT NULL,
  `CNPJ_Forn` varchar(14) NOT NULL,
  `Fone_Forn` varchar(11) NOT NULL,
  `Email_Forn` varchar(50) NOT NULL,
  `Nome_Resp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `Cod_Func` int(11) NOT NULL,
  `Nome_Func` varchar(255) NOT NULL,
  `Nasc_Func` date NOT NULL,
  `CPF_Func` varchar(11) NOT NULL,
  `Cod_Cargo` int(11) NOT NULL,
  `Email_Func` varchar(50) NOT NULL,
  `Senha_Func` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `funcionario`
--

INSERT INTO `funcionario` (`Cod_Func`, `Nome_Func`, `Nasc_Func`, `CPF_Func`, `Cod_Cargo`, `Email_Func`, `Senha_Func`) VALUES
(1, 'Luiz Gabriel Ferreira', '2008-01-25', '55555555555', 1, 'luiz.ferreira@nexo.com.br', 'admin'),
(2, 'Rebeca de Moura Mendes', '2008-01-25', '44444444444', 1, 'rebeca.moura@nexo.com.br', 'admin'),
(3, 'Vitor Daisuke Iwamoto', '2008-01-25', '33333333333', 1, 'vitor.iwamoto@nexo.com.br', 'admin'),
(4, 'Gerente Teste', '2008-01-25', '11111111111', 2, 'gerente.teste@nexo.com.br', 'gerente'),
(5, 'Operador de Caixa Teste', '2008-01-25', '99999999999', 3, 'operador.teste@nexo.com.br', 'operador');

-- --------------------------------------------------------

--
-- Estrutura para tabela `marca`
--

CREATE TABLE `marca` (
  `Cod_Marca` int(11) NOT NULL,
  `Nome_Marca` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `produto`
--

CREATE TABLE `produto` (
  `Cod_Prod` int(11) NOT NULL,
  `Nome_Prod` varchar(255) NOT NULL,
  `Preco_Prod` float NOT NULL,
  `Quant_Estoque` int(11) NOT NULL,
  `Cod_Forn` int(11) NOT NULL,
  `Cod_Marca` int(11) NOT NULL,
  `Cod_Categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `prod_compra`
--

CREATE TABLE `prod_compra` (
  `Cod_Compra` int(11) NOT NULL,
  `Cod_Prod` int(11) NOT NULL,
  `Quant_Prod` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`Cod_Cargo`);

--
-- Índices de tabela `categoria_produto`
--
ALTER TABLE `categoria_produto`
  ADD PRIMARY KEY (`Cod_Categoria`);

--
-- Índices de tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Cod_Cli`);

--
-- Índices de tabela `clube_fidelidade`
--
ALTER TABLE `clube_fidelidade`
  ADD UNIQUE KEY `CPF_Clube` (`CPF_Clube`),
  ADD KEY `Cod_Cli` (`Cod_Cli`);

--
-- Índices de tabela `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`Cod_Compra`),
  ADD KEY `Cod_Cli` (`Cod_Cli`),
  ADD KEY `Cod_Func` (`Cod_Func`),
  ADD KEY `Cod_Forma_Pag` (`Cod_Forma_Pag`);

--
-- Índices de tabela `fone_cli`
--
ALTER TABLE `fone_cli`
  ADD KEY `Cod_Cli` (`Cod_Cli`);

--
-- Índices de tabela `fone_func`
--
ALTER TABLE `fone_func`
  ADD KEY `Cod_Func` (`Cod_Func`);

--
-- Índices de tabela `forma_pag`
--
ALTER TABLE `forma_pag`
  ADD PRIMARY KEY (`Cod_Forma_Pag`);

--
-- Índices de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`Cod_Forn`);

--
-- Índices de tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`Cod_Func`),
  ADD UNIQUE KEY `cpf_func` (`CPF_Func`),
  ADD KEY `Cod_Cargo` (`Cod_Cargo`);

--
-- Índices de tabela `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`Cod_Marca`);

--
-- Índices de tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`Cod_Prod`),
  ADD KEY `Cod_Forn` (`Cod_Forn`),
  ADD KEY `Cod_Marca` (`Cod_Marca`),
  ADD KEY `Cod_Categoria` (`Cod_Categoria`);

--
-- Índices de tabela `prod_compra`
--
ALTER TABLE `prod_compra`
  ADD KEY `Cod_Compra` (`Cod_Compra`),
  ADD KEY `Cod_Prod` (`Cod_Prod`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cargo`
--
ALTER TABLE `cargo`
  MODIFY `Cod_Cargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `categoria_produto`
--
ALTER TABLE `categoria_produto`
  MODIFY `Cod_Categoria` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `Cod_Cli` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `compra`
--
ALTER TABLE `compra`
  MODIFY `Cod_Compra` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `forma_pag`
--
ALTER TABLE `forma_pag`
  MODIFY `Cod_Forma_Pag` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `Cod_Forn` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `Cod_Func` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `marca`
--
ALTER TABLE `marca`
  MODIFY `Cod_Marca` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `Cod_Prod` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `clube_fidelidade`
--
ALTER TABLE `clube_fidelidade`
  ADD CONSTRAINT `clube_fidelidade_ibfk_1` FOREIGN KEY (`Cod_Cli`) REFERENCES `cliente` (`Cod_Cli`);

--
-- Restrições para tabelas `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`Cod_Cli`) REFERENCES `cliente` (`Cod_Cli`),
  ADD CONSTRAINT `compra_ibfk_2` FOREIGN KEY (`Cod_Func`) REFERENCES `funcionario` (`Cod_Func`),
  ADD CONSTRAINT `compra_ibfk_3` FOREIGN KEY (`Cod_Forma_Pag`) REFERENCES `forma_pag` (`Cod_Forma_Pag`);

--
-- Restrições para tabelas `fone_cli`
--
ALTER TABLE `fone_cli`
  ADD CONSTRAINT `fone_cli_ibfk_1` FOREIGN KEY (`Cod_Cli`) REFERENCES `cliente` (`Cod_Cli`);

--
-- Restrições para tabelas `fone_func`
--
ALTER TABLE `fone_func`
  ADD CONSTRAINT `fone_func_ibfk_1` FOREIGN KEY (`Cod_Func`) REFERENCES `funcionario` (`Cod_Func`);

--
-- Restrições para tabelas `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`Cod_Cargo`) REFERENCES `cargo` (`Cod_Cargo`);

--
-- Restrições para tabelas `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`Cod_Forn`) REFERENCES `fornecedor` (`Cod_Forn`),
  ADD CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`Cod_Marca`) REFERENCES `marca` (`Cod_Marca`),
  ADD CONSTRAINT `produto_ibfk_3` FOREIGN KEY (`Cod_Categoria`) REFERENCES `categoria_produto` (`Cod_Categoria`);

--
-- Restrições para tabelas `prod_compra`
--
ALTER TABLE `prod_compra`
  ADD CONSTRAINT `prod_compra_ibfk_1` FOREIGN KEY (`Cod_Compra`) REFERENCES `compra` (`Cod_Compra`),
  ADD CONSTRAINT `prod_compra_ibfk_2` FOREIGN KEY (`Cod_Prod`) REFERENCES `produto` (`Cod_Prod`);
