package kotlinx.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, hxF = {"Lkotlinx/serialization/json/internal/WriteMode;", "", "begin", "", "end", "(Ljava/lang/String;ICC)V", "beginTc", "", "endTc", "OBJ", "LIST", "MAP", "POLY_OBJ", "kotlinx-serialization-runtime"})
public enum r {
    OBJ('{', '}'),
    LIST('[', ']'),
    MAP('{', '}'),
    POLY_OBJ('[', ']');
    
    public final byte UaE = g.G(this.UaG);
    public final byte UaF = g.G(this.UaH);
    public final char UaG;
    public final char UaH;

    public static r valueOf(String str) {
        AppMethodBeat.i(225722);
        r rVar = (r) Enum.valueOf(r.class, str);
        AppMethodBeat.o(225722);
        return rVar;
    }

    private r(char c2, char c3) {
        AppMethodBeat.i(225720);
        this.UaG = c2;
        this.UaH = c3;
        AppMethodBeat.o(225720);
    }

    static {
        AppMethodBeat.i(225719);
        AppMethodBeat.o(225719);
    }
}
