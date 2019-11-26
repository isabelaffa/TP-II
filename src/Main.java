import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {

        Trocas trocas = new Trocas();
        Scanner read = new Scanner(System.in);

        System.out.println("┌─────────────────────────────┐");
        System.out.println("│   ESCOLHA UMA OPÇÃO         │");
        System.out.println("├─────────────────────────────┤");
        System.out.println("│  1 - FIFO                   │");
        System.out.println("│  2 - Menos usadas           │");
        System.out.println("└─────────────────────────────┘");

        System.out.print("│ OPÇÃO: ");
        int opcao = read.nextInt();

        switch (opcao){
            case 1:
                System.out.println("Quantidade de trocas: " + trocas.trocaPorFIFO());
                break;
            case 2:
                System.out.println("Quantidade de trocas: " + trocas.trocaPorMenosUsadas());
                break;
        }
    }
}
