import java.util.Random;

public class Trabalho04 {
    static long reordenacoes = 0;
    static long tempoExecucao = 0;
    static int troca = 0;
    public static int iteracoes = 0;

    public static void imprimirVetor(int vetor[]) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public static int[] bubbleSort(int[] vetor) {
        int n = vetor.length;
        int temp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - i - 1); j++) {
                iteracoes++;
                if (vetor[j] > vetor[j + 1]) {
                    temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    troca++;
                }
            }
        }

        return vetor;
    }

    public static void selectionSort(int[] vetor) {
        int n = vetor.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                iteracoes++;
                if (vetor[i] > vetor[j]) {
                    int temp = vetor[i];
                    vetor[i] = vetor[j];
                    vetor[j] = temp;
                    troca++;
                }
            }
        }
    }

    public static void insertSort(int[] vetor) {

        for (int i = 1; i < vetor.length; i++) {
            int j = i;
            while (j > 0 && vetor[j] < vetor[j - 1]) {
                int aux = vetor[j];
                vetor[j] = vetor[j - 1];
                vetor[j - 1] = aux;
                j -= 1;
                troca++;
                iteracoes++;
            }
            if (j > 0) {
                iteracoes++;
            }
        }
    }

    public static void trocar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        troca++;
    }

    public static int particionar(int[] vetor, int esquerda, int direita) {
        int pivo = vetor[esquerda];
        int i = esquerda;

        for (int j = esquerda + 1; j <= direita; j++) {
            iteracoes++;
            if (vetor[j] <= pivo) {
                i += 1;
                trocar(vetor, i, j);
            }
        }
        trocar(vetor, esquerda, i);

        return i;
    }

    public static void quickSort(int[] vetor, int esquerda, int direita) {
        if (esquerda < direita) {
            int indicePivo = particionar(vetor, esquerda, direita);
            quickSort(vetor, esquerda, indicePivo - 1);
            quickSort(vetor, indicePivo + 1, direita);
        }
    }

    public static int[] mergeSort(int[] vetorA, int[] vetorB) {
        int[] vetorC = new int[vetorA.length + vetorB.length];
        int i = 0, j = 0, k = 0;

        while (i < vetorA.length && j < vetorB.length) {
            iteracoes++;
            if (vetorA[i] < vetorB[j]) {
                vetorC[k++] = vetorA[i++];
            } else {
                vetorC[k++] = vetorB[j++];
            }
            troca++;
        }

        while (i < vetorA.length) {
            vetorC[k++] = vetorA[i++];
            troca++;
        }

        while (j < vetorB.length) {
            vetorC[k++] = vetorB[j++];
            troca++;
        }
        return vetorC;
    }

    public static void shellSort(int[] vetor, int[] incrementos) {
        int incr, x, y, span;
        for (incr = 0; incr < incrementos.length; incr++) {
            span = incrementos[incr];
            for (x = span; x < vetor.length; x++) {
                iteracoes++;
                int temp = vetor[x];
                for (y = x; y >= span && vetor[y - span] > temp; y -= span) {
                    iteracoes++;
                    vetor[y] = vetor[y - span];
                    troca++;
                }
                vetor[y] = temp;
                if (y != x) {
                    troca++;
                }
            }
        }
    
    }
    
    public static int[] gerarAleatorio(int vetor[], long seed) {
        Random rand = new Random(seed);
        for (int i = 0; i < vetor.length; i++) {
            int aleatorio = rand.nextInt(10000);
            vetor[i] = aleatorio;
        }
        return vetor;
    }

    public static void sort(int vetor[]) {
        int N = vetor.length;

        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(vetor, N, i);
            iteracoes++;
        for (int i = N - 1; i > 0; i--) {
            iteracoes++;
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;
            troca++;
            heapify(vetor, i, 0);
        }
    }

    public static void heapify(int vetor[], int tamanho, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        iteracoes++;

        if (esquerda < tamanho && vetor[esquerda] > vetor[maior]) {
            iteracoes++;
            maior = esquerda;
        }
        if (direita < tamanho && vetor[direita] > vetor[maior]) {
            iteracoes++;
            maior = direita;
        }
        if (maior != i) {
            int troca = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = troca;
            troca++;
            heapify(vetor, tamanho, maior);
        }
    }

    public static float elapsedTime(long endTime, long startTime) {
        return (endTime - startTime) / 1e6f;
    }

    public static void main(String[] args) {
        long startTime;
        long endTime;
        float tempo = 0.0f;
        int seed = 42;
        int [] incrementos = new int[3];
        incrementos [0]=5;
        incrementos [1]=3;
        incrementos [2]=1;
        int vetorA[] = new int[50];
        int vetorB[] = new int[500];
        int vetorC[] = new int[1000];
        int vetorD[] = new int[5000];
        int vetorE[] = new int[10000];
        gerarAleatorio(vetorA, seed);
        gerarAleatorio(vetorB, seed);
        gerarAleatorio(vetorC, seed);
        gerarAleatorio(vetorD, seed);
        gerarAleatorio(vetorE, seed);

        startTime = System.nanoTime();

        insertSort(vetorA);
        selectionSort(vetorA);
        bubbleSort(vetorA);
        imprimirVetor(mergeSort(bubbleSort(vetorA), bubbleSort(vetorA)));
        quickSort(vetorA, 0, vetorA.length-1);
        shellSort(vetorA, incrementos);
        sort(vetorA);

        endTime = System.nanoTime();
        tempo = elapsedTime(endTime, startTime);
        imprimirVetor(vetorE);
        System.out.println("Quantidade de trocas: " + troca);
        System.out.println("Quantidade de iteracoes: " + iteracoes);
    
        System.out.printf("Tempo de busca: %.2f ns\n\n",tempo);

    }
}