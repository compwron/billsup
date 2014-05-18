import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args) {
        BillCalculator billCalculator = new BillCalculator();
        //        List<String> participants = newArrayList("Person1, Person2");
        List<String> allParticipants = new ArrayList<String>();
        allParticipants.add("Person1");
        allParticipants.add("Person2");
        allParticipants.add("Person3");

        List<String> someParticipants = new ArrayList<String>();
        someParticipants.add("Person1");
        someParticipants.add("Person2");
        billCalculator.addExpense(new Expense(10.0, "Person1", allParticipants));
        billCalculator.addExpense(new Expense(20.0, "Person2", someParticipants));
        System.out.println(billCalculator.fromPerspective("Person1"));


    }
}
