package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args)  {

        Address address1 = new Address(1,"lane1","Digana","Sri Lanka");
        Address address2 = new Address(2,"lane2","Menikhinna","Sri Lanka");
        Address address3 = new Address(3,"lane3","Theldeniya","Sri Lanka");
        Address address4 = new Address(4,"lane4","PJ","Malaysia");
        Address address5 = new Address(5,"lane5","Johor","Malaysia");


        User user1 = new User(1, "kk","kk@gmail.com","123",32,address1);
        User user2 = new User(2, "kk2","kk2@gmail.com","123",50,address2);
        User user3 = new User(3, "kk3","kk3@gmail.com","123",21, address3);
        User user4 = new User(4, "kk4","kk4@gmail.com","123",76,address4);
        User user5 = new User(5, "kk5","kk5@gmail.com","123",19,address2);
        User user6 = new User(6, "kk6","kk6@gmail.com","123", 46,address4);
        User user7 = new User(7, "kk7","kk7@gmail.com","123",28,address5);
        User user8 = new User(7, "kk8","kk8@gmail.com","123",11,address5);

        List<User> userList = new ArrayList<>();
        Collections.addAll(userList,user1,user2,user3,user4,user5,user6,user7,user8);

        // #### forEach
        //userList.stream().forEach(x-> System.out.println(x.getEmail()));

        // store emails into the new list
        List<String> userEmailList = userList.stream().map(User::getEmail).toList();

        // filter users who older than 40
        List<User> usersOlderThan40 = userList.stream().filter(user -> user.getAge() > 40)
                .toList();

        // get List of address which only for users who older 40
        List<Address> addressListForUserOlder40 = userList.stream().
                filter(user -> user.getAge() > 40).map(User::getAddress).toList();

        addressListForUserOlder40.forEach(System.out::println);

    }
}
