package cdg.inatel.loja.computador;

public class Computador {
    private String marca;
    private float preco;
    MemoriaUSB memoriaUSB;
    HardwareBasico [] Componentes;
    SistemaOperacional SO;

    public void addHardware (HardwareBasico Hardwarebasico){
        for (int i = 0; i < Componentes.length; i++){
            if (Componentes[i] == null) {
                Componentes[i] = Hardwarebasico;
                break;
            }
        }
    }

    public Computador(String marca, float preco, int tipoSO, String nomeSO, HardwareBasico [] componentes) {
        this.preco = preco;
        this.marca = marca;
        this.SO = new SistemaOperacional(nomeSO, tipoSO);
        this.Componentes = componentes;
    }

    public void mostraPCConfigs (){
        System.out.println("Marca: "+ marca);
        for (int i = 0; i < Componentes.length; i++){
            if (i == 1){
                System.out.println("Processador" + Componentes[i].getNome() + " de " + (int) Componentes[i].getCapacidade() + " Mhz");
            }
            if (i == 2){
                System.out.println(Componentes[i].getNome() + ": " + (int) Componentes[i].getCapacidade() + " Gb de RAM");
            }
            if (i == 3){
                if (Componentes[i].getCapacidade()>1000){
                    System.out.println(Componentes[i].getNome() + ": " + (int) Componentes[i].getCapacidade()/1000 + " Tb de HD");
                }
                if (Componentes[i].getCapacidade()<1000){
                    System.out.println(Componentes[i].getNome() + ": " + (int) Componentes[i].getCapacidade() + " Gb de HD");
                }
            }
        }
        System.out.println("Preço: Apenas " + (int) preco + " reais!");
    }

    public void addMemoriaUSB (MemoriaUSB musb){
        this.memoriaUSB = musb;
    }

    public float getPreco() {
        return preco;
    }
}
