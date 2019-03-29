package com.eldarja.eshop.data;

import java.io.Serializable;
import java.util.List;

public class KategorijaVM implements Serializable {
    public int id;
    public String naziv;
    public static int idCounter = 0;

    public KategorijaVM(String naziv) {
        this.naziv = naziv;
        id = idCounter++;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public List<ItemVM> getItems() {
        return Storage.getItemi(this);
    }

    public boolean removeItem(ItemVM item) {
        for (ItemVM i : getItems()) {
            if (i.equals(item)) {
                Storage.itemi.remove(i);
                return true;
            }
        }
        return false;
    }
}
