package lesson_9.MyClass;

interface MyList {
    // Return size of the list
    int size();

    // Check if element is in the list
    boolean isInList(MyClass element);

    // Return the number of element appearance in the list
    int appearanceCount(MyClass element);

    // Get list element by index
    MyClass get(int index);

    // Add element to the list
    void add(MyClass element);

    // Add element to the list by index
    void add(int index, MyClass element);

    // Replace element in the list by index
    void replace(int index, MyClass element);

    // Replace element in the list with other element
    void replace(MyClass before, MyClass after);

    // Remove list element
    void remove(MyClass element);

    // Remove list element by index
    void remove(int index);

    // Clear list
    void clear();

    // Sort list by ASC or DESC order
    void sort(String order);

    // Compare list with other list
    boolean isEqual(MyList other);

    // Print list elements
    void printElements();
}
