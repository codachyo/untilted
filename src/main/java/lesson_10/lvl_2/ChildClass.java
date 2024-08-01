package lesson_10.lvl_2;

class ChildClass extends ParentClass {
    private String text;

    public String getText() {
        return text;
    }

    public ChildClass(int number, String text) {
        super(number);
        this.text = text;
    }
}