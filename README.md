# Lease Management System

A comprehensive lease management system built with Java and Spring Boot for handling rental agreements, property management, and tenant services.

## Project Overview

This Lease Management System is designed to streamline the process of managing rental properties, tenants, lease agreements, and related services. The system consists of two main modules:

1. **Admin Module** - Provides backend management functionalities for property owners and administrators
2. **App Module** - Offers mobile application features for tenants and potential renters

Key features include:
- Apartment and room management
- Tenant screening and management
- Lease agreement creation and tracking
- Appointment scheduling for property viewing
- Payment processing and financial tracking
- Image and document management
- User access control and permissions

## Technical Requirements

### Database
- **MySQL 8.0+** 
- Recommended version: 8.0.28 or higher

### Java Environment
- **JDK 17**
- Spring Boot 3.0.5

### Middleware & Frameworks
- **Spring Boot 3.0.5**
- **Spring Security**
- **MyBatis Plus 3.5.3.1**
- **Redis** (for caching and session management)
- **MinIO** (for object storage)
- **Aliyun SMS** (for sending text messages)

### Build Tools
- **Maven 3.6+**

### Application Modules

#### Web Admin (`web-admin`)
Backend administration system with RESTful APIs for managing:
- Apartment information
- Room details
- Lease agreements
- User appointments
- System configurations

#### Web App (`web-app`)
Mobile application APIs for:
- Property browsing
- Room searching
- Appointment scheduling
- Lease signing
- Payment processing

## Project Structure

```
lease/
├── common/              # Shared utilities and configurations
├── model/               # Data models and entities
├── web/
│   ├── web-admin/       # Administration module
│   └── web-app/         # Mobile application module
└── pom.xml             # Parent Maven configuration
```

## Key Components

### Common Module
Contains shared utilities including:
- Exception handling
- JWT authentication utilities
- MinIO configuration
- MyBatis Plus configuration
- Redis configuration
- SMS service integration (Aliyun)
- Result wrappers for API responses

### Model Module
Defines all data entities including:
- Apartment and room information
- User and tenant details
- Lease agreements
- Payment types and terms
- Geographic information (province, city, district)
- Images and file attachments

### Web Modules
Both web modules follow the standard MVC pattern:
- Controllers for handling HTTP requests
- Services for business logic implementation
- Mappers for database operations
- VO (View Object) classes for API response formatting

## Getting Started

1. Clone the repository
2. Set up MySQL 8.0+ database
3. Configure Redis server
4. Set up MinIO for object storage
5. Update application.yml with your environment settings
6. Install dependencies using Maven
7. Run the application

## Configuration

Key configuration files can be found in each module's `src/main/resources` directory:
- `application.yml` - Main configuration file
- Database, Redis, and MinIO connection settings
- Aliyun SMS service credentials

## API Documentation

The project uses Knife4j (OpenAPI 3) for API documentation:
- Admin module: http://localhost:8080/doc.html
- App module: http://localhost:8081/doc.html

## Contributing

Contributions are welcome! Please feel free to submit issues or pull requests.

## License

This project is licensed under the MIT License.