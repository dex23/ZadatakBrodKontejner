package model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by androiddevelopment on 20.1.17..
 */
@DatabaseTable(tableName = "kontejner")
public class Kontejner {
    public static final String POLJE_OZNAKA = "oznaka";
    public static final String POLJE_OPIS = "opis";
    public static final String POLJE_TEZINA = "tezina";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_OZNAKA)
    private String oznaka;
    @DatabaseField(columnName = POLJE_OPIS)
    private String opis;
    @DatabaseField(columnName = POLJE_TEZINA)
    private double tezina;

    @DatabaseField(foreign = true,foreignAutoRefresh = false)
    private Brod brod;

    public Kontejner(){

    }

    public Kontejner(String oznaka, String opis, double tezina) {
        this.oznaka = oznaka;
        this.opis = opis;
        this.tezina = tezina;
    }

    public int getId() {
        return id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public String getOpis() {
        return opis;
    }

    public double getTezina() {
        return tezina;
    }

    public Brod getBrod() {
        return brod;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public void setBrod(Brod brod) {
        this.brod = brod;
    }

    @Override
    public String toString() {
        return "Kontejner{" +
                "id=" + id +
                ", oznaka='" + oznaka + '\'' +
                ", opis='" + opis + '\'' +
                ", tezina=" + tezina +
                '}';
    }
}
