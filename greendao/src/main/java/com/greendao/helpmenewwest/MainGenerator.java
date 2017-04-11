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
        addFireStations(schema);
        addPoliceStations(schema);
        addParks(schema);
        addHospitals(schema);
        addAlternativeFuels(schema);
        addBusStops(schema);
        addSkytrains(schema);
    }

    private static Entity addSkytrains(final Schema schema) {
        Entity skytrains = schema.addEntity("Skytrain");
        skytrains.addIdProperty().primaryKey().autoincrement();
        skytrains.addStringProperty("address");
        skytrains.addStringProperty("name");
        skytrains.addDoubleProperty("lat");
        skytrains.addDoubleProperty("lng");
        return skytrains;
    }

    private static Entity addAlternativeFuels(final Schema schema) {
        Entity alternativeFuels = schema.addEntity("AlternativeFuel");
        alternativeFuels.addIdProperty().primaryKey().autoincrement();
        alternativeFuels.addStringProperty("name").notNull();
        alternativeFuels.addStringProperty("address").notNull();
        alternativeFuels.addStringProperty("description");
        alternativeFuels.addDoubleProperty("lat").notNull();
        alternativeFuels.addDoubleProperty("lng").notNull();
        return alternativeFuels;
    }

    private static Entity addBusStops(final Schema schema) {
        Entity busStops = schema.addEntity("BusStop");
        busStops.addIdProperty().primaryKey().autoincrement();
        busStops.addStringProperty("address");
        busStops.addStringProperty("description");
        busStops.addDoubleProperty("lat").notNull();
        busStops.addDoubleProperty("lng").notNull();
        return busStops;
    }

    private static Entity addFireStations(final Schema schema) {
        Entity fire = schema.addEntity("Fire");
        fire.addIdProperty().primaryKey().autoincrement();
        fire.addStringProperty("name").notNull();
        fire.addStringProperty("address");
        fire.addStringProperty("description");
        fire.addDoubleProperty("lat").notNull();
        fire.addDoubleProperty("lng").notNull();
        return fire;
    }

    private static Entity addPoliceStations(final Schema schema) {
        Entity police = schema.addEntity("Police");
        police.addIdProperty().primaryKey().autoincrement();
        police.addStringProperty("name").notNull();
        police.addStringProperty("address");
        police.addStringProperty("description");
        police.addDoubleProperty("lat").notNull();
        police.addDoubleProperty("lng").notNull();
        return police;
    }

    private static Entity addParks(final Schema schema) {
        Entity parks = schema.addEntity("Park");
        parks.addIdProperty().primaryKey().autoincrement();
        parks.addStringProperty("name").notNull();
        parks.addStringProperty("address").notNull();
        parks.addStringProperty("description");
        parks.addDoubleProperty("lat").notNull();
        parks.addDoubleProperty("lng").notNull();
        return parks;
    }

    private static Entity addHospitals(final Schema schema) {
        Entity hospitals = schema.addEntity("Hospital");
        hospitals.addIdProperty().primaryKey().autoincrement();
        hospitals.addStringProperty("name").notNull();
        hospitals.addStringProperty("address").notNull();
        hospitals.addDoubleProperty("lat").notNull();
        hospitals.addDoubleProperty("lng").notNull();
        return hospitals;
    }

}

