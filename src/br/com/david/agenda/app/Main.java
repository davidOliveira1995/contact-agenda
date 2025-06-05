package br.com.david.agenda.app;

import br.com.david.agenda.model.Contato;
import br.com.david.agenda.service.Agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("----- Minha Agenda -----");

        boolean programaFinalizado = false;
        do {
            System.out.println("Selecione uma das opções abaixo!");

            System.out.println("1. Criar Agenda.");
            System.out.print("2. Cadastrar novo contato.");
            System.out.print("3. Editar contato existente.");
            System.out.print("4. Deletar contato.");
            System.out.print("5. Listar contatos.");
            System.out.print("6. Salvar contatos.");
            System.out.print("7. Carregar contatos.");
            System.out.print("8. Sair");

            int opcao = scan.nextInt();

            if (opcao >= 1 && opcao <= 8) {

                switch (opcao) {
                    case 1:
                        break;
                    default:
                        programaFinalizado = true;
                        break;
                }
            } else {
                System.out.println("Dados de entrada inválido, por favor! Entre com opção numérica de 1 a 6, conforme o Menu.");
            }

        } while (!programaFinalizado);

    }
}