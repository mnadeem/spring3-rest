# Client Side MVC and Spring 3 Rest

This example is intended to demonstrate things in two ares, this idea is to have clear separation between client side and server side
at the same time allow seam less integration between them

#### Client Side Technologies

*  Angular JS
*  Yeoman
*  Grunt
*  Bower


#### Sever Side Technologies

*  Spring3 Rest
*  Multiple representations support (JSON and XML)
*  Custom Exception Handling
*  Authentication with spring security
*  Authorization with jsr 250
*  Custom Aspect
*  Unit Testing
*  Codahale Metrics
*  Spring data JPA
*  Ehcache
*  Dozer

## Configuration

UI Files(static html, css, javascript etc) resides in folder src/main/ui, basically this is yeaoman scaffolding code
after a build the resulting files would go to directory src/main/webapp/static, which is mapped as static resource in spring mvc


```xml
 <mvc:resources order="0" mapping="/static/**" location="/static/, classpath:/META-INF/web-resources/" cache-period="31556926"/>

```

### UI Build
```bash
*  Go to root of the project 
*  npm install
*  bower install
*  grunt build

```
