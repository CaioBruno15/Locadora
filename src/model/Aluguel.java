package model;

import java.time.LocalDate;

public class Aluguel {
    private Cliente cliente;
    private Carro carro;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private  int dias;
    private double valorTotal;

    public Aluguel(Cliente cliente, Carro carro, int dias) {
        this.cliente = cliente;
        this.carro = carro;
        this.dataInicio = LocalDate.now();
        this.dataFim = dataInicio.plusDays(dias);
        this.dias = dias;
        this.valorTotal = carro.getValorDiaria() * dias;
    }

    public void exibirResumo() {
        System.out.printf("Cliente: %s | Carro: %s (%s)\n",
                cliente.getNome(), carro.getModelo(), carro.getPlaca());
        System.out.println("Período: " + dataInicio + " até " + dataFim + " (" + dias + " dias)");
        System.out.printf("Valor total a pagar: R$ %.2f\n", valorTotal);
    }

    //Devolução
    public void devolverAntecipadamente(int diasReais) {
        this.dataFim = dataInicio.plusDays(diasReais);
        this.valorTotal = carro.getValorDiaria() * diasReais;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public Carro getCarro() {
        return carro;
    }
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public LocalDate getDataFim() {
        return dataFim;
    }
    public double getValorTotal(){
        return valorTotal;
    }

}
