package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.a.f;
import kotlin.l.b.a.b.b.t;
import kotlin.l.b.a.b.j.f.e;
import kotlin.l.b.a.b.l.j;

public final class d extends e {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(j jVar, b bVar) {
        super(jVar, bVar);
        p.h(jVar, "storageManager");
        p.h(bVar, "containingClass");
        AppMethodBeat.i(56736);
        AppMethodBeat.o(56736);
    }

    @Override // kotlin.l.b.a.b.j.f.e
    public final List<t> hzW() {
        AppMethodBeat.i(56735);
        kotlin.l.b.a.b.b.e eVar = this.TJS;
        if (eVar == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
            AppMethodBeat.o(56735);
            throw tVar;
        }
        switch (e.$EnumSwitchMapping$0[((b) eVar).Tfv.ordinal()]) {
            case 1:
                f.a aVar = f.TfI;
                List<t> listOf = kotlin.a.j.listOf(f.a.a((b) this.TJS, false));
                AppMethodBeat.o(56735);
                return listOf;
            case 2:
                f.a aVar2 = f.TfI;
                List<t> listOf2 = kotlin.a.j.listOf(f.a.a((b) this.TJS, true));
                AppMethodBeat.o(56735);
                return listOf2;
            default:
                v vVar = v.SXr;
                AppMethodBeat.o(56735);
                return vVar;
        }
    }
}
