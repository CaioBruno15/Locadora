package service;

import database.BancoDeDados;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class AluguelService {
    private Scanner scanner = new Scanner(System.in);

    public void realizarAluguel() {
        // Buscar cliente pelo CPF
        Cliente clienteSelecionado = null;
        while (clienteSelecionado == null) {
            System.out.print("Digite o CPF do cliente: ");
            String cpf = scanner.nextLine();

            for (Cliente c : BancoDeDados.clientes) {
                if (c.getCpf().equals(cpf)) {
                    clienteSelecionado = c;
                    break;
                }
            }

            if (clienteSelecionado == null) {
                System.out.println("CPF não encontrado. Tente novamente.");
            }
        }

        // Listar carros disponíveis
        System.out.println("\n-- Carros disponíveis --");
        int disponiveis = 0;
        for (Carro carro : BancoDeDados.carros) {
            if (carro.isDisponivel()) {
                carro.exibirDados();
                disponiveis++;
            }
        }

        if (disponiveis == 0) {
            System.out.println("Nenhum carro disponível para aluguel.\n");
            return;
        }

        // Escolher carro disponível (validando placa)
        Carro carroSelecionado = null;
        while (carroSelecionado == null) {
            System.out.print("\nDigite a placa do carro desejado: ");
            String placa = scanner.nextLine();

            for (Carro c : BancoDeDados.carros) {
                if (c.getPlaca().equalsIgnoreCase(placa) && c.isDisponivel()) {
                    carroSelecionado = c;
                    break;
                }
            }

            if (carroSelecionado == null) {
                System.out.println("Placa inválida ou carro indisponível. Tente novamente.");
            }
        }

        // Prazo em dias
        System.out.print("Por quantos dias deseja alugar o carro? ");
        int dias = scanner.nextInt();
        scanner.nextLine(); // limpa o buffer

        // Marcar carro como alugado
        carroSelecionado.setDisponivel(false);

        // Criar objeto aluguel e salvar no sistema
        Aluguel aluguel = new Aluguel(clienteSelecionado, carroSelecionado, dias);
        BancoDeDados.alugueis.add(aluguel);

        System.out.println("\nAluguel realizado com sucesso!");
        aluguel.exibirResumo();
    }

    public void devolverCarro() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = null;
        for (Cliente c : BancoDeDados.clientes) {
            if (c.getCpf().equals(cpf)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        // Mostrar aluguéis do cliente ainda ativos
        ArrayList<Aluguel> alugueisCliente = new ArrayList<>();
        for (Aluguel a : BancoDeDados.alugueis) {
            if (a.getCliente().getCpf().equals(cpf) && !a.getCarro().isDisponivel()) {
                alugueisCliente.add(a);
            }
        }

        if (alugueisCliente.isEmpty()) {
            System.out.println("Esse cliente não possui carros alugados no momento.");
            return;
        }

        System.out.println("\n-- Aluguéis Ativos --");
        int i = 1;
        for (Aluguel a : alugueisCliente) {
            System.out.print(i + ". ");
            a.exibirResumo();
            i++;
        }

        System.out.print("Escolha o número do carro a ser devolvido: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // limpa buffer

        if (opcao < 1 || opcao > alugueisCliente.size()) {
            System.out.println("Opção inválida.");
            return;
        }

        Aluguel aluguelSelecionado = alugueisCliente.get(opcao - 1);

        System.out.print("A devolução será antecipada? (s/n): ");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Quantos dias o carro ficou com o cliente? ");
            int diasReais = scanner.nextInt();
            scanner.nextLine();
            aluguelSelecionado.devolverAntecipadamente(diasReais);
            System.out.printf("Valor recalculado: R$ %.2f\n", aluguelSelecionado.getValorTotal());
        }

        // Liberar o carro
        aluguelSelecionado.getCarro().setDisponivel(true);
        System.out.println("Carro devolvido com sucesso!");
    }

    public void listarAlugueis() {
        System.out.println("\n-- Aluguéis Realizados --");
        if (BancoDeDados.alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel registrado.\n");
            return;
        }

        for (Aluguel a : BancoDeDados.alugueis) {
            a.exibirResumo();
            System.out.println("-----");
        }
    }
}
