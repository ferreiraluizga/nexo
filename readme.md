<p align="center">
    <img src="https://skillicons.dev/icons?i=php,html,css,js,bootstrap,mysql"/>
</p>

<h1 align="center">Sistema de Gerenciamento de Estoque</h1>

### ℹ Sobre o Sistema
O Website do **NEXO** foi projetado para aproximar o cliente do minimercado, possibilitando seu cadastro no **NEXOClub** e também para funções internas de gerenciamento de estoque. Assim como na aplicação desktop, a geração de relatórios é uma das principais funcionalidades do sistema.

> Para maiores detalhes sobre o projeto, baixe a [documentação](https://github.com/user-attachments/files/17747624/doc_nexo.pdf)

## 💻 Requisitos Mínimos

Verifique se você atende aos requisitos antes de instalar o projeto:
- Sistema Operacional: `Windows 10 ou 11`
- Conexão à Internet: `Sim`
- Armazenamento: mínimo de `2GB` disponíveis
- Gerenciamento do Banco de Dados e Servidor Local: `XAMPP 8.2`

## 🚀 Instalação

Siga os passos abaixo para instalar de forma correta:

1. Baixe o arquivo ZIP desta branch ou clone o repositório em sua máquina:
```
git clone -b web_app https://github.com/ferreiraluizga/nexo.git
```

2. Em seu `PHPMyAdmin`, importe o banco de dados contido no diretório `src/sql_database`
```
Para uma instalação limpa, importe database_query.sql e para uma análise com
dados já inseridos, importe database_query_with_inserts.sql.
```

3. Coloque a pasta do repositório no diretório `xampp/htdocs` e mude o nome da pasta para `nexo`

4. Em seu navegador digite a URL `localhost/nexo` e execute o arquivo `nexo_desktopApp.jar` ou abra o projeto em sua IDE - recomenda-se o `Apache NetBeans 22`

Após esses passos concluídos, a aplicação está pronta para uso
> Para que a aplicação funcione corretamente, é necessário manter os serviços `Apache` e `MySql` do XAMPP ativos

## 📷 Screenshots

![desktop-image](https://github.com/user-attachments/assets/f5934724-78eb-45af-badf-9b93cdd3dfc0)
![Imagem 1](https://github.com/user-attachments/assets/579789cf-3412-4e5d-9aea-21dd040c9844)
![Imagem 2](https://github.com/user-attachments/assets/c92c1df7-34be-40c7-8dd4-dc738d5d4d41)

## 🛠️ Desenvolvedores

<table border="0" style="border-collapse: collapse;">
  <tr>
    <td align="center" style="border: none;">
      <a href="#">
        <img src="https://placehold.co/100x100" width="100px" style="border-radius: 50%;" alt="Placeholder"/><br>
        <sub>
          <b>Luiz Gabriel Ferreira</b>
        </sub>
      </a>
    </td>
    <td align="center" style="border: none;">
      <a href="#">
        <img src="https://github.com/user-attachments/assets/38f7f200-6a5a-47e6-b365-9f3c4651db4d" width="100px" style="border-radius: 50%;" alt="Placeholder"/><br>
        <sub>
          <b>Rebeca de Moura Mendes</b>
        </sub>
      </a>
    </td>
    <td align="center" style="border: none;">
      <a href="#">
        <img src="https://placehold.co/100x100" width="100px" style="border-radius: 50%;" alt="Placeholder"/><br>
        <sub>
          <b>Vitor Daisuke Iwamoto</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
