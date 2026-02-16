import java.util.ArrayList;
import java.util.Scanner;

public class DiarioDeGastos {
    private ArrayList<Gasto> listaDeGastos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public DiarioDeGastos(){
        listaDeGastos = new ArrayList<>();
    }

    public void adicionarGasto(Scanner sc){
        System.out.println("Digite a descrição:");
        String descricao = sc.nextLine();

        System.out.println("Digite a categoria:");
        String categoria = sc.nextLine();

        System.out.println("Digite o valor:");
        double valor = sc.nextDouble();
        sc.nextLine();

        System.out.println("Digite a data:");
        String data = sc.nextLine();

        Gasto g = new Gasto(descricao, categoria, valor, data);

        listaDeGastos.add(g);

        System.out.println("Gasto adicionado com sucesso!");
    }

    public void consultarGasto(){
        if(listaDeGastos.isEmpty()) {
            System.out.println("Não há gastos registrados.");
            return;
        }
        for(Gasto gasto : listaDeGastos) {
            System.out.println(gasto);
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
        int opcao = sc.nextInt();

        if (opcao >= 0 && opcao < listaDeGastos.size()){
            listaDeGastos.remove(opcao);
            System.out.println("Gasto removido com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }


    public void editarGasto(int indice, String novaDescricao, String novaCategoria,
                            double novoValor,
                            String novaData){
        if (indice < 0 || indice >= listaDeGastos.size()) {
            System.out.println("Índice inválido!");
            return;
        }
        Gasto gasto = listaDeGastos.get(indice);

        gasto.setDescricao(novaDescricao);
        gasto.setCategoria(novaCategoria);
        gasto.setValor(novoValor);
        gasto.setData(novaData);

        System.out.println("Gasto atualizado com sucesso!");


    }



}

