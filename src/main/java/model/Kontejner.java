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
    public static final String POLJE_NAZIV = "naziv";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_OZNAKA)
    private String oznaka;
    @DatabaseField(columnName = POLJE_NAZIV)
    private String naziv;

    @ForeignCollectionField(foreignFieldName = "brod")
    private ForeignCollection<Kontejner> kontejner;

    public Kontejner(){

    }

    public Kontejner(String oznaka, String naziv) {
        this.oznaka = oznaka;
        this.naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public String getNaziv() {
        return naziv;
    }

    public ForeignCollection<Kontejner> getKontejner() {
        return kontejner;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setKontejner(ForeignCollection<Kontejner> kontejner) {
        this.kontejner = kontejner;
    }

    @Override
    public String toString() {
        return "Brod{" +
                "id=" + id +
                ", oznaka='" + oznaka + '\'' +
                ", naziv='" + naziv + '\'' +
                '}';
    }


}
