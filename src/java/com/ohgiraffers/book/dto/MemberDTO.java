package com.ohgiraffers.book.dto;

public class MemberDTO {
    private int memberNum;
    private String memberName;
    private String memberAddress;
    private String memberPhone;
    private String memberRentalList;
    private String memberGender;
    private int memberMoney;

    // MemberDTO ------------------------------------------------------------------------------------------------------
    public MemberDTO(String memberName, String memberAddress, String memberPhone, String memberGender) {
        this.memberName = memberName;
        this.memberAddress = memberAddress;
        this.memberPhone = memberPhone;
        this.memberGender = memberGender;
    }

    // Getter & Setter ------------------------------------------------------------------------------------------------
    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
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


    // toString -------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "회원번호: " + memberNum +
                " 이름: " + memberName +
                " 주소: " + memberAddress +
                " 번호: " + memberPhone +
                " 대여목록: " + memberRentalList +
                " 성별: " + memberGender +
                " 잔액: " + memberMoney +
                "\n";
    }
}
