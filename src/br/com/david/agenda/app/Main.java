package br.com.david.agenda.app;

import br.com.david.agenda.model.Contato;
import br.com.david.agenda.service.Agenda;

public class Main {
    public static void main(String[] args) {

        Agenda minhaAgenda = new Agenda();

        minhaAgenda.cadastrarContato("David de Oliveira Silva",
                "(13) 9 9722-2123","david.oliveira@hotmail.com");

        minhaAgenda.cadastrarContato("Suzy Hellen",
                "(13) 9 9877-2311","suzyhellen@gmail.com");

        pulaLinha();
        minhaAgenda.listarContatos();

        pulaLinha();
        minhaAgenda.buscarContatoPorNome("David de Oliveira Silva");
    }

    public static void pulaLinha() {
        System.out.println();
    }
}