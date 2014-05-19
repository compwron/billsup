import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillCalculator {
    private List<Expense> expenses = new ArrayList<Expense>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public String fromPerspective(String person) {
        Map<String, Double> owed = new HashMap<String, Double>();
        for (Expense expense : expenses) {
            for (String ower : expense.getParticipants()) {
                if (owed.get(ower) == null) {
                    owed.put(ower, 0.0);
                }

                Double amountOwedByOwer = owed.get(ower);
                Double newAmountOwedByOwer = (amountOwedByOwer += (expense.getAmount() / (expense.getParticipants().size())));
                if (!ower.equals(person)) {
                    owed.put(ower, newAmountOwedByOwer);
                }
            }
        }

        String summary = "";
        for (String ower : owed.keySet()) {
            if (!ower.equals(person)) {
                summary += ower + ": " + owed.get(ower) + "\n";
            }
        }
        return summary;
    }
}
