package niall.assignment7.main;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
  Object[] items = new Object[10];
  int currentSize = 0;

  @Override
  public boolean add(T item) {
    doubleArraySize();

    items[currentSize] = item;
    currentSize++;
    return true;
  }

  public void doubleArraySize() {
    if (items.length == currentSize) {
      items = Arrays.copyOf(items, items.length * 2);
    }
  }

  @Override
  public boolean add(int index, T item) throws IndexOutOfBoundsException {
    doubleArraySize();
    if (index < 0 || index > currentSize) {
      throw new IndexOutOfBoundsException();
    }
    Object[] itemsCopy = new Object[items.length];

    System.arraycopy(items, 0, itemsCopy, 0, index);
    itemsCopy[index] = item;
    System.arraycopy(items, index, itemsCopy, index + 1, currentSize - index);

    items = itemsCopy;
    currentSize++;
    return true;
  }

  @Override
  public int getSize() {
    return currentSize;
  }

  @SuppressWarnings("unchecked")
  @Override
  public T get(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > currentSize) {
      throw new IndexOutOfBoundsException();
    }

    return (T) items[index];
  }

  @Override
  public T remove(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index > currentSize) {
      throw new IndexOutOfBoundsException();
    }

    T itemToRemove = get(index);
    Object[] itemsCopy = new Object[items.length];

    System.arraycopy(items, 0, itemsCopy, 0, index);
    System.arraycopy(items, index + 1, itemsCopy, index, currentSize - (index + 1));

    items = itemsCopy;
    currentSize--;
    return itemToRemove;
  }

}