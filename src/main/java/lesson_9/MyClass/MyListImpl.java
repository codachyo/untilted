package lesson_9.MyClass;

class MyListImpl implements MyList {

    MyClass[] list = new MyClass[0];

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public boolean isInList(MyClass element) {
        if (element == null) {
            return false;
        }
        for (MyClass myClass : list) {
            if (myClass.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int appearanceCount(MyClass element) {
        if (element == null) {
            return 0;
        }
        int result  = 0;
        for (MyClass myClass : list) {
            if (myClass.equals(element)) {
                result++;
            }
        }
        return result;
    }

    @Override
    public MyClass get(int index) {
        if (index > (list.length - 1)) {
            return null;
        }
        return list[index];
    }

    @Override
    public void add(MyClass element) {
        if (element == null) {
            return;
        }
        MyClass[] tmp = new MyClass[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            tmp[i] = list[i];
        }
        list = tmp;
        list[list.length - 1] = element;
    }

    @Override
    public void add(int index, MyClass element) {
        if (element == null || index > (list.length - 1)) {
            return;
        }
        MyClass[] tmp = new MyClass[list.length + 1];
        int j = 0;
        for (int i = 0; i < list.length; i++) {
            if (i == index) {
                tmp[j] = element;
                j++;
            }
            tmp[j] = list[i];
            j++;
        }
        list = tmp;
    }

    @Override
    public void replace(int index, MyClass element) {
        if (element == null || index > (list.length - 1)) {
            return;
        }
        list[index] = element;
    }

    @Override
    public void replace(MyClass before, MyClass after) {
        if (before == null || after == null) {
            return;
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(before)) {
                list[i] = after;
            }
        }
    }

    @Override
    public void remove(MyClass element) {
        if (element == null) {
            return;
        }
        int itemsCount = appearanceCount(element);
        if (itemsCount == 0) {
            return;
        }
        MyClass[] tmp = new MyClass[list.length - itemsCount];
        int j = 0;
        boolean succeed = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(element)) {
                succeed = true;
                continue;
            }
            tmp[j] = list[i];
            j++;
        }
        if (succeed) {
            list = tmp;
        }
    }

    @Override
    public void remove(int index) {
        if (index > (list.length - 1)) {
            return;
        }
        MyClass[] tmp = new MyClass[list.length - 1];
        int j = 0;
        boolean succeed = false;
        for (int i = 0; i < list.length; i++) {
            if (i == index) {
                succeed = true;
                continue;
            }
            tmp[j] = list[i];
            j++;
        }
        if (succeed) {
            list = tmp;
        }
    }

    @Override
    public void clear() {
        list = new MyClass[0];
    }

    @Override
    public void sort(String order) {
        if (!order.equals("ASC") && !order.equals("DESC")) {
            return;
        }
        boolean isSorted = false;
        MyClass tempClass;
        if (order.equals("ASC")) {
            while (!isSorted) {
                isSorted = sortOneCycle(1);
            }
        } else {
            while (!isSorted) {
                isSorted = sortOneCycle(-1);
            }
        }
    }

    @Override
    public boolean isEqual(MyList other) {
        if (other == null || list.length != other.size()) {
            return false;
        }
        for (int i = 0; i < list.length; i++) {
            if (!list[i].equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void printElements() {
        if (list == null || list.length == 0) {
            System.out.println("List is empty");
            return;
        }
        int elementNumber = 1;
        for (MyClass myClass : list) {
            System.out.println("Element " + elementNumber + " -> " + myClass);
            elementNumber++;
        }
    }

    private boolean sortOneCycle(int compareToOut) {
        if (compareToOut > 1 || compareToOut < -1) {
            return false;
        }

        MyClass tempClass;
        boolean isSorted = true;
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i].compareTo(list[i + 1]) == compareToOut) {
                tempClass = list[i + 1];
                list[i + 1] = list[i];
                list[i] = tempClass;
                isSorted = false;
            }
        }
        return isSorted;
    }
}
