package hu.nyirszikszi.spring.dolgozat1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Component
public class LottoSzamok {
    Scanner sc = new Scanner(System.in);
    private int szamok;

    @Autowired
    LottoSzelveny lottoSzelveny;

    public LottoSzamok(LottoSzelveny lottoSzelveny, List<Integer> otosLottoSzamai, int szamok) {
        this.lottoSzelveny = lottoSzelveny;
        this.otosLottoSzamai = otosLottoSzamai;
        this.szamok = szamok;
    }

    public LottoSzamok() {
    }

    public int getSzamok() {
        return szamok;
    }

    public void lottoVetel() {
        System.out.print("5-ös, vagy 6-os lottót kér?: ");
        int nyeroszamokMennyisege = sc.nextInt();
        while (nyeroszamokMennyisege != 5 || nyeroszamokMennyisege != 6) {
            System.out.print("Rossz számot adott meg, kérem adjon meg egy új számot!: ");
            nyeroszamokMennyisege = sc.nextInt();
        }
        szamok = nyeroszamokMennyisege;
    }


    private List<Integer> otosLottoSzamai = new ArrayList<>();
    private List<Integer> hatosLottoSzamai = new ArrayList<>();

    @PostConstruct
    public void otosLottoFeltolt() {
        Random random5 = new Random();
        for (int i = 0; i < 5; i++) {
            if (Integer.parseInt(random5.toString()) > 0 && Integer.parseInt(random5.toString()) <= 90) {
                otosLottoSzamai.add(Integer.parseInt(random5.toString()));
                if (otosLottoSzamai.contains(Integer.parseInt(random5.toString()))) {
                    otosLottoSzamai.remove(Integer.parseInt(random5.toString()));
                }
            }
        }
    }

    @PostConstruct
    public void hatosLottoFeltolt() {
        Random random6 = new Random();
        for (int i = 0; i < 6; i++) {
            if (Integer.parseInt(random6.toString()) > 0 && Integer.parseInt(random6.toString()) <= 100) {
                hatosLottoSzamai.add(Integer.parseInt(random6.toString()));
                if (hatosLottoSzamai.contains(Integer.parseInt(random6.toString()))) {
                    hatosLottoSzamai.remove(Integer.parseInt(random6.toString()));
                }
            }
        }
    }
}

