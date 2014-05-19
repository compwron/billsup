import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BillCalculator {
    private List<Expense> expenses = new ArrayList<Expense>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public String fromPerspective(String self) {
        Map<String, Double> owed = new HashMap<String, Double>();
        for (Expense expense : expenses) {
            for (String participant : expense.getParticipants()) {
                if (owed.get(participant) == null) {
                    owed.put(participant, 0.0);
                }

                Double previouslyOwed = owed.get(participant);
                Double newOwedAmount = expense.getAmount() / expense.getParticipants().size();
                if (!participant.equals(self)) {
                    if (expense.getPaidBy().equals(self)) {
                        owed.put(participant, previouslyOwed + newOwedAmount);
                    } else {
                        owed.put(participant, previouslyOwed - newOwedAmount);
                    }
                }
            }

        }
        return summarize(self, owed);
    }

    private String summarize(String self, Map<String, Double> owed) {
        String summary = "";
        for (String ower : owed.keySet()) {
            if (!ower.equals(self)) {
                summary += ower + ": " + owed.get(ower) + "\n";
            }
        }
        return summary;
    }
}
