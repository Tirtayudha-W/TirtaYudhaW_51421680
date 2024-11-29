package pert2_tirta;
import java.util.Scanner;

class Animal {
    private String name;
    private int energy;

    public Animal(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public void walk() {
        if (energy >= 5) {
            energy -= 5;
            System.out.println(name + " berjalan dan kehilangan 5 energi.");
        } else {
            System.out.println(name + " tidak memiliki cukup energi untuk berjalan.");
        }
    }

    public void eat() {
        energy += 4;
        System.out.println(name + " makan dan menambah 4 energi.");
    }

    public void displayStatus() {
        System.out.println("Nama: " + name + ", Energi: " + energy);
    }
}

public class pert2_tirta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input nama dan energi awal hewan
        System.out.print("Masukkan nama hewan: ");
        String name = scanner.nextLine();
        System.out.print("Masukkan energi awal hewan: ");
        int energy = scanner.nextInt();
        scanner.nextLine(); // konsumsi newline

        Animal hewan = new Animal(name, energy);

        while (true) {
            hewan.displayStatus();
            System.out.print("Masukkan perintah (berjalan/makan/keluar): ");
            String command = scanner.nextLine().toLowerCase();

            if (command.equals("berjalan")) {
                hewan.walk();
            } else if (command.equals("makan")) {
                hewan.eat();
            } else if (command.equals("keluar")) {
                System.out.println("Program selesai.");
                break;
            } else {
                System.out.println("Perintah tidak dikenal.");
            }
        }

        scanner.close();
    }
}
