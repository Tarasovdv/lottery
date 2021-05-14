package sandbox;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonInform {
    public String inform;

    public PersonInform() {

    }

    public String getInform() {
        return this.inform;
    }

    public void setInform(String inform) {
        this.inform = inform;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PersonInform)) return false;
        final PersonInform other = (PersonInform) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$inform = this.getInform();
        final Object other$inform = other.getInform();
        if (this$inform == null ? other$inform != null : !this$inform.equals(other$inform)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PersonInform;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $inform = this.getInform();
        result = result * PRIME + ($inform == null ? 43 : $inform.hashCode());
        return result;
    }

    public String toString() {
        return this.getInform();
    }
}
