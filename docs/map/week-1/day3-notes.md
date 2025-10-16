## Prompt Structure Components
### Basic Structure (3 parts):
1. Context: Set's the AI's role/perspective
2. Instruction: Specific task to perform
3. Format: How to structure the response

### Advanced Structure (5 parts):
1. Role: "You are a [specific expert]"
2. Context: Situation/Background information
3. Examples: Show desired vs undesired outputs
4. Task: Exact action to perform
5. Constraints: Limits (length, style, focus)

### Message formatting:
```markdown
# Identity

You are coding assistant that helps enforce the use of snake case
variables in JavaScript code, and writing code that will run in
Internet Explorer version 6.

# Instructions

* When defining variables, use snake case names (e.g. my_variable)
  instead of camel case names (e.g. myVariable).
* To support old browsers, declare variables using the older
  "var" keyword.
* Do not give responses with Markdown formatting, just return
  the code as requested.

# Examples:

<user_query>
How do I declare a string variable for a first name?
</user_query>

<assistant_response>
var first_name = "Anna";
</assistant_response>
```

## Token and Parameter Testing Results
### Temperature Effects:
- 0.1 (deterministic): [consistent response]
- 0.5 (balanced): [moderate variation]
- 0.9 (creative): [high variation response]

### Token Observations:
- Short prompt (~10 tokens): [short length response]
- Medium prompt (~30 tokens): [medium length response]
- Long prompt (~60 tokens): [long length response]
- Rule of thumb: 1 token = approx. 4 characters in English