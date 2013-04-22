#WebCrawler
This is a small Iterable which has the ability to crawl Websites and output all the links found.
For the HTTP communication it uses [HttpUnit](http://httpunit.sourceforge.net/) by Russel Gold.
This project was developed as a little school project to show how the Java `Iterator` works.

**NOTE: This project uses [Maven](http://maven.apache.org/) as Build-Management-Tool, so import it as Maven project using [Eclipse](www.eclipse.org) or [IntelliJ Idea](http://www.jetbrains.com/idea)**

#Usage
A working demo is available in the source, called `App.java`.

Import at least
```java
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebLink;
```
and all the different Exceptions you need to use.
Then just create a new WebCrawler object with two parameters, the full URL String and the depth it should crawl
```java
WebCrawler exampleCrawler = new WebCrawler("www.example.com",4);
```
Then you can use the iterator to get a whole bunch of links(every single one that is not `javascript` made).
```java
for(WebLink link : exampleCrawler) {
	//do what you want...
}
```


