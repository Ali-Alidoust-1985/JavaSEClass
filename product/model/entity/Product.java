package product.model.entity;

import com.google.gson.Gson;
import entity.Type;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
//@ToString

public class Product {
    private int id;
    private String name;
    private String brand;
    private int count;
    private double price;
    private LocalDateTime expireDate;
    private entity.PharmacyName pharmacyName;
    private Type type;
    private boolean rcsCbx, diecutCbx;

    public String ToString(){
        return new Gson().toJson(this);
    }

}
