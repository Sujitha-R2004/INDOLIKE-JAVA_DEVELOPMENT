package coding;

import java.util.*;

public class weather_App_CLI_Based {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeatherApp app = new WeatherApp();

        printWelcome();

        boolean running = true;
        while (running) {
            System.out.print("\n🏙️ Enter city name: ");
            String city = sc.nextLine().trim();

            app.displayWeather(city);

            System.out.print("\n🔁 Want to check another city? (yes/no): ");
            String again = sc.nextLine().trim().toLowerCase();
            if (!again.equals("yes")) {
                running = false;
            }
        }

        System.out.println("\n🌤️ Thank you for using Weather App. Stay safe!");
        sc.close();
    }

    public static void printWelcome() {
        System.out.println("=======================================");
        System.out.println("        🌦️ CLI Weather App             ");
        System.out.println("=======================================");
        System.out.println("Check weather for any city instantly!");
    }
}

// A separate class to generate fake weather data
class WeatherApp {
    private Random rand = new Random();
    private String[] conditions = {"☀️ Sunny", "🌧️ Rainy", "⛅ Cloudy", "🌩️ Stormy", "🌫️ Foggy", "❄️ Snowy"};

    public void displayWeather(String city) {
        int temp = rand.nextInt(35) + 5; // 5 to 39 °C
        int humidity = rand.nextInt(60) + 20; // 20% to 80%
        String condition = conditions[rand.nextInt(conditions.length)];

        System.out.println("\n📍 Weather Report for: " + city.toUpperCase());
        System.out.println("---------------------------------------");
        System.out.println("🌡️ Temperature : " + temp + "°C");
        System.out.println("💧 Humidity    : " + humidity + "%");
        System.out.println("🌤️ Condition   : " + condition);
        System.out.println("---------------------------------------");
    }
}

