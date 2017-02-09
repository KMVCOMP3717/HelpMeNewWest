package com.greendao.helpmenewwest;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;
import org.greenrobot.greendao.generator.Property;

public class MainGenerator
{
    public static void main(String[] args)
            throws Exception
    {
        final Schema       schema;
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

    }

    private static Entity addCommunityServices(final Schema schema) {
        Entity communityServces = schema.addEntity("community_services");
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
        Entity fire = schema.addEntity("fire_stations");
        fire.addIdProperty().primaryKey().autoincrement();
        fire.addStringProperty("name").notNull();
        fire.addStringProperty("building_id");
        fire.addStringProperty("map_ref_ref");
        fire.addStringProperty("location").notNull(); //strnum + strnam
        fire.addLongProperty("category_id").notNull();
        return fire;
    }

    private static Entity addPoliceStations(final Schema schema) {
        Entity police = schema.addEntity("police_stations");
        police.addIdProperty().primaryKey().autoincrement();
        police.addStringProperty("name").notNull();
        police.addStringProperty("building_id");
        police.addStringProperty("map_ref_ref");
        police.addStringProperty("location").notNull(); //strnum + strnam
        police.addLongProperty("category_id").notNull();
        return police;
    }

    private static Entity addParks(final Schema schema) {
        // Name, Category, Street_Number, Street_Name
        Entity parks  = schema.addEntity("parks");
        parks.addIdProperty().primaryKey().autoincrement();
        parks.addStringProperty("name").notNull();
        parks.addStringProperty("location").notNull(); // street_number + street_name
        parks.addLongProperty("category_id").notNull();
        return parks;
    }
/*
    private static Entity addFireStations(final Schema schema) {
        Entity  = schema.addEntity("");
        .addIdProperty().primaryKey().autoincrement();


        return ;
    }
    */
}

