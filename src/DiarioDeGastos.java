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


    public void removerGasto(String descricao) {
        for (int i = 0; i < listaDeGastos.size(); i++) {
            Gasto gasto = listaDeGastos.get(i);
            if (gasto.getDescricao().equalsIgnoreCase(descricao)) {
                listaDeGastos.remove(i);
                System.out.println("Gasto removido!");
                return;
            }
        }
        System.out.println("Gasto não encontrado.");
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

