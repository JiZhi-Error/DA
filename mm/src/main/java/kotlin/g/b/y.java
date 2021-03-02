package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l.d;

public final class y extends x {
    private final d SYA;
    private final String name;
    private final String signature;

    public y(d dVar, String str, String str2) {
        this.SYA = dVar;
        this.name = str;
        this.signature = str2;
    }

    @Override // kotlin.g.b.e
    public final d Rs() {
        return this.SYA;
    }

    @Override // kotlin.l.a, kotlin.g.b.e
    public final String getName() {
        return this.name;
    }

    @Override // kotlin.g.b.e
    public final String getSignature() {
        return this.signature;
    }

    @Override // kotlin.l.m
    public final Object get(Object obj) {
        AppMethodBeat.i(128971);
        Object ag = hye().ag(obj);
        AppMethodBeat.o(128971);
        return ag;
    }
}
