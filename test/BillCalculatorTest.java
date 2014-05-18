import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static com.google.common.collect.Sets.newHashSet;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BillCalculatorTest {
    private BillCalculator billCalculator;
    private String PERSON1 = "Person1";
    private String PERSON2 = "Person2";
    private String PERSON3 = "Person3";

    @Before
    public void setUp() {
        billCalculator = new BillCalculator();
    }

    @Test
    public void shouldOweNothingForNoBillsAndNoParticipants() {
        billCalculator.addExpense(new Expense(0.0, PERSON1, new HashSet<String>()));
        assertThat(billCalculator.fromPerspective(PERSON1), is(""));
    }

    @Test
    public void shouldOweNothingForNoBillsAndOneParticipant() {
        billCalculator.addExpense(new Expense(0.0, PERSON1, newHashSet(PERSON2)));
        assertThat(billCalculator.fromPerspective(PERSON1), is(PERSON2 + ": 0.0\n"));
    }

    @Test
    public void shouldOweNothingForNoBillsAndTwoParticipants() {
        billCalculator.addExpense(new Expense(0.0, PERSON1, newHashSet(PERSON2, PERSON3)));
        assertThat(billCalculator.fromPerspective(PERSON1), is(PERSON2 + ": 0.0\n" + PERSON3 + ": 0.0\n"));
    }

    @Test
    public void shouldOweNothingForOneBillWithOnlySelfPartcipating() {
        billCalculator.addExpense(new Expense(10.0, PERSON1, new HashSet<String>()));
        assertThat(billCalculator.fromPerspective(PERSON1), is(""));
    }

    @Test
    public void shouldOweNothingForOneBillWithOneOtherPersonPartcipating() {
        billCalculator.addExpense(new Expense(10.0, PERSON2, newHashSet(PERSON1)));
        assertThat(billCalculator.fromPerspective(PERSON2), is(""));
    }

    @Test
    public void shouldOweHalfBillForOneBillPaidByOtherPerson() {
        billCalculator.addExpense(new Expense(10.0, PERSON2, newHashSet(PERSON1)));
        assertThat(billCalculator.fromPerspective(PERSON1), is(PERSON1 + ": 5.0\n"));
    }
}
