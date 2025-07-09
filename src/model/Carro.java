package model;

public class Carro {
    private String placa;
    private String modelo;
    private boolean disponivel;
    private double valorDiaria;

    public Carro(String placa, String modelo, double valorDiaria) {
        this.placa = placa;
        this.modelo = modelo;
        this.valorDiaria = valorDiaria;
        this.disponivel = true;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void exibirDados() {
        System.out.printf("Placa: %s | Modelo: %s | Disponível: %b | Diária: R$ %.2f\n",
                placa, modelo, disponivel, valorDiaria);
    }

}
