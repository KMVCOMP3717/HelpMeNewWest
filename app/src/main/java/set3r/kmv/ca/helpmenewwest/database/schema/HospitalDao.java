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
        public final static Property Building_id = new Property(2, String.class, "building_id", false, "BUILDING_ID");
        public final static Property Map_ref = new Property(3, String.class, "map_ref", false, "MAP_REF");
        public final static Property Street_num = new Property(4, String.class, "street_num", false, "STREET_NUM");
        public final static Property Street_name = new Property(5, String.class, "street_name", false, "STREET_NAME");
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
                "\"BUILDING_ID\" TEXT," + // 2: building_id
                "\"MAP_REF\" TEXT," + // 3: map_ref
                "\"STREET_NUM\" TEXT NOT NULL ," + // 4: street_num
                "\"STREET_NAME\" TEXT NOT NULL );"); // 5: street_name
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
 
        String building_id = entity.getBuilding_id();
        if (building_id != null) {
            stmt.bindString(3, building_id);
        }
 
        String map_ref = entity.getMap_ref();
        if (map_ref != null) {
            stmt.bindString(4, map_ref);
        }
        stmt.bindString(5, entity.getStreet_num());
        stmt.bindString(6, entity.getStreet_name());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Hospital entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
 
        String building_id = entity.getBuilding_id();
        if (building_id != null) {
            stmt.bindString(3, building_id);
        }
 
        String map_ref = entity.getMap_ref();
        if (map_ref != null) {
            stmt.bindString(4, map_ref);
        }
        stmt.bindString(5, entity.getStreet_num());
        stmt.bindString(6, entity.getStreet_name());
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
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // building_id
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // map_ref
            cursor.getString(offset + 4), // street_num
            cursor.getString(offset + 5) // street_name
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Hospital entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setBuilding_id(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setMap_ref(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setStreet_num(cursor.getString(offset + 4));
        entity.setStreet_name(cursor.getString(offset + 5));
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
