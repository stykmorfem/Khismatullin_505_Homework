import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstScore = 0;
        int secondScore = 0;

        String[][] questions = {
                {"Какая река самая длинная в России?", "лена"},
                {"Какая река протекает через Москву?", "москва"},
                {"Какая река соединяет Европу и Азию?", "волга"},
                {"Какой город является столицей России?", "москва"},
                {"Какой город называют 'северной столицей'?", "санкт-петербург"},
                {"В каком городе находится пряничный завод?", "тула"},
                {"Какое изобретение придумали братья Белл для звонков?", "телефон"},
                {"Какое устройство называют 'мозгом' компьютера?", "процессор"},
                {"Что изобрели братья Райт?", "самолет"}
        };

        boolean[] used = new boolean[questions.length];
        String inputNamePlayer1;
        String inputNamePlayer2;

        System.out.println("Добро пожаловать в игру 'Своя игра'");
        System.out.println("Темы: реки, города, изобретения");
        System.out.println("Баллы: 100 | 200 | 300");
        System.out.println("Формат: тема баллы (пример: города 200)");
        System.out.println("Познакомимся? Напишите имена участников\n");
        System.out.print("Игрок 1: ");
        inputNamePlayer1 = scanner.nextLine();
        System.out.println();
        System.out.print("Игрок 2: ");
        inputNamePlayer2 = scanner.nextLine();

        while (true) {
            System.out.println(inputNamePlayer1 + ": " + firstScore + " | " + inputNamePlayer2 + ": " + secondScore);
            System.out.println("Выберете тему и количество баллов");
            System.out.print("Ввод: ");

            String input = scanner.nextLine().toLowerCase().trim();
            if (input.equals("выход")) break;

            String[] parts = input.split(" ");
            if (parts.length != 2 || !parts[1].matches("100|200|300")) {
                System.out.println("Ошибка! Пример: города 200");
                continue;
            }

            int points = Integer.parseInt(parts[1]);
            int questionIndex = getQuestionIndex(parts[0], points);

            if (questionIndex == -1) {
                System.out.println("Тема не найдена!");
                continue;
            }

            if (used[questionIndex]) {
                System.out.println("Вопрос уже был!");
                continue;
            }

            System.out.println("\nВопрос за " + points + ": " + questions[questionIndex][0]);
            used[questionIndex] = true;

            String player = (firstScore <= secondScore) ? inputNamePlayer1 : inputNamePlayer2;
            System.out.print(player + ", ответ: ");
            String answer = scanner.nextLine().toLowerCase().trim();

            if (answer.equals(questions[questionIndex][1])) {
                System.out.println("Правильно! +" + points);
                if (player.equals("Амир")) firstScore += points;
                else secondScore += points;
            } else {
                System.out.println("Неправильно! Ответ: " + questions[questionIndex][1]);
            }
        }

        System.out.println("\nИтог: Амир " + firstScore + " - " + secondScore + inputNamePlayer2);
        if (firstScore > secondScore) System.out.println("Победил Амир!");
        else if (secondScore > firstScore) System.out.println("Победил Динар!");
        else System.out.println("Ничья!");

        scanner.close();
    }

    static int getQuestionIndex(String topic, int points) {
        int base = 0;
        switch (topic) {
            case "реки": base = 0; break;
            case "города": base = 3; break;
            case "изобретения": base = 6; break;
            default: return -1;
        }
        return base + (points / 100) - 1;
    }
}
