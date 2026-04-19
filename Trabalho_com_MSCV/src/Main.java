import Exercicio_1.View.FutebolSocietyView;
import Exercicio_2.View.BibliotecaView;
import Exercicio_3.View.LanchoneteView;

void main() {
    Scanner scan = new Scanner(System.in);

    int opcao = -1;

    do {

        System.out.println("==================== Qual exercicio deesja acessar ====================");
        System.out.println("1 - Exercicio 1");
        System.out.println("2 - Exercicio 2");
        System.out.println("3 - Exercicio 3");
        System.out.println("0 - Nenhum, fechar sistema");

        try {
            opcao = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            System.out.println("Opção inválida");
        }

        switch (opcao) {
            case 1 -> new FutebolSocietyView().menuInicial();
            case 2 -> new BibliotecaView().bibliotecaMenu();
            case 3 -> new LanchoneteView().menuInicial();
            case 0 -> System.exit(0);
        }
    }while(opcao != 0);

}