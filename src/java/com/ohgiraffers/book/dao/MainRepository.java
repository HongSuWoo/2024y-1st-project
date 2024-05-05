package com.ohgiraffers.book.dao;

import com.ohgiraffers.book.dto.BookDTO;
import com.ohgiraffers.book.dto.MemberDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class MainRepository {
    private final ArrayList<MemberDTO> memberDB = new ArrayList<>();
    private final ArrayList<BookDTO> bookDB = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    // rentalService 관련 메서드 ----------------------------------------------------------------------------------------
    public int memberNameVerification(String memberName) {
        int result = -1;
        for (MemberDTO member : this.memberDB)
            if (member.getMemberName().equals(memberName)) {
                result = member.getMemberNum();
                System.out.println(member.toString());
                return result;
            }
        return result;
    }

    public String chargeBalance(int balance, int memberNumber) {
        MemberDTO members = this.memberDB.get(memberNumber);
        members.setMemberMoney(balance);
        return members.toString() + "\n" + balance + " 원이 충전 되었습니다.";
    }

    public String bookRental(int bookNumber, int memberNumber) {
        if (bookNumber >= bookDB.size()) {
            return "해당하는 도서가 없습니다.";
        }
        BookDTO books = bookDB.get(bookNumber);
        System.out.println(books.toString());
        if (books.getBookRent() != null) {
            return books.getBookRent() + " 님이 해당 도서를 대여중입니다.";
        }
        MemberDTO members = memberDB.get(memberNumber);
        books.setBookRent(members.getMemberName());
        if (members.getMemberRentalList() == null) {
            members.setMemberRentalList(books.getBookName());
        } else {
            members.setMemberRentalList(members.getMemberRentalList() + " " + books.getBookName());
        }
        members.setMemberMoney(members.getMemberMoney() - books.getBookRentalCost());
        books.setBookCount(books.getBookCount() + 1);

        return members.getMemberName() + " 님에게 " + books.getBookName() + " 이 대여 되셨습니다.";
    }


    // memberService 관련 메서드 ----------------------------------------------------------------------------------------
    public String selectMemberPrint(String memberName) {
        for (MemberDTO member : this.memberDB) {
            if (member.getMemberName().equals(memberName)) {
                return member.toString();
            }
            return member.toString();
        }
        return "해당하는 멤버가 존재하지 않습니다.";
    }

    public String registerMember(MemberDTO memberDTO) {
        int memberDBSize = this.memberDB.size();
        this.memberDB.add(memberDTO);
        System.out.println(this.memberDB);
        if (memberDBSize >= this.memberDB.size()) {
            return "등록실패";
        }
        MemberDTO members;
        members = memberDB.get(memberDBSize);
        members.setMemberNum(memberDBSize);
        return "등록성공";
    }

    public String memberModify(int modifyNum, String userName, String inputInfo) {
        for (int i = 0; i < this.memberDB.size(); i++) {
            MemberDTO member = this.memberDB.get(i);
            if (member.getMemberName().equals(userName)) {
                switch (modifyNum) {
                    case 1 -> {
                        member.setMemberName(inputInfo);
                    }
                    case 2 -> {
                        member.setMemberAddress(inputInfo);
                    }
                    case 3 -> {
                        member.setMemberPhone(inputInfo);
                    }
                    case 4 -> {
                        member.setMemberGender(inputInfo);
                    }
                    default -> {
                        return member.toString();
                    }
                }
            }
        }
        return "올바른 값을 입력하세요.";
    }

    public String memberDelete(int inputNum) {
        System.out.println(memberDB.get(inputNum).toString() + "선택한 회원을 삭제하시겠습니까?");
        System.out.print("true | false : ");
        boolean select = scanner.nextBoolean();
        if (!select) {
            return "삭제하지 않고 돌아갑니다.";
        }
        if (inputNum < memberDB.size()) {
            memberDB.remove(inputNum);
        } else {
            return "잘못된 입력입니다.";
        }
        return inputNum + " 번이 삭제 되었습니다.";
    }

    public String allMemberPrint() {
        if (memberDB.isEmpty()) {
            return "등록된 회원이 없습니다.";
        }
        String result = "";
        for (MemberDTO member : this.memberDB) {
            result += member.toString();
        }
        return result;
    }


    // bookService 관련 메서드  -----------------------------------------------------------------------------------------
    public String selectBookPrint(String inputBookNumber) {
        for (BookDTO book : this.bookDB) {
            if (book.getBookName().equals(inputBookNumber)) {
                return book.toString();
            } else {
                return "없는 책 입니다.";
            }
        }
        int num = Integer.parseInt(inputBookNumber);
        if (num >= this.bookDB.size()) {
            return "없는 번호 입니다.";
        }
        return this.bookDB.get(num).toString();
    }

    public String registerBook(BookDTO bookDTO) {
        int bookDBSize = this.bookDB.size();
        this.bookDB.add(bookDTO);
        System.out.println(bookDBSize);
        System.out.println(this.bookDB);
        if (bookDBSize >= this.bookDB.size()) {
            return "등록실패";
        }
        BookDTO book2;
        book2 = bookDB.get(bookDBSize);
        book2.setBookNum(bookDBSize);
        return "등록성공";
    }

    public String bookModify(int inputNum, int modifyNum, String inputInfo) {
        if (inputNum < bookDB.size()) {
            BookDTO books = bookDB.get(inputNum);
            switch (modifyNum) {
                case 1 -> {
                    books.setBookName(inputInfo);
                }
                case 2 -> {
                    books.setBookAuthor(inputInfo);
                }
                case 3 -> {
                    books.setBookPrice(Integer.parseInt(inputInfo));
                }
                default -> {
                    return "잘못된 입력입니다.";
                }
            }
            return bookDB.toString() + " 로 수정 되었습니다.";
        } else {
            return "잘못된 입력입니다.";
        }
    }

    public String bookDelete(int inputNum) {
        System.out.println(bookDB.get(inputNum).toString() + "선택한 도서를 삭제하시겠습니까?");
        System.out.print("true | false : ");
        boolean select = scanner.nextBoolean();
        if (!select) {
            return "삭제하지 않고 돌아갑니다.";
        }
        if (inputNum < bookDB.size()) {
            bookDB.remove(inputNum);
        } else {
            return "잘못된 입력입니다.";
        }
        return inputNum + " 번이 삭제 되었습니다.";
    }

    public String allBookPrint() {
        if (bookDB.isEmpty()) {
            return "등록된 책이 없습니다.";
        }
        String result = "";
        for (BookDTO book : this.bookDB) {
            result += book.toString();
        }
        return result;
    }

    public String bookReturn(int bookNumber) {
        if (bookNumber >= bookDB.size()) {
            return "해당하는 책이 없습니다.";
        }
        BookDTO books = bookDB.get(bookNumber);
        System.out.println(books.toString());
        if (books.getBookRent() == null) {
            return "해당 책은 대여되지 않았습니다.";
        }
        books.setBookRent(null);
        return books.getBookName() + " 이 반납되었습니다.";
    }
}
