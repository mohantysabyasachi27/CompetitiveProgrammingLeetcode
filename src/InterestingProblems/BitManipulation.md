Bit manipulation, in some cases, can obviate or reduce the need to loop over a data structure and can give many-fold speed ups, as bit manipulations are processed in parallel, but the code can become more difficult to write and maintain.

****Details****
****Basics****
At the heart of bit manipulation are the bit-wise operators & (and), | (or), ~ (not) and ^ (exclusive-or, xor) and shift operators a << b and a >> b.

Set union A | B

Set intersection A & B

Set subtraction A & ~B

Set negation ALL_BITS ^ A or ~A

Set bit A |= 1 << bit

Clear bit A &= ~(1 << bit)

Test bit (A & 1 << bit) != 0

Extract last bit A&-A or A&~(A-1) or x^(x&(x-1))

Remove last bit A&(A-1)

Get all 1-bits ~0
