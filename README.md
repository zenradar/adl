Another Digital Library
=======================

A simple web application to demonstrate the following technologies:

| Framework | URL |
|----|----|
|Maven | https://maven.apache.org |
|Spring MVC | https://spring.io |
| H2 | http://www.h2database.com |
| JDBI | http://jdbi.org |
| FreeMarker | http://freemarker.org |
| Bootstrap | http://getbootstrap.com |
| JQuery | https://jquery.com |
| JUnit | http://junit.org |
| Jetty | https://eclipse.org/jetty |

To keep things interesting we are using the [org.mortbay jetty maven plugin](https://mvnrepository.com/artifact/org.mortbay.jetty/jetty)
rather than the Eclipse Jetty plugin.


Getting Started
---------------

1. **Clone from GitHub**

    ```sh
    $ git clone https://github.com/zenradar/adl.git
	```

2. Change directory to `adl`

    ```sh
    $ cd adl
	```

3. Run from Maven

    ```sh
	$ mvn jetty:run
	```

	or if port 8080 is occupied, tell `jetty` to use another port

	```sh
    $ mvn -Djetty.port=8765 jetty:run
	```

4. Open in your favourite browser
go to http://localhost:8080/digital-library

5. Have a look around, shouldn't take too long!

6. When you're done, hit `Ctrl-C` to terminate Jetty



Other Options
-------------

### Unit Tests

You can check the health of the project anytime by running the unit tests from the command line

```sh
$ mvn test
```
Unit testing database tables are created and seeded at start-up  using these scripts:
```
src/test/resources/db/sql/create-test-db.sql
src/test/resources/db/sql/seed-test-data.sql
```

Project database tables are created and seeded at start-up using these scripts:
```
src/main/resources/db/sql/create-db.sql
src/main/resources/db/sql/seed-data.sql
```



### Logging

A log is written to `log/digital-library.log`.

The verbosity of the log can be set in `src/main/resources/log4j.properties`.

### Javadoc

API documentation is located in the `doc` folder of the project.


----
You may also be interested in checking out my [wpm1](https://github.com/zenradar/wpm1) project.

----
