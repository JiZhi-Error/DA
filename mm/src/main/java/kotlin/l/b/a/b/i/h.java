package kotlin.l.b.a.b.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Set;
import kotlin.a.e;
import kotlin.a.j;

public enum h {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true);
    
    public static final Set<h> TFS;
    public static final Set<h> TFT = e.Y(values());
    public static final a TFU = new a((byte) 0);
    private final boolean TFR;

    public static h valueOf(String str) {
        AppMethodBeat.i(59802);
        h hVar = (h) Enum.valueOf(h.class, str);
        AppMethodBeat.o(59802);
        return hVar;
    }

    private h(boolean z) {
        this.TFR = z;
    }

    static {
        AppMethodBeat.i(59800);
        h[] values = values();
        ArrayList arrayList = new ArrayList();
        for (h hVar : values) {
            if (hVar.TFR) {
                arrayList.add(hVar);
            }
        }
        TFS = j.r((Iterable) arrayList);
        AppMethodBeat.o(59800);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
