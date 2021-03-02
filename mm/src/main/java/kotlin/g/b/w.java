package kotlin.g.b;

import kotlin.l.a;
import kotlin.l.k;

public abstract class w extends e implements k {
    public w() {
    }

    public w(Object obj) {
        super(obj);
    }

    /* access modifiers changed from: protected */
    public final k hyg() {
        return (k) super.hxS();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            return Rs().equals(wVar.Rs()) && getName().equals(wVar.getName()) && getSignature().equals(wVar.getSignature()) && p.j(hxQ(), wVar.hxQ());
        } else if (obj instanceof k) {
            return obj.equals(hxR());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((Rs().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        a hxR = hxR();
        if (hxR != this) {
            return hxR.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.g.b.e
    public final /* bridge */ /* synthetic */ a hxS() {
        return (k) super.hxS();
    }
}
