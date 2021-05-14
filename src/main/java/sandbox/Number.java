package sandbox;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Number {
    public int number;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Number)) return false;
        final Number other = (Number) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getNumber() != other.getNumber()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Number;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getNumber();
        return result;
    }

    public String toString() {
        return String.valueOf(this.getNumber());
    }
}
