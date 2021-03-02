package kotlin.l.b.a.b.e.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.g.b.p;

public final class f extends kotlin.l.b.a.b.e.b.a {
    public static final f TCE = new f(1, 1, 16);
    public static final f TCF = new f(new int[0]);
    public static final a TCG = new a((byte) 0);
    private final boolean TCD;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(int[] iArr, boolean z) {
        super(Arrays.copyOf(iArr, iArr.length));
        p.h(iArr, "versionArray");
        AppMethodBeat.i(59242);
        this.TCD = z;
        AppMethodBeat.o(59242);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public f(int... iArr) {
        this(iArr, false);
        p.h(iArr, "numbers");
        AppMethodBeat.i(59243);
        AppMethodBeat.o(59243);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(59244);
        AppMethodBeat.o(59244);
    }

    public final boolean hIi() {
        boolean z;
        AppMethodBeat.i(59241);
        if (!(this.major == 1 && this.minor == 0)) {
            if (this.TCD) {
                z = a(TCE);
            } else {
                z = this.major == 1 && this.minor <= 4;
            }
            if (z) {
                AppMethodBeat.o(59241);
                return true;
            }
        }
        AppMethodBeat.o(59241);
        return false;
    }
}
