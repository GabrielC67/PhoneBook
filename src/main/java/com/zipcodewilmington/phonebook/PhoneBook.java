package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {//Constructor
        if (map == null){
            this.phonebook = new HashMap<>();
        }
        else {
            this.phonebook = map;
        }
    }

    public PhoneBook() { //Null constructor
        this(null);
    }

    public void add(String name, String phoneNumber) {
        if (name == "" || name == null){
            throw new NullPointerException ("Name cannot be empty");
        } else if (phoneNumber == "" || phoneNumber == null) {
            throw new NullPointerException("Phone Number cannot be empty nor null");
        } else{
            phonebook.put(name, List.of(phoneNumber));
        }

    }

    public void addAll(String name, String... phoneNumbers) {
        if (name == null || name == ""){
            throw new NullPointerException("Name cannot be Null nor empty");
        } else if (phoneNumbers == null) {
            throw  new NullPointerException("Phone numbers cannot contain a null value");
        } else
            phonebook.computeIfAbsent(name, k -> new ArrayList<>()).addAll(Arrays.asList(phoneNumbers));

    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        if (name == "" || name == null){
            throw new NullPointerException("Name cannot be empty nor Null");
        } else if (phonebook.containsKey(name)) {
            return true;
        }
        return false;
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return null;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
