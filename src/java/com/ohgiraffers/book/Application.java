package com.ohgiraffers.book;

import com.ohgiraffers.book.controller.MainController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        MainController mainController = new MainController();
        Scanner scanner = new Scanner(System.in);
        boolean onIs = true;
        int input = 0;

        while (onIs) {

            System.out.println("======= 도서 관리 프로그램 =======");
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
                System.out.println("오류! 숫자를 입력해주세요");
                scanner.nextLine();
                continue;
            }

            switch (input) {
                case 1 -> {
                    System.out.print("회원이름을 입력 해주세요: ");
                    mainController.rentalService();
                }
                case 2 -> {
                    mainController.memberService();
                }
                case 3 -> {
                    mainController.bookService();
                }
                case 4 -> {
                    mainController.returnService();
                }
                case 9 -> {
                    onIs = false;
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
// 이책을 누가 몇번 빌려갔는지
