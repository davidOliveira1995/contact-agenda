# Agenda de Contatos em Java

Este é um projeto simples de uma **Agenda de Contatos** desenvolvido em Java, focado em demonstrar conceitos fundamentais de Programação Orientada a Objetos (POO), manipulação de coleções (como `ArrayList`) e persistência de dados em arquivos de texto.

---

## 🚀 Funcionalidades

A Agenda de Contatos oferece as seguintes funcionalidades principais:

* **Cadastro de Contatos:** Adicione novos contatos com nome, telefone e e-mail.
* **Listagem de Contatos:** Visualize todos os contatos cadastrados.
* **Busca de Contatos:** Encontre um contato específico pelo nome.
* **Edição de Contatos:** Atualize as informações de um contato existente.
* **Exclusão de Contatos:** Remova contatos da agenda.
* **Persistência de Dados:**
    * **Salvar Contatos:** Grave todos os contatos em um arquivo de texto (`.txt`) para que não sejam perdidos ao fechar o programa.
    * **Carregar Contatos:** Leia os contatos de um arquivo de texto (`.txt`) para restaurar a agenda ao iniciar o programa.

---

## 💻 Como Compilar e Rodar

Para usar este projeto, você precisará ter o **Java Development Kit (JDK)** instalado em sua máquina (versão 8 ou superior é recomendada).

1.  **Clone ou Baixe o Projeto:**
    * Se estiver usando Git, clone o repositório:
        ```bash
        git clone [URL_DO_SEU_REPOSITORIO_AQUI]
        ```
    * Ou baixe o arquivo ZIP do projeto e descompacte-o.

2.  **Abra o Projeto em uma IDE:**
    * Recomendamos usar uma IDE como **IntelliJ IDEA**, **Eclipse** ou **VS Code** com a extensão Java.
    * Importe a pasta do projeto como um projeto Java.

3.  **Compile e Execute:**
    * Navegue até a classe principal que contém o método `main` (provavelmente `Main.java` ou `App.java`).
    * Execute o método `main` diretamente pela sua IDE.

    Alternativamente, via linha de comando (a partir da pasta raiz do projeto, assumindo `Main.java` na raiz de `src`):
    * **Compile:**
        ```bash
        javac -d out src/br/com/david/agenda/model/*.java src/br/com/david/agenda/service/*.java src/Main.java
        ```
        *(Nota: Adapte os caminhos se sua classe principal estiver em outro pacote ou nome.)*
    * **Execute:**
        ```bash
        java -cp out Main
        ```

---

## 📂 Estrutura do Projeto

O projeto é organizado em pacotes para melhor modularidade:

* `src/`: Contém o código fonte Java.
    * `br.com.david.agenda.model`: Pacote para as classes que representam modelos de dados.
        * `Contato.java`: Define a estrutura de um contato (nome, telefone, e-mail).
    * `br.com.david.agenda.service`: Pacote para as classes que contêm a lógica de negócio e as operações da agenda.
        * `Agenda.java`: Gerencia a lista de contatos, incluindo operações de CRUD (Criar, Ler, Atualizar, Deletar) e persistência em arquivo.
    * *(Sua classe principal, como `Main.java` ou `App.java`, estará aqui, talvez no pacote `br.com.david.agenda.app` ou diretamente na raiz de `src`)*

---

## 🛠️ Tecnologias Utilizadas

* **Java SE (Standard Edition)**
* **`java.util.ArrayList`**: Para armazenar os contatos em memória.
* **`java.io.*` e `java.nio.file.*`**: Para operações de leitura e escrita de arquivos de texto.
* **`java.util.Scanner`**: Para interação com o usuário via linha de comando.

---

## 🗺️ Próximos Passos (Evolução do Projeto)

Este projeto pode ser expandido com as seguintes funcionalidades:

* **Interface Gráfica (GUI):** Implementar uma interface de usuário visual usando **JavaFX** para uma experiência mais amigável.
* **Persistência com Banco de Dados:** Substituir o salvamento em arquivo de texto por um banco de dados (como **MySQL** ou **SQLite**) para um gerenciamento de dados mais robusto e escalável.
* **Tratamento de Exceções Mais Avançado:** Aprimorar o tratamento de erros e validação de entrada do usuário.
* **Busca Avançada:** Permitir buscar cont
