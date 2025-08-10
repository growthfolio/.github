package com.growthfolio.table;

/**
 * Flags enabling optional table features.
 */
public class TableFeatures {

    private boolean filtering;
    private boolean pagination;
    private boolean export;
    private boolean editable;

    public static TableFeatures none() {
        return new TableFeatures();
    }

    public TableFeatures enableFiltering() {
        this.filtering = true;
        return this;
    }

    public TableFeatures enablePagination() {
        this.pagination = true;
        return this;
    }

    public TableFeatures enableExport() {
        this.export = true;
        return this;
    }

    public TableFeatures editable(boolean editable) {
        this.editable = editable;
        return this;
    }

    public boolean isFiltering() {
        return filtering;
    }

    public boolean isPagination() {
        return pagination;
    }

    public boolean isExport() {
        return export;
    }

    public boolean isEditable() {
        return editable;
    }
}
