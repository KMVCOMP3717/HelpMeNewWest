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
 * DAO for table "PARK".
*/
public class ParkDao extends AbstractDao<Park, Long> {

    public static final String TABLENAME = "PARK";

    /**
     * Properties of entity Park.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Category_id = new Property(2, String.class, "category_id", false, "CATEGORY_ID");
        public final static Property Street_num = new Property(3, String.class, "street_num", false, "STREET_NUM");
        public final static Property Street_name = new Property(4, String.class, "street_name", false, "STREET_NAME");
    }


    public ParkDao(DaoConfig config) {
        super(config);
    }
    
    public ParkDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PARK\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"CATEGORY_ID\" TEXT NOT NULL ," + // 2: category_id
                "\"STREET_NUM\" TEXT NOT NULL ," + // 3: street_num
                "\"STREET_NAME\" TEXT NOT NULL );"); // 4: street_name
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PARK\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Park entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindString(3, entity.getCategory_id());
        stmt.bindString(4, entity.getStreet_num());
        stmt.bindString(5, entity.getStreet_name());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Park entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindString(3, entity.getCategory_id());
        stmt.bindString(4, entity.getStreet_num());
        stmt.bindString(5, entity.getStreet_name());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Park readEntity(Cursor cursor, int offset) {
        Park entity = new Park( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.getString(offset + 2), // category_id
            cursor.getString(offset + 3), // street_num
            cursor.getString(offset + 4) // street_name
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Park entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setCategory_id(cursor.getString(offset + 2));
        entity.setStreet_num(cursor.getString(offset + 3));
        entity.setStreet_name(cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Park entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Park entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Park entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
