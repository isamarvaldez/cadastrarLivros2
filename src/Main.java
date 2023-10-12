import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Livro> listaLivros = new ArrayList<>();
        ArrayList<Autor> listAutor = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao nosso sebo");

        int opcao;// se refiere a que el cliente va a escoger un numero de las opciones ofrecidas abajo 1/2/0

        do {
            System.out.println("Ecolha uma opcao: 1 -Cadastrar livro / 2 -listarLivro / 0 -Voltar ao menu anterior");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    //instancia uma classe
                    Livro novoLivro = new Livro();
                    Autor novoAutor = new Autor();

                    System.out.println("Digite o titulo do livro: ");
                    novoLivro.Titulo = scanner.next();
                    scanner.nextLine();

                    System.out.println("Digite o nome do autor do livro");
                    novoAutor.nome = scanner.next();
                    scanner.nextLine();

                    System.out.println("digite o local de nascimento");
                    novoAutor.localNasc = scanner.next();
                    scanner.nextLine();


                    System.out.println("Digite o preco");
                    novoLivro.preco = scanner.nextFloat();
                    scanner.nextLine();


                    System.out.println("Digite a data de lancamento de livro");
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyy"));
                    scanner.nextLine();
                    Period period = Period.between(date, LocalDate.now());

                    novoLivro.dataLancamento = date;
                    if (period.getYears() > 5) {
                        System.out.println("O livro tem mais de 5 anos");

                    } else {
                        System.out.println("o livro tem menos de 5 anos. \nVoltando para o menu anterior");
                        break;
                    }

                    novoLivro.autor = novoAutor;


                    listaLivros.add(novoLivro);

                    System.out.println("Cadastrar com sucesso");
                    break;

                case 2:
                    if (listaLivros.size() <= 0) {
                        System.out.println("A lista esta vazia");
                    } else {
                        for (Livro cadaLivro : listaLivros) {
                            System.out.println();
                            System.out.println("titulo: " + cadaLivro.Titulo);
                            System.out.println("autor: " + cadaLivro.autor.nome);
                            System.out.println("valor: " + cadaLivro.preco);
                            System.out.println("data de lancamento:" + cadaLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyy")));
                        }
                    }

                    break;

                case 0:
                    System.out.println("Obrigado por usar o sistema");
                    break;

                default:
                    System.out.println("Opcao invalida");
                    break;
            }

        }while (opcao != 0);
    }
}

