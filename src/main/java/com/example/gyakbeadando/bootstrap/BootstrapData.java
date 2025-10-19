package com.example.gyakbeadando.bootstrap;

import com.example.gyakbeadando.model.*;
import com.example.gyakbeadando.repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Configuration
public class BootstrapData {

    @Bean
    CommandLineRunner seed(ApplicationContext ctx,
                           ProcesszorRepository procRepo,
                           OprendszerRepository osRepo,
                           GepRepository gepRepo) {
        return args -> {
            //System.out.println("== BootstrapData START ==");

            // 1) processzorok
            //System.out.println("Processzor count BEFORE: " + procRepo.count());
            if (procRepo.count() == 0) {
                try (BufferedReader br = open(ctx, "classpath:data/processzor.txt")) {
                    String line = br.readLine(); // header
                    int rows = 0;
                    while ((line = br.readLine()) != null) {
                        String[] p = line.split("\\t");
                        if (p.length < 3) continue;
                        Long id = Long.valueOf(p[0].trim());
                        String gyarto = p[1].trim();
                        String tipus  = p[2].trim();
                        procRepo.save(new Processzor(id, gyarto, tipus));
                        rows++;
                    }
                    //System.out.println("Processzor inserted: " + rows);
                }
            }
            //System.out.println("Processzor count AFTER: " + procRepo.count());

            // 2) oprendszerek
            //System.out.println("Oprendszer count BEFORE: " + osRepo.count());
            if (osRepo.count() == 0) {
                try (BufferedReader br = open(ctx, "classpath:data/oprendszer.txt")) {
                    String line = br.readLine(); // header
                    int rows = 0;
                    while ((line = br.readLine()) != null) {
                        String[] p = line.split("\\t");
                        if (p.length < 2) continue;
                        Long id = Long.valueOf(p[0].trim());
                        String nev = p[1].trim();
                        osRepo.save(new Oprendszer(id, nev));
                        rows++;
                    }
                    //System.out.println("Oprendszer inserted: " + rows);
                }
            }
            //System.out.println("Oprendszer count AFTER: " + osRepo.count());

            // 3) gepek
            //System.out.println("Gep count BEFORE: " + gepRepo.count());
            if (gepRepo.count() == 0) {
                try (BufferedReader br = open(ctx, "classpath:data/gep.txt")) {
                    String line = br.readLine(); // header
                    int rows = 0;
                    while ((line = br.readLine()) != null) {
                        String[] p = line.split("\\t");
                        if (p.length < 10) continue;

                        String gyarto = p[0].trim();
                        String tipus  = p[1].trim();
                        Double kijelzo = parseDouble(p[2]);
                        Integer memoria = parseInt(p[3]);
                        Integer merevlemez = parseInt(p[4]);
                        String videovezerlo = p[5].trim();
                        Integer ar = parseInt(p[6]);
                        Long processzorId = Long.valueOf(p[7].trim());
                        Long oprendszerId = Long.valueOf(p[8].trim());
                        Integer db = parseInt(p[9]);

                        Processzor proc = procRepo.findById(processzorId)
                                .orElseThrow(() -> new IllegalStateException("Lost processzor id=" + processzorId));
                        Oprendszer os = osRepo.findById(oprendszerId)
                                .orElseThrow(() -> new IllegalStateException("Lost oprendszer id=" + oprendszerId));

                        Gep g = new Gep();
                        g.setGyarto(gyarto);
                        g.setTipus(tipus);
                        g.setKijelzo(kijelzo);
                        g.setMemoria(memoria);
                        g.setMerevlemez(merevlemez);
                        g.setVideovezerlo(videovezerlo);
                        g.setAr(ar);
                        g.setDbMennyiseg(db);
                        g.setProcesszor(proc);
                        g.setOprendszer(os);

                        gepRepo.save(g);
                        rows++;
                    }
                    //System.out.println("Gep inserted: " + rows);
                }
            }
            //System.out.println("Gep count AFTER: " + gepRepo.count());

            //System.out.println("== BootstrapData END ==");
        };
    }

    private BufferedReader open(ApplicationContext ctx, String location) throws IOException {
        Resource r = ctx.getResource(location);
        //System.out.println("Loading resource: " + location + " | exists=" + r.exists() + " | filename=" + r.getFilename());
        if (!r.exists()) {
            throw new FileNotFoundException("Nem találom: " + location + " (tedd ide: src/main/resources/data/...)");
        }
        return new BufferedReader(new InputStreamReader(r.getInputStream(), StandardCharsets.UTF_8));
    }

    private static Integer parseInt(String s) { return Integer.valueOf(s.trim()); }
    private static Double parseDouble(String s) { return Double.valueOf(s.trim().replace(',', '.')); }
}
