# Average Calculator Application

This Spring Boot application demonstrates a simple average calculator microservice with basic security configuration. It fetches numbers from a test server based on different qualifiers (prime, fibonacci, even, random), maintains a sliding window of numbers, and calculates the average of numbers in the current window.

# Features

Fetch numbers from a test server (prime, fibonacci, even, random).
Maintain a sliding window of fetched numbers.
Calculate and display the average of numbers in the current window.
Basic security configuration with HTTP Basic Authentication.
Requirements

Java Development Kit (JDK) 11 or higher
Maven or Gradle (for building the project)
Postman (optional, for testing endpoints)

# Accessing endpoints:

Use a tool like Postman to send requests to endpoints such as:
- GET http://localhost:9876/numbers/e (Fetch even numbers)
- GET http://localhost:9876/numbers/p (Fetch prime numbers)
- GET http://localhost:9876/numbers/f (Fetch Fibonacci numbers)
- GET http://localhost:9876/numbers/r (Fetch random numbers)

This application uses basic security configuration to protect endpoints. Ensure that proper security measures are implemented based on your application's requirements before deploying to production.

# Technologies Used

- Java
- Spring Boot
- Maven / Gradle

# SCREENSHOT
<img width="1440" alt="Screenshot 2024-06-14 at 13 16 09" src="https://github.com/DHARANI2D/727721EUCS027/assets/99940501/c06f80cf-f21d-49fb-983a-7d103612f737">
