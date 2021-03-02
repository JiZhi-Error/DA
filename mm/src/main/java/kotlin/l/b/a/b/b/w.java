package kotlin.l.b.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum w {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;
    
    public static final a Tht = new a((byte) 0);

    static {
        AppMethodBeat.i(56860);
        AppMethodBeat.o(56860);
    }

    public static w valueOf(String str) {
        AppMethodBeat.i(56862);
        w wVar = (w) Enum.valueOf(w.class, str);
        AppMethodBeat.o(56862);
        return wVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static w bn(boolean z, boolean z2) {
            if (z) {
                return w.ABSTRACT;
            }
            if (z2) {
                return w.OPEN;
            }
            return w.FINAL;
        }
    }
}
