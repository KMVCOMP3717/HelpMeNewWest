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
 * DAO for table "FIRE".
*/
public class FireDao extends AbstractDao<Fire, Long> {

    public static final String TABLENAME = "FIRE";

    /**
     * Properties of entity Fire.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Address = new Property(2, String.class, "address", false, "ADDRESS");
        public final static Property Description = new Property(3, String.class, "description", false, "DESCRIPTION");
        public final static Property Lat = new Property(4, double.class, "lat", false, "LAT");
        public final static Property Lng = new Property(5, double.class, "lng", false, "LNG");
    }


    public FireDao(DaoConfig config) {
        super(config);
    }
    
    public FireDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FIRE\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"ADDRESS\" TEXT," + // 2: address
                "\"DESCRIPTION\" TEXT," + // 3: description
                "\"LAT\" REAL NOT NULL ," + // 4: lat
                "\"LNG\" REAL NOT NULL );"); // 5: lng
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FIRE\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Fire entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(3, address);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(4, description);
        }
        stmt.bindDouble(5, entity.getLat());
        stmt.bindDouble(6, entity.getLng());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Fire entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(3, address);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(4, description);
        }
        stmt.bindDouble(5, entity.getLat());
        stmt.bindDouble(6, entity.getLng());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Fire readEntity(Cursor cursor, int offset) {
        Fire entity = new Fire( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // address
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // description
            cursor.getDouble(offset + 4), // lat
            cursor.getDouble(offset + 5) // lng
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Fire entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setAddress(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDescription(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setLat(cursor.getDouble(offset + 4));
        entity.setLng(cursor.getDouble(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Fire entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Fire entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Fire entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
