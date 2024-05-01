package com.ohgiraffers;
//뭐야 이건 젠장
import com.ohgiraffers.order.controller.OrderController;
import com.ohgiraffers.service.OrderService;
import java.util.Scanner;

public class Application
{
    public static void main(String[] args)
    {
        boolean onIs = true;
        Scanner sc = new Scanner(System.in);
        OrderController oc = new OrderController();
        OrderService    os = new OrderService();
        oc.basicBookRegist();
        oc.basicMemberRegist();

        int input;
        do
             {
                System.out.println("====도서 관리 프로그램====");
                System.out.println("1. 대   출");
                System.out.println("2. 회원관리");
                System.out.println("3. 도서관리");
                System.out.println("4. 반   납");
//                System.out.println("5. 로그인");
//                System.out.println("6. 로그아웃");
                System.out.println("7. 종   료");
                System.out.print("메뉴를 선택해 주세요. -> ");

                input = sc.nextInt();
                sc.nextLine();
                switch (input)
                {
                    case 1:
                        System.out.print("회원이름을 입력 해주세요. -> ");
                        oc.rentalService();
                    break;
                    case 2: oc.memberService();
                    break;
                    case 3: oc.bookService();
                    break;
                    case 4: oc.returnBook();
                    break;
//                    case 5:
//                    break;
//                    case 6:
//                    break;
                    case 7:
                        onIs=false;
                    break;
                    default :
                        System.out.println("입력을 확인해 주세요.");
                    break;
                }
        }while(onIs);
    }
}
