package br.com.david.agenda.service;

import br.com.david.agenda.model.Contato;

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
        return true;
    }

    public void salvarContatos(String nomeArquivo) {

    }

    public void carregarContatos(String nomeArquivo) {

    }
}
