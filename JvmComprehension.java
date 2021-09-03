public class JvmComprehension { //новый класс - отдается для загрузки в систему загрузчиков классов и перемещается в Metaspace где сохраняется информация о классе JvmComprehension
    public static void main(String[] args) { //создается фрейм в стеке во время вызова метода main()
        int i = 1;                      // 1 во фрейм main() помещается информация о том что создана переменная i равна 1
        Object o = new Object();        // 2 В куче создается новый объект Object  и в стеке во фрейме main() появляется ссылка "o"  на этот обект 
        Integer ii = 2;                 // 3 во фрейм main помещается информация о том что создана переменная ii равна 2
        printAll(o, i, ii);             // 4 создается фрейм в стеке во время вызова метода printAll(). В стеке во фрейме printAll() появляется еще одна ссылка на объект "o"и две новые переменные: i,ii
                                        // Object o  помечается для сборщика мусора как "можно удалить"
        System.out.println("finished"); // 7 в стеке создастся новый фрейм println() с переменной типа string и значением "finished"
    }
  
    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 во фрейм printAll() помещается информация о том что создана переменная uselessVar равна 700
        System.out.println(o.toString() + i + ii);  // 6 В куче создается новый объект string(), в стеке создастся новый фрейм println() с двумя новыми переменными i,ii и с ссылкой на string().
    }
  }