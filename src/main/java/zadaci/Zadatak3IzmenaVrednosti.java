package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Brod;
import model.Kontejner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Zadatak3IzmenaVrednosti {
    static Dao<Brod,Integer> brodDao;
    static Dao<Kontejner,Integer> kontejnerDao;
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");
            brodDao = DaoManager.createDao(connectionSource, Brod.class);
            kontejnerDao = DaoManager.createDao(connectionSource, Kontejner.class);

            List<Kontejner> kontejner = kontejnerDao.queryForAll();
            for (Kontejner k:kontejner)
                System.out.println("k = " + k);

            List<Kontejner> pronadjenKontejner = kontejnerDao.queryForEq(Kontejner.POLJE_OPIS,"Morski proizvodi");
            Kontejner kontejnerzaIzmenu = pronadjenKontejner.get(0);
            kontejnerzaIzmenu.setOpis("Plodovi mora");

            kontejnerDao.update(kontejnerzaIzmenu);

            kontejner = kontejnerDao.queryForAll();
            for(Kontejner k:kontejner)
                System.out.println("Kontejner= " + k);


        }catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                connectionSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
