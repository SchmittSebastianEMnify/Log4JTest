# Log4JTest

Small sample application to test different logging libraries for the newly found log4j vulnerability

to check if the exploid would work run wireshark and filter for `ip.addr==127.0.0.6` to see if it tries to establish a connection on logging the attackString


## Results

| Dependency                                                                                     | Vulnerable | Notes |
|------------------------------------------------------------------------------------------------|:----------:|-------|
| org.apache.logging.log4j:log4j-api:jar:2.15.0 & org.apache.logging.log4j:log4j-core:jar:2.15.0 | NO         |       |
| org.apache.logging.log4j:log4j-api:jar:2.14.1 & org.apache.logging.log4j:log4j-core:jar:2.14.1 | YES        |       |
| org.apache.logging.log4j:log4j-api:jar:2.0 & org.apache.logging.log4j:log4j-core:jar:2.0       | YES        |       |
| log4j:log4j:jar:1.2.17                                                                         | NO         |       |
| io.confluent:confluent-log4j:jar:1.2.17-cp4                                                    | YES        | includes dependency for log4j 2.10.0      |
| io.confluent:confluent-log4j:jar:1.2.17-cp3                                                    | YES        | includes dependency for log4j 2.10.0      |
| io.confluent:confluent-log4j:jar:1.2.17-cp2                                                    | NO         |       |
| io.confluent:confluent-log4j:jar:1.2.17-cp1                                                    | NO         |       |
| org.slf4j:log4j-over-slf4j:jar:1.7.32 & org.slf4j:slf4j-simple:jar:1.7.32                      | NO         |       |
| org.slf4j:log4j-over-slf4j:jar:1.7.25 & org.slf4j:slf4j-simple:jar:1.7.25                      | NO         |       |