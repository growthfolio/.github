package com.growthfolio.table;

/**
 * Options used during table building.
 */
public class TableBuilderOptions {

    private TableFeatures features = TableFeatures.none();

    public TableBuilderOptions features(TableFeatures features) {
        this.features = features;
        return this;
    }

    public TableFeatures getFeatures() {
        return features;
    }
}
