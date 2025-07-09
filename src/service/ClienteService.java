package service;

import database.BancoDeDados;
import model.Cliente;

import java.util.Scanner;

public class ClienteService {
    private Scanner scanner = new Scanner(System.in);

    public void adicionarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        // Verificação de CPF duplicado
        for (Cliente c : BancoDeDados.clientes) {
            if (c.getCpf().equals(cpf)) {
                System.out.println("Erro: CPF já cadastrado!\n");
                return;
            }
        }

        System.out.print("Tipo de CNH: ");
        String cnh = scanner.nextLine();

        BancoDeDados.clientes.add(new Cliente(nome, cpf, cnh));
        System.out.println("Cliente adicionado com sucesso!\n");
    }

    public void listarClientes() {
        for (Cliente c : BancoDeDados.clientes) {
            c.exibirDados();
        }
    }

    public void atualizarCliente() {
        System.out.print("CPF do cliente a atualizar: ");
        String cpf = scanner.nextLine();
        for (Cliente c : BancoDeDados.clientes) {
            if (c.getCpf().equals(cpf)) {
                System.out.print("Novo nome: ");
                c.setNome(scanner.nextLine());
                System.out.print("Novo tipo de CNH: ");
                c.setTipoCNH(scanner.nextLine());
                System.out.println("Atualizado com sucesso!\n");
                return;
            }
        }
        System.out.println("Cliente não encontrado.\n");
    }

    public void removerCliente() {
        System.out.print("CPF do cliente a remover: ");
        String cpf = scanner.nextLine();
        BancoDeDados.clientes.removeIf(c -> c.getCpf().equals(cpf));
        System.out.println("Removido, se existia.\n");
    }
}
