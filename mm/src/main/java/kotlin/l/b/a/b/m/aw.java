package kotlin.l.b.a.b.m;

public abstract class aw implements av {
    public String toString() {
        if (hLH()) {
            return "*";
        }
        if (hLI() == bh.INVARIANT) {
            return hBy().toString();
        }
        return hLI() + " " + hBy();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof av)) {
            return false;
        }
        av avVar = (av) obj;
        if (hLH() != avVar.hLH()) {
            return false;
        }
        if (hLI() != avVar.hLI()) {
            return false;
        }
        return hBy().equals(avVar.hBy());
    }

    public int hashCode() {
        int i2;
        int hashCode;
        int hashCode2 = hLI().hashCode();
        if (bc.aA(hBy())) {
            i2 = hashCode2 * 31;
            hashCode = 19;
        } else {
            i2 = hashCode2 * 31;
            hashCode = hLH() ? 17 : hBy().hashCode();
        }
        return hashCode + i2;
    }
}
