package org.example;

/**
 * Класс Container представляет собой контейнер, который может хранить произвольное количество объектов.
 *
 * @param <T> Тип объектов, которые будут храниться в контейнере.
 */
public class Container<T> {
    private Object[] elements;
    private int size;

    /**
     * Конструктор по умолчанию, инициализирует контейнер с начальным размером.
     */
    public Container() {
        elements = new Object[10];
        size = 0;
    }

    /**
     * Добавляет элемент в контейнер.
     *
     * @param element Элемент, который нужно добавить.
     */
    public void add(T element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    /**
     * Извлекает элемент по индексу.
     *
     * @param index Индекс элемента.
     * @return Элемент по указанному индексу.
     * @throws IndexOutOfBoundsException Если индекс вне диапазона.
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        return (T) elements[index];
    }

    /**
     * Удаляет элемент по индексу.
     *
     * @param index Индекс элемента, который нужно удалить.
     * @throws IndexOutOfBoundsException Если индекс вне диапазона.
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; // Удаляем ссылку на удаляемый элемент
    }

    /**
     * Возвращает текущее количество элементов в контейнере.
     *
     * @return Количество элементов.
     */
    public int size() {
        return size;
    }

    private void resize() {
        Object[] newArray = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }
}
