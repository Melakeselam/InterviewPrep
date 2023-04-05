# Microservice Concepts

## Definition
An architectural approach where a large monolithic application is broken down into smaller service based applications. 
The collection of services behave as one whole application, indistinguishable to the client. Microservices provide the following features to the application:
## Benifits
-  Loose coupling
-  Separation of Concern
-  Targeted scalability
-  Faster deployment to production
-  Smaller manageable code-base
-  Manageable development via different teams
-  Allow utilization of different tech-stack for different services
## Challenges
-  Service discovery
-  Security
-  Load balancing
-  Communication between component - network is slow
-  Orchestration - managing data flow
-  Monitoring - visibility of processes

## Spring Cloud
It is the building block for cloud and microservice. It provides a suite of solutions of which the primary ones include:
- ##### Service Discovery
  - ##### Eurika
    - Netflix Service discovery server. 
      - @EnableEurikaServer - provide service discovery
      - @EnableDiscoveryClient - makes a service discoverable by client.
- ##### Configuration Server
- ##### Monitoring
  - Zipkin and Sleuth
  - New Relic
  - Splunk
- ### Gateways
  - #### Zuul
    - gateway for communication from website to backend
    - features: 
      - dynamic routing, 
      - monitoring, 
      - resilliance, 
      - security
    - doesn't need to manage CORS
  - #### 

## Communication
-  ### RESTful
  - using Load balanced RestTemplate  
- ### Messaging
  - #### Kafka with Avro
    - #### Core API's
      - Producer API
      - Consumer API
      - Stream API
      - Connector API
    - #### Topic
      - name of message stream within a specific category
      - consists of streams and records
    - #### Record
      - individual message published to a stream
      - consists of key, value, timestamp
    - #### record retention policy
      - regardless of consumption, record is maintained for the configurable retention period
- ### Logging
  - #### Kafka
  - #### Splunk

## Containerization
- ### Docker
  - container creation platform
  - provide consistent environment for application deployed on different platforms
  - encapsulation 
  - simplifies the process of spinning up new instances of apps
  - load balancing with Docker Swarm