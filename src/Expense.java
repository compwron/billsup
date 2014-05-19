import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class Expense {
    private final Double amount;
    private final String paidBy;
    private final Set<String> participants;
}
