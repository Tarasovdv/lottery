import lombok.*;

import java.awt.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Person  {

    private String firstName;
    private String lastName;
    private String tel;
    private int number;


    public String toString() {
        return "Number lottery:" + this.getNumber() +
                " | Name:" + this.getFirstName() +
                " | Last Name:" + this.getLastName() +
                " | Telephone number:" + this.getTel() + "\n";
    }

}

