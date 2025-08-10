package com.growthfolio.table;

import java.util.function.Function;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

/**
 * Specification for a table column. Holds metadata and value extraction logic.
 *
 * @param <T> row type
 * @param <R> cell value type
 */
public class ColumnSpec<T, R> {

    private final String id;
    private final String title;
    private final Function<T, ObservableValue<R>> valueProvider;

    private ColumnSpec(String id, String title, Function<T, ObservableValue<R>> valueProvider) {
        this.id = id;
        this.title = title;
        this.valueProvider = valueProvider;
    }

    public String id() {
        return id;
    }

    public String title() {
        return title;
    }

    public Function<T, ObservableValue<R>> valueProvider() {
        return valueProvider;
    }

    public static <T, R> ColumnSpec<T, R> of(String id, String title,
            Function<T, ObservableValue<R>> provider) {
        return new ColumnSpec<>(id, title, provider);
    }

    public static <T> ColumnSpec<T, String> of(String id, String title,
            Function<T, StringProperty> provider) {
        return new ColumnSpec<>(id, title, t -> provider.apply(t));
    }

    public static <T> ColumnSpec<T, Integer> number(String id, String title,
            Function<T, IntegerProperty> provider) {
        return new ColumnSpec<>(id, title, t -> provider.apply(t).asObject());
    }
}
