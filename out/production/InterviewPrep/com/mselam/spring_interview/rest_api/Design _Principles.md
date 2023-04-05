## Design Principles
  - ### Uniform Interface
    - #### Resource Based
      - URI points to resource
    - #### Manipulation of Resource through representations
      - URI link returned with the resource used to modify itself.
    - #### Self-discriptive messages
      - message contains info on how to process
    - #### HATEOAS
      - response holds link to itself and related resources. Used as a means to drive future requests.
  - ### Client - Server Architecture
    - client separate from server via interface
    - abstraction - allows change of either without affecting the other.
  - ### Stateless
    - #### Modes of state transfer:
      - REQUEST: 
        - URI, 
        - Query-string Param, 
        - Headers, 
        - Request Body
      - RESPONSE:
        - Status,
        - Headers,
        - Response Body
    - #### Client-side
      - send all necessary information including authorization to acquire the resource on every request.
    - #### Server-side
      - holds no state for previous requests
  - ### Cacheable
    - #### Client-side
      - store part of response in cache not to have to request un-changing part each time.
    - #### Server-side
      - responses implicitely/explicitely defined as cacheable, eg. Last-Modified header
  - ### Layered
    - intermediaries may exist between client and server(owner of resource)
    - connection to specific machine is not required
    - client needs data only
  - ### Code on Demand (optional)
    - server allow client temporary extension of functionality by sending executable logic.
    - eg. compiled component - java applet, java-script code
    - not common
  - ### Request Nature
    - ### Safe
      - read only HTTP request methods: GET, HEAD
      - no change required on server state
    - ### Idempotent
      - multiple identical request behave as a single original request
      - change of state only occurs once
      - HTTP request methods: PUT, POST, DELETE
      - allow automatic request on failure. POST request will cause new change on every request.
    - ### 