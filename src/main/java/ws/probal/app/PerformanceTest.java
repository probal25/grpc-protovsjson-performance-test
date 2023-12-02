package ws.probal.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import ws.probal.app.json.DemoPerson;
import ws.probal.app.models.Person;

public class PerformanceTest {
    public static void main(String[] args) {

        // json
        DemoPerson personDemo = new DemoPerson("probal", 30);
        ObjectMapper mapper = new ObjectMapper();

        Runnable runnableJson = () -> {
            try {
                byte[] demoPersonBytes = mapper.writeValueAsBytes(personDemo);
                DemoPerson demoPerson = mapper.readValue(demoPersonBytes, DemoPerson.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // protobuf
        Person person = Person.newBuilder().setName("probal").setAge(30).build();

        Runnable runnableProto = () -> {
            try {
                byte[] personByteArray = person.toByteArray();
                Person deserializedPerson = Person.parseFrom(personByteArray);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i < 10; i++) {
            System.out.println("No : " + i + " started");
            runPerformanceTest(runnableJson, "json method");
            runPerformanceTest(runnableProto, "proto method");
            System.out.println("No : " + i + " ended");
            System.out.println("=====================");
        }
    }

    private static void runPerformanceTest(Runnable runnable, String method) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5_000_000; i++) {
            runnable.run();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(method + " -> time taken : " + (endTime - startTime) + " ms");
    }
}
