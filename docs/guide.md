# Practical Learning Guideline (Project-SDA): 4-Week Preparation Plan

**Target:** Build the skills to understand how to create a project like Project-SDA (Smart Document Assistant)

**Audience:** Java/Spring Boot Developers with no prior AI development experience

---

## Week 1: LLMs, Prompt Engineering, & Spring AI Basics

### Day 1: What Are LLMs & Where Are They Used?
**Tasks:**
- **1:** Read an introductory guide to Large Language Models (LLMs): understand text generation, question-answering, summarization
- **2:** Search for the top LLMs in use (OpenAI, Anthropic, Google Gemini) - research their capabilities and pricing
- **3:** Explore simple demos using ChatGPT/Claude - type a question, observe results, experiment with different question types
- **4:** Document your findings: create a comparison table of different LLMs and their use cases

**Deliverable:** Notes document comparing LLM providers and their capabilities

---

### Day 2: Prompt Engineering Fundamentals
**Tasks:**
- **1:** Learn prompt basics: direct/hinting, chain-of-thought, step-by-step tasks
- **2:** Experiment with prompt variations in online playgrounds (OpenAI Playground, Hugging Face)
- **3:** Write and save 5 example prompts for document summarization and Q&A
- **4:** Test your prompts with different document types (technical docs, reports, emails)

**Deliverable:** Collection of 5 tested prompts with documentation of their effectiveness

---

### Day 3: Your First Spring Boot AI Setup
**Tasks:**
- **1:** Follow a guide to set up a Spring Boot project (use start.spring.io)
- **2:** Add "Spring AI" library dependencies to your project
- **3:** Configure your application to connect to an AI Provider like OpenAI by inputting an API key in your application.properties (or application.yml) file
- **4:** Run a "Hello AI" endpoint that sends a prompt to LLM and returns the result, test via browser/Postman

**Deliverable:** Working Spring Boot application with AI integration

---

### Day 4: Basic Microservice & REST API Creation
**Tasks:**
- **1:** Build a simple document upload REST endpoint with Spring Boot (store file to local disk or cloud storage)
- **2:** Add metadata fields (filename, date uploaded, file size)