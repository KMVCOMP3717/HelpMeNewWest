package set3r.kmv.ca.helpmenewwest.database.schema;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "HOSPITAL".
*/
public class HospitalDao extends AbstractDao<Hospital, Long> {

    public static final String TABLENAME = "HOSPITAL";

    /**
     * Properties of entity Hospital.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Address = new Property(2, String.class, "address", false, "ADDRESS");
        public final static Property Lat = new Property(3, double.class, "lat", false, "LAT");
        public final static Property Lng = new Property(4, double.class, "lng", false, "LNG");
    }


    public HospitalDao(DaoConfig config) {
        super(config);
    }
    
    public HospitalDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"HOSPITAL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"ADDRESS\" TEXT NOT NULL ," + // 2: address
                "\"LAT\" REAL NOT NULL ," + // 3: lat
                "\"LNG\" REAL NOT NULL );"); // 4: lng
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"HOSPITAL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Hospital entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindString(3, entity.getAddress());
        stmt.bindDouble(4, entity.getLat());
        stmt.bindDouble(5, entity.getLng());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Hospital entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindString(3, entity.getAddress());
        stmt.bindDouble(4, entity.getLat());
        stmt.bindDouble(5, entity.getLng());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Hospital readEntity(Cursor cursor, int offset) {
        Hospital entity = new Hospital( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.getString(offset + 2), // address
            cursor.getDouble(offset + 3), // lat
            cursor.getDouble(offset + 4) // lng
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Hospital entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setAddress(cursor.getString(offset + 2));
        entity.setLat(cursor.getDouble(offset + 3));
        entity.setLng(cursor.getDouble(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Hospital entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Hospital entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Hospital entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
