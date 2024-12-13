package com.anirudh.spring_expense_tracker;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Expense Tracker API Documentation",
                description = "CRUD APIs for Expense tracker",
                version = "1.0",
                license = @License(
                        name = "Axoid",
                        url = "www.axoid.com"
                ),
                contact = @Contact(
                        name = "Anirudh Sharma",
                        email = "anirudhsharma1596@gmail.com"
                )

        )
)
@SpringBootApplication
public class SpringExpenseTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringExpenseTrackerApplication.class, args);
    }

}
