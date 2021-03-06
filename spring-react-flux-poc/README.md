# spring-react-flux-poc

POC of client side application using React, Reflux, Spring REST API.

This project contains sub module on path ./src/main/**webapp-client** which is root of client application. All .jsx source files are written in ES6.

## Main Frameworks

- [ReactJS](https://facebook.github.io/react/) - rendering content
- [RefluxJS](https://github.com/reflux/refluxjs) - data flow and actions management
- [SuperAgent](https://visionmedia.github.io/superagent/) - client side REST communication
- [Thymeleaf](http://www.thymeleaf.org/) - serves client application
- [Spring Web MVC](http://docs.spring.io/autorepo/docs/spring/4.2.x/spring-framework-reference/html/mvc.html) - used as REST API and for first load of application

#### Build Tools

- [NodeJS](https://nodejs.org/en/)
- [Gulp](http://gulpjs.com/)
- [Webpack](https://webpack.github.io/)
- [Browser-sync](http://www.browsersync.io/)
- [Babel](https://babeljs.io/)
- [Maven](https://maven.apache.org/)

## Build

Make sure [node.js](https://nodejs.org) and [Gulp](http://gulpjs.com/) are installed.

On path ./src/main/webapp-client
```
$ npm install
```

```
$ gulp buil --production
```

Make sure [Maven](https://maven.apache.org/) is installed.

```
$ mvn clean install
```

## Develop

### Run Server

```
$ mvn tomcat7:run
```

### Start Browser-sync and automatic builds

```
$ gulp
```
