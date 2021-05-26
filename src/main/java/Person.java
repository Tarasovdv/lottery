import lombok.*;

import java.awt.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Person  {

    private String inform;
    


    public String toString() {
        return this.getInform();
    }

}

