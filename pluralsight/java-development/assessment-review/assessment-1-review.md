# Java Basics Assessment Review

1.  **Primitive Data Types**: Java has eight built-in data types: `byte`, `short`, `int`, `long`, `float`, `double`, `char`, and `boolean`.

    ```java
    byte b = 10;
    short s = 500;
    int i = 1000;
    long l = 5000L;
    float f = 5.7f;
    double d = 9.7;
    char c = 'A';
    boolean bool = true;
    ```

    Note: `String` is NOT a primitive data type.

    ```java
    String str = "Hello, Java!";
    ```

2.  **Main Method**: This is the entry point of a Java application.

    ```java
    public static void main(String[] args) {
        // code here
    }
    ```

3.  **Classes**: They are declared using the `class` keyword.

    ```java
    public class MyClass {
        // class members here
    }
    ```

4.  **Identifiers**: Identifiers are the names given to various program elements, such as variables, methods, classes, etc.

    - **Valid Identifiers**:

      ```java
      int validIdentifier = 10;
      String _alsoValid = "underscore";
      double $validToo = 5.6;
      ```

    - **Invalid Identifiers**:
      An identifier cannot start with a number, cannot contain spaces, and cannot be a reserved keyword. Special characters other than underscore (\_) and dollar sign ($) are also not allowed.
      ```java
      int 123invalid;  // starts with a number
      String class;    // 'class' is a reserved keyword in Java
      double my#var;   // contains a special character #
      ```

5.  **Printing to the Console**: Use `System.out.println();`

    ```java
    String message = "Java is fun!";
    System.out.println(message);
    ```

6.  **Operators**: Remember the order of operations.

    Operator precedence determines the order in which operators are evaluated in expressions. For instance, multiplication and division have higher precedence than addition and subtraction. Without proper attention to precedence, expressions can yield unexpected results.

    ```java
    int result1 = 4 + 4 / 2;  // 6. We do division first: 4 / 2 then + 4.
    ```

7.  **Postfix and Prefix**: Difference between `x++` and `++x`. The former will use `x` and then increment, while the latter increments first.

    ```java
    int x = 5;
    System.out.println(x++); // 5
    ```

    ```java
    int x = 5;
    System.out.println(++x); // 6
    ```

8.  **Compound Assignment and Expression Evaluation**: Compound assignment operators in Java allow for a shorter notation when applying an operation and subsequently assigning the result to the variable.

    - **Example**:

      ```java
      int y = 7;
      y *= 3 + 4;  // Equivalent to: y = y * (3 + 4);
      ```

      Here, the operation on the right (`3 + 4`) is evaluated first, which results in `7`. Then, the multiplication operation (`y * 7`) is executed, which gives `49`, and this value is then assigned to `y`.

    - **Outcome**:
      After executing the code, the value of `y` will be `49`.

9.  **String Comparison**:

    - `==` checks if two strings are the same object.
    - `.equals()` checks if two strings have the same value.
    - `.equalsIgnoreCase()` does the same but is case-insensitive.

    ```java
    String s1 = "Hello";
    String s2 = "hello";
    boolean isEqual1 = s1.equals(s2);  // false
    boolean isEqual2 = s1.equalsIgnoreCase(s2);  // true
    ```

10. **Arrays**: One-dimensional arrays look like `int[] arr = {1, 2, 3, 4};`. They use curly braces `{}` for initialization.

    ```java
    int[] arr = {1, 2, 3, 4};
    ```

11. **For-each Loop**: This is a concise way to loop through arrays or collections.

    ```java
    for (Type var : array) {
        // code here
    }
    ```

    Real example:

    ```java

    String[] fruits = {"apple", "banana", "cherry"};
    for (String fruit : fruits) {
    System.out.println(fruit);
    }
    ```

12. **Comparison Operators**: `==`, `!=`, `<`, `<=`, `>`, `>=`. Note: `=>` is NOT valid.

13. **Conditional Statements**: `if-else` statements can have multiple conditions but only one `else` block.

    ```java
    int score = 85;
    if (score > 90) {
        System.out.println("A grade");
    } else if (score > 75) {
        System.out.println("B grade");
    } else {
        System.out.println("C grade");
    }
    ```

14. **Loop Types**:

    - `for`: Standard loop.
    - `while`: Executes as long as the condition is true.
    - `do-while`: Executes at least once and then checks the condition.

    ```java
    for (int j = 0; j < 3; j++) {
        System.out.println("For loop: " + j);
    }

    int k = 0;
    while (k < 3) {
        System.out.println("While loop: " + k);
        k++;
    }

    int m = 0;
    do {
        System.out.println("Do-while loop: " + m);
        m++;
    } while (m < 3);
    ```

15. **Break**: Used to exit out of loops early.

    ```java
    for (int n = 0; n < 5; n++) {
        if (n == 3) {
            break;
        }
        System.out.println("Number: " + n);
    }
    ```

16. **String Operations**:

    - Concatenation: `"Hello" + " World" = "Hello World"`.
    - Substring: `s.substring(start, end)`. End index is exclusive.
    - Case-insensitive Comparison: Use `.equalsIgnoreCase()`.

    ```java
    String greet = "Hello";
    String who = "World";
    System.out.println(greet + " " + who);  // "Hello World"

    String txt = "Hello, World!";
    System.out.println(txt.substring(7, 12));  // "World"

    String s3 = "HELLO";
    String s4 = "hello";
    boolean isSameCaseInsensitive = s3.equalsIgnoreCase(s4);  // true
    ```

17. **Java Virtual Machine (JVM)**

    The Java Virtual Machine (JVM) is a virtual machine that enables a computer to run Java programs as well as programs written in other languages that are also compiled to Java bytecode. The JVM is responsible for loading code, verifying code, executing code, and providing the runtime environment.

18. **Constructors**

    Constructors in Java are special methods used to initialize objects. The constructor is called when an object of a class is created. It can be used to set initial values for object attributes:

    ```java
    public class MyClass {
        int x;

        // Constructor
        public MyClass(int y) {
            x = y;
        }
    }
    ```

19. **Creating an Empty Array**

    To create an empty array in Java, you define the array with a specified size (number of elements it can hold), but without initializing the elements:

    ```java
    int[] myArray = new int[10]; // An empty array of integers with a capacity of 10 elements
    ```

20. **The "this" Keyword**

    In Java, `this` is a reference variable that refers to the current object. It is used to access class variables and methods. It is also used in constructors and setters to distinguish between instance variables and parameters with the same names.

21. **The "-=" Operator**

    The `-=` operator is used to subtract a right-hand operand from a left-hand operand and then assign the result to the left operand. For example:

    ```java
    int i = 10;
    i -= 2;  // i is now 8
    ```

22. **Switch Statement**

    A switch statement allows a variable to be tested for equality against a list of values. Each value is called a case, and the variable being switched on is checked for each switch case.

    ```java
    switch(expression) {
        case x:
            // code block
            break;
        case y:
            // code block
            break;
        default:
            // code block
    }
    ```

23. **The "continue" Keyword in Loops**

    The `continue` keyword skips the current iteration of a loop and proceeds to the next iteration. This is useful if you want to skip specific conditions within your loop.

    ```java
    for (int i = 0; i < 5; i++) {
        if (i == 2) continue;
        System.out.print(i + " "); // Outputs: 0 1 3 4
    }
    ```

24. **Iterating Over Arrays with Loops**

    All types of loops—`for`, `while`, and `do-while`—can be used to iterate over elements of an array in Java. This allows you to perform operations on array elements regardless of the loop type used.

    ```java
    int[] array = {1, 2, 3, 4, 5};
    for (int num : array) {
        System.out.println(num);
    }
    ```

25. **Difference Between "=" and "=="**

    - `=` is the assignment operator, used to assign the value on its right to the variable on its left.
    - `==` is the equality operator, used to test if two variables are equal in value.

26. **`==` and `new String`**

    When comparing strings in Java, `==` checks for reference equality (whether they refer to the same object), while `.equals()` checks for value equality (whether the contents are the same). Using `new String` creates a new object in memory, so `==` will return `false` when comparing strings created with `new String`, even if they contain the same characters.
