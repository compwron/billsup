import lombok.Getter;

import java.util.Set;

@Getter
public class Expense {
    private final Double amount;
    private final String paidBy;
    private final Set<String> participants;

    public Expense(Double amount, String paidBy, Set<String> participants) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.participants = participants;
    }
}
