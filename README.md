<h3>Usage</h3>

```java
/*inside render loop somewhere*/

/* the Time.getTime() method takes 1 parameter--the time scale. For example, 
if you want 3 seconds real world time to equal 1 minute (60 seconds) of game time, 
you would enter a scale of 20. To determine what scale to use, simply use the
equation int scale = gameTime/realWorldTime; Note that the scale must be an int, so
anything after the decimal will be dropped. A scale of 1 means that the game time will
equal the real world time.*/
Time time = Time.getTime(20);
Color tint = time.getTint();

/*set the tint of your sprites. This process will vary between frameworks.*/
```
