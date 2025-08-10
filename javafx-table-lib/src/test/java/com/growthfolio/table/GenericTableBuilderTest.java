package com.growthfolio.table;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericTableBuilderTest {

    @BeforeAll
    static void initToolkit() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        Platform.startup(latch::countDown);
        latch.await();
    }

    record Person(String name, int age) {}

    @Test
    void buildsTableWithColumnsAndData() {
        List<Person> data = List.of(new Person("Ana", 30), new Person("Bob", 25));
        TableView<Person> table = new GenericTableBuilder<>(data)
                .addColumn(ColumnSpec.of("name", "Nome", p -> new SimpleStringProperty(p.name())))
                .addColumn(ColumnSpec.number("age", "Idade", p -> new SimpleIntegerProperty(p.age())))
                .features(TableFeatures.none().enableFiltering())
                .build();

        assertEquals(2, table.getColumns().size());
        assertEquals("Ana", table.getColumns().get(0).getCellData(0));
        assertEquals(25, table.getColumns().get(1).getCellData(1));
    }
}
