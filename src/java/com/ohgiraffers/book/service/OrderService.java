package com.ohgiraffers.book.service;

import com.ohgiraffers.book.dao.MainRepository;
import com.ohgiraffers.book.dto.BookDTO;
import com.ohgiraffers.book.dto.MemberDTO;

import java.util.Scanner;

public class OrderService {
    Scanner scanner = new Scanner(System.in);
    MainRepository mainRepository = new MainRepository();


    // rentalService 관련 메서드 ----------------------------------------------------------------------------------------
    public int serviceRental(String name) {
        return mainRepository.memRental(name);
    }

    public String serviceMemberIncome(int income, int num) {
        return mainRepository.trIncome(income, num);
    }

    public String serviceBookRental(int bookNum, int memNum) {
        return mainRepository.bookRental(bookNum, memNum);
    }


    // memberService 관련 메서드 ----------------------------------------------------------------------------------------
    public String serviceMemberView(String inputSel) {
        return mainRepository.memSelectPrint(inputSel);
    }

    public String serviceMemRegister(MemberDTO memberDTO) {
        return mainRepository.registerMember(memberDTO);
    }

    public String serviceMemModify(String name) {
        System.out.println("수정을 원하시는 정보를 입력 해주세요. \nex)이름 or 주소 or  번호 or 성별");
        String input = scanner.nextLine();
        int modifyNum = 0;
        if (input.equals("이름"))
            modifyNum = 1;
        else if (input.equals("주소"))
            modifyNum = 2;
        else if (input.equals("번호"))
            modifyNum = 3;
        else if (input.equals("성별"))
            modifyNum = 4;
        else
            return "올바른 메뉴를 입력해 주세요.";
        System.out.println("변경하실 정보를 입력해주세요.");
        String inputInfo = scanner.nextLine();
        return mainRepository.memModify(modifyNum, name, inputInfo);
    }

    public String serviceMemDelete(int sel) {
        return mainRepository.memDelete(sel);
    }

    public String serviceMemOverPrint() {
        return mainRepository.memOverPrint();
    }


    // bookService 관련 메서드  -----------------------------------------------------------------------------------------
    public String serviceView(String inputSel) {
        return mainRepository.selectBookPrint(inputSel);
    }

    public String serviceRegister(BookDTO bookDTO) {
        return mainRepository.registerBook(bookDTO);
    }

    public String serviceModify(int sel) {
        if (sel < 0)
            return "일련번호는 음수가 될 수 없습니다.";
        int num = 0;
        System.out.println("수정을 원하시는 정보를 입력 해주세요. \nex) 제목 or 저자 or 가격");
        String input = scanner.nextLine();
        if (input.equals("제목"))
            num = 1;
        else if (input.equals("저자"))
            num = 2;
        else if (input.equals("가격"))
            num = 3;
        else
            return "올바른 메뉴를 입력해 주세요.";
        System.out.println("덮어쓸 정보를 입력해주세요.");
        String input2 = scanner.nextLine();

        return mainRepository.bookModify(sel, num, input2);
    }

    public String serviceDelete(int sel) {
        return mainRepository.bookDelete(sel);
    }

    public String serviceOverPrint() {
        return mainRepository.bookOverPrint();
    }


    // returnBook 관련 메서드 -------------------------------------------------------------------------------------------
    public String serviceBookReturn(int num) {
        return mainRepository.bookReturn(num);
    }


    // OrderService 관련 메서드  ----------------------------------------------------------------------------------------
}
