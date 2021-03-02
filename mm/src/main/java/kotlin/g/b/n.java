package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.a;
import kotlin.l.e;

public class n extends e implements m, e {
    private final int arity;

    public n(int i2) {
        this.arity = i2;
    }

    public n(int i2, Object obj) {
        super(obj);
        this.arity = i2;
    }

    @Override // kotlin.g.b.m
    public int getArity() {
        return this.arity;
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.g.b.e
    public final a hxP() {
        AppMethodBeat.i(128937);
        e a2 = aa.a(this);
        AppMethodBeat.o(128937);
        return a2;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(128938);
        if (obj == this) {
            AppMethodBeat.o(128938);
            return true;
        } else if (obj instanceof n) {
            n nVar = (n) obj;
            if (Rs() != null ? Rs().equals(nVar.Rs()) : nVar.Rs() == null) {
                if (getName().equals(nVar.getName()) && getSignature().equals(nVar.getSignature()) && p.j(hxQ(), nVar.hxQ())) {
                    AppMethodBeat.o(128938);
                    return true;
                }
            }
            AppMethodBeat.o(128938);
            return false;
        } else if (obj instanceof e) {
            boolean equals = obj.equals(hxR());
            AppMethodBeat.o(128938);
            return equals;
        } else {
            AppMethodBeat.o(128938);
            return false;
        }
    }

    public int hashCode() {
        AppMethodBeat.i(128939);
        int hashCode = (((Rs() == null ? 0 : Rs().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
        AppMethodBeat.o(128939);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.i(128940);
        a hxR = hxR();
        if (hxR != this) {
            String obj = hxR.toString();
            AppMethodBeat.o(128940);
            return obj;
        } else if ("<init>".equals(getName())) {
            AppMethodBeat.o(128940);
            return "constructor (Kotlin reflection is not available)";
        } else {
            String str = "function " + getName() + " (Kotlin reflection is not available)";
            AppMethodBeat.o(128940);
            return str;
        }
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.g.b.e
    public final /* bridge */ /* synthetic */ a hxS() {
        AppMethodBeat.i(128941);
        e eVar = (e) super.hxS();
        AppMethodBeat.o(128941);
        return eVar;
    }
}
