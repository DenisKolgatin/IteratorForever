package main;

class Main {
    public static void main(String[] args) {
        Randoms randoms = new Randoms(90, 100);

        for (int number : randoms) {
            System.out.println("Случайное число: " + number);
            if (number == 100) {
                System.out.println("Выпало число 100, давайте на этом закончим");
                break;
            }
        }
    }
}