package model;

public class Cliente extends Pessoa {
    private String tipoCNH;

    public Cliente(String nome, String cpf, String tipoCNH) {
        super(nome, cpf);
        this.tipoCNH = tipoCNH;
    }

    @Override
    public void exibirDados() {
        System.out.println("Cliente: " + nome + ", CPF: " + cpf + ", CNH: " + tipoCNH);
    }

    public String getTipoCNH() {
        return tipoCNH;
    }

    public void setTipoCNH(String tipoCNH) {
        this.tipoCNH = tipoCNH;
    }
}
