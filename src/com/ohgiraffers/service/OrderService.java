package com.ohgiraffers.service;

import com.ohgiraffers.dao.BookRepository;
import com.ohgiraffers.dto.BookDTO;
import com.ohgiraffers.dto.MemberDTO;

import java.util.Scanner;


public class OrderService
{
    Scanner sc=new Scanner(System.in);
    BookRepository br = new BookRepository();
    public String servcieView(String inputSel)
    {
        return br.selectBookPrint(inputSel);
    }
    public String serviceRegist(BookDTO bookDTO)
    {
        return br.registerBook(bookDTO);
    }
    public String serviceOverPrint()
    {
        return br.bookOverPrint();
    }
    public String serviceModify(int sel)
    {
        if(sel < 0)
            return "번호를 확인하렴.";
        int num=0;
        System.out.println("수정을 원하시는 정보를 입력 해주세요. \nex) 제목 저자 가격");
        String input = sc.nextLine();
        if(input.equals("제목"))
            num=1;
        else if(input.equals("저자"))
            num=2;
        else if(input.equals("가격"))
            num=3;
        else
            return "글자를 확인하여 다시 쳐주세요.";
        System.out.println("덮어쓸 정보를 입력해주세요.");
        String input2 = sc.nextLine();

        return br.bookModify(sel,num,input2);
    }
    public String serviceDelete(int sel)
    {
        return br.bookDelete(sel);
    }
    public String serviceMemRegist(MemberDTO memberDTO)
    {
        return br.registerMember(memberDTO);
    }
    public String serviceMemberView(String inputSel)
    {
        return br.memSelectPrint(inputSel);
    }
    public String serviceMemModify(String name)
    {
        System.out.println("수정을 원하시는 정보를 입력 해주세요. \nex)이름 주소 번호 성별");
        String input = sc.nextLine();
        int num=0;
        if(input.equals("이름"))
            num=1;
        else if(input.equals("주소"))
            num=2;
        else if(input.equals("번호"))
            num=3;
        else if (input.equals("성별"))
            num=4;
        else
            return "글자를 확인하여 다시 쳐주세요.";
        System.out.println("변경하실 정보를 입력해주세요.");
        String input2 = sc.nextLine();
        return br.memModify(num,name,input2);
    }
    public String serviceMemDelete(int sel)
    {
        return br.memDelete(sel);
    }
    public String serviceMemOverPrint()
    {
        return br.memOverPrint();
    }
    public String serviceMemincome(int income,int num)
    {
        return br.trincome(income,num);
    }
    public int serviceRental(String name)
    {
        return br.memRental(name);
    }
    public String serviceBookRental(int bookNum,int memNum)
    {
        return br.bookRental(bookNum,memNum);
    }
    public String serviceBookReturn(int num)
    {
        return br.bookReturn(num);
    }

}
