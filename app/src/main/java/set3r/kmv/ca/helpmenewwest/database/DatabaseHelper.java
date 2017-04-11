package set3r.kmv.ca.helpmenewwest.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.greenrobot.greendao.database.Database;
import java.util.List;

import set3r.kmv.ca.helpmenewwest.database.schema.AlternativeFuel;
import set3r.kmv.ca.helpmenewwest.database.schema.AlternativeFuelDao;
import set3r.kmv.ca.helpmenewwest.database.schema.BusStop;
import set3r.kmv.ca.helpmenewwest.database.schema.BusStopDao;
import set3r.kmv.ca.helpmenewwest.database.schema.DaoMaster;
import set3r.kmv.ca.helpmenewwest.database.schema.DaoSession;
import set3r.kmv.ca.helpmenewwest.database.schema.Fire;
import set3r.kmv.ca.helpmenewwest.database.schema.FireDao;
import set3r.kmv.ca.helpmenewwest.database.schema.Hospital;
import set3r.kmv.ca.helpmenewwest.database.schema.HospitalDao;
import set3r.kmv.ca.helpmenewwest.database.schema.Park;
import set3r.kmv.ca.helpmenewwest.database.schema.ParkDao;
import set3r.kmv.ca.helpmenewwest.database.schema.Police;
import set3r.kmv.ca.helpmenewwest.database.schema.PoliceDao;
import set3r.kmv.ca.helpmenewwest.database.schema.Skytrain;
import set3r.kmv.ca.helpmenewwest.database.schema.SkytrainDao;

/**
 * Created by Matthew on 2017-02-11.
 */


public class DatabaseHelper {
    private final static String TAG = DatabaseHelper.class.getName();
    private static DatabaseHelper instance;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private SkytrainDao skytrainDao;
    private AlternativeFuelDao alternativeFuelDao;
    private BusStopDao busStopDao;
    private PoliceDao policeDao;
    private FireDao fireDao;
    private HospitalDao hospitalDao;
    private ParkDao parkDao;
    private DatabaseOpenHelper helper;

    private DatabaseHelper(final Context context) {
        openDatabaseForWriting(context);
    }

    public synchronized static DatabaseHelper getInstance(final Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
        }
        return (instance);
    }

    public static DatabaseHelper getInstance() {
        if (instance == null) {
            throw new Error();
        }
        return (instance);
    }

    private void openDatabase() {
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        busStopDao = daoSession.getBusStopDao();
        alternativeFuelDao = daoSession.getAlternativeFuelDao();
        skytrainDao = daoSession.getSkytrainDao();
        fireDao = daoSession.getFireDao();
        policeDao = daoSession.getPoliceDao();
        hospitalDao = daoSession.getHospitalDao();
        parkDao = daoSession.getParkDao();
    }

    public void openDatabaseForWriting(final Context context) {
        helper = new DatabaseOpenHelper(context,
                "newwest",
                null);
        db = helper.getWritableDatabase();
        openDatabase();
    }

    public void openDatabaseForReading(final Context context) {
        final DatabaseOpenHelper helper;

        helper = new DatabaseOpenHelper(context,
                "newwest",
                null);
        db = helper.getReadableDatabase();
        openDatabase();
    }

    public void close() {
        helper.close();
    }

    public Fire getFire(Long id) {
        return fireDao.queryBuilder()
                .where(FireDao.Properties.Id.eq(id))
                .limit(1)
                .unique();
    }
    public Police getPolice(Long id) {
        return policeDao.queryBuilder()
                .where(PoliceDao.Properties.Id.eq(id))
                .limit(1)
                .unique();
    }
    public Hospital getHospital(Long id) {
        return hospitalDao.queryBuilder()
                .where(HospitalDao.Properties.Id.eq(id))
                .limit(1)
                .unique();
    }
    public Skytrain getSkytrain(Long id) {
        return skytrainDao.queryBuilder()
                .where(SkytrainDao.Properties.Id.eq(id))
                .limit(1)
                .unique();
    }
    public AlternativeFuel getAlternativeFuel(Long id) {
        return alternativeFuelDao.queryBuilder()
                .where(AlternativeFuelDao.Properties.Id.eq(id))
                .limit(1)
                .unique();
    }
    public BusStop getBusStop(Long id) {
        return busStopDao.queryBuilder()
                .where(BusStopDao.Properties.Id.eq(id))
                .limit(1)
                .unique();
    }
    public Park getPark(Long id) {
        return parkDao.queryBuilder()
                .where(ParkDao.Properties.Id.eq(id))
                .limit(1)
                .unique();
    }

    public List<Fire> getFires(){
        return (fireDao.loadAll());
    }

    public List<Hospital> getHospitals() {
        return hospitalDao.loadAll();
    }

    public List<Police> getPolices() {
        return policeDao.loadAll();
    }

    public List<Park> getParks() {
        return (parkDao.loadAll());
    }

    public List<BusStop> getBusStops() {
        return busStopDao.loadAll();
    }

    public List<Skytrain> getSkytrains() {
        return skytrainDao.loadAll();
    }

    public List<AlternativeFuel> getAlternativeFuels() {
        return alternativeFuelDao.loadAll();
    }

    public static void upgrade(final Database db,
                               final int oldVersion,
                               final int newVersion) {
    }
}
