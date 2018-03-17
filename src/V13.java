import java.util.Objects;

public class V13 {
    String fieldArray[][];
    private int fieldSize;
    public V13 (int field) {
        if (field <= 1)
            throw new Error();
        fieldArray = new String[field][field];
        fieldSize = field;
    }
    public void addX (int str, int col) {
        if (str < 0 || str > fieldSize -1 || col < 0 || col > fieldSize - 1)
            throw new Error();
        fieldArray[str][col] = "X";
    }
    public void addO (int str, int col) {
        if (str < 0 || str > fieldSize -1 || col < 0 || col > fieldSize - 1)
            throw new Error();
        fieldArray[str][col] = "O";
    }
    public void clean (int str, int col) {
        if (str < 0 || str > fieldSize -1 || col < 0 || col > fieldSize - 1)
            throw new Error();
        fieldArray[str][col] = "";
    }
    private int checkHelp (String L) {
        int localL = 0;
        int maxL = 0; // L принимает значение "X" или "O" в зависимости от параметра
        // проверка строк
        for (int i = 0; i <= fieldSize - 1; i++) {
            for (int j = 0; j <= fieldSize - 2; j++) {
                if (Objects.equals(fieldArray[i][j], L) && !Objects.equals(fieldArray[i][j + 1], L)) {
                    if (maxL == 0)
                        maxL = 1;
                    localL = 0;
                }
                if (Objects.equals(fieldArray[i][j], L) && Objects.equals(fieldArray[i][j + 1], L)) {
                    if (localL == 0)
                        localL += 2;
                    else localL++;
                    if (localL > maxL)
                        maxL = localL;
                }
            }
        }
        localL = 0;
        // проверка колонок
        for (int j = 0; j <= fieldSize - 1; j++) {
            for (int i = 0; i <= fieldSize - 2; i++) {
                if (Objects.equals(fieldArray[i][j], L) && !Objects.equals(fieldArray[i + 1][j], L)) {
                    if (maxL == 0)
                        maxL = 1;
                    localL = 0;
                }
                if (Objects.equals(fieldArray[i][j], L) && Objects.equals(fieldArray[i + 1][j], L)) {
                    if (localL == 0)
                        localL += 2;
                    else localL++;
                    if (localL > maxL)
                        maxL = localL;
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
                    if (localL == 0)
                        localL += 2;
                    else localL++;
                    if (localL >= maxL)
                        maxL = localL;
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
                    if (localL == 0)
                        localL += 2;
                    else localL++;
                    if (localL >= maxL)
                        maxL = localL;
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
                    if (localL == 0)
                        localL += 2;
                    else localL++;
                    if (localL >= maxL)
                        maxL = localL;
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
                    if (localL == 0)
                        localL += 2;
                    else localL++;
                    if (localL >= maxL)
                        maxL = localL;
                }
                else localL = 0;
                str--;
                col--;
            }
            b--;
        }
        return maxL;
    }
    public int checkO () {
        return  checkHelp("O");
    }
    public int checkX () {
        return checkHelp("X");
    }
}
