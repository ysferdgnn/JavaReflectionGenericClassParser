## Getting Started

 This project mainly targets convert a class type to another class type. 
 In the other hand converts map list to class.


## Usage
![example of parse class to class](https://i.imgur.com/QYuaNO6.png)

- DestinationClass : Example result class
- SourceClass : Example source class
- fieldMatchMap : A map describe which variables match 

after parseClassToClass method execution, Source class variable values convert 
into Destination class.

#### Main methods
- `parseClassToClass(T sourceClazz, V destinationClazz, Map<String,String> fieldMatchMap)`


- `parseMapToClass(Map<String,String> sourceMap, V destinationClazz, Map<String,String> fieldMap)`

## Supported Variable Types
- BigDecimal
- Boolean
- Byte
- Character
- Double
- Float
- Integer
- Long
- Date(java.sql.Date)
- Date(java.util.Date)
- Timestamp
## Prerequisites
- Java 8



