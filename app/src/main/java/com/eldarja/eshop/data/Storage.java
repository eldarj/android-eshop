package com.eldarja.eshop.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Storage {
    public static List<KategorijaVM> kategorije;
    public static int brojacKategorija = 0;

    public static List<ItemVM> itemi;

    public static List<ItemVM> getItemi() {
        if (itemi == null) {
            itemi = new ArrayList<>();
            //itemi.add(new ItemVM("Sony TV 45''", getKategorije())); //dodaj u sve kategorije
            // dodaj u specificnu kategoriju
            itemi.add(new ItemVM("Samsung 150\", OX9", Arrays.asList(getKategorijaById(0))));
            itemi.add(new ItemVM("Grundig 39\" MM1", Arrays.asList(getKategorijaById(0))));
            itemi.add(new ItemVM("Huawei Lite 9", Arrays.asList(getKategorijaById(2))));
            itemi.add(new ItemVM("Huawei Mate 16", Arrays.asList(getKategorijaById(2))));
            itemi.add(new ItemVM("Samsung J12 2025", Arrays.asList(getKategorijaById(2))));
            itemi.add(new ItemVM("Lenovo PAX91", Arrays.asList(getKategorijaById(1))));
            itemi.add(new ItemVM("Lenovo 9595", Arrays.asList(getKategorijaById(1))));
            //ili
            itemi.add(new ItemVM("Asus K550JX", new ArrayList<KategorijaVM>() {{
                    add(getKategorijaById(1));
                }}
            ));
        }
        return itemi;
    }

    public static List<ItemVM> getItemi(KategorijaVM kat) {
        List<ItemVM> itms = new ArrayList<>(getItemi());
        Iterator itr = itms.iterator();
        while(itr.hasNext()) {
            ItemVM obj = (ItemVM) itr.next();
            if (!obj.getKategorijeList().contains(kat)){
                itr.remove();
            }
        }
        return itms;
    }

    public static void setItemi(List<ItemVM> itemi) {
        Storage.itemi = itemi;
    }

    public static List<KategorijaVM> getKategorije() {
        if(kategorije == null) {
            kategorije = new ArrayList<>();
            kategorije.add(new KategorijaVM("TV"));
            kategorije.add(new KategorijaVM("Laptopi"));
            kategorije.add(new KategorijaVM("Mobiteli"));
        }
        return kategorije;
    }

    public static KategorijaVM getKategorijaById(int id) {
        List<KategorijaVM> kategorije = getKategorije();
        for (KategorijaVM k :
                kategorije) {
            if (k.getId() == id) return k;
        }
        return null;
    }

    public static void setKategorije(List<KategorijaVM> kategorije) {
        Storage.kategorije = kategorije;
    }
}
