package controller;


import dto.BookDTO;
import dto.MemberDTO;
import service.OrderService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderController {
    OrderService orderService = new OrderService();
    Scanner scanner = new Scanner(System.in);
    String bookName, bookAuthor, inputSel, result, memName, memAddress, memPhone, memGen;
    int bookPrice, input, inputNum;

    public void bookService() {

        System.out.println();
        System.out.println("-----도서 관리 메뉴-------");
        System.out.println("1. 도서 검색");
        System.out.println("2. 도서 등록");
        System.out.println("3. 도서 수정");
        System.out.println("4. 도서 삭제");
        System.out.println("5. 도서 전체");
        System.out.print("메뉴를 선택해주세요: ");

        verification();

        switch (input) {
            case 1 -> {
                System.out.println("검색 하실 도서 번호나 도서 제목을 입력해주세요.");
                inputSel = scanner.nextLine();
                result = orderService.serviceView(inputSel);
            }
            case 2 -> {
                System.out.println("도서 제목을 입력해주세요.");
                bookName = scanner.nextLine();
                System.out.println("도서 저자를 입력해주세요.");
                bookAuthor = scanner.nextLine();
                System.out.println("도서 가격을 입력해주세요.");
                bookPrice = scanner.nextInt();
                if (bookPrice <= 0) {
                    System.out.println("가격 정보를 다시 확인해주세요.");
                    break;
                }
                BookDTO bookDTO = new BookDTO(bookName, bookAuthor, bookPrice);
                result = orderService.serviceRegist(bookDTO);
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
            default -> {
                System.out.println("잘못된 입력입니다!");
            }
        }
        System.out.println(result);
    }

    public void memberService() {
        System.out.println();
        System.out.println("-----멤버 관리 메뉴-------");
        System.out.println("1. 멤버 검색");
        System.out.println("2. 멤버 등록");
        System.out.println("3. 멤버 수정");
        System.out.println("4. 멤버 삭제");
        System.out.println("5. 멤버 전체");
        System.out.print("원하시는 메뉴를 선택해주세요 -> ");

        verification();

        switch (input) {
            case 1:
                System.out.println("검색하실 회원명을 입력 해주세요.");
                inputSel = scanner.nextLine();
                result = orderService.serviceMemberView(inputSel);
                break;
            case 2:
                System.out.println("등록하실 회원 이름을 입력해주세요.");
                memName = scanner.nextLine();
                System.out.println("주소를 입력해 주세요..");
                memAddress = scanner.nextLine();
                System.out.println("핸드폰 번호를 입력해주세요.");
                memPhone = scanner.nextLine();
                System.out.println("성별을 입력 해주세요.");
                memGen = scanner.nextLine();
                MemberDTO memberDTO = new MemberDTO(memName, memAddress, memPhone, memGen);
                result = orderService.serviceMemRegist(memberDTO);
                break;
            case 3:
                System.out.println("수정 하실 회원의 이름을 입력해주세요.");
                memName = scanner.nextLine();
                result = orderService.serviceMemModify(memName);
                break;
            case 4:
                System.out.println("삭제 하실 번호를 입력해주세요.");
                inputNum = scanner.nextInt();
                if (inputNum <= 0) {
                    System.out.println("번호를 확인해 주세요.");
                    break;
                }
                result = orderService.serviceMemDelete(inputNum);
                break;
            case 5:
                result = orderService.serviceMemOverPrint();
                break;
            default:
                System.out.println("Error");
                break;
        }
        System.out.println(result);
    }

    public void rentalService() {
        String rental, result = "";
        int intToken, token;
        memName = scanner.nextLine();
        token = orderService.serviceRental(memName);
        if (token == -1)
            System.out.println("회원 이름이 잘못 되었습니다.");
        else {
            System.out.println("빌리실 책의 바코드 또는 책의 번호를 눌러주세요." + token);
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
                result = orderService.serviceMemincome(income, token);
                System.out.println(result + "\n");
            } else {
                result = orderService.serviceBookRental(Integer.parseInt(rental), token);
                System.out.println(result);
            }
        }
    }

    public String returnBook() {
        String result;
        System.out.println("반납하실 책의 바코드 또는 번호를 입력해주세요.");
        result = scanner.nextLine();
        if (result.equals("@"))
            System.out.println("바코드 클래스 이행");
        result = orderService.serviceBookReturn(Integer.parseInt(result));
        System.out.println(result);
        return result;
    }

    public void verification() {
        try {
            this.input = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요 !!!");
            scanner.nextLine();
        }
    }

}