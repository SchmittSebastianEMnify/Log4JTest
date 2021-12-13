# Log4JTest

Small sample application to test different logging libraries for the newly found log4j vulnerability

to check if the exploid would work run wireshark and filter for `ip.addr==127.0.0.6` to see if it tries to establish a connection on logging the attackString:

```sh
mvn compile exec:java -Dexec.mainClass=VulnerableLog4jExample
```

A remediation action is to disable log4j lookups. To verify this repeat the test with:

```sh
mvn compile exec:java -Dexec.mainClass=VulnerableLog4jExample -Dlog4j2.formatMsgNoLookups=true
```

## Results

| Dependency                                                                                     | Vulnerable | Notes |
|------------------------------------------------------------------------------------------------|:----------:|-------|
| org.apache.logging.log4j:log4j-api:jar:2.15.0 & org.apache.logging.log4j:log4j-core:jar:2.15.0 | NO         |       |
| org.apache.logging.log4j:log4j-api:jar:2.14.1 & org.apache.logging.log4j:log4j-core:jar:2.14.1 | YES        |       |
| org.apache.logging.log4j:log4j-api:jar:2.0 & org.apache.logging.log4j:log4j-core:jar:2.0       | YES        |       |
| log4j:log4j:jar:1.2.17                                                                         | NO         |       |
| io.confluent:confluent-log4j:jar:1.2.17-cp5                                                    | NO         | removed log4j from logredactor dependency |
| io.confluent:confluent-log4j:jar:1.2.17-cp4                                                    | YES        | includes dependency for log4j 2.10.0 as part of own dependency io.confluent:logredactor:jar:1.0.3     |
| io.confluent:confluent-log4j:jar:1.2.17-cp3                                                    | YES        | includes dependency for log4j 2.10.0 as part of own dependency io.confluent:logredactor:jar:1.0.1     |
| io.confluent:confluent-log4j:jar:1.2.17-cp2                                                    | NO         |       |
| io.confluent:confluent-log4j:jar:1.2.17-cp1                                                    | NO         |       |
| org.slf4j:log4j-over-slf4j:jar:1.7.32 & org.slf4j:slf4j-simple:jar:1.7.32                      | NO         |       |
| org.slf4j:log4j-over-slf4j:jar:1.7.25 & org.slf4j:slf4j-simple:jar:1.7.25                      | NO         |       |


### Dependency trees io.confluent:confluent-log4j:jar:1.2.17-cpX

#### io.confluent:confluent-log4j:jar:1.2.17-cp5
```
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building Log4JTest 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ Log4JTest ---
[INFO] org.example:Log4JTest:jar:1.0-SNAPSHOT
[INFO] \- io.confluent:confluent-log4j:jar:1.2.17-cp5:compile
[INFO]    \- io.confluent:logredactor:jar:1.0.7:compile
[INFO]       +- com.google.re2j:re2j:jar:1.6:compile
[INFO]       +- io.confluent:logredactor-metrics:jar:1.0.7:compile
[INFO]       \- com.eclipsesource.minimal-json:minimal-json:jar:0.9.5:compile
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.721 s
[INFO] Finished at: 2021-12-13T13:13:49+01:00
[INFO] Final Memory: 13M/475M
[INFO] ------------------------------------------------------------------------
```


#### io.confluent:confluent-log4j:jar:1.2.17-cp4
```
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building Log4JTest 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ Log4JTest ---
[INFO] org.example:Log4JTest:jar:1.0-SNAPSHOT
[INFO] \- io.confluent:confluent-log4j:jar:1.2.17-cp4:compile
[INFO]    \- io.confluent:logredactor:jar:1.0.3:compile
[INFO]       +- com.google.re2j:re2j:jar:1.6:compile
[INFO]       +- org.apache.logging.log4j:log4j-api:jar:2.10.0:compile
[INFO]       +- org.apache.logging.log4j:log4j-core:jar:2.10.0:compile
[INFO]       \- com.eclipsesource.minimal-json:minimal-json:jar:0.9.5:compile
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.225 s
[INFO] Finished at: 2021-12-10T15:35:22+01:00
[INFO] Final Memory: 16M/599M
[INFO] ------------------------------------------------------------------------
```

#### io.confluent:confluent-log4j:jar:1.2.17-cp3
```
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building Log4JTest 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ Log4JTest ---
[INFO] org.example:Log4JTest:jar:1.0-SNAPSHOT
[INFO] \- io.confluent:confluent-log4j:jar:1.2.17-cp3:compile
[INFO]    \- io.confluent:logredactor:jar:1.0.1:compile
[INFO]       +- com.google.re2j:re2j:jar:1.6:compile
[INFO]       +- org.apache.logging.log4j:log4j-api:jar:2.10.0:compile
[INFO]       +- org.apache.logging.log4j:log4j-core:jar:2.10.0:compile
[INFO]       \- com.fasterxml.jackson.core:jackson-databind:jar:2.12.3:compile
[INFO]          +- com.fasterxml.jackson.core:jackson-annotations:jar:2.12.3:compile
[INFO]          \- com.fasterxml.jackson.core:jackson-core:jar:2.12.3:compile
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.868 s
[INFO] Finished at: 2021-12-10T15:54:51+01:00
[INFO] Final Memory: 16M/599M
[INFO] ------------------------------------------------------------------------
```