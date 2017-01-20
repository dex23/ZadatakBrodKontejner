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
public class Zadatak2DodavanjeVrednosti {
    static Dao<Brod,Integer> brodDao;
    static Dao<Kontejner,Integer> kontejnerDao;
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");

            brodDao = DaoManager.createDao(connectionSource, Brod.class);
            kontejnerDao =DaoManager.createDao(connectionSource, Kontejner.class);

            Brod b1 = new Brod("Brod 1", "Transporter 1");
            brodDao.create(b1);
            Brod b2 = new Brod("Brod 2", "Transporter 2");
            brodDao.create(b2);

            Kontejner k1 = new Kontejner("KP1", "Namestaj", 100);
            k1.setBrod(b1);
            kontejnerDao.create(k1);
            Kontejner k2 = new Kontejner("KP2", "Banane", 1000.5);
            k2.setBrod(b1);
            kontejnerDao.create(k2);
            Kontejner k3 = new Kontejner("KP3", "Morski proizvodi", 200.7);
            k3.setBrod(b1);
            kontejnerDao.create(k3);
            Kontejner k4 = new Kontejner("KP4", "Mercedes", 500.4);
            k4.setBrod(b2);
            kontejnerDao.create(k4);
            Kontejner k5 = new Kontejner("KP5", "Klavir", 100);
            k5.setBrod(b2);
            kontejnerDao.create(k5);

            List<Brod> brod = brodDao.queryForAll();
            for(Brod b:brod)
                System.out.println("b = " + b);
            List<Kontejner> kontejner = kontejnerDao.queryForAll();
            for (Kontejner k:kontejner)
                System.out.println("k = " + k);


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
