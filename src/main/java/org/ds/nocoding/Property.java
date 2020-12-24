package org.ds.nocoding;

public class Property {

     private String name;
     private String value;
     private DataType type;

     public Property(String name,String value,DataType type){
          this.name=name;
          this.value=value;
          this.type=type;
     }

     enum DataType{
          INT,LONG,STRING,ARRAY
     }

     public String getName() {
          return name;
     }

     public DataType getType() {
          return type;
     }

     public String getValue() {
          return value;
     }
}
