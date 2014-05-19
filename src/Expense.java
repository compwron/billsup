import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@AllArgsConstructor
@ToString
public class Expense {
    private final Double amount;
    private final String paidBy;
    private final Set<String> participants;
}
