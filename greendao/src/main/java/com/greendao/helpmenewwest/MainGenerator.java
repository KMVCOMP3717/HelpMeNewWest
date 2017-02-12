package com.greendao.helpmenewwest;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.Property;

public class MainGenerator {
    public static void main(String[] args)
            throws Exception {
        final Schema schema;
        final DaoGenerator generator;
        schema = new Schema(1, "set3r.kmv.ca.helpmenewwest.database.schema");
        schema.enableKeepSectionsByDefault();
        addTables(schema);
        generator = new DaoGenerator();
        generator.generateAll(schema, "./app/src/main/java");

    }

    private static void addTables(final Schema schema) {
        addCommunityServices(schema);
        addFireStations(schema);
        addPoliceStations(schema);
        addParks(schema);
        addHospitals(schema);
    }

    private static Entity addCommunityServices(final Schema schema) {
        Entity communityServces = schema.addEntity("Community");
        communityServces.addIdProperty().primaryKey().autoincrement();
        communityServces.addStringProperty("name").notNull();
        communityServces.addStringProperty("description");
        communityServces.addStringProperty("hours");
        communityServces.addStringProperty("location");
        communityServces.addStringProperty("postal_code");
        communityServces.addLongProperty("phone");
        communityServces.addStringProperty("email");
        communityServces.addStringProperty("website");
        communityServces.addLongProperty("category_id").notNull();
        return communityServces;
    }

    private static Entity addFireStations(final Schema schema) {
        Entity fire = schema.addEntity("Fire");
        fire.addIdProperty().primaryKey().autoincrement();
        fire.addStringProperty("name").notNull();
        fire.addStringProperty("building_id");
        fire.addStringProperty("map_ref_ref");
        fire.addStringProperty("street_num").notNull();
        fire.addStringProperty("street_name").notNull();
        return fire;
    }

    private static Entity addPoliceStations(final Schema schema) {
        Entity police = schema.addEntity("Police");
        police.addIdProperty().primaryKey().autoincrement();
        police.addStringProperty("name").notNull();
        police.addStringProperty("building_id");
        police.addStringProperty("map_ref");
        police.addStringProperty("street_num").notNull();
        police.addStringProperty("street_name").notNull();
        return police;
    }

    private static Entity addParks(final Schema schema) {
        // Name, Category, Street_Number, Street_Name
        Entity parks = schema.addEntity("Park");
        parks.addIdProperty().primaryKey().autoincrement();
        parks.addStringProperty("name").notNull();
        parks.addStringProperty("category_id").notNull();
        parks.addStringProperty("street_num").notNull();
        parks.addStringProperty("street_name").notNull();
        return parks;
    }

    private static Entity addHospitals(final Schema schema) {
        Entity hospitals = schema.addEntity("Hospital");
        hospitals.addIdProperty().primaryKey().autoincrement();
        hospitals.addStringProperty("name").notNull();
        hospitals.addStringProperty("building_id");
        hospitals.addStringProperty("map_ref");
        hospitals.addStringProperty("street_num").notNull();
        hospitals.addStringProperty("street_name").notNull();

        return hospitals;
    }

/*
    private static Entity addFireStations(final Schema schema) {
        Entity  = schema.addEntity("");
        .addIdProperty().primaryKey().autoincrement();


        return ;
    }
    */
}

