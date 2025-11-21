import java.util.Iterator;

class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Элемент 1");
        list.add("Элемент 2");
        list.add("Элемент 3");
        list.add("Элемент 4");

        // Обход с for-each
        System.out.println("Элементы списка:");
        for (String item : list) {
            System.out.println(item);
        }

        // Использование итератора с удалением
        System.out.println("\nУдаляем 'Элемент 2':");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String item = it.next();
            if (item.equals("Элемент 2")) {
                it.remove();
            }
        }

        // После удаления
        for (String item : list) {
            System.out.println(item);
        }

        System.out.println("Размер списка: " + list.size());
    }
}