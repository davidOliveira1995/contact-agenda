package br.com.david.agenda.service;

import br.com.david.agenda.model.Contato;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Contato> contatos = new ArrayList<>();

    public Agenda() {
    }

    public Agenda(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public void cadastrarContato(String nome, String telefone, String email) {
        Contato novoContato = new Contato(nome, telefone, email);

        this.contatos.add(novoContato);

        System.out.println("Contato " + nome + " cadastrado com sucesso!");
    }

    public List<Contato> listarContatos() {

        System.out.println("===> ***** Lista de Contatos ***** <===");
        for (Contato contato : this.contatos) {
            System.out.println(contato);
        }
        return this.contatos;
    }

    public Contato buscarContatoPorNome(String nome) {
        for (Contato contatoAtual : this.contatos) {
            if(contatoAtual.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Contato encontrado " + contatoAtual.getNome());
                return contatoAtual;
            }
        }
        System.out.println("Contato com o nome " + nome + " não encontrado.");
        return null;
    }

    public boolean editarContato(String nomeAntigo, String novoNome, String novoTelefone, String novoEmail) {

        Contato contatoParaEditar = buscarContatoPorNome(nomeAntigo);

        if (contatoParaEditar != null) {
            contatoParaEditar.setNome(novoNome);
            contatoParaEditar.setTelefone(novoTelefone);
            contatoParaEditar.setEmail(novoEmail);

            System.out.println("Contato de '" + nomeAntigo + "' editado para '" + novoNome + "' com sucesso!");
            return true;
        }

        System.out.println("O contato de " + nomeAntigo + " não foi encontrado!");
        return false;
    }

    public boolean excluirContato(String nome) {

        Contato excluirContatoSelecionado = buscarContatoPorNome(nome);

        if(excluirContatoSelecionado != null) {
            contatos.remove(excluirContatoSelecionado);

            System.out.println("O contato '" + nome + "' foi deletado com sucesso!");
            return true;
        }
        System.out.println("O contato '" + nome + "' não foi encontrado na agenda!");
        return false;
    }

    public void salvarContatos(String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)){

            for (Contato contato : this.contatos) {
                String linhaContato = "Nome: " + contato.getNome() + "\nTelefone: " + contato.getTelefone()
                        + "\nEmail: " + contato.getEmail() + "\n";
                writer.write(linhaContato);
                writer.write(System.lineSeparator());
            }
            System.out.println("Contatos salvos com sucesso em '" + nomeArquivo + "'!");

        } catch (IOException e) {
            System.err.println("Erro ao salvar contatos em '" + nomeArquivo
            + "'!");
            e.printStackTrace();
        }
    }

    public void carregarContatos(String nomeArquivo) {

        Path caminhoDoArquivo = Paths.get(nomeArquivo);
        this.contatos.clear(); // Limpa a lista existente antes de carregar

        try {
            List<String> linhasDoArquivo = Files.readAllLines(caminhoDoArquivo);

            String nomeTemp = null;
            String telefoneTemp = null;
            String emailTemp = null;

            // Percorre cada linha lida do arquivo
            for (String linha : linhasDoArquivo) {
                // Remove espaços em branco do início e fim da linha e verifica se não está vazia
                linha = linha.trim();
                if (linha.isEmpty()) {
                    // Se a linha for vazia, significa que pode ser um separador entre contatos
                    // Se já temos um contato parcialmente montado, adicionamos ele
                    if (nomeTemp != null && telefoneTemp != null && emailTemp != null) {
                        this.contatos.add(new Contato(nomeTemp, telefoneTemp, emailTemp));
                        // Reseta as variáveis temporárias para o próximo contato
                        nomeTemp = null;
                        telefoneTemp = null;
                        emailTemp = null;
                    }
                    continue; // Pula para a próxima linha
                }

                // Verifica e extrai as informações com base nos rótulos
                if (linha.startsWith("Nome:")) {
                    nomeTemp = linha.substring("Nome:".length()).trim();
                } else if (linha.startsWith("Telefone:")) {
                    telefoneTemp = linha.substring("Telefone:".length()).trim();
                } else if (linha.startsWith("Email:")) {
                    emailTemp = linha.substring("Email:".length()).trim();
                } else {
                    System.err.println("Atenção: Linha do arquivo não reconhecida e ignorada: " + linha);
                }

                // Se todas as partes de um contato foram coletadas, cria e adiciona o Contato
                if (nomeTemp != null && telefoneTemp != null && emailTemp != null) {
                    this.contatos.add(new Contato(nomeTemp, telefoneTemp, emailTemp));
                    // Reseta as variáveis temporárias para o próximo contato
                    nomeTemp = null;
                    telefoneTemp = null;
                    emailTemp = null;
                }
            }

            // Verifica se há um contato "pendente" após a última linha do arquivo
            if (nomeTemp != null && telefoneTemp != null && emailTemp != null) {
                this.contatos.add(new Contato(nomeTemp, telefoneTemp, emailTemp));
            }

            System.out.println("Contatos carregados com sucesso de '" + nomeArquivo + "'!");
        } catch (IOException e) {
            System.err.println("Erro ao carregar contatos de '" + nomeArquivo + "': " + e.getMessage());
            // e.printStackTrace();
        }

    }
}
