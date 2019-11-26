import java.io.*;
import java.util.*;

public class Trocas {

    public Trocas() throws IOException {
    }

    List<String> pedidos = new ArrayList<String>();

    public void lerArquivo() throws IOException {

        pedidos.clear();

        InputStream is = new FileInputStream("TestePedidos.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String s = br.readLine();

        while (s != null) {
            String pedido = s;

            pedidos.add(pedido);

            s = br.readLine();
        }

        br.close();
    }

    public int trocaPorFIFO() throws IOException {

        lerArquivo();
        List<String> produtosNasPrateleiras = new ArrayList<String>(10);
        int i = 0, contadorTrocas = 0;

        // enche os frames com as primeiras solicitações
        while (i < 10) {
            if (produtosNasPrateleiras.contains(pedidos.get(0))) {
                pedidos.remove(0);
                i++;
            } else {
                produtosNasPrateleiras.add(pedidos.remove(0));
                i++;
            }
        }

        boolean achou = false;

        // percorre a lista com todos os pedidos
        for (int j = 0; j < pedidos.size(); j++) {
            int k = 0;
            achou = false;
            // percorre o vetor com os produtos na prateleira
            while (!achou && k < 10) {
                String p = pedidos.get(0);
                if (produtosNasPrateleiras.contains(p)) {
                    pedidos.remove(0);
                    achou = true;
                } else
                    k++;

                if (!achou) {
                    produtosNasPrateleiras.remove(0);
                    produtosNasPrateleiras.add(pedidos.get(0));
                    pedidos.remove(0);

                    contadorTrocas++;
                }
            }
        }

        return contadorTrocas;
    }


}
