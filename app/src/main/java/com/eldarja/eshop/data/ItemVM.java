package com.eldarja.eshop.data;

import java.util.List;

public class ItemVM {

    private int ItemID;
    private String ItemNaziv;
    private List<KategorijaVM> KategorijeList;

    public ItemVM(String itemNaziv, List<KategorijaVM> kategorijeList) {
        ItemNaziv = itemNaziv;
        KategorijeList = kategorijeList;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public String getItemNaziv() {
        return ItemNaziv;
    }

    public void setItemNaziv(String itemNaziv) {
        ItemNaziv = itemNaziv;
    }

    public List<KategorijaVM> getKategorijeList() {
        return KategorijeList;
    }

    public void setKategorijeList(List<KategorijaVM> kategorijeList) {
        KategorijeList = kategorijeList;
    }

    public void removeFromKategorija(List<KategorijaVM> kategorije) {
        for (KategorijaVM k:kategorije) {
            if (this.KategorijeList.contains(k)) {
                this.KategorijeList.remove(k);
            }
        }
    }

    public void addToKategorija(List<KategorijaVM> kategorije) {
        for (KategorijaVM k:kategorije) {
            if (!this.KategorijeList.contains(k)) this.KategorijeList.add(k);
        }
    }
}
