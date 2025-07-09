package main;

import service.ClienteService;
import service.CarroService;
import service.AluguelService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteService clienteService = new ClienteService();
        CarroService carroService = new CarroService();
        Scanner scanner = new Scanner(System.in);
        AluguelService aluguelService = new AluguelService();

        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Atualizar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("5. Adicionar Carro");
            System.out.println("6. Listar Carros");
            System.out.println("7. Atualizar Carro");
            System.out.println("8. Remover Carro");
            System.out.println("9. Realizar Aluguel");
            System.out.println("10. Listar Aluguéis");
            System.out.println("11. Devolver Carro");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> clienteService.adicionarCliente();
                case 2 -> clienteService.listarClientes();
                case 3 -> clienteService.atualizarCliente();
                case 4 -> clienteService.removerCliente();
                case 5 -> carroService.adicionarCarro();
                case 6 -> carroService.listarCarros();
                case 7 -> carroService.atualizarCarro();
                case 8 -> carroService.removerCarro();
                case 9 -> aluguelService.realizarAluguel();
                case 10 -> aluguelService.listarAlugueis();
                case 11 -> aluguelService.devolverCarro();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida");
            }

        } while (opcao != 0);
    }
}