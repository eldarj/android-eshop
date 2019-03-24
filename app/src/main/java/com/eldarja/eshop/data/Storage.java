package com.eldarja.eshop.data;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<KategorijaVM> kategorije;
    public static int brojacKategorija = 0;

    public static List<KategorijaVM> getKategorije() {
        if(kategorije == null) {
            kategorije = new ArrayList<>();
            kategorije.add(new KategorijaVM("Clothing"));
            kategorije.add(new KategorijaVM("Electornics"));
            kategorije.add(new KategorijaVM("Toys"));
        }
        return kategorije;
    }

    public static void setKategorije(List<KategorijaVM> kategorije) {
        Storage.kategorije = kategorije;
    }
}
