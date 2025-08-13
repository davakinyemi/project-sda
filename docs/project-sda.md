## Smart Document Assistant (SDA)
#### A lightweight, enterprise-focused microservices application that showcases Spring AI, LLM capabilities, and MCP integration in a realistic business context.

**Core Application Concept** - A document management system that uses AI to analyze, summarize, and answer questions about uploaded documents, demonstrating how AI can enhance enterprise workflows.

### Architecture (Microservices, mono-repo)
	1. Document Service (Spring Boot + PostgreSQL)
		- File upload/storage management
		- Document metadata and versioning
		- RESTful APIs for document operations
	2. AI Analysis Service (Spring Boot + Spring AI)
		- Document content extraction and analysis
		- AI-powered summarization using LLM
		- Natural language querying capabilities
	3. MCP Integration Service (Spring Boot + Spring AI MCP)
		- Custom MCP server exposing document tools
		- Integration with external knowledge sources
		- Tool registration and discovery
	4. API Gateway (Spring Cloud Gateway)
		- Request routing and load balancing
		- Basic authentication and rate limiting
		- Cross-cutting concerns handling

### Database Strategy
    - PostgreSQL: Primary document metadata, user data, and structured information
    - MongoDB: AI analysis results, conversation history, and document embeddings

### Frontend
    - Angular 18: Clean, modern SPA with document upload, chat interface, and dashboard views

### Enterprise Use Cases
	1. Document Summarization: Upload contracts, reports, or proposals and get AI-generated summaries
	2. Q&A System: Ask natural language questions about document contents
	3. Content Analysis: Extract key information, entities, and insights from documents
	4. Knowledge Base Integration: Connect documents with external knowledge sources via MCP 

### Deployment
	1. Local Development: Docker Compose for all services
	2. Deployment: Kubernetes
	3. Documentation: Comprehensive README with setup instructions

### Success Metrics
	- Functionality: Document upload, AI analysis, and Q&A working end-to-end
	- Architecture: Proper microservices separation and communication
	- Code Quality: Clean, minimal (only what is absolutely required and necessary), well-documented code with basic testing
	- User Experience: Clean, minimal, intuitive Angular interface with responsive design
	- AI Integration: Meaningful AI capabilities that demonstrate business value