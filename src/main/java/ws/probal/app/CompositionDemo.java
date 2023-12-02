package ws.probal.app;

import ws.probal.app.models.Address;
import ws.probal.app.models.Car;
import ws.probal.app.models.Person;

import java.util.List;

public class CompositionDemo {

    public static void main(String[] args) {
        Person person = Person.newBuilder()
                .setName("Probal")
                .setAge(30)
                .setAddress(getAddress())
                .addCar(getCar())
                .addCar(getCar())
                .build();

        System.out.println(person);
    }

    private static Address getAddress() {
        return Address.newBuilder()
                .setCity("Dhaka")
                .setStreet("road 11")
                .setPostbox(1229)
                .build();
    }

    private static Car getCar() {
        return Car.newBuilder()
                .setMake("BMW")
                .setModel("EVM")
                .setYear(2023)
                .build();
    }
}
