# cps-legacy
Clicks Per Second, but its compatible with every version of java, starting from J2SE 1.2.  

### How it works
This program is essentially just a simple click speed calculator. It does this by creating a button, which on clicking increments the total number of clicks. To make the Click speed calculation real-time, another Thread is creating that refreshes every 1000 milliseconds, or 1 second.  
  
Unfortunately, IntelliJ idea does not support compiling for target J2SE 1.2, so I made most of this in Java 6, but I occasionally switched to J2SE 1.2 to make sure I wasn't using any new Api(s)  
  
__Note: The website links in the website currently work only on Mac OS, Linux and Windows. To use the links on linux, you need to have the `xdg-utils` package installed__

### Why J2SE 1.2?
Why not Java 1.1, or earlier? Well, Swing was originally introduced in J2SE 1.2, therefore I couldn't use any earlier version of Java. Also, J2SE 1.2 introduced too many amazing features to miss out on, which even led to Sun naming their next 3 versions of java after Java 2.

### License
[![Creative Commons License](https://i.creativecommons.org/l/by-nc/4.0/88x31.png)](http://creativecommons.org/licenses/by-nc/4.0/)  
This work is licensed under a [Creative Commons Attribution-NonCommercial 4.0 International License](http://creativecommons.org/licenses/by-nc/4.0/)

#### Check out the original project (archived) 
[https://github.com/BoogieMonster1O1/cpscalculator](https://github.com/BoogieMonster1O1/cpscalculator)
