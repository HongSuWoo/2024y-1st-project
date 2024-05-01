package com.ohgiraffers.order.controller;


import com.ohgiraffers.dto.BookDTO;
import com.ohgiraffers.dto.MemberDTO;
import com.ohgiraffers.service.OrderService;

import java.util.Scanner;

public class OrderController {
    OrderService os = new OrderService();
    Scanner sc = new Scanner(System.in);
    String bookName, bookAuthor, inputSel, result,memName,memAdress,memPhone,memGen;
    int bookPrice, input, inputNum;
    public void bookService() {
        int input;
        //도서 전체 열람
        System.out.println();
        System.out.println("-----도서 관리 메뉴-------");
        System.out.println("1. 도서 검색");
        System.out.println("2. 도서 등록");
        System.out.println("3. 도서 수정");
        System.out.println("4. 도서 삭제");
        System.out.println("5. 도서 전체");
        System.out.print("원하시는 메뉴를 선택해주세요 -> ");
        input = sc.nextInt();
        sc.nextLine();
        switch (input) {
            case 1:
                System.out.println("검색 하실 도서 번호나 도서 제목을 입력해주세요.");
                inputSel = sc.nextLine();
                result = os.servcieView(inputSel);
                break;
            case 2:
                System.out.println("도서 제목을 입력해주세요.");
                bookName = sc.nextLine();
                System.out.println("도서 저자를 입력해주세요.");
                bookAuthor = sc.nextLine();
                System.out.println("도서 가격을 입력해주세요.");
                bookPrice = sc.nextInt();
                if (bookPrice <= 0) {
                    System.out.println("가격 정보를 다시 확인해주세요.");
                    break;
                }
                BookDTO bookDTO = new BookDTO(bookName, bookAuthor, bookPrice);
                result = os.serviceRegist(bookDTO);
                break;
            case 3:
                System.out.println("수정 하실 책의 일련번호 를 입력해주세요.");
                inputNum = sc.nextInt();
                sc.nextLine();
                if (inputNum <= 0)
                    {
                    System.out.println("번호를 확인해 주세요.");
                    break;
                    }
                result = os.serviceModify(inputNum);
                break;
            case 4:
                System.out.println("삭제 하실 번호를 입력해주세요.");
                inputNum = sc.nextInt();
                if (inputNum <= 0)
                    {
                    System.out.println("번호를 확인해 주세요.");
                    break;
                    }
                result = os.serviceDelete(inputNum);
                break;
            case 5:
                result = os.serviceOverPrint();
                break;
            default:
                System.out.println("Error");
                break;
        }
        System.out.println(result);
    }


    public void basicBookRegist()
    {
        String[] basicBook = new String[9];
        basicBook[0] = ("개미,베르나르,10000");
        basicBook[1] = ("나무,김모성,10000");
        basicBook[2] = ("금과은,김씨다,10000");
        basicBook[3] = ("더 로그,홍정훈,10000");
        basicBook[4] = ("레드 클라우드,골렘,10000");
        basicBook[5] = ("소설 속 엑스트라,지갑송,10000");
        basicBook[6] = ("원피스,오다,4000");
        basicBook[7] = ("헌터x헌터,욕욕욕,4000");
        basicBook[8] = ("마검 전생,김재한,10000");

        for (int i = 0; i < basicBook.length; i++)
        {
            String[] bookData = basicBook[i].split(",");
            String name = bookData[0];
            String author = bookData[1];
            int price = Integer.parseInt(bookData[2]);

            BookDTO bookDTO = new BookDTO(name, author, price);
            os.serviceRegist(bookDTO);
        }
    }
    public void basicMemberRegist()
    {
        String[] basicMember = new String[9];
        basicMember[0] = ("홍서우,서울,010-9592-6660,남");
        basicMember[1] = ("김효주,서울,010-1111-1111,여");
        basicMember[2] = ("주순태,서울,010-2222-2222,남");
        basicMember[3] = ("황정한,서울,010-3333-3333,남");
        basicMember[4] = ("쓰  랄,아제로스,010-4444-4444,남");
        basicMember[5] = ("안두인,스톰윈드,010-5555-5555,남");
        basicMember[6] = ("제이나,테라모어,010-6666-6666,여");
        basicMember[7] = ("멀록킹,아옳옳,010-7777-7777,남");
        basicMember[8] = ("바리안,스톰윈드,010-8888-8888,남");
        for (int i = 0; i < basicMember.length; i++)
        {
            String[] memberData = basicMember[i].split(",");
            String name = memberData[0];
            String address = memberData[1];
            String phone = memberData[2];
            String gender = memberData[3];

            MemberDTO memberDTO = new MemberDTO(name, address, phone, gender);
            os.serviceMemRegist(memberDTO);
        }
    }
    public void memberService()
    {
        int input;
        System.out.println();
        System.out.println("-----멤버 관리 메뉴-------");
        System.out.println("1. 멤버 검색");
        System.out.println("2. 멤버 등록");
        System.out.println("3. 멤버 수정");
        System.out.println("4. 멤버 삭제");
        System.out.println("5. 멤버 전체");
        System.out.print("원하시는 메뉴를 선택해주세요 -> ");
        input = sc.nextInt();
        sc.nextLine();
        switch (input) {
            case 1:
                System.out.println("검색하실 회원명을 입력 해주세요.");
                inputSel = sc.nextLine();
                result = os.serviceMemberView(inputSel);
                break;
            // public MemberDTO(String memberName, String memberAdress, String memberPhone, char memberGender)
            case 2:
                System.out.println("등록하실 회원 이름을 입력해주세요.");
                memName = sc.nextLine();
                System.out.println("주소를 입력해 주세요..");
                memAdress = sc.nextLine();
                System.out.println("핸드폰 번호를 입력해주세요.");
                memPhone = sc.nextLine();
                System.out.println("성별을 입력 해주세요.");
                memGen = sc.nextLine();
                MemberDTO memberDTO = new MemberDTO(memName,memAdress,memPhone,memGen);
                result = os.serviceMemRegist(memberDTO);
                break;
            case 3:
                System.out.println("수정 하실 회원의 이름을 입력해주세요.");
                memName = sc.nextLine();
                result = os.serviceMemModify(memName);
                break;
            case 4:
                System.out.println("삭제 하실 번호를 입력해주세요.");
                inputNum = sc.nextInt();
                if (inputNum <= 0)
                {
                    System.out.println("번호를 확인해 주세요.");
                    break;
                }
                result = os.serviceMemDelete(inputNum);
                break;
            case 5:
                result = os.serviceMemOverPrint();
                break;
            default:
                System.out.println("Error");
                break;
        }
        System.out.println(result);
    }
    public void rentalService()
    {
        String rental,result="";
        int intToken,token;
        memName = sc.nextLine();
        token = os.serviceRental(memName);
        if(token==-1)
            System.out.println("회원 이름이 잘못 되었습니다.");
        else
        {
            System.out.println("빌리실 책의 바코드 또는 책의 번호를 눌러주세요." + token);
            System.out.println("충전을 하실경우 $를 눌러주세요.");
            rental = sc.nextLine();
            if (rental.equals("@"))
                System.out.println("바코드 클래스 이행");
            else if (rental.equals("$"))
            {
                System.out.println("얼마를 충전 하시겠습니까?");
                int income = sc.nextInt();
                sc.nextLine();
                if (income <= 0)
                    System.out.println("Error");
                result = os.serviceMemincome(income, token);
                System.out.println(result+"\n");
            }
            else
            {
                result = os.serviceBookRental(Integer.parseInt(rental), token);
                System.out.println(result);
            }
        }
    }
    public String returnBook()
    {
        String result;
        System.out.println("반납하실 책의 바코드 또는 번호를 입력해주세요.");
        result = sc.nextLine();
        if (result.equals("@"))
            System.out.println("바코드 클래스 이행");
        result = os.serviceBookReturn(Integer.parseInt(result));
        System.out.println(result);
        return result;
    }

}