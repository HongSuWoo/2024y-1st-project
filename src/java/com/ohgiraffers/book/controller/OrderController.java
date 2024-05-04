package com.ohgiraffers.book.controller;

import com.ohgiraffers.book.dto.BookDTO;
import com.ohgiraffers.book.dto.MemberDTO;
import com.ohgiraffers.book.service.OrderService;
import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderController {
    OrderService orderService = new OrderService();
    Scanner scanner = new Scanner(System.in);
    private String result, inputSel, memName, input1, input2, input3;
    private int input, inputNum;


    // 대출 관련 메서드  -------------------------------------------------------------------------------------------------
    public void rentalService() {
        String rental, result = "";
        int token;
        memName = scanner.nextLine();
        token = orderService.serviceRental(memName);
        if (token == -1)
            System.out.println("회원 이름이 잘못 되었습니다.");
        else {
            System.out.println("빌리실 책의 바코드 또는 책의 번호를 눌러주세요.");
            System.out.println("충전을 하실경우 $를 눌러주세요.");
            rental = scanner.nextLine();
            if (rental.equals("@"))
                System.out.println("바코드 클래스 이행");
            else if (rental.equals("$")) {
                System.out.println("얼마를 충전 하시겠습니까?");
                int income = scanner.nextInt();
                scanner.nextLine();
                if (income <= 0)
                    System.out.println("Error");
                result = orderService.serviceMemberIncome(income, token);
                System.out.println(result + "\n");
            } else {
                result = orderService.serviceBookRental(Integer.parseInt(rental), token);
                System.out.println(result);
            }
        }
    }


    // 회원관리 관련 메서드  ----------------------------------------------------------------------------------------------
    public void memberService() {

        selectMenu("멤버", "멤버 검색", "멤버 등록", "멤버 수정", "멤버 삭제", "멤버 전체", "이전 메뉴");

        verification();

        switch (input) {
            case 1 -> {
                System.out.println("검색하실 회원명을 입력 해주세요.");
                inputSel = scanner.nextLine();
                result = orderService.serviceMemberView(inputSel);
            }
            case 2 -> {
                System.out.println("등록하실 회원 이름을 입력해주세요.");
                memName = scanner.nextLine();

                inputInfo("주소", "핸드폰번호", "성별");

                MemberDTO memberDTO = new MemberDTO(memName, input1, input2, input3);
                result = orderService.serviceMemRegister(memberDTO);
            }
            case 3 -> {
                System.out.println("수정 하실 회원의 이름을 입력해주세요.");
                memName = scanner.nextLine();
                result = orderService.serviceMemModify(memName);
            }
            case 4 -> {
                System.out.println("삭제 하실 번호를 입력해주세요.");
                inputNum = scanner.nextInt();
                if (inputNum <= 0) {
                    System.out.println("번호를 확인해 주세요.");
                    break;
                }
                result = orderService.serviceMemDelete(inputNum);
            }
            case 5 -> {
                result = orderService.serviceMemOverPrint();
            }
            case 9 -> {
                result = "이전 메뉴로 돌아갑니다.";
            }
            default -> {
                System.out.println("Error");
            }
        }
        System.out.println(result);
        System.out.println();
    }


    // 도서관리 관련 메서드  ----------------------------------------------------------------------------------------------
    public void bookService() {

        selectMenu("도서", "도서 검색", "도서 등록", "도서 수정", "도서 삭제", "도서 전체", "이전 메뉴");

        verification();

        switch (input) {
            case 1 -> {
                System.out.println("검색 하실 도서 번호나 도서 제목을 입력해주세요.");
                inputSel = scanner.nextLine();
                result = orderService.serviceView(inputSel);
            }
            case 2 -> {
                System.out.println("도서 제목을 입력해주세요.");
                String bookName = scanner.nextLine();
                System.out.println("도서 저자를 입력해주세요.");
                String bookAuthor = scanner.nextLine();
                System.out.println("도서 가격을 입력해주세요.");
                verification();

                if (input <= 0) {
                    System.out.println("가격 정보를 다시 확인해주세요.");
                    break;
                }
                BookDTO bookDTO = new BookDTO(bookName, bookAuthor, input);
                result = orderService.serviceRegister(bookDTO);
            }
            case 3 -> {
                System.out.println("수정 하실 책의 일련번호 를 입력해주세요.");
                inputNum = scanner.nextInt();
                scanner.nextLine();
                if (inputNum <= 0) {
                    System.out.println("번호를 확인해 주세요.");
                    break;
                }
                result = orderService.serviceModify(inputNum);
            }
            case 4 -> {
                System.out.println("삭제 하실 번호를 입력해주세요.");
                inputNum = scanner.nextInt();
                if (inputNum <= 0) {
                    System.out.println("번호를 확인해 주세요.");
                    break;
                }
                result = orderService.serviceDelete(inputNum);
            }
            case 5 -> {
                result = orderService.serviceOverPrint();
            }
            case 9 -> {
                result = "이전 메뉴로 돌아갑니다.";
            }
            default -> {
                System.out.println("잘못된 입력입니다!");
            }
        }
        System.out.println(result);
        System.out.println();
    }


    // 반납 관련 메서드  -------------------------------------------------------------------------------------------------
    public void returnBook() {
        String result;
        System.out.println("반납하실 책의 바코드 또는 번호를 입력해주세요.");
        result = scanner.nextLine();
        if (result.equals("@"))
            System.out.println("바코드 클래스 이행");
        result = orderService.serviceBookReturn(Integer.parseInt(result));
        System.out.println(result);
    }


    // OrderController 관련 메서드  -------------------------------------------------------------------------------------
    public void selectMenu(String menuName, String menu1, String menu2, String menu3, String menu4, String menu5, String menu6) {
        System.out.println();
        System.out.println("-----" + menuName + " 관리 메뉴-------");
        System.out.println("1. " + menu1);
        System.out.println("2. " + menu2);
        System.out.println("3. " + menu3);
        System.out.println("4. " + menu4);
        System.out.println("5. " + menu5);
        System.out.println("9. " + menu6);
        System.out.print("메뉴를 선택해주세요: ");
    }

    public void verification() {
        try {
            input = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("오류! 숫자를 입력해주세요");
            scanner.nextLine();
        }
    }

    public void inputInfo(String input1, String input2, String input3) {
        System.out.println(input1 + " 을(를) 입력해 주세요.");
        input1 = scanner.nextLine();
        System.out.println(input2 + " 을(를) 입력해 주세요.");
        input2 = scanner.nextLine();
        System.out.println(input3 + " 을(를) 입력해 주세요.");
        input3 = scanner.nextLine();
    }
}