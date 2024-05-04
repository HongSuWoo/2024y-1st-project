package com.ohgiraffers.book.service;

import com.ohgiraffers.book.dao.MainRepository;
import com.ohgiraffers.book.dto.BookDTO;
import com.ohgiraffers.book.dto.MemberDTO;

import java.util.Scanner;

public class MainService {
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

    public String serviceMemModify(String userName) {

        memberModify(userName,"이름", "주소", "번호", "성별");

        return "수정 완료";
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
        int modifyNum = 0;
        String inputInfo = "";
        if (sel < 0)
            return "도서 번호는 음수가 될 수 없습니다.";

        bookModify(sel,"제목","저자","가격");

        return "수정 완료";
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


    // ----------------------------------------------------------------------------------------------------------------
    public void memberModify(String userName,String...name) {
        System.out.println("수정을 원하시는 정보를 입력 해주세요.");
        for (String info : name) {
            System.out.print(info + "|");
        }
        System.out.print(" 입력: ");
        String input = scanner.nextLine();
        int modifyNum = -1;
        for (int i = 0; i < name.length; i++) {
            if (name[i].equals(input)) {
                modifyNum = i + 1;
                break;
            }
        }
        if (modifyNum == -1) {
            System.out.println("잘못된 선택입니다. 다시 시도하세요.");
        }

        System.out.println("변경하실 정보를 입력해주세요.");
        String inputInfo = scanner.nextLine();
        mainRepository.memModify(modifyNum, userName, inputInfo);
    }

    public void bookModify(int sel,String...name) {
        System.out.println("수정을 원하시는 정보를 입력 해주세요.");
        for (String info : name) {
            System.out.print(info + "|");
        }
        System.out.print(" 입력: ");
        String input = scanner.nextLine();
        int modifyNum = -1;
        for (int i = 0; i < name.length; i++) {
            if (name[i].equals(input)) {
                modifyNum = i + 1;
                break;
            }
        }
        if (modifyNum == -1) {
            System.out.println("잘못된 선택입니다. 다시 시도하세요.");
        }

        System.out.println("변경하실 정보를 입력해주세요.");
        String inputInfo = scanner.nextLine();
        mainRepository.bookModify(sel, modifyNum, inputInfo);
    }
}
