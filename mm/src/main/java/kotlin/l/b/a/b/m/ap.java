package kotlin.l.b.a.b.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.b.l;
import kotlin.t;

public final class ap {
    public static final ab c(as asVar) {
        AppMethodBeat.i(60816);
        p.h(asVar, "$this$starProjectionType");
        l hzx = asVar.hzx();
        if (hzx == null) {
            t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassifierDescriptorWithTypeParameters");
            AppMethodBeat.o(60816);
            throw tVar;
        }
        at hzz = ((i) hzx).hzz();
        p.g(hzz, "classDescriptor.typeConstructor");
        List<as> parameters = hzz.getParameters();
        p.g(parameters, "classDescriptor.typeConstructor.parameters");
        List<as> list = parameters;
        ArrayList arrayList = new ArrayList(j.a(list, 10));
        for (T t : list) {
            p.g(t, LocaleUtil.ITALIAN);
            arrayList.add(t.hzz());
        }
        ba d2 = ba.d(new a(arrayList));
        List<ab> hyo = asVar.hyo();
        p.g(hyo, "this.upperBounds");
        aj c2 = d2.c((ab) j.ks(hyo), bh.OUT_VARIANCE);
        if (c2 == null) {
            aj hzk = kotlin.l.b.a.b.j.d.a.G(asVar).hzk();
            p.g(hzk, "builtIns.defaultBound");
            c2 = hzk;
        }
        AppMethodBeat.o(60816);
        return c2;
    }

    public static final class a extends au {
        final /* synthetic */ List TOx;

        a(List list) {
            this.TOx = list;
        }

        @Override // kotlin.l.b.a.b.m.au
        public final av d(at atVar) {
            AppMethodBeat.i(60815);
            p.h(atVar, "key");
            if (this.TOx.contains(atVar)) {
                h hzS = atVar.hzS();
                if (hzS == null) {
                    t tVar = new t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                    AppMethodBeat.o(60815);
                    throw tVar;
                }
                av d2 = bc.d((as) hzS);
                AppMethodBeat.o(60815);
                return d2;
            }
            AppMethodBeat.o(60815);
            return null;
        }
    }
}
