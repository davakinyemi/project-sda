## ChatClient vs ChatModel
- ChatClient: Fluent API for developers (what I use in controllers)
- ChatModel: Lower-level interface (Spring AI uses internally)
- ChatClient.Builder: Injected by Spring Boot, used to create ChatClient instances