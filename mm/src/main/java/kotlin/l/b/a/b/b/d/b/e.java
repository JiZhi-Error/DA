package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import kotlin.g.b.p;
import kotlin.l.b.a.b.d.a.e.a;
import kotlin.l.b.a.b.d.a.e.c;
import kotlin.l.b.a.b.f.f;

public final class e extends d implements c {
    private final Annotation TmG;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(f fVar, Annotation annotation) {
        super(fVar);
        p.h(annotation, "annotation");
        AppMethodBeat.i(57417);
        this.TmG = annotation;
        AppMethodBeat.o(57417);
    }

    @Override // kotlin.l.b.a.b.d.a.e.c
    public final a hCF() {
        AppMethodBeat.i(57416);
        c cVar = new c(this.TmG);
        AppMethodBeat.o(57416);
        return cVar;
    }
}
