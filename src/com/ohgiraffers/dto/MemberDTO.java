package com.ohgiraffers.dto;

public class MemberDTO
{
    private int memberNum;

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    private String memberName;
    private String memberAdress;
    private String memberPhone;
    private String memberRentalList;
    private String memberGender;
    private int memberMoney;


    public MemberDTO(String memberName, String memberAdress, String memberPhone, String memberGender)
    {
        this.memberName = memberName;
        this.memberAdress = memberAdress;
        this.memberPhone = memberPhone;
        this.memberGender = memberGender;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberAdress() {
        return memberAdress;
    }

    public void setMemberAdress(String memberAdress) {
        this.memberAdress = memberAdress;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberRentalList() {
        return memberRentalList;
    }

    public void setMemberRentalList(String memberRentalList) {
        this.memberRentalList = memberRentalList;
    }

    public String getMemberGender() {
        return memberGender;
    }

    public void setMemberGender(String memberGender) {
        this.memberGender = memberGender;
    }

    public int getMemberMoney() {
        return memberMoney;
    }

    public void setMemberMoney(int memberMoney) {
        this.memberMoney = memberMoney;
    }


    @Override
    public String toString() {
        return "회원정보 " +memberNum +" "+
                "이름 = " + memberName  +
                " 주소 = " + memberAdress  +
                " 번호 = " + memberPhone  +
                " 대여목록 = " + memberRentalList  +
                " 성별 = " + memberGender +
                " 금액 = " + memberMoney +
                "\n";
    }
}
