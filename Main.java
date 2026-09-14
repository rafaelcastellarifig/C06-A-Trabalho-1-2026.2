package cdg.inatel;

import java.util.Scanner;

import cdg.inatel.cliente.Cliente;
import cdg.inatel.loja.computador.Computador;
import cdg.inatel.loja.computador.HardwareBasico;
import cdg.inatel.loja.computador.MemoriaUSB;
import static cdg.inatel.loja.ProcessarPedido.Envio;

public class Main {
    static void main(String[] args) {
        HardwareBasico [] HbPC1 = new HardwareBasico [3];
        HardwareBasico [] HbPC2 = new HardwareBasico [3];
        HardwareBasico [] HbPC3 = new HardwareBasico [3];

        HardwareBasico PPC1 = new HardwareBasico("PentiumCore i5", 2200);
        HardwareBasico PPC2 = new HardwareBasico("PentiumCore i7", 3370);
        HardwareBasico PPC3 = new HardwareBasico("PentiumCore i7", 4500);
        HardwareBasico RPC1 = new HardwareBasico("Memória RAM", 8);
        HardwareBasico RPC2 = new HardwareBasico("Memória RAM", 16);
        HardwareBasico RPC3 = new HardwareBasico("Memória RAM", 32);
        HardwareBasico HPC1 = new HardwareBasico("HD", 500);
        HardwareBasico HPC2 = new HardwareBasico("HD", 1000);
        HardwareBasico HPC3 = new HardwareBasico("HD", 2000);

        Computador PC1 = new Computador ("Apple", 171.00F, 64, "MacOS Sequoia", HbPC1);
        Computador PC2 = new Computador ("Samsung", 172.00F, 64, "Windows 8", HbPC2);
        Computador PC3 = new Computador ("Dell", 173.00F, 64, "Windows 10", HbPC3);

        float total;
        boolean deseja;

        PC1.addHardware(PPC1);
        PC1.addHardware(RPC1);
        PC1.addHardware(HPC1);
        PC2.addHardware(PPC2);
        PC2.addHardware(RPC2);
        PC2.addHardware(HPC2);
        PC3.addHardware(PPC3);
        PC3.addHardware(RPC3);
        PC3.addHardware(HPC3);

        MemoriaUSB musb1 = new MemoriaUSB("Pen-drive", 16);
        MemoriaUSB musb2 = new MemoriaUSB("Pen-drive", 32);
        MemoriaUSB musb3 = new MemoriaUSB("HD Externo", 1000);

        System.out.println("Bem vindo à PCMania!");
        System.out.println("Gostaria de ver nossas ofertas? (sim ou não)");
        Scanner resp1 = new Scanner(System.in);
        String Resp1 = resp1.next();
        if (Resp1.equalsIgnoreCase("sim")){
            System.out.println("digite seu nome para garantir as ofertas: ");
            Scanner resp0 = new Scanner (System.in);
            String Resp0 = resp0.next();
            System.out.println("digite seu CPF para garantir as ofertas: ");
            String Resp01 = resp0.next();
            Cliente cliente = new Cliente (Resp0, Resp01);
            Computador [] Carrinho = new Computador [100];
            deseja = true;
            int i = 0;
            while (deseja && i <= 100) {
                System.out.println("Estamos com as seguintes ofertas:");
                PC1.mostraPCConfigs();
                System.out.println("PS: Acompanha (sem custo adicional e a desejo do cliente): " + musb1.getNome() + " de " + musb1.getCapacidade() + " GB");
                PC2.mostraPCConfigs();
                System.out.println("PS: Acompanha (sem custo adicional e a desejo do cliente): " + musb2.getNome() + " de " + musb2.getCapacidade() + " GB");
                PC3.mostraPCConfigs();
                System.out.println("PS: Acompanha (sem custo adicional e a desejo do cliente): " + musb2.getNome() + " de " + musb2.getCapacidade() + " TB");
                System.out.println("Qual promoção você prefere?(1, 2 ou 3)");
                Scanner resp2 = new Scanner(System.in);
                int Resp2 = resp2.nextInt();
                if (Resp2 == 1) {
                    cliente.AddCarrinho (PC1, Carrinho, musb1);
                }
                if (Resp2 == 2) {
                    cliente.AddCarrinho (PC2, Carrinho, musb2);
                }
                if (Resp2 == 3) {
                    cliente.AddCarrinho (PC3, Carrinho, musb3);
                }
                System.out.println("Deseja comprar mais? (sim ou não)");
                Scanner resp3 = new Scanner (System.in);
                String Resp3 = resp3.next();
                if (Resp3.equalsIgnoreCase("não")){
                    deseja = false;
                }
                i++;
            }

            cliente.CalculatotalCompra();
            cliente.Pagarconta();
            Envio ();
        }
        else{
            System.out.println("Obrigado por visitar a nossa página!");
        }
    }
}