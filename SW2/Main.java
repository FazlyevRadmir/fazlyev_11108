import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AATree aat = new AATree();
        char ch;

        do {
            System.out.println("\nAATree Operations\n");
            System.out.println("1.Вставить ");
            System.out.println("2.Поиск");
            System.out.println("3.Подсчитать узлы");
            System.out.println("4.Проверка на пустоту");
            System.out.println("5.Удалить");

            int choice = scan.nextInt();
            switch (choice) {
                case 1 :
                    System.out.println("Введите целочисленный элемент для вставки");
                    aat.insert( scan.nextInt() );
                    break;
                case 2 :
                    System.out.println("Введите целочисленный элемент для поиска");
                    System.out.println("Результат поиска : "+ aat.search( scan.nextInt() ));
                    break;
                case 3 :
                    System.out.println("Узлы = "+ aat.countNodes());
                    break;
                case 4 :
                    System.out.println("Статус пустоты = "+ aat.isEmpty());
                    break;
                case 5 :
                    System.out.println("\nДерево очищено");
                    aat.clear();
                    break;
                default :
                    System.out.println("Неверный ввод \n ");
                    break;
            }

            System.out.print("\nPost order : ");
            aat.postorder();
            System.out.print("\nPre order : ");
            aat.preorder();
            System.out.print("\nIn order : ");
            aat.inorder();

            System.out.println("\nВы хотите продолжить? (Введитке y (yes) или n (no)) \n");
            ch = scan.next().charAt(0);
        }
        while (ch == 'Y'|| ch == 'y');
    }
}