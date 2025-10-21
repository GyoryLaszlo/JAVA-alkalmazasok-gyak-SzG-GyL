package com.example.gyakbeadando.service;

import com.example.gyakbeadando.model.Gep;
import com.example.gyakbeadando.repo.GepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DiagramService {
    @Autowired
    private GepRepository gepRepo;

    public Map<String, Integer> getAvgPricesByManufacturer() {
        List<Gep> notebooks = gepRepo.findAll();
        Map<String, Integer> prices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();
        Map<String, Integer> avgsByManufacturers = new HashMap<>();
        String manufacturer;
        int price = 0;

        for (Gep gep : notebooks) {
            manufacturer = gep.getProcesszor().getGyarto();
            price = gep.getAr();
            if (!prices.containsKey(manufacturer)) {
                prices.put(manufacturer, price);
                counts.put(manufacturer, 1);
            } else {
                prices.put(manufacturer, prices.get(manufacturer) + price);
                counts.put(manufacturer, counts.get(manufacturer) + 1);
            }
        }

        for (String p : prices.keySet()) {
            int avgPrice = (int) (prices.get(p) / counts.get(p));
            avgsByManufacturers.put(p, avgPrice);
        }

        return avgsByManufacturers;
    }

    public Map<String, Integer> getNotebookCountByOS() {
        List<Gep> notebooks = gepRepo.findAll();
        Map<String, Integer> countByOS = new HashMap<>();

        for (Gep gep : notebooks) {
            String osName = normalizeOSName(gep.getOprendszer().getNev());
            countByOS.put(osName, countByOS.getOrDefault(osName, 0) + 1);
        }

        return countByOS;
    }

    private String normalizeOSName(String raw) {
        if (raw == null) return "Ismeretlen";

        String lower = raw.toLowerCase();

        if (lower.contains("windows xp")) return "Windows XP";
        if (lower.contains("vista")) return "Windows Vista";
        if (lower.contains("windows 7")) return "Windows 7";
        if (lower.contains("linux")) return "Linux";
        if (lower.contains("freedos")) return "FreeDOS";
        if (lower.contains("nincs")) return "Nincs OS";

        return raw;
    }
}
