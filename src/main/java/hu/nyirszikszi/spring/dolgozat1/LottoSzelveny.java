package hu.nyirszikszi.spring.dolgozat1;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LottoSzelveny {
    private int nyeremeny;

    public LottoSzelveny(int nyeremeny, Scanner sc) {
        this.nyeremeny = nyeremeny;
        this.sc = sc;
    }

    public LottoSzelveny() {
    }

    Scanner sc = new Scanner(System.in);

    public void setNyeremeny(){
        System.out.print("Mennyi legyen a nyeremény?: ");
        if(nyeremeny > 0 && nyeremeny < 100000000) {
            int nyeremeny = sc.nextInt();
        }
    }

}