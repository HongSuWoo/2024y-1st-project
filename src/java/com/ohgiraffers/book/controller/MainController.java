package com.ohgiraffers.book.controller;

import com.ohgiraffers.book.dto.BookDTO;
import com.ohgiraffers.book.dto.MemberDTO;
import com.ohgiraffers.book.service.MainService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainController {
    MainService mainService = new MainService();
    Scanner scanner = new Scanner(System.in);

    // 대출 관련 메서드  -------------------------------------------------------------------------------------------------
    public void rentalService() {
        String result = "";
        int token, rental = 0, income = 0, bookNum = 0;

        String memName = scanner.nextLine();
        token = mainService.serviceRental(memName);

        if (token == -1) {
            System.out.println("등록되지 않은 회원입니다.");
        } else {
            System.out.println("메뉴를 선택해 주세요.");
            System.out.print("1. 책번호 | 2. 바코드 | 3. 충전 : ");

            rental = integerException(rental);

            switch (rental) {
                case 1 -> {
                    System.out.println("책의 번호를 입력해 주세요.");

                    bookNum = integerException(bookNum);

                    mainService.serviceBookRental(bookNum, token);
                }
                case 2 -> {
                    System.out.println("바코드 클래스 이행");
                }
                case 3 -> {
                    System.out.println("얼마를 충전 하시겠습니까?");

                    income = integerException(income);

                    if (income <= 0) {
                        System.out.println("금액은 0보다 작거나 같을수 없습니다.");
                    } else {
                        result = mainService.serviceMemberIncome(income, token);
                        System.out.println(result + "\n");
                    }
                }
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    // 회원 관련 메서드  -------------------------------------------------------------------------------------------------
    public void memberService() {
        int input = 0, inputNum = 0;
        String inputSel, memName, result = "";

        menuInterface("회원 검색", "회원 등록", "회원 수정", "회원 삭제", "전체 회원 조회", "이전 메뉴");

        input = integerException(input);

        switch (input) {
            case 1 -> {
                System.out.println("검색하실 회원명을 입력 해주세요.");
                inputSel = scanner.nextLine();
                result = mainService.serviceMemberView(inputSel);
            }
            case 2 -> {
                String[] inputResult = requestInput("회원명", "주소", "전화번호", "성별");
                MemberDTO memberDTO = new MemberDTO(inputResult[0], inputResult[1], inputResult[2], inputResult[3]);
                result = mainService.serviceMemRegister(memberDTO);
            }
            case 3 -> {
                System.out.println("수정 하실 회원의 이름을 입력해주세요.");
                memName = scanner.nextLine();
                result = mainService.serviceMemModify(memName);
            }
            case 4 -> {
                System.out.println("삭제 하실 번호를 입력해주세요.");

                inputNum = integerException(inputNum);

                if (inputNum <= 0) {
                    System.out.println("번호를 확인해 주세요.");
                    break;
                }
                result = mainService.serviceMemDelete(inputNum);
            }
            case 5 -> {
                result = mainService.serviceMemOverPrint();
            }
            case 9 -> {
                result = "이전 메뉴로 돌아갑니다.";
            }
            default -> System.out.println("잘못된 입력입니다, 숫자를 입력하세요.");
        }
        System.out.println(result);
        System.out.println();
    }

    // 도서관리 관련 메서드  ----------------------------------------------------------------------------------------------
    public void bookService() {
        int input = 0, inputNum = 0;
        String inputSel, result = "";

        menuInterface("도서 검색", "도서 등록", "도서 수정", "도서 삭제", "전체 도서 조회", "이전 메뉴");

        input = integerException(input);

        switch (input) {
            case 1 -> {
                System.out.println("검색 하실 도서 번호나 도서 제목을 입력해주세요.");
                inputSel = scanner.nextLine();
                result = mainService.serviceView(inputSel);
            }
            case 2 -> {
                String[] inputResult = requestInput("도서 이름", "도서 저자");
                System.out.println("도서 가격을 입력해주세요.");

                input = integerException(input);

                if (input <= 0) {
                    System.out.println("가격 정보를 다시 확인해주세요.");
                    break;
                }
                BookDTO bookDTO = new BookDTO(inputResult[0], inputResult[1], input);
                result = mainService.serviceRegister(bookDTO);
            }
            case 3 -> {
                System.out.println("수정 할 책의 번호 를 입력해주세요.");

                inputNum = integerException(inputNum);

                if (inputNum < 0) {
                    System.out.println("번호를 확인해 주세요.");
                    break;
                }
                result = mainService.serviceModify(inputNum);
            }
            case 4 -> {
                System.out.println("삭제 하실 번호를 입력해주세요.");

                inputNum = integerException(inputNum);

                if (inputNum <= 0) {
                    System.out.println("번호를 확인해 주세요.");
                    break;
                }
                result = mainService.serviceDelete(inputNum);
            }
            case 5 -> {
                result = mainService.serviceOverPrint();
            }
            case 9 -> {
                result = "이전 메뉴로 돌아갑니다.";
            }
            default -> System.out.println("잘못된 입력입니다, 숫자를 입력하세요.");
        }
        System.out.println(result);
        System.out.println();
    }

    // 반납 관련 메서드  -------------------------------------------------------------------------------------------------
    public void returnService() {
        String result = "";
        int input = 0, bookNum = 0;

        System.out.println("1. 책번호 | 2. 바코드");

        input = integerException(input);

        switch (input) {
            case 1 -> {
                System.out.println("책의 번호를 입력해 주세요.");

                bookNum = integerException(bookNum);

                result = mainService.serviceBookReturn(bookNum);
            }
            case 2 -> {
                System.out.println("바코드 클래스 이행");
            }
        }
        System.out.println(result);
    }

    public void menuInterface(String menu1, String menu2, String menu3, String menu4, String menu5, String menu6) {
        System.out.println();
        System.out.println("======= 도서 관리 메뉴 =======");
        System.out.println("1. " + menu1);
        System.out.println("2. " + menu2);
        System.out.println("3. " + menu3);
        System.out.println("4. " + menu4);
        System.out.println("5. " + menu5);
        System.out.println("9. " + menu6);
        System.out.print("메뉴를 선택해주세요: ");
    }

    public String[] requestInput(String... menu) {
        String[] inputResult = new String[menu.length];
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i] + " 을(를) 입력하세요.");
            inputResult[i] = scanner.nextLine();
        }
        return inputResult;
    }

    public int integerException(int input) {
        try {
            input = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("오류! 숫자를 입력해주세요");
            scanner.nextLine();
        }
        return input;
    }
}