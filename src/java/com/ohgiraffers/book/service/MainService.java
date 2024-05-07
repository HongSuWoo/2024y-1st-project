package com.ohgiraffers.book.service;

import com.ohgiraffers.book.dao.MainRepository;
import com.ohgiraffers.book.dto.BookDTO;
import com.ohgiraffers.book.dto.MemberDTO;

import java.util.Scanner;

public class MainService {
    Scanner scanner = new Scanner(System.in);
    MainRepository mainRepository = new MainRepository();


    // rentalService 관련 메서드 ----------------------------------------------------------------------------------------
    public int serviceMemberNameVerification(String name) {
        return mainRepository.memberNameVerification(name);
    }

    public String serviceChargeBalance(int income, int num) {
        return mainRepository.chargeBalance(income, num);
    }

    public String serviceBookRental(int bookNum, int memNum) {
        return mainRepository.bookRental(bookNum, memNum);
    }


    // memberService 관련 메서드 ----------------------------------------------------------------------------------------
    public String serviceSelectMemberPrint(String inputSel) {
        return mainRepository.selectMemberPrint(inputSel);
    }

    public String serviceRegisterMember(MemberDTO memberDTO) {
        return mainRepository.registerMember(memberDTO);
    }

    public String serviceMemberModify(String userName) {

        memberModify(userName,"이름", "주소", "번호", "성별");

        return "수정 완료";
    }

    public String serviceMemberDelete(int inputNum) {
        return mainRepository.memberDelete(inputNum);
    }

    public String serviceAllMemberPrint() {
        return mainRepository.allMemberPrint();
    }


    // bookService 관련 메서드  -----------------------------------------------------------------------------------------
    public String serviceSelectBookPrint(String inputBookNumber) {
        return mainRepository.selectBookPrint(inputBookNumber);
    }

    public String serviceRegisterBook(BookDTO bookDTO) {
        return mainRepository.registerBook(bookDTO);
    }

    public String serviceBookModify(int inputNum) {
        int modifyNum = 0;
        String inputInfo = "";
        if (inputNum < 0)
            return "도서 번호는 음수가 될 수 없습니다.";

        bookModify(inputNum,"제목","저자","가격");

        return "수정 완료";
    }

    public String serviceBookDelete(int inputNum) {
        return mainRepository.bookDelete(inputNum);
    }

    public String serviceAllBookPrint() {
        return mainRepository.allBookPrint();
    }


    // returnBook 관련 메서드 -------------------------------------------------------------------------------------------
    public String serviceBookReturn(int bookNumber) {
        return mainRepository.bookReturn(bookNumber);
    }


    // MainService 관련 메서드 ------------------------------------------------------------------------------------------
    public void memberModify(String userName,String...name) {
        System.out.println("수정을 원하시는 정보를 입력 해주세요.");
        for (String info : name) {
            System.out.print(info + " | ");
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
        mainRepository.memberModify(modifyNum, userName, inputInfo);
    }

    public void bookModify(int inputNum,String...userName) {
        System.out.println("수정을 원하시는 정보를 입력 해주세요.");
        for (String info : userName) {
            System.out.print(info + " | ");
        }
        System.out.print(" 입력: ");
        String input = scanner.nextLine();
        int modifyNum = -1;
        for (int i = 0; i < userName.length; i++) {
            if (userName[i].equals(input)) {
                modifyNum = i + 1;
                break;
            }
        }
        if (modifyNum == -1) {
            System.out.println("잘못된 선택입니다. 다시 시도하세요.");
        }
        System.out.println("변경하실 정보를 입력해주세요.");
        String inputInfo = scanner.nextLine();
        mainRepository.bookModify(inputNum, modifyNum, inputInfo);
    }
}
