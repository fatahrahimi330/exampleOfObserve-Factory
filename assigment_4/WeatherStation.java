import java.util.ArrayList;
import java.util.List;

public class WeatherStation {

    private int temperature;
    private List<Observer> observers = new ArrayList<>();

    public WeatherStation() {
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Observer temperatureDisplay = new TemperatureDisplay();
        Observer humidityDisplay = new HumidityDisplay();

        weatherStation.addObserver(temperatureDisplay);
        weatherStation.addObserver(humidityDisplay);

        weatherStation.setTemperature(25);

        weatherStation.removeObserver(humidityDisplay);

        weatherStation.setTemperature(30);
    }
}

interface Observer {
    void update(int temperature);
}

class TemperatureDisplay implements Observer {

    @Override
    public void update(int temperature) {
        System.out.println("Temperature is now " + temperature + " degrees Celsius.");
    }
}

class HumidityDisplay implements Observer {

    @Override
    public void update(int temperature) {
        System.out.println("Humidity display received update. Temperature is " + temperature + " degrees Celsius.");
    }
}

// We use the Observer pattern in the Weather Station code because it allows us
// to decouple the subject (the Weather Station) from the observers (the
// Temperature Display and Humidity Display). This makes the code more flexible
// and maintainable.

// Without the Observer pattern, we would need to have a tight coupling between
// the Weather Station and the observers. This would mean that we would need to
// update the code of the observers whenever we made a change to the Weather
// Station. This could be cumbersome and error-prone.

// With the Observer pattern, the observers are only loosely coupled to the
// Weather Station. This means that we can make changes to the Weather Station
// without having to update the code of the observers. This makes the code more
// flexible and maintainable.

// Here are some specific benefits of using the Observer pattern in the Weather
// Station code:

// Flexibility: We can add or remove observers without having to modify the code
// of the Weather Station.
// Maintainability: The code is easier to maintain because the observers are
// loosely coupled to the Weather Station.
// Reusability: We can reuse the Observer pattern in other parts of our
// codebase.
// Overall, the Observer pattern is a powerful design pattern that can be used
// to decouple subjects from observers. This makes the code more flexible,
// maintainable, and reusable.
