package com.growthfolio.table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.List;

/**
 * Utility builder for creating JavaFX {@link TableView} instances in a
 * concise and type-safe way.
 *
 * @param <T> type of the row objects
 */
public class GenericTableBuilder<T> {

    private final TableView<T> table;
    private final TableBuilderOptions options = new TableBuilderOptions();

    /**
     * Creates a builder with the provided data.
     *
     * @param data list of row objects
     */
    public GenericTableBuilder(List<T> data) {
        ObservableList<T> observableData = FXCollections.observableArrayList(data);
        this.table = new TableView<>(observableData);
    }

    /**
     * Adds a new column defined by the given {@link ColumnSpec}.
     *
     * @param spec column specification
     * @param <R>  cell value type
     * @return builder instance for method chaining
     */
    public <R> GenericTableBuilder<T> addColumn(ColumnSpec<T, R> spec) {
        table.getColumns().add(TableColumnBuilder.build(spec));
        return this;
    }

    public GenericTableBuilder<T> features(TableFeatures features) {
        options.features(features);
        return this;
    }

    /**
     * Builds and returns the configured {@link TableView}.
     *
     * @return table view instance
     */
    public TableView<T> build() {
        return table;
    }
}

