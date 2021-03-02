package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"Lkotlinx/serialization/json/internal/EscapeCharMappings;", "", "()V", "ESCAPE_2_CHAR", "", "initC2ESC", "", "c", "", "esc", "", "kotlinx-serialization-runtime"})
public final class c {
    public static final char[] Uah = new char[117];
    public static final c Uai = new c();

    static {
        AppMethodBeat.i(225712);
        for (int i2 = 0; i2 <= 31; i2++) {
            a(i2, 'u');
        }
        a(8, 'b');
        a(9, 't');
        a(10, 'n');
        a(12, 'f');
        a(13, 'r');
        a(47, '/');
        a(34, '\"');
        a(92, '\\');
        AppMethodBeat.o(225712);
    }

    private c() {
    }

    private static void a(int i2, char c2) {
        if (c2 != 'u') {
            Uah[c2] = (char) i2;
        }
    }
}
