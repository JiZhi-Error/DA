package kotlin.l.b.a.b.d.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l.b.a.b.e.c.a.c;
import kotlin.l.b.a.b.e.c.a.f;

public final class a {
    public final EnumC2293a Twl;
    public final f Twm;
    private final c Twn;
    public final String[] Two;
    public final String[] Twp;
    private final String Twq;
    private final int Twr;
    private final String packageName;
    public final String[] strings;

    public a(EnumC2293a aVar, f fVar, c cVar, String[] strArr, String[] strArr2, String[] strArr3, String str, int i2, String str2) {
        p.h(aVar, "kind");
        p.h(fVar, "metadataVersion");
        p.h(cVar, "bytecodeVersion");
        AppMethodBeat.i(58283);
        this.Twl = aVar;
        this.Twm = fVar;
        this.Twn = cVar;
        this.Two = strArr;
        this.Twp = strArr2;
        this.strings = strArr3;
        this.Twq = str;
        this.Twr = i2;
        this.packageName = str2;
        AppMethodBeat.o(58283);
    }

    /* renamed from: kotlin.l.b.a.b.d.b.a.a$a  reason: collision with other inner class name */
    public enum EnumC2293a {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        public static final C2294a TwA = new C2294a((byte) 0);
        private static final Map<Integer, EnumC2293a> Twz;
        private final int id;

        public static EnumC2293a valueOf(String str) {
            AppMethodBeat.i(58280);
            EnumC2293a aVar = (EnumC2293a) Enum.valueOf(EnumC2293a.class, str);
            AppMethodBeat.o(58280);
            return aVar;
        }

        private EnumC2293a(int i2) {
            this.id = i2;
        }

        static {
            AppMethodBeat.i(58278);
            EnumC2293a[] values = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(j.mZ(ae.atJ(values.length), 16));
            for (EnumC2293a aVar : values) {
                linkedHashMap.put(Integer.valueOf(aVar.id), aVar);
            }
            Twz = linkedHashMap;
            AppMethodBeat.o(58278);
        }

        /* renamed from: kotlin.l.b.a.b.d.b.a.a$a$a  reason: collision with other inner class name */
        public static final class C2294a {
            private C2294a() {
            }

            public /* synthetic */ C2294a(byte b2) {
                this();
            }
        }

        public static final EnumC2293a atR(int i2) {
            AppMethodBeat.i(58281);
            EnumC2293a aVar = Twz.get(Integer.valueOf(i2));
            if (aVar == null) {
                aVar = UNKNOWN;
            }
            AppMethodBeat.o(58281);
            return aVar;
        }
    }

    public final String hEp() {
        String str = this.Twq;
        if (this.Twl == EnumC2293a.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final boolean hEq() {
        return (this.Twr & 2) != 0;
    }

    public final String toString() {
        AppMethodBeat.i(58282);
        String str = this.Twl + " version=" + this.Twm;
        AppMethodBeat.o(58282);
        return str;
    }
}
