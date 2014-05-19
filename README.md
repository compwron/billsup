Purpose:
When a group of people are sharing expenses (for example, on a road trip) provide an easy way to split and track accounts.

Examples:
````
1.
amount, paid by, participants
10, Bob, [Bob, Alice]

outcome from Bob perspective:
Alice owes Bob 5
i.e.: Alice: 5

2.
amount, paid by, participants
10, Bob, [Alice]

outcome from Bob perspective:
Alice owes Bob 10
i.e.: Alice: 10

3.
amount, paid by, participants
10, Alice, [Bob, Alice]

outcome from Bob perspective:
Bob owes Alice 5
i.e.: Alice: -5

4.
amount, paid by, participants
6, Bob, [Bob, Alice]
8, Alice, [Bob, Alice]

outcome from Bob perspective:
Bob owes Alice 1
i.e.: Alice: -1

outcome from Alice perspective:
Bob owes Alice 1
i.e.: Bob: 1
````
