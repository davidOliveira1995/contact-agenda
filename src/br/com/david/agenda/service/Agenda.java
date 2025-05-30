package br.com.david.agenda.service;

import br.com.david.agenda.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    List<Contato> contatos = new ArrayList<>();

    public void adicionarContato() {

    }

    public void listarContatos() {

    }

    public Contato buscarContatoPorNome(String nome, List<Contato> contatos) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }
}
