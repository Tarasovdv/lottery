import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BoxLottery {
    private String lotterySlot;

    public String toString() {
        return this.getLotterySlot();
    }
}
