package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.c.a;
import kotlin.l.b.a.b.e.c.a.e;
import kotlin.m;

public final class s {
    public static final a TvQ = new a((byte) 0);
    final String signature;

    static {
        AppMethodBeat.i(58237);
        AppMethodBeat.o(58237);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(58240);
        if (this == obj || ((obj instanceof s) && p.j(this.signature, ((s) obj).signature))) {
            AppMethodBeat.o(58240);
            return true;
        }
        AppMethodBeat.o(58240);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(58239);
        String str = this.signature;
        if (str != null) {
            int hashCode = str.hashCode();
            AppMethodBeat.o(58239);
            return hashCode;
        }
        AppMethodBeat.o(58239);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(58238);
        String str = "MemberSignature(signature=" + this.signature + ")";
        AppMethodBeat.o(58238);
        return str;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static s ot(String str, String str2) {
            AppMethodBeat.i(58233);
            p.h(str, "name");
            p.h(str2, "desc");
            s sVar = new s(str + str2, (byte) 0);
            AppMethodBeat.o(58233);
            return sVar;
        }

        public static s ou(String str, String str2) {
            AppMethodBeat.i(58234);
            p.h(str, "name");
            p.h(str2, "desc");
            s sVar = new s(str + '#' + str2, (byte) 0);
            AppMethodBeat.o(58234);
            return sVar;
        }

        public static s a(e eVar) {
            AppMethodBeat.i(58235);
            p.h(eVar, "signature");
            if (eVar instanceof e.b) {
                s ot = ot(eVar.getName(), eVar.getDesc());
                AppMethodBeat.o(58235);
                return ot;
            } else if (eVar instanceof e.a) {
                s ou = ou(eVar.getName(), eVar.getDesc());
                AppMethodBeat.o(58235);
                return ou;
            } else {
                m mVar = new m();
                AppMethodBeat.o(58235);
                throw mVar;
            }
        }

        public static s a(s sVar, int i2) {
            AppMethodBeat.i(58236);
            p.h(sVar, "signature");
            s sVar2 = new s(sVar.signature + '@' + i2, (byte) 0);
            AppMethodBeat.o(58236);
            return sVar2;
        }

        public static s a(c cVar, a.b bVar) {
            AppMethodBeat.i(58232);
            p.h(cVar, "nameResolver");
            p.h(bVar, "signature");
            s ot = ot(cVar.getString(bVar.Tyk), cVar.getString(bVar.TBX));
            AppMethodBeat.o(58232);
            return ot;
        }
    }

    private s(String str) {
        this.signature = str;
    }

    public /* synthetic */ s(String str, byte b2) {
        this(str);
    }
}
