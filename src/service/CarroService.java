package service;

import database.BancoDeDados;
import model.Carro;

import java.util.Scanner;

public class CarroService {

    private Scanner scanner = new Scanner(System.in);

    public void adicionarCarro() {
        System.out.print("Placa: ");
        String placa = scanner.nextLine();

        for (Carro c : BancoDeDados.carros) {
            if (c.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Erro: carro com essa placa já foi cadastrado.");
                return;
            }
        }

        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Valor da diária (R$): ");
        double diaria = scanner.nextDouble();
        scanner.nextLine(); // limpar buffer

        BancoDeDados.carros.add(new Carro(placa, modelo, diaria));
        System.out.println("Carro adicionado com sucesso!\n");
    }

    public void atualizarCarro() {
        System.out.print("Placa do carro a atualizar: ");
        String placa = scanner.nextLine();
        for (Carro c : BancoDeDados.carros) {
            if (c.getPlaca().equals(placa)) {
                System.out.print("Novo modelo: ");
                c.setModelo(scanner.nextLine());
                System.out.println("Atualizado com sucesso!\n");
                return;
            }
        }
        System.out.println("Carro não encontrado.\n");
    }

    public void removerCarro() {
        System.out.print("Placa do carro a remover: ");
        String placa = scanner.nextLine();
        BancoDeDados.carros.removeIf(c -> c.getPlaca().equals(placa));
        System.out.println("Removido, se existia.\n");
    }

    public void listarCarros() {
        if (BancoDeDados.carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
            return;
        }

        System.out.println("\n-- Lista de Carros --");
        for (Carro c : BancoDeDados.carros) {
            c.exibirDados();
        }
    }
}
