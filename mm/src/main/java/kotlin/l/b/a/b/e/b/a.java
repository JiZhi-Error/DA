package kotlin.l.b.a.b.e.b;

import java.util.ArrayList;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.a.b;
import kotlin.g.b.p;

public abstract class a {
    public static final C2328a TAS = new C2328a((byte) 0);
    public final int TAP;
    private final List<Integer> TAQ;
    private final int[] TAR;
    public final int major;
    public final int minor;

    public a(int... iArr) {
        int i2;
        int i3;
        v vVar;
        int i4 = -1;
        p.h(iArr, "numbers");
        this.TAR = iArr;
        Integer m = e.m(this.TAR, 0);
        if (m != null) {
            i2 = m.intValue();
        } else {
            i2 = -1;
        }
        this.major = i2;
        Integer m2 = e.m(this.TAR, 1);
        if (m2 != null) {
            i3 = m2.intValue();
        } else {
            i3 = -1;
        }
        this.minor = i3;
        Integer m3 = e.m(this.TAR, 2);
        this.TAP = m3 != null ? m3.intValue() : i4;
        if (this.TAR.length > 3) {
            vVar = j.p(e.W(this.TAR).subList(3, this.TAR.length));
        } else {
            vVar = v.SXr;
        }
        this.TAQ = vVar;
    }

    /* access modifiers changed from: protected */
    public final boolean a(a aVar) {
        p.h(aVar, "ourVersion");
        return this.major == 0 ? aVar.major == 0 && this.minor == aVar.minor : this.major == aVar.major && this.minor <= aVar.minor;
    }

    public String toString() {
        int[] iArr = this.TAR;
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (!(i2 != -1)) {
                break;
            }
            arrayList.add(Integer.valueOf(i2));
        }
        ArrayList arrayList2 = arrayList;
        return arrayList2.isEmpty() ? "unknown" : j.a(arrayList2, ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62);
    }

    public boolean equals(Object obj) {
        return obj != null && p.j(getClass(), obj.getClass()) && this.major == ((a) obj).major && this.minor == ((a) obj).minor && this.TAP == ((a) obj).TAP && p.j(this.TAQ, ((a) obj).TAQ);
    }

    public int hashCode() {
        int i2 = this.major;
        int i3 = i2 + (i2 * 31) + this.minor;
        int i4 = i3 + (i3 * 31) + this.TAP;
        return i4 + (i4 * 31) + this.TAQ.hashCode();
    }

    /* renamed from: kotlin.l.b.a.b.e.b.a$a  reason: collision with other inner class name */
    public static final class C2328a {
        private C2328a() {
        }

        public /* synthetic */ C2328a(byte b2) {
            this();
        }
    }
}
