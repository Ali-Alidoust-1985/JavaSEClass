package Test;

import com.google.gson.Gson;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@ToString
@SuperBuilder
public class Person {
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private int id;
    private String name;
    private String family;
    private int age;
//
//    public Person(int id, String name, int age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.family = family;
//    }

//
//    @Override
//    public String toString() {
//        Gson gson = new Gson();
//        return(gson.toJson(this));

}
