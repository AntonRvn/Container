package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    void testAddAndGet() {
        Container<String> container = new Container<>();
        container.add("Container");
        container.add("Test");

        assertEquals("Container", container.get(0));
        assertEquals("Test", container.get(1));
    }

    @Test
    void testRemove() {
        Container<Integer> container = new Container<>();
        container.add(1);
        container.add(2);
        container.add(3);

        container.remove(1);

        assertEquals(1, (int) container.get(0));
        assertEquals(3, (int) container.get(1));
        assertEquals(2, container.size());
    }

    @Test
    void testSize() {
        Container<Double> container = new Container<>();
        assertEquals(0, container.size());

        container.add(1.1);
        assertEquals(1, container.size());

        container.add(2.2);
        assertEquals(2, container.size());
    }
}
