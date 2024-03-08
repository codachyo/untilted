package lesson_7.UserEntity;

class UserEntityTest {
    private static final String TEXT_RESET = "\u001B[0m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";

    private static int totalRun = 0;
    private static int totalPassed = 0;
    private static int totalFailed = 0;

    public static void main(String[] args) {
        shouldAddUserTest();
        shouldRejectUserAddingWithNonUniquePersonIdTest();
        shouldGetUserByIdTest();
        shouldGetUsersByNameTest();
        shouldGetAllUsersTest();
        shouldUpdateUserTest();
        shouldRejectUserUpdateWithNonUniquePersonIdTest();
        shouldDeleteUserTest();
        printFooter();
    }

    private static void shouldAddUserTest() {
        totalRun++;
        UserEntityRepository repository = new UserEntityRepository();
        TransactionResult actual = processAdd(repository, "John", "Smith", 101);
        TransactionResult expected = new TransactionResult(true, 1, "John", "Smith", 101);
        checkResult(expected,  actual,"shouldAddUserTest");
    }

    private static void shouldRejectUserAddingWithNonUniquePersonIdTest() {
        totalRun++;
        UserEntityRepository repository = new UserEntityRepository();
        repository.addUser("John", "Smith", 101);
        TransactionResult actual = processAdd(repository, "Carlos", "Tevez", 101);
        TransactionResult expected = new TransactionResult(false, 0, "", "", 0);
        checkResult(expected,  actual,"shouldRejectUserAddingWithNonUniquePersonIdTest");
    }

    private static void shouldGetUserByIdTest() {
        totalRun++;
        UserEntityRepository repository = new UserEntityRepository();
        repository.addUser("John", "Smith", 101);
        repository.addUser("John", "Wick", 102);
        repository.addUser("Dan", "Brown", 103);
        TransactionResult actual = processGetUserById(repository, 2);
        TransactionResult expected = new TransactionResult(true, 2, "John", "Wick", 102);
        checkResult(expected,  actual,"shouldGetUserByIdTest");
    }

    private static void shouldGetUsersByNameTest() {
        totalRun++;
        UserEntityRepository repository = new UserEntityRepository();
        repository.addUser("John", "Smith", 101);
        repository.addUser("John", "Wick", 102);
        repository.addUser("Dan", "Brown", 103);
        int actual = processGetUsersByName(repository, "John");
        checkResult(2,  actual,"shouldGetUsersByNameTest");
    }

    private static void shouldGetAllUsersTest() {
        totalRun++;
        UserEntityRepository repository = new UserEntityRepository();
        repository.addUser("John", "Smith", 101);
        repository.addUser("John", "Wick", 102);
        repository.addUser("Dan", "Brown", 103);
        int actual = processGetAllUsers(repository);
        checkResult(3,  actual,"shouldGetAllUsersTest");
    }

    private static void shouldUpdateUserTest() {
        totalRun++;
        UserEntityRepository repository = new UserEntityRepository();
        repository.addUser("John", "Smith", 101);
        repository.addUser("John", "Wick", 102);
        repository.addUser("Dan", "Brown", 103);
        TransactionResult actual = processUpdateUser(repository, 1,"JohnUPD", "SmithUPD", 101111);
        TransactionResult expected = new TransactionResult(true, 1, "JohnUPD", "SmithUPD", 101111);
        checkResult(expected,  actual,"shouldUpdateUserTest");
    }

    private static void shouldRejectUserUpdateWithNonUniquePersonIdTest() {
        totalRun++;
        UserEntityRepository repository = new UserEntityRepository();
        repository.addUser("John", "Smith", 101);
        repository.addUser("John", "Wick", 102);
        repository.addUser("Dan", "Brown", 103);
        TransactionResult actual = processAdd(repository, "Carlos", "Tevez", 101);
        TransactionResult expected = new TransactionResult(false, 0, "", "", 0);
        checkResult(expected,  actual,"shouldRejectUserUpdateWithNonUniquePersonIdTest");
    }

    private static void shouldDeleteUserTest() {
        totalRun++;
        UserEntityRepository repository = new UserEntityRepository();
        repository.addUser("John", "Smith", 101);
        repository.addUser("John", "Wick", 102);
        repository.addUser("Dan", "Brown", 103);
        checkResult(true,  processDeleteUser(repository, 2), "shouldDeleteUserTest");
    }


    private static void checkResult(int expected, int actual, String testName) {
        if (expected == actual) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual + TEXT_RESET);
            totalFailed++;
        }
    }

    private static void checkResult(boolean expected, boolean actual, String testName) {
        if (expected == actual) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual + TEXT_RESET);
            totalFailed++;
        }
    }

    private static void checkResult(TransactionResult expected, TransactionResult actual, String testName) {
        if (expected == null && actual == null){
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
            return;
        }
        if (expected == null || actual == null){
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual + TEXT_RESET);
            totalFailed++;
            return;
        }
        if (expected.equals(actual)) {
            System.out.println(TEXT_GREEN + testName + " - passed" + TEXT_RESET);
            totalPassed++;
        } else {
            System.out.println(TEXT_RED + testName + " - failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual + TEXT_RESET);
            totalFailed++;
        }
    }

    private static void printFooter() {
        System.out.println("********************************************");
        if (totalFailed > 0) {
            System.out.println(TEXT_RED + "TOTAL: RUN = " + totalRun + "; PASSED = " + totalPassed +
                    "; FAILED = " + totalFailed + TEXT_RESET);
        } else {
            System.out.println(TEXT_GREEN + "TOTAL: RUN = " + totalRun + "; PASSED = " + totalPassed +
                    "; FAILED = " + totalFailed + TEXT_RESET);
        }
        System.out.println("********************************************");
    }

    private static TransactionResult processAdd(UserEntityRepository repo, String name, String surname, int personId) {
        if (repo == null) {
            return null;
        }
        TransactionResult result = new TransactionResult();
        UserEntity user = repo.addUser(name, surname, personId);
        result.setSuccessful(user != null);
        if (user != null) {
            result.setId(user.getId());
            result.setName(user.getName());
            result.setSurname(user.getSurname());
            result.setPersonId(user.getPersonId());
        } else {
            result.setName("");
            result.setSurname("");
        }
        return result;
    }

    private static TransactionResult processGetUserById(UserEntityRepository repo, int id) {
        if (repo == null) {
            return null;
        }
        TransactionResult result = new TransactionResult();
        UserEntity user = repo.getUserById(id);
        if (user == null) {
            return null;
        }
        result.setSuccessful(true);
        result.setId(user.getId());
        result.setName(user.getName());
        result.setSurname(user.getSurname());
        result.setPersonId(user.getPersonId());
        return result;
    }

    private static int processGetUsersByName(UserEntityRepository repo, String name) {
        if (repo == null) {
            return 0;
        }
        UserEntity[] users = repo.getUsersByName(name);
        if (users == null) {
            return 0;
        }
        return users.length;
    }

    private static int processGetAllUsers(UserEntityRepository repo) {
        if (repo == null) {
            return 0;
        }
        UserEntity[] users = repo.getAllUsers();
        if (users == null) {
            return 0;
        }
        return users.length;
    }

    private static TransactionResult processUpdateUser(UserEntityRepository repo, int id, String name, String surname, int personId) {
        if (repo == null) {
            return null;
        }
        TransactionResult result = new TransactionResult();
        UserEntity user = repo.updateUser(id, name, surname, personId);
        result.setSuccessful(user != null);
        if (user != null) {
            result.setId(user.getId());
            result.setName(user.getName());
            result.setSurname(user.getSurname());
            result.setPersonId(user.getPersonId());
        } else {
            result.setName("");
            result.setSurname("");
        }

        return result;
    }

    private static boolean processDeleteUser(UserEntityRepository repo, int id) {
        if (!repo.deleteUser(id)) {
            return false;
        }
        return repo.getUserById(id) == null;
    }
}
