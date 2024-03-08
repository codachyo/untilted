package lesson_7.UserEntity;

class UserEntity {
    private static int nextId = 0;

    private int id;
    private String name;
    private String surname;
    private int personId;

    public static void setNextId(int nextId) {
        UserEntity.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public UserEntity(String name, String surname, int personId) {
        this.id = ++nextId;
        this.name = name;
        this.surname = surname;
        this.personId = personId;
    }
}
