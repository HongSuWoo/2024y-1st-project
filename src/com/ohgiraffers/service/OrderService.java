package com.ohgiraffers.service;

import com.ohgiraffers.dao.MainRepository;
import com.ohgiraffers.dto.BookDTO;
import com.ohgiraffers.dto.MemberDTO;

import java.util.Scanner;


public class OrderService {
    Scanner sc = new Scanner(System.in);
    MainRepository mr = new MainRepository();

    public String serviceView(String inputSel) {
        return mr.selectBookPrint(inputSel);
    }

    public String serviceRegist(BookDTO bookDTO) {
        return mr.registerBook(bookDTO);
    }

    public String serviceOverPrint() {
        return mr.bookOverPrint();
    }

    public String serviceModify(int sel) {
        if (sel < 0)
            return "번호를 확인하렴.";
        int num = 0;
        System.out.println("수정을 원하시는 정보를 입력 해주세요. \nex) 제목 저자 가격");
        String input = sc.nextLine();
        if (input.equals("제목"))
            num = 1;
        else if (input.equals("저자"))
            num = 2;
        else if (input.equals("가격"))
            num = 3;
        else
            return "글자를 확인하여 다시 쳐주세요.";
        System.out.println("덮어쓸 정보를 입력해주세요.");
        String input2 = sc.nextLine();

        return mr.bookModify(sel, num, input2);
    }

    public String serviceDelete(int sel) {
        return mr.bookDelete(sel);
    }

    public String serviceMemRegist(MemberDTO memberDTO) {
        return mr.registerMember(memberDTO);
    }

    public String serviceMemberView(String inputSel) {
        return mr.memSelectPrint(inputSel);
    }

    public String serviceMemModify(String name) {
        System.out.println("수정을 원하시는 정보를 입력 해주세요. \nex)이름 주소 번호 성별");
        String input = sc.nextLine();
        int num = 0;
        if (input.equals("이름"))
            num = 1;
        else if (input.equals("주소"))
            num = 2;
        else if (input.equals("번호"))
            num = 3;
        else if (input.equals("성별"))
            num = 4;
        else
            return "글자를 확인하여 다시 쳐주세요.";
        System.out.println("변경하실 정보를 입력해주세요.");
        String input2 = sc.nextLine();
        return mr.memModify(num, name, input2);
    }

    public String serviceMemDelete(int sel) {
        return mr.memDelete(sel);
    }

    public String serviceMemOverPrint() {
        return mr.memOverPrint();
    }

    public String serviceMemincome(int income, int num) {
        return mr.trincome(income, num);
    }

    public int serviceRental(String name) {
        return mr.memRental(name);
    }

    public String serviceBookRental(int bookNum, int memNum) {
        return mr.bookRental(bookNum, memNum);
    }

    public String serviceBookReturn(int num) {
        return mr.bookReturn(num);
    }

}
