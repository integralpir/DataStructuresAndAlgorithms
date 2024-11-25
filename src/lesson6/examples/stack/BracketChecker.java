package lesson6.examples.stack;

public class BracketChecker {
    private String input; // Входная строка

    public BracketChecker(String in) {
        input = in;
    }

    public void check() {
        int stackSize = input.length(); // Определение размера стека
        StackImpl theStack = new StackImpl(stackSize); // Создание стека
        for (int j = 0; j < input.length(); j++) { // Последовательное чтение
            char ch = input.charAt(j); // Чтение символа
            switch(ch) {
                case '{': // Открывающие скобки
                case '[':
                case '(':
                    theStack.push(ch); // Занести в стек
                    break;
                case '}': // Закрывающие скобки
                case ']':
                case ')':
                    if( !theStack.isEmpty() ) { // Если стек не пуст,
                        char chx = theStack.pop(); // Извлечь и проверить
                        if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[') || (ch == ')' && chx != '(')) {
                            System.out.println("Error: " + ch + " at " + j);
                        }
                    } else { // Преждевременная нехватка элементов
                        System.out.println("Error: " + ch + " at " + j);
                    }
                    break;
                default: // Для других символов действия не выполняются
                    break;
            }
        }
        // В этой точке обработаны все символы
        if (!theStack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}
