## Client Side MVC and Spring 3 Rest Together

This example is intended to demonstrate things in two ares, the idea is to have clear separation between client side and server side
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
*  Refer [this][proxySupportId] if you want proxy support


## Configuration

UI Files(static html, css, javascript etc) resides in folder src/main/ui, basically this is yeaoman scaffolding code
after a build the resulting files would go to directory src/main/webapp/static, which is mapped as static resource in spring mvc


```xml
 <mvc:resources order="0" mapping="/static/**" location="/static/, classpath:/META-INF/web-resources/" cache-period="31556926"/>

```

### UI Build
```bash
1.  Go to root of the project 
2.  npm install
3.  bower install
4.  grunt build

```
you can even do `grunt serve`

### MVC Build

Modify srcipt/style refrences of  src/main/webapp/static/index.html file suce that static is appeded to path 

Ideally I am expecting a [grunt plugin][pluginId] to do this, untill unless the plugin is ready we have to do that manually

for example, modify 
```javascript
<script src="scripts/535d1513.scripts.js"></script>
```
as 

```javascript
<script src="static/scripts/535d1513.scripts.js"></script>
```
Next run the jetty server

```bash
mvn jetty:run
```


[pluginId]: http://stackoverflow.com/questions/19432595/grunt-change-path-to-all-files
[proxySupportId]: http://reachmnadeem.wordpress.com/2014/01/23/configuring-jetty-servlet-proxy/
