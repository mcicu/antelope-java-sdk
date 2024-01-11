## Antelope libraries for JAVA SDK

### First version of the antelope libraries were released into maven central:

```xml
<!-- antelope libraries -->
<dependency>
  <groupId>io.github.mcicu</groupId>
  <artifactId>antelope-java-sdk</artifactId>
  <version>0.0.1</version>
</dependency>

<dependency>
  <groupId>io.github.mcicu</groupId>
  <artifactId>antelope-java-softkey-signature-provider</artifactId>
  <version>0.0.1</version>
</dependency>

<dependency>
  <groupId>io.github.mcicu</groupId>
  <artifactId>antelope-java-rpc-provider</artifactId>
  <version>0.0.1</version>
</dependency>

<!-- make sure to use the proper abieos-serialization-provider library for your platform -->
<!-- currently available platforms: linux, darwin; (windows is not supported so far)-->
<dependency>
  <groupId>io.github.mcicu</groupId>
  <artifactId>antelope-java-abieos-serialization-provider-linux</artifactId>
  <version>0.0.1</version>
</dependency>

```

### Demo project integrating the Antelope Java SDK is available at:

https://github.com/mcicu/antelope-java-sdk-demo