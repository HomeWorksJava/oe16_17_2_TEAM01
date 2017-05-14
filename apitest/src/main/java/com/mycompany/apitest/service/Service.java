/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apitest.service;

import com.mycompany.apitest.model.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Peter
 */
@Path("service")
public class Service {
    private static Map<Integer,Person> persons=new HashMap<Integer,Person>();
    
    static{
        for(int i=0;i<10;i++){
            Person person=new Person();
            person.setId(i+1);
            person.setFullName("name db "+i);
            person.setAge(new Random().nextInt(40));
            
            persons.put(person.getId(), person);
        }
        
    }
    
    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id")int id){
        return persons.get(id);
    }
    
    @GET
    @Path("/getPersonByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJSON(@PathParam("id")int id){
        return persons.get(id);
    }
    
    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonInXML(){
        return new ArrayList<Person>(persons.values());
    }
}
