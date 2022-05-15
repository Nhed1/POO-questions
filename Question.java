
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Question {
    private static Scanner sc = new Scanner(System.in);
    private static int peopleLength;
    private static LinkedHashSet<Person> people = new LinkedHashSet<Person>();

    private static void getPeopleLength() throws InputMismatchException, NullPointerException {

        for (int x = 0; x < 1; x++) {
            try {
                System.out.println("Digite a quantidade de pessoas: ");
                peopleLength = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("O valor precisa ser inteiro");
                x -= 1;
            }
            sc.nextLine();
        }
    }

    private static void readPerson(int i, Person person) {
        readCpf(i, readAge(i, readName(i, person)));
    }

    private static Person readName(int i, Person person) throws InputMismatchException {
        System.out.println("Digite o nome da pessoa " + (i + 1));
        person.setName(sc.nextLine());
        return person;
    }

    private static Person readAge(int i, Person person) throws InputMismatchException {
        System.out.println("Digite a idade da pessoa " + (i + 1));
        person.setAge(sc.nextInt());
        return person;
    }

    private static Person readCpf(int i, Person person) throws InputMismatchException {
        System.out.println("Digite o cpf da pessoa " + (i + 1));
        person.setCpf(sc.nextLine());
        return person;
    }

    private static boolean checkCpf(Person person) {
        boolean cpfExists = true;

        Iterator<Person> peopleIterator = people.iterator();
        if (people.size() == 0) {
            cpfExists = false;
        } else {
            while (peopleIterator.hasNext()) {
                Person p = peopleIterator.next();
                if (p.getCpf() == person.getCpf()) {
                    cpfExists = true;
                } else {
                    cpfExists = false;
                }
            }
        }
        return cpfExists;
    }

    private static void showPeople(LinkedHashSet<Person> people) {
        Iterator<Person> peopleIterator = people.iterator();
        while (peopleIterator.hasNext()) {
            Person p = peopleIterator.next();
            System.out.println("Nome: " + p.getName());
            System.out.println("Idade: " + p.getAge());
            System.out.println("Cpf: " + p.getCpf());
        }
    }

    public static void main(String args[]) {
        getPeopleLength();
        for (int i = 0; i < peopleLength; i++) {
            Person person = new Person();
            try {
                readPerson(i, person);
                if (checkCpf(person)) {
                    System.out.println("Pessoa já cadastrada");
                    System.out.println("tente novamente");
                    i -= 1;
                } else {
                    people.add(person);
                }
            } catch (InputMismatchException e) {
                System.out.println("Preencha os inputs com o tipo certo");
                i -= 1;
            }
            sc.nextLine();
        }
        showPeople(people);
    }
}