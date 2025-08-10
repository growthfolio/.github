package com.growthfolio.table;

import javafx.scene.control.TableColumn;

/**
 * Utility to build JavaFX {@link TableColumn} instances from {@link ColumnSpec}.
 */
public final class TableColumnBuilder {

    private TableColumnBuilder() {
    }

    public static <T, R> TableColumn<T, R> build(ColumnSpec<T, R> spec) {
        TableColumn<T, R> column = new TableColumn<>(spec.title());
        column.setId(spec.id());
        column.setCellValueFactory(cell -> spec.valueProvider().apply(cell.getValue()));
        return column;
    }
}
