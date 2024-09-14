package geeksforgeeks.week4;
//
//@Configuration
//public class CreateConnection {
//
//    @Bean
//    public Connection createConnection() {
//        // some logic to create a connection object
//        return new Connection ();
//    }
//
//}
//
//class Connection {}

/*
You can a create a bean with @Component in Spring.
This makes it a Spring managed bean.

@Service, @Repository, @Controller, @RestController:
Specialized types of @Components for different areas of application

@Configuration: Marks a class as a configuration class, which can be used
to define beans programmatically. Eg: DB Connection, AWS Connection

@Bean, which defines a bean inside a @Configuration class.
 */

/*
Bean Lifecycle
1. Instantiation -> Spring creates the bean instance.
2. Dependency Injection: Dependencies are injected
3. Post-initialization: Customised initialisation logic implementation
4. Ready for use: Used in a way planned.
5. Pre-Destruction: Customised cleanup logic (optional)
6. Destruction: The bean is destroyed when the application context is closed (for singleton beans).
 */

/* Bean Scope
1. Singleton
2. Prototype
// Eg:
    @Bean
    @Scope("prototype")
 */