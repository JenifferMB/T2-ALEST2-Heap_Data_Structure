import java.io.IOException;
import java.util.ArrayList;

public class HeapTest {
    private static MinHeap hv;
    private static MaxHeap hc;
    private static long lucro = 0;
    private static long vendidas = 0;
    private static long tempoInicial = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {

        hv = new MinHeap(); 
        hc = new MaxHeap(); 

        ArrayList<String> file = File.read_file();
        int primeira = Integer.parseInt(file.get(0));
        
        for (int i = 1; i < primeira + 1; i++) {
            String[] linha = file.get(i).split(" ");
            int quant = Integer.parseInt(linha[1]);
            int valor = Integer.parseInt(linha[2]);

            if (linha[0].equals("C")) {
                hc.put(valor, quant);
            } else {
                hv.put(valor, quant);               
            }

            while(hc.verQuantidade()>=hv.verQuantidade() && hv.size()>1 && hc.size()>1){
              realizaTransicao(); 
            }
        }
        System.out.printf("OPERACOES DE COMPRAS RESTANTES: %d\nOPERACOES DE VENDAS RESTANTES: %d\nLUCRO: %d\nVENDIDAS: %d\n", hc.size(), hv.size(), lucro, vendidas);
        System.out.printf("TEMPO DE EXECUCAO: %d ms", (System.currentTimeMillis() - tempoInicial)); 
        
      }

    public static void realizaTransicao() {
      int[] compra1 = hc.verQuantidadePreco();
      int[] venda1 = hv.verQuantidadePreco();

    if(compra1[1]>venda1[1]){
      int diferenca= compra1[0]-venda1[0];
      vendidas+= venda1[1];
      lucro+=diferenca*venda1[1]; 
      hv.get();
      hc.set(compra1[1]-venda1[1]);
    }

    if(compra1[1]<venda1[1]){
      int diferenca= compra1[0]-venda1[0];
      vendidas+=compra1[1];
      lucro+=diferenca*compra1[1]; 
      hc.get();
      hv.set(venda1[1]-compra1[1]);
    }

    if(compra1[1]==venda1[1]){
      int diferenca= compra1[0]-venda1[0];
      int quantidadeVendida = compra1[1];
      vendidas+=quantidadeVendida;
      lucro+=diferenca*quantidadeVendida; 
      hv.get();
      hc.get(); 
    }
  }
}