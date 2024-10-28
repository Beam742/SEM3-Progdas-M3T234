import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePortScanner {
    /**
     * Main function (executor)
     *
     */
    public static void main(String[] args) {
        SimplePortScanner scannerApp = new SimplePortScanner();
        scannerApp.run();
    }

    // Refactor 2: Memisahkan logika utama ke dalam metode run()
    /***
     * main runner method
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        PortScanner portScanner = new PortScanner();

        // Refactor 2: Logika menu dipindah ke metode displayMenu
        int option = displayMenu(scanner);

        // Meminta input alamat IP
        System.out.println("Enter IP address to scan: ");
        String ip = scanner.next();

        // Refactor 2: Pemrosesan pilihan pengguna dipindah ke handleUserChoice()
        handleUserChoice(option, ip, scanner, portScanner);
        scanner.close();
    }

    // Refactor 2: Method untuk menampilkan menu
    /***
     * Method for displaying menu
     * @param scanner receive scanner object
     * @return return the user input (pilihan menu)
     */
    private int displayMenu(Scanner scanner) {
        System.out.println("Port Scanner Menu:");
        System.out.println("1. Scan range of ports");
        System.out.println("2. Scan a specific port");
        System.out.println("Choose an option: ");
        return scanner.nextInt();
    }

    // Refactor 2: Method untuk menangani pilihan pengguna

    /***
     * Method for handling user input choice
     * @param option user choice
     * @param ip target IP Address
     * @param scanner scanner object for user input
     * @param portScanner portScanner class
     */
    private void handleUserChoice(int option, String ip, Scanner scanner, PortScanner portScanner) {
        switch (option) {
            case 1:
                System.out.println("Enter start port: ");
                int startPort = scanner.nextInt();
                System.out.println("Enter end port: ");
                int endPort = scanner.nextInt();
                portScanner.scanPortRange(ip, startPort, endPort);
                break;

            case 2:
                System.out.println("Enter port: ");
                int port = scanner.nextInt();
                portScanner.scanSinglePort(ip, port);
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}

// Refactor 1: Memisahkan kelas PortScanner
/***
 * main portScanner class
 */
class PortScanner {

    // Refactor 4: Menambahkan exception handling yang lebih baik
    /***
     * method for scanning a single port
     * @param ip target IP Address to scan
     * @param port target port to scan
     */
    public void scanSinglePort(String ip, int port) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), 1000);
            socket.close();
            Logger.log("Port " + port + " is open on " + ip);
        } catch (IOException e) {
            //Logger.log("Port " + port + " is closed on " + ip);
        } catch (Exception e) {
            Logger.log("An error occurred while scanning port " + port + ": " + e.getMessage());
        }
    }

    // Refactor 3: Menambahkan threading untuk mempercepat scanning
    /***
     * method for scanning by port range
     * @param ip target IP Address to scan
     * @param startPort first port to scan
     * @param endPort last port to scan
     */
    public void scanPortRange(String ip, int startPort, int endPort) {
        ExecutorService executor = Executors.newFixedThreadPool(10); // 10 thread paralel
        for (int port = startPort; port <= endPort; port++) {
            int finalPort = port;
            executor.submit(() -> scanSinglePort(ip, finalPort));
        }
        executor.shutdown(); // Menutup thread pool setelah semua tugas selesai
    }
}

// Refactor 5: Memisahkan logging ke kelas Logger
class Logger {
    public static void log(String message) {
        System.out.println(message);
    }
}
