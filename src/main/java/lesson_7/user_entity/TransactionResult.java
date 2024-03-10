package lesson_7.user_entity;

class TransactionResult {
    private boolean successful;
    private int id;
    private String name;
    private String surname;
    private int personId;

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public TransactionResult() {
    }

    public TransactionResult(boolean successful, int id, String name, String surname, int personId) {
        this.successful = successful;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionResult that = (TransactionResult) o;
        return successful == that.successful && id == that.id && personId == that.personId &&
                name.equals(that.name) && surname.equals(that.surname);
    }

    @Override
    public String toString() {
        return "TransactionResult{" +
                "successful=" + successful +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personId=" + personId +
                '}';
    }
}
