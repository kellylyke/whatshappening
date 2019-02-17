# what's happening

#### Problem Statement:

Do you know how many votes went down in Congress today? Me neither.
So I googled it. On this particular day, there were <b>94</b>.

So, who chooses which of these 94 issues are important? Well... The news.

The problem is the news and you may have different ideas of
what is important. And sometimes, let's face it, there is just
so much news(and frankly other distractions always going on),
that we miss the actual gears that keep the country running.

The goal of this project is to have a manageable way for
constituents to search for relevant issues, keep tabs on
their congresspeople, get voter information, and
inspire the desire to hold our politicians accountable.

### Project Technologies/Techniques 

* Security/Authentication
  * Tomcat's JDBC Realm Authentication
  * Admin role: Make sure nothing is broken and info is accurate
  * User role: Can add favorite/least favorite issues/candidates for a custom feed
  * All: Can see latest votes
* Database
  * MySQL
  * Store user accounts and preferences
* ORM Framework
  * Hibernate 5
* Dependency Management
  * Maven
* Web Services consumed using Java
  * SoapUI
* CSS 
  * Bootstrap or Materialize
* Data Validation
  * Bootstrap Validator for front end
  * Explore Hibernate's validation
* Logging
  * Configurable logging using Log4J2. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Hosting
  * AWS
* Independent Research Topic/s
  * CI tools in AWS
  * Materialize
  * Hibernate Validation?
  * Hibernate Search?
  * Hoaxy API
* Project Lombok to eliminate boilerplate code like getters/setters/equals -- this sounds nice
* Unit Testing
  * JUnit tests to achieve 80%+ code coverage 
* IDE: IntelliJ IDEA

