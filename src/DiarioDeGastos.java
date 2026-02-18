import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DiarioDeGastos {
    private ArrayList<Gasto> listaDeGastos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void salvarEmArquivo() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("gastos.txt"))) {

            for (Gasto gasto : listaDeGastos) {
                writer.write(
                        gasto.getDescricao() + ";" +
                                gasto.getCategoria() + ";" +
                                gasto.getValor() + ";" +
                                gasto.getData()
                );
                writer.newLine();
            }

            System.out.println("Gastos salvos com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public void carregarDoArquivo() {
        File arquivo = new File("gastos.txt");

        if (!arquivo.exists()) {
            return; // Se ainda não existir arquivo, não faz nada
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] partes = linha.split(";");

                if (partes.length == 4) {

                    String descricao = partes[0];
                    String categoria = partes[1];
                    double valor = Double.parseDouble(partes[2]);
                    String data = partes[3];

                    Gasto gasto = new Gasto(descricao, categoria, valor, data);
                    listaDeGastos.add(gasto);
                }
            }

            System.out.println("Gastos carregados com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }

    public int lerInteiro(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Digite um número inteiro válido:");
            }
        }
    }

    public double lerDouble(Scanner sc) {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Digite um valor numérico válido:");
            }
        }
    }

    public DiarioDeGastos(){
        listaDeGastos = new ArrayList<>();
        carregarDoArquivo();
    }

    public void adicionarGasto(Scanner sc){
        System.out.println("Digite a descrição:");
        String descricao = sc.nextLine();

        System.out.println("Digite a categoria:");
        String categoria = sc.nextLine();

        System.out.println("Digite o valor:");
        double valor = lerDouble(sc);

        while (valor <= 0) {
            System.out.println("O valor deve ser positivo:");
            valor = lerDouble(sc);
        }

        String data;
        while (true) {
            System.out.println("Digite a data (dd/MM/yyyy): ");
            data = sc.nextLine();

            if (data.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            } else {
                System.out.println("Formato inválido! Use dd/MM/yyyy.");
            }
        }

        Gasto g = new Gasto(descricao, categoria, valor, data);

        listaDeGastos.add(g);

        System.out.println("Gasto adicionado com sucesso!");
    }

    public void consultarGasto(Scanner sc) {

        if (listaDeGastos.isEmpty()) {
            System.out.println("Não há gastos registrados.");
            return;
        }

        System.out.println("Consultar por:");
        System.out.println("1 - Mês");
        System.out.println("2 - Semana");
        int opcao = lerInteiro(sc);

        switch (opcao) {

            case 1:
                System.out.print("Digite o mês (MM): ");
                String mes = sc.nextLine();

                for (Gasto gasto : listaDeGastos) {
                    String mesGasto = gasto.getData().substring(3,5);

                    if (mesGasto.equals(mes)) {
                        System.out.println(gasto);
                    }
                }
                break;

            case 2:
                System.out.print("Digite o dia inicial da semana: ");
                int inicio = lerInteiro(sc);

                System.out.print("Digite o dia final da semana: ");
                int fim = lerInteiro(sc);

                for (Gasto gasto : listaDeGastos) {
                    int dia = Integer.parseInt(gasto.getData().substring(0,2));

                    if (dia >= inicio && dia <= fim) {
                        System.out.println(gasto);
                    }
                }
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    public void removerGasto(Scanner sc) {
        if (listaDeGastos.isEmpty()){
            System.out.println("Não há gastos para remover");
            return;
        }
        int i;
        for (i = 0; i < listaDeGastos.size(); i++) {
            System.out.println("[" + i + "]" + listaDeGastos.get(i));
        }
        System.out.println("Selecione o item a ser removido");
        int opcao = lerInteiro(sc);


        if (opcao >= 0 && opcao < listaDeGastos.size()){
            System.out.println("Tem certeza que deseja remover este gasto? (s/n)");
            System.out.println(listaDeGastos.get(opcao));
            String confirmacao = sc.nextLine().trim().toLowerCase();

            if (confirmacao.equals("s")) {
                listaDeGastos.remove(opcao);
                System.out.println("Gasto removido com sucesso!");
            } if (confirmacao.equals("n")) {
                System.out.println("Remoção cancelada.");
            }
            else {
                System.out.println("Digite apenas 's' ou 'n'.");
            }
        } else {
            System.out.println("Índice inválido.");

        }
    }

    public void editarGasto(Scanner sc){
        if (listaDeGastos.isEmpty()) {
            System.out.println("Não há gastos para editar.");
            return;
        }

        for (int i = 0; i < listaDeGastos.size(); i++) {
            System.out.println("[" + i + "] " + listaDeGastos.get(i));
        }

        System.out.print("Selecione o índice do item a ser modificado: ");
        int opcao = lerInteiro(sc);

        if (opcao < 0 || opcao >= listaDeGastos.size()) {
            System.out.println("Índice inválido.");
            return;
        }

        Gasto gasto = listaDeGastos.get(opcao);

        System.out.print("Digite a nova descrição: ");
        String novaDescricao = sc.nextLine();
        gasto.setDescricao(novaDescricao);

        System.out.print("Digite a nova categoria: ");
        String novaCategoria = sc.nextLine();
        gasto.setCategoria(novaCategoria);

        System.out.print("Digite o novo valor: ");
        double novoValor = lerDouble(sc);
        while (novoValor <= 0) {
            System.out.println("O valor deve ser positivo:");
            novoValor = lerDouble(sc);
        }

        gasto.setValor(novoValor);

        System.out.println("Digite a nova data: ");
        String novaData = sc.nextLine();
        gasto.setData(novaData);

        System.out.println("Gasto editado com sucesso!");
    }
}