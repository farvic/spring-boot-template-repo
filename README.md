<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->

<!-- PROJECT LOGO -->
<!-- <br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">

  </a>

  <h3 align="center">Best-README-Template</h3>

  <p align="center">
    An awesome README template to jumpstart your projects!
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template">View Demo</a>
    ·
    <a href="https://github.com/othneildrew/Best-README-Template/issues">Report Bug</a>
    ·
    <a href="https://github.com/othneildrew/Best-README-Template/issues">Request Feature</a>
  </p>
</div> -->
[![LinkedIn][linkedin-shield]][linkedin-url]
[![GitHub Workflow Status (with branch)](https://img.shields.io/github/actions/workflow/status/farvic/spring-boot-template-repo/build_test_action.yml?branch=main&label=tests&logo=github&style=for-the-badge)](https://github.com/farvic/spring-boot-template-repo/actions/workflows/build_test_action.yml)

# Spring-Boot REST API Template

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
    </li>
    <li>
        <a href="#built-with">Built With</a>
    </li>
    <li>
        <a href="#topics-covered-in-this-template">Topics covered in this template</a>
    <li>
        <a href="#getting-started">Getting Started</a>
    </li>
    <li>
        <a href="#roadmap">Roadmap</a>
    </li>
    <li>
        <a href="#contact">Contact</a>
    </li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->
## About The Project

This is a template for a REST API using Spring Boot. It was created to be used as a base for future projects.

## Built With

* [Spring Boot 3.0.2](https://start.spring.io) and [Java 17](https://www.java.com/download/)
* [Maven 3.8.6](https://maven.apache.org/download.cgi)

## Topics covered in this template

* REST API
* Domain-Driven Design
* Tests with JUnit Jupiter, MockMvc and Mockito
* Databases with H2 embedded database
* Custom Exception Handling
* Swagger UI API

<!-- GETTING STARTED -->
## Getting Started

1. . Clone the repo

   ```sh
   Fork or clone the repo: https://github.com/farvic/cinema-room-spring.git
   ```

2. Run using Maven or your IDE

   ```bash
   mvn spring-boot:run
   ```

3. In order to run the tests

   ```bash
   mvn test
   ```

4. Some relevant lines from the application.properties

   ```properties
    # localhost:8080/
    port=8080


    # localhost:8080/swagger-ui/index.html

    springdoc.swagger-ui.path=/swagger-ui.html
    springdoc.api-docs.path=/v3/api-docs
    sprindoc.swagger-ui.config-url=/v3/api-docs/swagger-config
    springdoc.swagger-ui.url=/v3/api-docs


    # H2 Database name - in memory database
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.h2.console.enabled=true

    # localhost:8080/h2-console
    spring.h2.console.path=/h2-console

    spring.datasource.driverClassName=org.h2.Driver

    # authentication to access the database console
    spring.datasource.username=sa
    spring.datasource.password=
   ```

5. An API documentation can be accessed through [localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) once the program is running

<!-- ROADMAP -->
## Roadmap

* [x] Create a basic REST API
* [x] Add a database support
* [x] Add a Swagger UI API documentation
* [x] Add tests for the controllers, services and repositories
* [ ] Add a security layer
* [ ] Add remote database support
* [ ] Add a Dockerfile for the application
* [ ] And more...?

[//]: # (CONTRIBUTING)

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- CONTACT -->
## Contact

If you want to talk about the project, feel free to contact me through one of my socials.

Victor Fonseca -  [@Linkedin](https://www.linkedin.com/in/victorfa)

Project Link: [https://github.com/farvic/cinema-room-spring](https://github.com/your_username/repo_name)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-blue.svg?style=for-the-badge
[linkedin-url]: https://linkedin.com/in/victorfa
