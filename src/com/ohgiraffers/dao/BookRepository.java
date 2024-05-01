package com.ohgiraffers.dao;
import com.ohgiraffers.dto.BookDTO;
import com.ohgiraffers.dto.MemberDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class BookRepository
{
    private final ArrayList<MemberDTO> memberDB = new ArrayList<>();
    private final ArrayList<BookDTO> bookDB = new ArrayList<>();
    String result ="";
    Scanner sc = new Scanner(System.in);


    public String registerBook(BookDTO bookDTO)
    {
        int oldnum = this.bookDB.size();
        this.bookDB.add(bookDTO);
        System.out.println(oldnum);
        System.out.println(this.bookDB);
        if (oldnum >= this.bookDB.size())
            return "등록실패";
        BookDTO book2;
        book2 = bookDB.get(oldnum);
        book2.setBookNum(oldnum);
        return "등록성공";
    }


    public String bookOverPrint() {
        if (bookDB.isEmpty()) {
            return "등록된 책이 없습니다.";
        }
        String result = "";
        for (BookDTO book : this.bookDB) {
            result += book.toString();
        }
        return result;
    }


    public String selectBookPrint(String inputsel)
    {
        for (BookDTO book : this.bookDB)
            if (book.getBookName().equals(inputsel))
                return book.toString();
            else
                return "없는 책 입니다.";
        int num = Integer.parseInt(inputsel);
        if (num >= this.bookDB.size())
            return "없는 번호 입니다.";
        return this.bookDB.get(num).toString();
    }

    public String bookDelete(int num)
    {
        System.out.println(bookDB.get(num).toString() + " 얘를 진짜 지울래? -> true or false");
        boolean select = sc.nextBoolean();
        if(!select)
            return "삭제하지 않고 돌아갑니다.";
        if (num < bookDB.size())
            bookDB.remove(num);
        else
            return "Error";
        return num+ " 번이 삭제 되었습니다.";
    }

    public String bookModify(int num, int num2, String data)
    {
        if (num < bookDB.size())
        {
            BookDTO books = bookDB.get(num);
            switch (num2)
            {
                case 1:
                    books.setBookName(data); break;
                case 2:
                    books.setBookName(data);
                    break;
                case 3:
                    books.setBookName(data);
                     break;
                default:
                    return "잘못된 입력입니다.";
            }
            return bookDB.toString()+" 로 수정 되었습니다.";
        }
        else
            return "잘못된 입력입니다.";

    }
    public String bookRental(int bookNum,int memNum)
    {
        if(bookNum >= bookDB.size())
            return "해당하는 책이 없습니다.";
        BookDTO books = bookDB.get(bookNum);
        System.out.println(books.toString());
        if(books.getBookRent() != null)
            return books.getBookRent()+ " 님이 해당 도서를 대여중입니다.";
        MemberDTO members = memberDB.get(memNum);

        books.setBookRent(members.getMemberName());
        if(members.getMemberRentalList()==null)
            members.setMemberRentalList(books.getBookName());
        else
            members.setMemberRentalList(members.getMemberRentalList()+" "+books.getBookName());

        members.setMemberMoney(members.getMemberMoney()-books.getBookRentalCost());
        books.setBookCount(books.getBookCount()+1);

        return members.getMemberName() +" 님에게 " + books.getBookName() +" 책 이 대여 되셨습니다.";
    }

    public String registerMember(MemberDTO memberDTO)
    {
        int oldnum = this.memberDB.size();
        this.memberDB.add(memberDTO);
        System.out.println(oldnum);
        System.out.println(this.memberDB);
        if (oldnum >= this.memberDB.size())
            return "등록실패";
        MemberDTO members;
        members = memberDB.get(oldnum);
        members.setMemberNum(oldnum);
        return "등록성공";
    }

    public String memSelectPrint(String data) {
        for (MemberDTO member : this.memberDB)
            if (member.getMemberName().equals(data))
                return member.toString();
        return "해당하는 멤버가 존재하지 않습니다.";
    }

    public String memModify(int sel, String data, String data2)
    {
        for (int i = 0; i < this.memberDB.size(); i++)
        {
            MemberDTO member = this.memberDB.get(i);
            if (member.getMemberName().equals(data))
            {
                switch (sel)
                {
                    case 1:
                        member.setMemberName(data2);
                        break;
                    case 2:
                        member.setMemberAdress(data2);
                        break;
                    case 3:
                        member.setMemberPhone(data2);
                        break;
                    case 4:
                        member.setMemberGender(data2);
                        break;
                }
                return member.toString();
            }

        }
        return "Error";
    }

    public String memDelete(int num)
    {
        System.out.println(memberDB.get(num).toString() + " 얘를 진짜 지울래? -> true or false");
        boolean select = sc.nextBoolean();
        if(!select)
            return "삭제하지 않고 돌아갑니다.";
        if (num < memberDB.size())
            memberDB.remove(num);
        else
            return "Error";
        return num+ " 번이 삭제 되었습니다.";
    }

    public String memOverPrint()
    {
        if (memberDB.isEmpty())
            return "등록된 회원이 없습니다.";
        String result = "";
        for (MemberDTO member : this.memberDB)
            result += member.toString();
        return result;
    }
    public int memRental(String name)
    {   int result=-1;
        for (MemberDTO member : this.memberDB)
            if (member.getMemberName().equals(name))
            {
                result = member.getMemberNum();
                System.out.println(member.toString());
                return result;
            }
        return result;
    }

    public String trincome(int income,int num)
    {
        MemberDTO members =this.memberDB.get(num);
        members.setMemberMoney(income);
        return members.toString()+"\n"+income + " 원이 충전 되었습니다.";

    }

    public String bookReturn(int bookNum)
    {
        if(bookNum >= bookDB.size())
            return "해당하는 책이 없습니다.";
        BookDTO books = bookDB.get(bookNum);
        System.out.println(books.toString());
        if(books.getBookRent() == null)
            return "해당 책은 대여되지 않았습니다.";
        books.setBookRent(null);
        return books.getBookName()+ " 이 반납되었습니다.";
    }




}
