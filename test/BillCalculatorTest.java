import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static com.google.common.collect.Sets.newHashSet;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BillCalculatorTest {
    private BillCalculator billCalculator;
    private String Bob = "Person1";
    private String Alice = "Person2";
    private String PERSON3 = "Person3";

    @Before
    public void setUp() {
        billCalculator = new BillCalculator();
    }

    @Test
    public void shouldOweNothingForNoBillsAndNoParticipants() {
        billCalculator.addExpense(new Expense(0.0, Bob, new HashSet<String>()));
        assertThat(billCalculator.fromPerspective(Bob), is(""));
    }

    @Test
    public void shouldOweNothingForNoBillsAndOneParticipant() {
        billCalculator.addExpense(new Expense(0.0, Bob, newHashSet(Alice)));
        assertThat(billCalculator.fromPerspective(Bob), is(Alice + ": 0.0\n"));
    }

    @Test
    public void shouldOweNothingForNoBillsAndTwoParticipants() {
        billCalculator.addExpense(new Expense(0.0, Bob, newHashSet(Alice, PERSON3)));
        assertThat(billCalculator.fromPerspective(Bob), is(Alice + ": 0.0\n" + PERSON3 + ": 0.0\n"));
    }

    @Test
    public void shouldOweNothingForOneBillWithOnlySelfPartcipating() {
        billCalculator.addExpense(new Expense(10.0, Bob, new HashSet<String>()));
        assertThat(billCalculator.fromPerspective(Bob), is(""));
    }

    @Test
    public void shouldOweHalfBillForEventSharedWithOneParticipantOtherThanSelf() {
        billCalculator.addExpense(new Expense(10.0, Bob, newHashSet(Bob, Alice)));
        assertThat(billCalculator.fromPerspective(Bob), is(Alice + ": 5.0\n"));
    }

    @Test
    public void shouldOweOtherWhenOtherPaysForExpense() {
        billCalculator.addExpense(new Expense(10.0, Bob, newHashSet(Bob, Alice)));
        assertThat(billCalculator.fromPerspective(Alice), is(Bob + ": -5.0\n"));
    }

    @Test
    public void shouldOweWholeAmountWhenExpenseIsPaidByOtherPerson() {
        billCalculator.addExpense(new Expense(10.0, Bob, newHashSet(Alice)));
        assertThat(billCalculator.fromPerspective(Bob), is(Alice + ": 10.0\n"));
    }

    @Test
    public void shouldSumTwoBillsPaidByTwoPeople() {
        billCalculator.addExpense(new Expense(6.0, Bob, newHashSet(Bob, Alice)));
        billCalculator.addExpense(new Expense(8.0, Alice, newHashSet(Bob, Alice)));
        assertThat(billCalculator.fromPerspective(Bob), is(Alice + ": -1.0\n"));
        assertThat(billCalculator.fromPerspective(Alice), is(Bob + ": 1.0\n"));
    }
}
