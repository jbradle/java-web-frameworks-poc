# java-web-frameworks-poc
The project brings together a series of ways for developing Java web applications and client application using Spring and React frameworks.

It will serve as the POC (Proof Of Concept) for my thesis in [University of Hradec Kralove](https://www.uhk.cz/cs-CZ/UHK).

## Main Frameworks

- [Spring](https://spring.io/) 4.2.5.RELEASE
- [Thymeleaf](http://www.thymeleaf.org/) 2.1.4.RELEASE
- [React](https://facebook.github.io/react/) 0.14.2
- [RefluxJS](https://github.com/reflux/refluxjs) 0.4.0

#### Build Tools

- [Maven](https://maven.apache.org/)
- [NodeJS](https://nodejs.org/en/)
- [Gulp](http://gulpjs.com/)
- [Webpack](https://webpack.github.io/)
- [Browser-sync](http://www.browsersync.io/)

## Modules Description

- **examples** - examples of used technologies (snipped in thesis)
- **spring-app-poc** - Spring application that holds "business" logic.
- **spring-web-poc** - POC of server side web application using Spring MVC with Thymeleaf template engine.
- **spring-react-flux-poc** - POC of client side application using React, Reflux, Spring REST API. App is served by Thymeleaf template engine.
- **template-poc** - HTML templates for POC projects

## All-in-one Installation

Make sure [node.js](https://nodejs.org) and [Maven](https://maven.apache.org/) are installed.

### 1. Install gulp globally:

```
$ npm install --global gulp
```


Following this step install dependencies for all modules. It is possible to install dependencies for each module alone.

### 1. In ROOT folder run:

```
$ install
```
