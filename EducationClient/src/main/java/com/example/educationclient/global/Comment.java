package com.example.educationclient.global;

import java.util.Scanner;

public class Comment {

    Scanner sc;

    public static final String RESET = "\u001B[0m";
    public static final String FONT_RED = "\u001B[31m";
    public static final String FONT_BLUE = "\u001B[34m";

    public Comment() {
        this.sc = new Scanner(System.in);
    }

    public int initial() {
        System.out.println("-------------------- 👨🏻‍🎓 [ 명지대학교 수강신청 시스템 ] 👨🏻‍🎓 ---------------------");
        System.out.println("1.학생 시스템 \n2.관리자 시스템\n0.종료");
        System.out.print("번호 입력:");
        return sc.nextInt();
    }
}
