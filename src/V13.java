public class V13 {
    String fieldArray[][];
    int fieldSize;
    public V13 (int field) {
        fieldArray = new String[field][field];
        fieldSize = field;
    }
    public void addX (int str, int col) {
        fieldArray[str][col] = "X";
    }
    public void addO (int str, int col) {
        fieldArray[str][col] = "O";
    }
    public void clean (int str, int col) {
        fieldArray[str][col] = "";
    }
    public int checkHelp (String L) {
        int localL = 0;
        int maxL = 0; // L принимает значение "X" или "Y" в зависимости от параметра
        // проверка строк
        for (int i = 0; i <= fieldSize - 1; i++) {
            for (int j = 0; j <= fieldSize - 2; j++) {
                if (fieldArray[i][j] == L && fieldArray[i][j + 1] != L) {
                    if (maxL == 0)
                        maxL = 1;
                    localL = 0;
                }
                if (fieldArray[i][j] == L && fieldArray[i][j + 1] == L) {
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
                if (fieldArray[i][j] == L && fieldArray[i + 1][j] != L) {
                    if (maxL == 0)
                        maxL = 1;
                    localL = 0;
                }
                if (fieldArray[i][j] == L && fieldArray[i + 1][j] == L) {
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
                if (fieldArray[str][col] == L && fieldArray[str - 1][col + 1] == L) {
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
                if (fieldArray[str][col] == L && fieldArray[str - 1][col + 1] == L) {
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
                if (fieldArray[str][col] == L && fieldArray[str - 1][col - 1] == L) {
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
                if (fieldArray[str][col] == L && fieldArray[str - 1][col - 1] == L) {
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
