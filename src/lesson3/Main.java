package homework2;

public class Main {

    public static void main(String[] args) {
        String[][] arr = new String[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = "3r";
            }
        }

        try {
            System.out.println(payload(arr));
        } catch (MyArraySizeException e) {
            System.out.print("Size exception " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.print("Data exception " + e.getMessage());
        }
    }

    private static int payload(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException("width != 4");
        }

        for (String[] item : arr) {
            if (item.length != 4) {
                throw new MyArraySizeException("height != 4");
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(e.getMessage(), i, j);
                }
            }
        }

        return sum;
    }

}

class MyArraySizeException extends Exception {
    MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    MyArrayDataException(String message, int i, int j) {
        super(message + " Wrong data: " + i + ":" + j);
    }
}
