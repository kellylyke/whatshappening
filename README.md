# what's happening
Demo: [https://www.youtube.com/watch?v=0Z3-zvNYDy0]

### Problem Statement:

We all know money plays a huge part in politics, especially these days, but it's hard to keep tabs
on. Our goal is to provide an easy way to search for politicians and see their top
donors, leaving you (the voters) to be the judge of its effects.

### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication with sha256
  * Admin role: Make sure nothing is broken and info is accurate, add/remove users if necessary
  * User role: Can add candidates to watch list for easy access
  * All: Can search for candidates and see top donors
* Database
  * MySQL
  * Store user accounts, roles, and watch list of candidates
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* CSS
  * Bootstrap
* Data Validation
  * Jquery/Javascript on front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * Materialize
  * Lombok
  * Sha256
* Project Lombok to eliminate boilerplate code like getters/setters/equals -- this sounds nice
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA

### [Project Plan](ProjectPlan.md)

### [Time Log](TimeLog.md)

### [User Stories](UserStories.md)

### [Design Plan](DesignDocuments/wireframes)


