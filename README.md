# SIVANNSAN Foundation

A Java module providing basic Java library for general use cases

## Classes

+ Annotations
    - Nonnegative
    - Nonnull
+ Common
    - Check
    - Ensure
    - Validate
+ Security
    - Encryption
+ Utility
    - DateUtility
    - FileUtility

## Maven

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
```xml
<dependency>
    <groupId>com.github.sivannsan</groupId>
    <artifactId>foundation</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Examples

<details>
<summary>Index check</summary>

This will check if index `5` is available in the list `myList`

```java
if (Check.withinBounds(myList, 5)) {
    // do stuff    
}
```

</details>
<details>
<summary>Password encryption</summary>

The original string `MyPassword` will be encrypted using `SHA-256` algorithm

```java
String encryptedPassword = Encryption.encrypt("MyPassword", "SHA-256");
```

</details>
<details>
<summary>Date formatting</summary>

This will format the input `new Date()` into the following pattern `yyyy/MM/dd HH:mm:ss` <br>
You even can make a reverse operation by parsing using `DateUtility#parse` method <br>
You can specify `TimeZone` more if you intend not to use the default one

```java
String formattedDate = DateUtility.format(new Date(), "yyyy/MM/dd HH:mm:ss");
```

</details>
