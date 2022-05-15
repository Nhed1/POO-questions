import java.util.InputMismatchException;
import java.util.Scanner;

public class Question {
    private static int peopleLength;
    private static Scanner sc = new Scanner(System.in);

    private static void getPeopleLength() throws InputMismatchException, NullPointerException {

        for (int x = 0; x < 1; x++) {
            try {
                System.out.println("Digite a quantidade de pessoas: ");
                peopleLength = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("O valor precisar ser inteiro.");
                x -= 1;
            }
            sc.nextLine();
        }
    }

    private static void readName(int i, Person[] people) throws InputMismatchException {
        System.out.println("Digite o nome da pessoa " + (i + 1));
        people[i].setName(sc.nextLine());
    }

    private static void readAge(int i, Person[] people) throws InputMismatchException {
        System.out.println("Digite a idade da pessoa " + (i + 1));
        people[i].setAge(sc.nextInt());
    }

    private static void readCpf(int i, Person[] people) throws InputMismatchException {
        System.out.println("Digite o cpf da pessoa " + (i + 1));
        people[i].setCpf(sc.nextLine());
    }

    private static void readPerson(int i, Person[] people) {
        readName(i, people);
        readAge(i, people);
        readCpf(i, people);
    }

    private static void showPeople(int i, Person[] people) {
        System.out.println("noem da pessoa " + (i + 1) + ": " + people[i].getName());
        System.out.println("idade da pessoa " + (i + 1) + ": " + people[i].getAge());
        System.out.println("cpf da pessoa " + (i + 1) + ": " + people[i].getCpf());
    }

    public static void main(String args[]) {
        getPeopleLength();
        Person[] people = new Person[peopleLength];

        for (int i = 0; i < 3; i++) {
            people[i] = new Person();
            try {
                readPerson(i, people);
            } catch (InputMismatchException e) {
                System.out.println("O tipo colocado no input está incorreto");
                i -= 1;
            }
            sc.nextLine();
        }
        for (int i = 0; i < 3; i++) {
            showPeople(i, people);
        }
    }
}