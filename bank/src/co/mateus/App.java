package co.mateus;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bank santander = new Bank("0001");

        while (true) {
            System.out.println("O que deseja fazer? A=Acessar minha conta C=Criar conta E=Sair da conta");
            String op = scanner.nextLine();

            if (op.equals("C")) {
                System.out.println("Digite seu nome:");
                String name = scanner.nextLine();
                Account account = santander.generateAccount(name);
                santander.InsertAccount(account);

                operateAccount(account);
            }else if(op.equals("A")) {
                System.out.println("Digite seu numero da conta:");
                String buscar = scanner.nextLine();

            }else if (op.equals("E")) {
                break;
            } else {
                System.out.println("Comando inválido , tente novamente inserindo um comando válido!");
            }
        }
        List<Account> accountList = santander.getAccounts();
        for (Account cc : accountList) {
            System.out.println(cc);
        }
        santander.outputTotal();
    }

    static void operateAccount(Account account) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite a operação desejada! D=Depósito S=Saque E=Sair");
            String op = scanner.nextLine();


            if (op.equals("D")) {
                System.out.println("Digite o valor do depósito:");
                double value = scanner.nextDouble();
                account.deposit(value);
            } else if (op.equals("S")) {
                System.out.println("Digite o valor do saque:");
                double value = scanner.nextDouble();
                if (!account.withDraw(value)) {
                    System.out.println("Ops! Não foi possível sacar o valor de R$" + value);
                }
            } else if (op.equals("E")) {
                break;

            } else {
                System.out.println("Comando inválido , tente novamente inserindo um comando válido!");
            }
            scanner = new Scanner(System.in);
        }
        System.out.println("Sua cessão foi finalizada!"  );
    }
}


