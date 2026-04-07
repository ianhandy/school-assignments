# CIS 181 - Homework #2

**Name:** Ian Handy

---

## 1. Context-Free Grammar (12 points)

Using boolean relational operators:

1. S → S < S
2. S → S <= S
3. S → S > S
4. S → S >= S
5. S → S == S
6. S → S != S
7. S → numerical negative infinity to positive infinity

---

## 2. Concrete Syntax Tree (18 points)

Extended CFG (adding math operations to the above):

1. S → S + S
2. S → S - S
3. S → S * S
4. S → S / S
5. S → (S)

Expression: `(9 + 1/5) <= (9*3/6 + 1)`

```
                        S
                   _____|_____
                  /     |     \
                 S     <=      S
                 |             |
               ( S )         ( S )
                 |             |
              S  +  S       S  +  S
              |     |       |     |
              S   S / S   S / S   S
              |   |   |   |   |   |
              9   1   5  S*S  6   1
                         | |
                         9 3
```

Reading the tree: The root is `<=`. The left subtree is `(9 + 1/5)` and the right subtree is `(9*3/6 + 1)`.

Left side `(9 + 1/5)`:
- S is `(S)`, where inner S is `S + S`
- Left S of `+` is `9`
- Right S of `+` is `S / S` which is `1 / 5`

Right side `(9*3/6 + 1)`:
- S is `(S)`, where inner S is `S + S`
- Left S of `+` is `S / S` which is `S*S / 6`, where `S*S` is `9*3`
- Right S of `+` is `1`

Full CST (showing every production rule applied):

```
                              S
                     _________|_________
                    /          |         \
                   S          <=          S
                   |                      |
                 ( S )                  ( S )
                   |                      |
              ___S_+_S___            ___S_+_S___
             /           \          /           \
            S           S / S    S / S           S
            |           |   |    |   |           |
            9           1   5  S * S  6          1
                               |   |
                               9   3
```

---

## 3. Abstract Syntax Tree (20 points)

The AST removes the parentheses and extra S nodes, keeping only operators and values:

```
            <=
           /  \
          +    +
         / \  / \
        9   /  /  1
           / \  / \
          1   5  *  6
                / \
               9   3
```

The key difference from the CST is that the parentheses are gone. In a CST, `(S)` is its own production rule and shows up as nodes in the tree. In the AST, parentheses aren't needed because the tree structure itself encodes the order of operations. The nesting of nodes shows what gets evaluated first — leaf nodes get evaluated before their parents.

---

## 4. Explain the Error in Terms of an AST (10 points)

Expression: `(1 * 9 - ) < 40`

### Abstract Syntax Tree (as far as we can go):

```
         <
        / \
       -   40
      / \
     *    ???
    / \
   1   9
```

The tree can be built starting from the `<` at the root. The right side is `40`. The left side starts with `(1 * 9 - )`. We can build the `*` node with children `1` and `9`. The `-` node takes `1*9` as its left child, but there is nothing on the right side — the `)` closes the expression before giving the subtraction a second operand. The tree cannot be completed because the `-` node is missing its right child.

### Explanation of Error Finding

This is how ASTs help compilers give better error messages. When a compiler tries to build the AST, it follows the grammar rules. Every binary operator like `-` requires exactly two operands (two child nodes). When the compiler reaches the `-` and tries to find its right operand, it finds `)` instead of a number or expression. At this point, the compiler knows exactly what went wrong and where: the subtraction operator at that specific position is missing its right-hand operand. Instead of just saying "syntax error on line X," the compiler can say something like "expected expression after '-' operator." The tree-building process naturally identifies not just that there is an error, but what kind of value was expected and where it was expected, leading to much more descriptive and helpful error messages.
