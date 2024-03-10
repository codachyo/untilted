package lesson_7.user_entity;

class UserEntityRepository {
    UserEntity[] data = new UserEntity[0];
    private int capacity = 0;

    public UserEntityRepository() {
        UserEntity.setNextId(0);
    }

    public UserEntity addUser(String name, String surname, int personId) {
        if (!isUniquePersonId(personId)) {
            return null;
        }
        UserEntity user = new UserEntity(name, surname, personId);
        capacity++;
        UserEntity[] tmp = new UserEntity[capacity];
        for (int i = 0; i < data.length; i++) {
            tmp[i] = data[i];
        }
        data = tmp;
        data[capacity - 1] = user;
        return user;
    }

    public UserEntity getUserById(int id) {
        for (UserEntity user : data) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public UserEntity[] getUsersByName(String name) {
        UserEntity[] users = new UserEntity[capacity];
        int i = 0;
        for (UserEntity user : data) {
            if (user.getName().equals(name)) {
                users[i] = user;
                i++;
            }
        }
        return trimEmptyElements(users, i);
    }

    public UserEntity[] getAllUsers() {
        return data;
    }

    public UserEntity updateUser(int id, String name, String surname, int personId) {
        if (!isUniquePersonId(personId)) {
            return null;
        }
        for (UserEntity user : data) {
            if (user.getId() == id) {
                user.setName(name);
                user.setSurname(surname);
                user.setPersonId(personId);
                return user;
            }
        }
        return null;
    }

    public boolean deleteUser(int id) {
        boolean succeed = false;
        capacity--;
        UserEntity[] tmp = new UserEntity[capacity];
        int j = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i].getId() == id) {
                succeed = true;
                continue;
            }
            tmp[j] = data[i];
            j++;
        }
        if (succeed) {
            data = tmp;
        }
        return succeed;
    }

    private boolean isUniquePersonId(int personId) {
        for (UserEntity user : data) {
            if (user.getPersonId() == personId) {
                return false;
            }
        }
        return true;
    }

    private UserEntity[] trimEmptyElements(UserEntity[] arr, int fromIndex) {
        UserEntity[] result = new UserEntity[fromIndex];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
