package com.ohgiraffers.dto;


public class BookDTO
{
    private int bookNum;
    private String bookName; //1
    private String bookAuthor; //2
    private int bookPrice; //3
    private int bookCount; //
    private String bookRent; //
    private int bookRentalCost;

    int bookRentCost;
    public BookDTO(String bookName, String bookAuthor, int bookPrice)
    {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        if(this.bookPrice>=8000)
            this.bookRentalCost =1000;
        else
            this.bookRentalCost =400;

    }



    public void setBookNum(int num) {

        this.bookNum = num;

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public String getBookRent() {
        return bookRent;
    }

    public void setBookRent(String bookRent) {
        this.bookRent = bookRent;
    }


    public int getBookRentalCost() {
        return bookRentalCost;
    }



    @Override
    public String toString() {
        return "도서 " +
                "번호 = " + bookNum +
                ", 제목 = " + bookName +
                ", 저자 = " + bookAuthor +
                ", 가격 = " + bookPrice +
                ", 빌린 횟수 = " + bookCount +
                ", 빌려간분 = " + bookRent +
                ", 대여비용 = " + bookRentalCost +
                "\n";
    }
}
