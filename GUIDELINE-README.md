>### Drawable Shape Naming:

- For solid color rounded rectangle shape use:
  - rounded_primary_color_10dp_radius
  - rounded_primary_color_tr10dp_radius
  
###### instruction
1. tr = top-right
2. tl = top-left
3. br = bottom-right
4. bl = bottom-left

---
- For solid circle shape use:
  - circular_primary_color
---
- For dash line shape use:
  - dashed_hline_white_color_1dp
  - dashed_rounded_hline_white_color_1dp
  - dashed_vline_white_color_1dp
  - dashed_rounded_10dp_vline_white_color_1dp

###### instruction
1. hline = horizontal line
2. vline = vertical line
3. _dp = line thickness
---

- For solid and transparent color rounded stroke corner rectangle shape use:
    - rounded_primary_stroke_black_color_10dp_radius
    - rectangle_stroke_black_color_10dp_radius
      -Note: for transparent color/no solid color
    - circle_primary_stroke_black_color_10dp_radius 
     -Note: oval/circle shape
---

- For selector shape use:
    - home_icon_state_selector
      - Note: all icon selector
    - radio_button_thumb_state_selector 
      - Note: view group selector
    - bg_state_selector_rounded_15_color_white_black 
      - info: rounded solid background shape, white is default color and black is pressed/active color
    - bg_state_selector_stroke_15_color_white_black
      - Note: rounded solid color with stroke background shape, white is default color and black is pressed/active color
    - bg_state_selector_rounded_stroke_15_color_white_black
    - bg_state_selector_circle_color_white_black
    - bg_state_selector_rounded_15_color_white_black
    - text_state_selector_color_white_black
      - Note: text sate selector, white is default color and black is pressed/active color
---
>### Drawable Shape Naming:
- Use "ic_" for icons.
  -Example: ic_home
- Use "banner_" for banners.
  - Example: banner_promotion
- Use "logo" for logos.
  - Example: logo_company
- Use "img_" or "image_" for general images.
  - Example: img_product

---
>### String Naming:
- Use "action_" for action-related strings (e.g., button labels).
  - Example: action_login, action_confirm_delete
- Error Messages: Make error messages descriptive and include the error type.
  - Example: error_invalid_email, error_password_too_short
- Hints: Use "hint" to indicate hint text for input fields.
  - Example: hint_username, hint_password
- Labels and Headings: Use "label" for labels and headings.
  - Example: label_settings, label_account_details
- Dialogs: Include "dialog" in the name for strings related to dialogs.
  - Example: dialog_confirmation_message
- Menus: Use "menu" to indicate menu item labels.
  - Example: menu_item_settings, menu_item_logout
- Shared Text: If you have the same text that serves as both a label and a button text, you can create a naming convention that works for both cases.
  - Example: shared_welcome_message
- Semicolon: Use "semicolon" in the label name if it includes a semicolon.
  - Example: label_settings_semicolon
- Placeholder: Use a descriptive name for placeholders.
  - Example: placeholder_discount_offer, placeholder_bd_currency

---
>### Class/File naming
1. Use Descriptive Names:
   - Choose class names that clearly describe the purpose or responsibility of the class.
   - Avoid vague or generic names.
```kotlin
// Not clear:
class Data
// Clear and descriptive:
class UserData
```
2.Use Nouns or Noun Phrases:
 - Class names should represent objects or entities, so use nouns or noun phrases for naming.
```kotlin
// Good:
class Customer
class OrderManager

// Avoid:
class Manage
```
3. Use CamelCase or PascalCase:
- Follow the naming convention of the programming language you're using.
```kotlin
// Good:
class UserManager
class ShoppingCartItem

// Avoid:
class user_manager
class shopping_cart_item
```

4. Avoid Abbreviations (When Possible):
 - While shortening names may seem convenient, it can reduce readability.
 - Use full, meaningful words instead of abbreviations.
```kotlin
// Good:
// Good:
class Employee
class ProductCategory

// Avoid:
class Emp
class ProdCat
```
5. Be Consistent:
   - Follow consistent naming patterns throughout your codebase.
   - If you use a specific naming style for a certain type of class (e.g., controllers, services), stick to it.
```kotlin
// Consistent naming pattern:
class OrderService
class OrderRepository

// Inconsistent naming pattern:
class OrderManagementService
class OrdersRepo
```
6. Use Singular Nouns for Most Classes:
   - In general, use singular nouns for class names to represent a single instance of an entity.
```kotlin
// Good:
class Customer
class Product

// Avoid:
class Customers
class Products
```
7. Use Plural Nouns for Collection Classes:
   - If a class represents a collection or group of entities, use a plural noun.
```kotlin
// Good:
class Customers
class Products

// Avoid:
class CustomerCollection
class ProductGroup
```
8. Avoid Class Names with Too Many Responsibilities:
   - Follow the Single Responsibility Principle (SRP) and ensure that a class has a single, well-defined responsibility.
   - If a class name becomes too long or contains multiple responsibilities, consider refactoring it.
```kotlin
// Good:
class OrderValidator
class OrderProcessor

// Avoid:
class OrderValidationAndProcessingManager
```

9. Use Domain-Specific Language (DSL) Terminology:
   - If your application deals with specific domain concepts, use terminology from that domain in class names to improve understanding.
```kotlin
// Using domain-specific terminology:
class RentalReservation
class RentalTripHistory

// Avoid generic names:
class Reservation
class History
```

>### Variable naming
1. Use Descriptive Names:
   - Choose variable names that clearly describe the purpose or content of the variable.
   - Avoid single-letter or ambiguous names.

```kotlin
// Not clear:
val x = 10

// Clear and descriptive:
val numberOfUsers = 10
```
2. Follow Camel Case:
   - Use camelCase for variable names in Kotlin.
   - Start with a lowercase letter and capitalize the first letter of each subsequent word.

```kotlin
// Good:
val userName = "Kamrul"
val itemCount = 5

// Avoid:
val UserName = "Kamrul"
val item_count = 5
```

3. Use Meaningful Words:
   - Use meaningful words and avoid abbreviations or cryptic names.
   - Prioritize readability over brevity.
```kotlin
// Good:
val totalPrice = 100.0
val userProfile = getUserProfile()

// Avoid:
val tPrice = 100.0
val uProf = getUserProfile()
```
4. Avoid Hungarian Notation:
   - Avoid prefixes that indicate the data type of the variable (e.g., strName, intCount).
   - Kotlin's type inference system makes this unnecessary.
```kotlin
// Good:
val name = "Kamrul"
val count = 5

// Avoid:
val strName = "Kamrul"
val intCount = 5
```
5. Be Consistent:
   - Follow consistent naming patterns throughout your codebase.
   - If you use a specific naming style for a certain type of variable (e.g., constants, properties), stick to it.
```kotlin
// Consistent naming pattern:
val maxItemCount = 100
val userName = "Kamrul"
val totalPrice = calculateTotalPrice()

// Inconsistent naming pattern:
val MaxItemCount = 100
val UserName = "Kamrul"
val calcTotalPrice = calculateTotalPrice()
```
6. Use Domain-Specific Language (DSL) Terminology:
   - If your application deals with specific domain concepts, use terminology from that domain in variable names to improve understanding.
```kotlin
// Using domain-specific terminology:
val rentalReservation = getRentalReservation()
val rentalTripHistory = getRentalTripHisotry()

// Avoid generic names:
val reservation = getReservation()
val history = getHistory()

```

>### Function Naming Clean Code Instructions
1. Use Descriptive Names:
   - Choose function names that clearly describe the purpose or action performed by the function.
   - Avoid vague or generic names.
```kotlin
// Not clear:
fun process()

// Clear and descriptive:
fun calculateTotalPrice()
```
2. Use Verb-Noun Format:
   - Function names should typically start with a verb that describes the action followed by a noun or noun phrase that represents the subject.
```kotlin
// Good:
fun createUser()
fun fetchUserData()

// Avoid:
fun user()
fun data()
```
3. Follow Camel Case:
   - Use camelCase for function names in Kotlin.
   - Start with a lowercase letter and capitalize the first letter of each subsequent word.
```kotlin
fun calculateTotalPrice()
fun getUserProfile()

// Avoid:
fun CalculateTotalPrice()
fun GetUserProfile()
```
4. Be Explicit:
   - Make function names explicit to avoid ambiguity.
   - Use complete words rather than abbreviations.
```kotlin
// Good:
fun computeAverage()
fun retrieveUserInformation()

// Avoid:
fun avg()
fun getUserInfo()
```
5. Avoid Overloading:
   - Avoid creating multiple functions with the same name but different parameters (overloading) unless it significantly enhances clarity.
```kotlin
// Good:
fun getUserById(userId: Int)
fun getUserByEmail(email: String)

// Avoid overloading if not necessary:
fun getUser(idOrEmail: String)
```
6. Use Domain-Specific Language (DSL) Terminology:
   - If your application deals with specific domain concepts, use terminology from that domain in function names to improve understanding.
```kotlin
// Using domain-specific terminology:
fun processPayment()

// Avoid generic names:
fun pay()
```

7. One Task One Function
   - the principle of "one task, one function" is a fundamental guideline in clean code development. Each function should have a clear and single responsibility, making your code easier to understand, test, and maintain.
```kotlin
// Bad: Multiple responsibilities in one function.
fun processOrderAndNotifyUser(order: Order) {
    // Process the order
    // Notify the user about the order
}

// Good: Separate functions for distinct tasks.
fun processOrder(order: Order) {
    // Process the order logic here
}

fun notifyUser(order: Order) {
    // Notify the user logic here
}
```
8. Examples:
   - Here are some examples of well-named functions in Kotlin based on the clean code instructions:
```kotlin

// Descriptive and follows verb-noun format:
fun createUser()
fun calculateTotalPrice()
fun fetchUserData()

// Clear and follows camelCase:
fun fetchUserProfile()
fun computeAverage()
fun getUserInformation()

// Explicit and avoids abbreviations:
fun processPayment()
fun fetchCustomerDetails()
fun calculateTaxAmount()

// Avoids overloading unless necessary:
fun getUserById(userId: Int)
fun getUserByEmail(email: String)

// Uses domain-specific terminology:
fun processOrderPayment()
fun updateCustomerSubscription()
```

>### GIT Commit Rules
1. Use Semantic Commit Messages:
   - Write commit messages that clearly describe the purpose and intent of the commit.
   - Follow a semantic commit message format to automate changelog generation.
```sql
feat: add user authentication
fix: resolve null pointer exception in user service
chore: update dependencies
docs: update README with usage instructions
```
2. Limit Commit Scope:
   - Include a scope in your commit message to indicate the specific component, module, or feature the commit relates to.
```sql
feat(auth): add user authentication
```

3. Keep Commit Messages Concise:

   - Limit the subject line of the commit message to 50-72 characters.
   - Use the body of the message to provide additional details if needed.

4. Reference Issue Numbers:
   - If the commit is related to an issue or task in your issue tracking system (e.g., GitHub issues), reference it in the commit message.
```sql
feat(auth): implement login functionality

Closes #123
```
5. Separate Subject from Body:
   - Separate the subject line from the body with a blank line.
   - Start the subject line with a capital letter and do not end it with a period.

```sql
feat(auth): implement login functionality

This commit adds the login functionality, including user authentication and token validation.
```
6. Use Imperative Mood:
   - Write commit messages in the imperative mood (e.g., "add," "fix," "update") to indicate what the commit does.
```sql
feat(auth): add login functionality
```

7. Keep Commits Atomic:
   - Make each commit address a single logical change or task.
   - Avoid combining unrelated changes in a single commit.

8. If your commit includes changes to Gradle build files, mention it explicitly in the commit message.
```sql
chore(build): update Gradle dependencies
```

>### Tips to write clean and maintainable code
1. Follow Coding Conventions:
   - Adhere to Kotlin's coding conventions, including naming conventions, formatting, and style guidelines. Consistency in coding style makes your code easier to read and understand.

2. Use Descriptive Variable and Function Names:
   - Choose meaningful and descriptive names for variables, functions, and classes. Avoid single-letter or cryptic names that can lead to confusion.
3. Keep Functions Short and Focused:
   - Follow the "one task, one function" principle. Each function should have a single, well-defined purpose. Shorter functions are easier to understand, test, and maintain.

4. Avoid Magic Numbers and Strings:
 - Replace magic numbers and strings with named constants or enum values. This makes your code more self-explanatory and easier to modify in the future.
5. Comments and Documentation:
   - Add comments to explain complex logic or provide context. Write clear and concise documentation for classes, functions, and APIs to aid other developers.
6. Use Kotlin's Type Inference:
   - Leverage Kotlin's type inference system to avoid redundant type declarations when declaring variables and function return types.
7. Null Safety:
   -Embrace Kotlin's null safety features, including nullable and non-nullable types, to prevent null pointer exceptions.
8. Immutable Data Whenever Possible:
   - Favor immutability by using val for variables whenever the value does not need to change. This reduces potential side effects and enhances code predictability.
9. Error Handling:
   - Implement proper error handling using try-catch blocks or Kotlin's runCatching function. Provide meaningful error messages to aid in debugging.
10. Unit Testing:
    - Write unit tests for your code to ensure its correctness and reliability. Use Kotlin testing frameworks like JUnit or Spek.
11. Use Functional Programming Concepts:
    - Explore functional programming concepts like lambda expressions, higher-order functions, and extension functions to write concise and expressive code.
12. Refactor Regularly:
    - Refactor your code when necessary to improve its structure and readability. Don't hesitate to split functions, extract variables, or rename elements for clarity.
13. Version Control and Git Best Practices:
    - Use version control systems like Git to track changes and collaborate with others. Follow Git best practices like committing frequently, writing meaningful commit messages, and branching strategy.
14. Code Reviews:
    - Engage in code reviews with your team to gain insights, share knowledge, and catch potential issues early.
15. Learn and Improve:
    - Continuously learn and stay updated with the latest Kotlin features and best practices. Attend workshops, read books, and follow Kotlin-related blogs and communities.

























