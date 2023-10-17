>### "Common Module"
>##### Purpose:
> - The common module contains code and resources that are used across different parts of your application. It serves as a central repository for shared functionality, utilities, and constants.
> #### Contents:
> - **Utility Classes:** Common utilities such as date/time formatting, string manipulation, error handling, and more.
> - **Constants:** Constants like AppConstants, API endpoints, and other global values.
> - **Base Classes:** Abstract classes or base components that are extended or used by other modules.
> - **Resource Files:** Shared resources like strings, colors, dimensions, and drawables.
---
>### "UI Module"
>##### Purpose: 
> - The UI module is responsible for defining the user interface components and layouts used throughout the app. It encapsulates UI-related logic and can provide reusable UI components.
>##### Contents:
> - **Fragments**: UI fragments representing different screens or components in the app.
> - **Custom Views:** Reusable custom views or widgets that are used across multiple screens.
> - **Styles and Themes:** Custom styles and themes for consistent UI theming.
> - **Resource Files:** Layouts, drawables, animations, and other UI-related resources.

---

>### "Design System Module"
>##### Purpose
> - The design system module is a more specialized module focused on enforcing a consistent design language and user experience across the entire app. It defines design guidelines, components, and styles.
>##### Contents:
> - **UI Components:** Reusable UI components following the design system's guidelines, such as buttons, cards, typography components, etc.
> - **Styles and Themes:** Comprehensive styles and themes that adhere to the design system's visual language.
> - **Assets:** Any design-related assets, such as icons and images, adhering to the design system's guidelines.
> - **Documentation:** Guidelines and documentation explaining how to use the design system components and styles.
---
>### "Where we can put drawable icon,string,animation and other resources? In common, design system or UI module"
> ##### Common Module:
> - **Use Case:** Place drawable icons and images in the common module when they are truly generic and can be shared across different projects or modules.
> - **Example:** Very generic icons that are not tied to any specific UI or design language.
> - **Advantage:** Enables maximum code and resource reuse across multiple projects.
>##### UI Module:
> - **Use Case:** Place drawable icon,string,animation and other resources in the UI module when they are specific to the user interface of your app but are not part of a broader design system.
> - **Example:** Custom icons or images unique to a particular screen or feature.
> - **Advantage:** Keeps UI-related resources close to the UI code, making it easier to manage and maintain.
> ##### Design System Module:
> - **Use Case:** Place drawable icons icon,string,animation and other resources in the design system module when they are part of a broader design language and need to adhere to consistent guidelines throughout the app.
> - **Example:** Icons and images that follow specific design system guidelines and should be reused consistently across multiple screens or features.
> - **Advantage:** Ensures consistency in design language and UI components across the app.

--- 

>### "DI (Dependency Injection) Module"
> - **Purpose:** The DI module serves as the central place for configuring and managing the dependency injection framework of your choice (e.g., Dagger, Hilt, Koin). It provides a way to manage object creation and maintain a clear separation of concerns.
> - **Contents:** 
>  - Configuration files for setting up dependency injection.
>  - Modules that define how dependencies are provided.
>  - Component classes or annotations for injection points.
>  - Custom scopes if needed to manage the lifecycle of objects.

---
>### "Data Module"
> - **Purpose:** The Data module is responsible for handling data-related operations and acts as an intermediary between the domain layer and external data sources. It encapsulates the logic for data retrieval, storage, and transformation.
> - **Contents:**
>   - Data sources (e.g., database, network) and related client classes.
>   - Repository interfaces defining data access methods.
>   - Data models or entities that represent the data structures used by the app.
>   - Data mappers for converting between data models and domain models.
>   - Caching mechanisms, if applicable.

---
>### "Cache Module"
> - **Purpose:** The Cache module focuses on implementing caching mechanisms to improve data retrieval performance and reduce network requests. It works in conjunction with the Data module to provide efficient data storage and retrieval.
> - **Contents:**
>   - Cache implementations (e.g., in-memory cache, disk cache).
>   - Strategies for cache eviction, refreshing, or synchronization.
>   - Logic for managing cached data.

---

>### "Domain Module"
> - **Purpose:** The Domain module contains the core business logic and defines the use cases (interactors) that represent the high-level operations your app can perform. It should be independent of Android-specific APIs, ensuring that the business logic is portable and testable.
> - **Contents:** 
>   - Domain models or entities representing the core data structures and business entities.
>   - Use case classes that encapsulate specific business operations.
>   - Business logic and rules that govern how data is processed.
>   - Interfaces defining interactions with the data layer.

---

>### "API Response Module"
> - **Purpose:** The API Response module is responsible for handling API responses and mapping them to data models or entities. It ensures that data from external sources is properly processed and integrated into the app's data flow.
> - **Contents:**
>   - API response models representing the structure of responses.
>   - Mappers or converters for transforming API responses into domain models or entities.
>   - Parsing and error-handling logic specific to API interactions.

---

>### "Entity Module"
>  - **Purpose:** The Entity module may be used to define shared data models or entities that need to maintain consistency across different parts of the application. This module promotes reusability and consistency.
>  - **Contents:**
>    - Shared data models or entities that are used by multiple modules.
>    - Value objects representing common data structures.
>    - Interfaces or contracts for shared data structures.
