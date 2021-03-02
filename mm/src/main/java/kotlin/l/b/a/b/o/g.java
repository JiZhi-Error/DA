package kotlin.l.b.a.b.o;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");
    
    public static final a TRY = new a((byte) 0);
    final String description;

    public static g valueOf(String str) {
        AppMethodBeat.i(61375);
        g gVar = (g) Enum.valueOf(g.class, str);
        AppMethodBeat.o(61375);
        return gVar;
    }

    private g(String str) {
        this.description = str;
    }

    static {
        AppMethodBeat.i(61373);
        AppMethodBeat.o(61373);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean hLU() {
        return this == WARN;
    }

    public final boolean hLV() {
        return this == IGNORE;
    }
}
