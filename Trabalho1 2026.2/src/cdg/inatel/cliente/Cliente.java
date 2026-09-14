package cdg.inatel.cliente;

import cdg.inatel.loja.computador.Computador;
import cdg.inatel.loja.computador.MemoriaUSB;

import java.util.Scanner;

public class Cliente {
    private String nome;
    private String cpf;
    private float total;
    private Computador [] Carrinho = new Computador[100];
    int i;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void AddCarrinho (Computador PC, Computador [] carrinho, MemoriaUSB musb){
        this.Carrinho = carrinho;
        boolean vazio = true;
        while (vazio){
            if (carrinho[i] == null){
                carrinho[i] = PC;
                System.out.println("Computador adicionada ao carrinho...");
                System.out.println("Deseja obter o brinde de acompanhamento?(sim ou não)");
                Scanner resp = new Scanner (System.in);
                String Resp = resp.next();
                if (Resp.equalsIgnoreCase("sim")){
                    PC.addMemoriaUSB(musb);
                    System.out.println("Brinde adicionada ao carrinho...");
                }
                vazio = false;
            }
            i++;
        }
    }

    public float CalculatotalCompra (){
        int i=0;
        total = 0;
        while (Carrinho [i] != null){
            total += Carrinho[i].getPreco();
            i++;
        }
        System.out.println("Total da compra é: " + (int) total + " reais.");
        return total;
    }

    public void Pagarconta(){
        System.out.println("Encaminhando para a página de pagamento...");
        System.out.println("Pagamento concluído...");
    }
}
