import static org.junit.jupiter.api.Assertions.*;

class V13Test {
    @org.junit.jupiter.api.Test
    void addX() {
        V13 V13Help = new V13(5);
        V13Help.addX(3,4);
        assertEquals(V13Help.fieldArray[3][4],"X");
    }
    @org.junit.jupiter.api.Test
    void addO() {
        V13 V13Help = new V13(5);
        V13Help.addO(3,4);
        assertEquals(V13Help.fieldArray[3][4],"O");
    }

    @org.junit.jupiter.api.Test
    void clean() {
        V13 V13Help = new V13(5);
        V13Help.addO(3,4);
        V13Help.clean(3,4);
        assertEquals(V13Help.fieldArray[3][4],"");
    }

    @org.junit.jupiter.api.Test
    void checkO() {
        V13 V13Help = new V13(5);
        V13Help.addO(0,1);
        V13Help.addO(0,4);
        V13Help.addO(1,1);
        V13Help.addO(1,3);
        V13Help.addO(2,2);
        V13Help.addO(2,3);
        V13Help.addO(3,1);
        V13Help.addO(3,3);
        V13Help.addO(4,0);
        assertEquals(5,V13Help.checkO());
    }

    @org.junit.jupiter.api.Test
    void checkX() {
        V13 V13Help = new V13(5);
        V13Help.addX(0,0);
        V13Help.addX(0,3);
        V13Help.addX(1,3);
        V13Help.addX(2,0);
        V13Help.addX(2,1);
        V13Help.addX(2,2);
        V13Help.addX(3,3);
        V13Help.addX(4,0);
        V13Help.addX(4,3);
        assertEquals(3,V13Help.checkX());
    }
}