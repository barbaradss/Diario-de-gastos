import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MenuPrincipal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DiarioDeGastos diario = new DiarioDeGastos();
        int opcao;

        do {
            System.out.println("==|Menu|==");
            System.out.println("Bem vindo ao seu diário de gastos!");
            System.out.println("Escolha uma opção: ");
            System.out.println("1- Adicionar Gasto");
            System.out.println("2- Listar Gasto");
            System.out.println("3-Remover Gasto");
            System.out.println("4-Editar gasto");
            System.out.println("5-Sair");
            opcao = diario.lerInteiro(sc); // arrumar delay no scanner


            switch (opcao) {
                case 1 -> diario.adicionarGasto(sc);
                case 2 -> diario.consultarGasto(sc);
                case 3 -> diario.removerGasto(sc);
                case 4 -> diario.editarGasto(sc);
                case 5 -> {
                    diario.salvarEmArquivo();
                    System.out.println("Saindo do programa...");
                    break;
                }
            }
        }while (opcao != 5);
    }
}