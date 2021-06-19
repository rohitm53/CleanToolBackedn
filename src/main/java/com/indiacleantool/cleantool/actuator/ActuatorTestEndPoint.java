package com.indiacleantool.cleantool.actuator;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "myendpoint")
public class ActuatorTestEndPoint {

    private Map<String,String> mapUsers = new HashMap<>();

    @ReadOperation
    public Map<String,String> features(){
        mapUsers.put("firstuser","Rohit");
        mapUsers.put("seconduser","Ram");
        return mapUsers;
    }

    @WriteOperation
    public String writeOperation(String name){
        return name + "\t in HTTP POST method";
    }

    @DeleteOperation
    public String deleteOperation(){
        return "HTTP DELETE method";
    }

}
