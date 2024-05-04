package com.ohgiraffers.book.fakeDB;


import com.ohgiraffers.book.dto.BookDTO;
import com.ohgiraffers.book.dto.MemberDTO;
import com.ohgiraffers.book.service.MainService;

public class fakeDB {
    MainService orderService = new MainService();

    public void basicBookRegist() {
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

        for (int i = 0; i < basicBook.length; i++) {
            String[] bookData = basicBook[i].split(",");
            String name = bookData[0];
            String author = bookData[1];
            int price = Integer.parseInt(bookData[2]);

            BookDTO bookDTO = new BookDTO(name, author, price);
            orderService.serviceRegister(bookDTO);
        }
    }

    public void basicMemberRegist() {
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
        for (int i = 0; i < basicMember.length; i++) {
            String[] memberData = basicMember[i].split(",");
            String name = memberData[0];
            String address = memberData[1];
            String phone = memberData[2];
            String gender = memberData[3];

            MemberDTO memberDTO = new MemberDTO(name, address, phone, gender);
            orderService.serviceMemRegister(memberDTO);
        }
    }
}
