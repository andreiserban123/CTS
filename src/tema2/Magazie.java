package tema2;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Magazie {
    private final Map<MateriePrima, Queue<LotMateriePrima>> stocuri;
    private final ReentrantReadWriteLock lock;

    public Magazie() {
        this.stocuri = new HashMap<>();
        this.lock = new ReentrantReadWriteLock();
    }

    public void adaugaStoc(MateriePrima materiePrima, double cantitate) {
        lock.writeLock().lock();

        try {
            Queue<LotMateriePrima> loturi = stocuri.computeIfAbsent(materiePrima, k -> new LinkedList<>());
            LotMateriePrima lot = new LotMateriePrima(materiePrima, cantitate, new Date());
            loturi.add(lot);
            System.out.println("Adaugat in stoc: " + lot);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean verficaStoc(Ingredient ingredient) {
        lock.readLock().lock();
        try {

            double cantitateNecesarea = ingredient.getCantitate();

            Queue<LotMateriePrima> loturi = stocuri.get(ingredient.getMateriePrima());

            if (loturi == null) {
                return false;
            }

            double cantiateDisponibila = loturi.stream()
                    .mapToDouble(LotMateriePrima::getCantitate)
                    .sum();

            return cantiateDisponibila >= cantitateNecesarea;

        } finally {
            lock.readLock().unlock();
        }
    }

    public boolean verificaStoc(Preparat preparat, int cantitate) {
        lock.readLock().lock();
        try {
            for (Ingredient ingredient : preparat.getIngrediente()) {
                double cantitateNecesara = ingredient.getCantitate() * cantitate;
                Queue<LotMateriePrima> loturi = stocuri.get(ingredient.getMateriePrima());

                if (loturi == null) {
                    return false;
                }

                double cantitateDisponibila = loturi.stream()
                        .mapToDouble(LotMateriePrima::getCantitate)
                        .sum();

                if (cantitateDisponibila < cantitateNecesara) {
                    return false;
                }
            }
            return true;
        } finally {
            lock.readLock().unlock();
        }
    }

    public boolean extrageMateriiPrime(Preparat preparat, int cantitate) {
        lock.writeLock().lock();
        try {
            if (!verificaStoc(preparat, cantitate)) {
                return false;
            }


            for (Ingredient ingredient : preparat.getIngrediente()) {
                double cantitateNecesara = ingredient.getCantitate() * cantitate;
                Queue<LotMateriePrima> loturi = stocuri.get(ingredient.getMateriePrima());

                while (cantitateNecesara > 0) {
                    LotMateriePrima lot = loturi.peek();

                    if (lot.getCantitate() <= cantitateNecesara) {
                        cantitateNecesara -= lot.getCantitate();
                        loturi.poll();
                        System.out.println("Lot epuizat: " + lot);
                    } else {

                        lot.setCantitate(lot.getCantitate() - cantitateNecesara);
                        cantitateNecesara = 0;
                        System.out.println("Extras din lot: " + cantitateNecesara + " " +
                                lot.getMateriePrima().getUnitateMasura() + " din " + lot);
                    }
                }


                if (loturi.isEmpty()) {
                    stocuri.remove(ingredient.getMateriePrima());
                }
            }

            System.out.println("Materiile prime pentru " + preparat.getNume() +
                    " x " + cantitate + " au fost extrase cu succes");
            return true;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void afiseazaStoc() {
        lock.readLock().lock();
        try {
            System.out.println("=== STOC MAGAZIE ===");
            if (stocuri.isEmpty()) {
                System.out.println("Magazie goală!");
                return;
            }

            for (Map.Entry<MateriePrima, Queue<LotMateriePrima>> entry : stocuri.entrySet()) {
                MateriePrima mp = entry.getKey();
                Queue<LotMateriePrima> loturi = entry.getValue();

                double cantitateTotal = loturi.stream()
                        .mapToDouble(LotMateriePrima::getCantitate)
                        .sum();

                System.out.println(mp.getNume() + ": " + cantitateTotal + " " + mp.getUnitateMasura());

                System.out.println("  Loturi:");
                for (LotMateriePrima lot : loturi) {
                    System.out.println("  - " + lot.getCantitate() + " " +
                            mp.getUnitateMasura() + " (intrare: " + lot.getDataIntrare() + ")");
                }
            }
            System.out.println("===================");
        } finally {
            lock.readLock().unlock();
        }
    }
}
