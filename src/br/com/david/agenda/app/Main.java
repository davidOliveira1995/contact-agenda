package br.com.david.agenda.app;

import br.com.david.agenda.model.Contato;
import br.com.david.agenda.service.Agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("----- Minha Agenda -----");

        Agenda minhaAgenda = new Agenda();

        boolean programaFinalizado = false;
        do {
            pulaLinha();
            System.out.println("Selecione uma das opções abaixo!");

            System.out.println("1. Cadastrar novo contato.");
            System.out.println("2. Editar contato existente.");
            System.out.println("3. Deletar contato.");
            System.out.println("4. Listar contatos.");
            System.out.println("5. Salvar contatos.");
            System.out.println("6. Carregar contatos.");
            System.out.println("7. Sair");
            pulaLinha();

            System.out.print("Digite: ");
            int opcao = scan.nextInt();

            scan.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("Opção 1: Cadastrar novo contato!");

                        System.out.print("Nome: ");
                        String nome = scan.nextLine();

                        System.out.print("Telefone: ");
                        String telefone = scan.nextLine();

                        System.out.print("Email: ");
                        String email = scan.nextLine();

                        minhaAgenda.cadastrarContato(nome, telefone, email);
                        break;
                    case 2:
                        System.out.println("Opção 2: Editar contato!");

                        System.out.print("Buscar nome do contato: ");
                        String nomeAntigo = scan.nextLine();

                        System.out.print("Novo nome: ");
                        String novoNome = scan.nextLine();

                        System.out.print("Novo telefone: ");
                        String novoTelefone = scan.nextLine();

                        System.out.print("Novo email: ");
                        String novoEmail = scan.nextLine();
                            minhaAgenda.editarContato(nomeAntigo, novoNome, novoTelefone, novoEmail);
                        break;
                    case 3:
                        System.out.println("Opção 3: Excluir contato!");

                        System.out.print("Digite o nome do contato a ser excluido: ");
                        String nomeExcluido = scan.nextLine();
                        minhaAgenda.excluirContato(nomeExcluido);
                        break;
                    case 4:
                        System.out.println("Opção 4: Listar contatos!");

                        minhaAgenda.listarContatos();
                        break;
                    case 5:
                        System.out.println("Opção 5: Salvar contatos!");

                        System.out.print("Digite o nome do arquivo para salvar: ");
                        String nomeArquivo = scan.nextLine();

                        minhaAgenda.salvarContatos(nomeArquivo);
                        break;
                    case 6:
                        System.out.println("Opção 6: Carregar contatos!");

                        System.out.print("Digite o nome do arquivo: ");
                        String carregarNomeArquivo = scan.nextLine();
                        minhaAgenda.carregarContatos(carregarNomeArquivo);
                        break;
                    case 7:
                        programaFinalizado = true;
                        break;
                    default:
                        System.out.println("Dados de entrada inválido, por favor! Entre com opção numérica de 1 a 7, conforme o Menu.");
                        break;
                }

        } while (!programaFinalizado);

    }

    public static void pulaLinha() {
        System.out.println();
    }
}