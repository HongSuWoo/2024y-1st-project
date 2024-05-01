import controller.OrderController;

import java.util.InputMismatchException;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        OrderController orderController = new OrderController();
        Scanner scanner = new Scanner(System.in);
        boolean onIs = true;
        int input = 0;

        while (onIs) {
            System.out.println("=======도서 관리 프로그램=======");
            System.out.println("1. 대   출");
            System.out.println("2. 회원관리");
            System.out.println("3. 도서관리");
            System.out.println("4. 반   납");
            System.out.println("9. 종   료");
            System.out.print("메뉴를 선택해 주세요: ");

            try {
                input = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요 !!!");
                scanner.nextLine();
            }

            switch (input) {
                case 1 -> {
                    System.out.print("회원이름을 입력 해주세요: ");
                    orderController.rentalService();
                }
                case 2 -> {
                    orderController.memberService();
                }
                case 3 -> {
                    orderController.bookService();
                }
                case 4 -> {
                    orderController.returnBook();
                }
                case 9 -> {
                    onIs = false;
                }
                default -> {
                    System.out.println("잘못된 입력입니다!");
                }
            }
        }
    }
}
