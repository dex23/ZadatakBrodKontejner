package zadaci;

import com.j256.ormlite.dao.Dao;
import model.Brod;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Luka {
    public static Integer brojPristiglihBrodova = 0;
    static Dao<Brod,Integer> brodDao;

    public static void main(String[] args) {
        BrodNit b1 = new BrodNit();
        BrodNit b2 = new BrodNit();
        BrodNit b3 = new BrodNit();
        BrodNit b4 = new BrodNit();

        b1.start();
        b2.start();
        b3.start();
        b4.start();

    }
}
