package hu.nyirszikszi.spring.dolgozat1;

import com.sun.source.doctree.BlockTagTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class LottoVetel {
    @Autowired
    LottoSzelveny lottoSzelveny;
    @Autowired
    LottoSzamok lottoSzamok;

    Scanner sc = new Scanner(System.in);

    private List<Integer> sajatSzamaim = new ArrayList<>();

    public void szelvenyVetel(){
        lottoSzamok.lottoVetel();
        int szamok = lottoSzamok.getSzamok();
        List<Integer> enSzamaim = new ArrayList<>();
        for (int i = 0; i < szamok; i++) {
            System.out.print("Írja be a számait: ");
            int szamom = sc.nextInt();
            enSzamaim.add(szamom);
        }
        if (enSzamaim.contains(lottoSzamok.getSzamok())){
            System.out.println("Gratulálok! Vannak nyerőszámai! ");
        }
    }
}
