
import java.util.Objects;

public class ticTacToe {
    public enum Field { X, O, }

    private Field fieldArray[][];
    private int fieldSize;
    public ticTacToe(int size) {
        if (size <= 1)
            throw new IllegalArgumentException();
        fieldArray = new Field[size][size];
        fieldSize = size;
    }
    public void addX (int str, int col) {
        if (str < 0 || str > fieldSize -1 || col < 0 || col > fieldSize - 1)
            throw new IndexOutOfBoundsException();
        fieldArray[str][col] = Field.X;
    }
    public void addO (int str, int col) {
        if (str < 0 || str > fieldSize -1 || col < 0 || col > fieldSize - 1)
            throw new IndexOutOfBoundsException();
        fieldArray[str][col] = Field.O;
    }
    public void clean (int str, int col) {
        if (str < 0 || str > fieldSize -1 || col < 0 || col > fieldSize - 1)
            throw new IndexOutOfBoundsException();
        fieldArray[str][col] = null;
    }
    public Field get (int str, int col) {
        return fieldArray[str][col];
    }
    private int[] checkHelp (Field L) {
        int localL = 0;
        int maxL = 0; // L принимает значение "X" или "O" в зависимости от параметра
        // проверка строк
        int strBeggining = -1;
        int colBeggining = -1;// координаты начала самой длинной последовательности
        int strEnd = -1;
        int colEnd = -1;// координаты конца самой длинной последовательности
        int localStrBeggining = -1;
        int localColBeggining = -1; // координаты начала текущей последовательности
        for (int i = 0; i <= fieldSize - 1; i++) {
            for (int j = 0; j <= fieldSize - 2; j++) {
                if (Objects.equals(fieldArray[i][j], L) && !Objects.equals(fieldArray[i][j + 1], L)) {
                    if (maxL == 0) {
                        maxL = 1;
                        strEnd = i;
                        colEnd = j;
                        strBeggining = i;
                        colBeggining = j;
                    }
                    localL = 0;
                }
                if (Objects.equals(fieldArray[i][j], L) && Objects.equals(fieldArray[i][j + 1], L)) {
                    if (localL == 0) {
                        localL += 2;
                        localStrBeggining = i;
                        localColBeggining = j;
                    }
                    else localL++;
                    if (localL > maxL) {
                        maxL = localL;
                        strBeggining = localStrBeggining;
                        colBeggining = localColBeggining;
                        strEnd = i;
                        colEnd = j + 1;
                    }
                }
            }
        }
        localL = 0;
        // проверка колонок
        for (int j = 0; j <= fieldSize - 1; j++) {
            for (int i = 0; i <= fieldSize - 2; i++) {
                if (Objects.equals(fieldArray[i][j], L) && !Objects.equals(fieldArray[i + 1][j], L)) {
                    if (maxL == 0) {
                        strEnd = i;
                        colEnd = j;
                        strBeggining = i;
                        colBeggining = j;
                        maxL = 1;
                    }
                    localL = 0;
                }
                if (Objects.equals(fieldArray[i][j], L) && Objects.equals(fieldArray[i + 1][j], L)) {
                    if (localL == 0) {
                        localL += 2;
                        localStrBeggining = i;
                        localColBeggining = j;
                    }
                    else localL++;
                    if (localL > maxL) {
                        maxL = localL;
                        strBeggining = localStrBeggining;
                        colBeggining = localColBeggining;
                        strEnd = i + 1;
                        colEnd = j;
                    }
                }
            }
        }
        localL = 0;
        // проверка первой диоганали
        int a = fieldSize - 1;
        int b = fieldSize - 2;// переменные для запоминания текщей строки  и столбца
        while (b >= 0) {
            int str = a;
            int col = b;
            while (col != fieldSize - 1) {
                if (Objects.equals(fieldArray[str][col], L) && Objects.equals(fieldArray[str - 1][col + 1], L)) {
                    if (localL == 0) {
                        localL += 2;
                        localStrBeggining = str;
                        localColBeggining = col;
                    }

                    else localL++;
                    if (localL > maxL) {
                        maxL = localL;
                        strBeggining = localStrBeggining;
                        colBeggining = localColBeggining;
                        strEnd = str - 1;
                        colEnd = col + 1;
                    }

                }
                else localL = 0;
                str--;
                col++;
            }
            b--;
        }
        localL = 0;
        a = fieldSize - 1;
        b = 0;
        while (a > 0) {
            int str = a;
            int col = b;
            while (str != 0) {
                if (Objects.equals(fieldArray[str][col], L) && Objects.equals(fieldArray[str - 1][col + 1], L)) {
                    if (localL == 0) {
                        localL += 2;
                        localStrBeggining = str;
                        localColBeggining = col;
                    }

                    else localL++;
                    if (localL > maxL) {
                        maxL = localL;
                        strBeggining = localStrBeggining;
                        colBeggining = localColBeggining;
                        strEnd = str - 1;
                        colEnd = col + 1;
                    }

                }
                else localL = 0;
                str--;
                col++;
            }
            a --;
        }
        // проверка второй диоганали
        localL = 0;
        a = 1;
        b = fieldSize - 1;
        while (a < 4) {
            int str = a;
            int col = b;
            while (str != 0) {
                if (Objects.equals(fieldArray[str][col], L) && Objects.equals(fieldArray[str - 1][col - 1], L)) {
                    if (localL == 0) {
                        localL += 2;
                        localStrBeggining = str;
                        localColBeggining = col;
                    }

                    else localL++;
                    if (localL > maxL) {
                        maxL = localL;
                        strBeggining = localStrBeggining;
                        colBeggining = localColBeggining;
                        strEnd = str - 1;
                        colEnd = col - 1;
                    }

                }
                else localL = 0;
                str--;
                col--;
            }
            a++;
        }
        localL = 0;
        a = fieldSize - 1;
        b = fieldSize - 1;
        while (b > 0) {
            int str = a;
            int col = b;
            while (col != 0) {
                if (Objects.equals(fieldArray[str][col], L) && Objects.equals(fieldArray[str - 1][col - 1], L)) {
                    if (localL == 0) {
                        localL += 2;
                        localStrBeggining = str;
                        localColBeggining = col;
                    }

                    else localL++;
                    if (localL > maxL) {
                        maxL = localL;
                        strBeggining = localStrBeggining;
                        colBeggining = localColBeggining;
                        strEnd = str -1;
                        colEnd = col -1;
                    }

                }
                else localL = 0;
                str--;
                col--;
            }
            b--;
        }
        if (strBeggining == -1 || strEnd == -1 || colBeggining == -1 || colEnd == -1)
            throw new IndexOutOfBoundsException();
        int[] Ans = {strBeggining, colBeggining, strEnd, colEnd};
        return Ans;
    }
    public int[] checkO () { return checkHelp(Field.O); }
    public int[] checkX () {
        return checkHelp(Field.X);
    }
}