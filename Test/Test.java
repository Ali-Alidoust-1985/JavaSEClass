package Test;

import com.google.gson.Gson;

public class Test {
    public static void main(String[] args) {
        Person person=Person.builder().id(122).name("Ali").family("Alidoust").age(20).build();

        person.getId();
//        Person person = new Person();
//        person.setId(122);
//        person.setAge(20);
//        person.setName("Ali");
//        person.setFamily("Alidoust");

//        //Serialize
//        Gson json=new Gson();
//        String j=json.toJson(person);
//        System.out.println(j);
//
//        //Deserialize
//        Person person2=json.fromJson(j, Person.class);
//        System.out.println(person2);
//        String name=person2.getName();
//        System.out.println(name);

        // toString ra gson gharar dadim
        System.out.println(person);
    }
}
