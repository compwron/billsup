import lombok.Getter;

import java.util.List;

@Getter
public class Expense {
    private final Double amount;
    private final String paidBy;
    private final List<String> participants;

    public Expense(Double amount, String paidBy, List<String> participants) {
        this.amount = amount;
        this.paidBy = paidBy;
        this.participants = participants;
    }
}
