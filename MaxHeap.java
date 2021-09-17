public class MaxHeap {

    private int v[][];
    private int used;

    public MaxHeap() {
        used = 0;
        v = new int[10000000][2];
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void sift_up(int pos) {
        int posParent = parent(pos);

        if (v[posParent][0] < v[pos][0]) {
            int aux = v[posParent][0];
            int aux2 = v[posParent][1];
            v[posParent][0] = v[pos][0];
            v[posParent][1] = v[pos][1];
            v[pos][0] = aux;
            v[pos][1] = aux2;
            sift_up(posParent);
        }
    }

    public void put(int data,int data2) {
        v[used][0] = data;
        v[used][1] = data2;
        sift_up(used);
        used++;
    }

    private void sift_down(int pos) {
        int posLeft = left(pos);
        int posRight = right(pos);

        int maiorPos = pos;
        int maior = v[pos][0];

        if (posLeft < this.used && maior < v[posLeft][0]) {
            maiorPos = posLeft;
            maior = v[posLeft][0];
        }

        if (posRight < this.used && maior < v[posRight][0]) {
            maiorPos = posRight;
            maior = v[posRight][0];
        }

        if (pos != maiorPos) {
            int aux = v[pos][0];
            int aux2 = v[pos][1];
            v[pos][0] = v[maiorPos][0];
            v[pos][1] = v[maiorPos][1];
            v[maiorPos][0] = aux;
            v[maiorPos][1] = aux2;
            sift_down(maiorPos);
        }
    }

    public int[] get() {
        int res[] = {v[0][0],v[0][1]};
        v[0][0] = v[--used][0];
        v[0][1] = v[used][1];
            sift_down(0);       
            return res;
    }

    public int[] verQuantidadePreco() {
        int res[] = {v[0][0],v[0][1]};
        return res;
    }
    public int verQuantidade() {
        int res= v[0][0];
        return res;
    }

    public int verPreco() {
        int res= v[0][1];
        return res;
    }

    public void set(int dado){
        v[0][1]=dado;
    }

    private int len(int a) {
        int res = 0;
        while (a > 0) {
            res++;
            a /= 10;
        }
        return res;
    }

    public int size(){
        return used;
    }

    private void print(int b, int elem, int sp) {
        int i, j;

        System.out.println("");
        for (j = 0; j < used; j++)
            System.out.print(v[j][0] + " ");
        System.out.println("");

        while (true) {
            for (j = 0; j <= sp / 2; j++)
                System.out.print(" ");
            for (i = b; i < b + elem; i++) {
                if (i == used)
                    return;
                int aux = len(v[i][0]);
                System.out.print(v[i][0]);
                for (j = 0; j < sp - aux; j++)
                    System.out.print(" ");
            }
            System.out.println("");
            b = b + elem;
            elem = 2 * elem;
            sp = sp / 2;
        }
    }

    boolean isEmpty(){
        return used == 0;
    }
    
    public void print() {
        System.out.println("");
        //print(0, 1, 64);
        for (int j = 0; j < used; j++)
            System.out.print("C: " +v[j][0] + " ");
        System.out.println("");
    }

    public void printSV1() {
        int j;
        System.out.println("");
        for (j = 0; j < used; j++)
            System.out.print("C: " +v[j][0] + " ");
        System.out.println("");
    }

    public void printSV2() {
        int j;
        for (j = 0; j < used; j++)
            System.out.print("C: " +v[j][1] + " ");
        System.out.println("");
    }

    private void print1(int b, int elem, int sp) {
        int i, j;

        System.out.println("");
        for (j = 0; j < used; j++)
            System.out.print(v[j][0] + " ");
        System.out.println("");

        while (true) {
            for (j = 0; j <= sp / 2; j++)
                System.out.print(" ");
            for (i = b; i < b + elem; i++) {
                if (i == used)
                    return;
                int aux = len(v[i][0]);
                System.out.print(v[i][0]);
                for (j = 0; j < sp - aux; j++)
                    System.out.print(" ");
            }
            System.out.println("");
            b = b + elem;
            elem = 2 * elem;
            sp = sp / 2;
        }
    }

    public void print1() {
        System.out.println("");
        print(0, 1, 64);
        System.out.println("");
    }


    private void print2(int b, int elem, int sp) {
        int i, j;

        System.out.println("");
        for (j = 0; j < used; j++)
            System.out.print(v[j][1] + " ");
        System.out.println("");

        while (true) {
            for (j = 0; j <= sp / 2; j++)
                System.out.print(" ");
            for (i = b; i < b + elem; i++) {
                if (i == used)
                    return;
                int aux = len(v[i][1]);
                System.out.print(v[i][1]);
                for (j = 0; j < sp - aux; j++)
                    System.out.print(" ");
            }
            System.out.println("");
            b = b + elem;
            elem = 2 * elem;
            sp = sp / 2;
        }
    }

    public void print2() {
        System.out.println("");
        print2(0, 1, 64);
        System.out.println("");
    }
}