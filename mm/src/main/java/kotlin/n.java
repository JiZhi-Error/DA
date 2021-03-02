package kotlin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, hxF = {"Lkotlin/NotImplementedError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "(Ljava/lang/String;)V", "kotlin-stdlib"})
public final class n extends Error {
    public /* synthetic */ n() {
        this("An operation is not implemented.");
        AppMethodBeat.i(129590);
        AppMethodBeat.o(129590);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(String str) {
        super(str);
        p.h(str, "message");
        AppMethodBeat.i(129589);
        AppMethodBeat.o(129589);
    }
}
