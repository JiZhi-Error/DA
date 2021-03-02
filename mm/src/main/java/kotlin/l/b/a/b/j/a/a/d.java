package kotlin.l.b.a.b.j.a.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.h;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.ae;
import kotlin.l.b.a.b.m.av;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.ay;
import kotlin.l.b.a.b.m.bh;
import kotlin.l.b.a.b.m.m;
import kotlin.l.b.a.b.m.z;
import kotlin.o;
import kotlin.s;
import kotlin.t;

public final class d {
    private static ab b(av avVar) {
        AppMethodBeat.i(60034);
        p.h(avVar, "typeProjection");
        a aVar = new a(avVar);
        AppMethodBeat.o(60034);
        return aVar;
    }

    public static final boolean ad(ab abVar) {
        AppMethodBeat.i(60035);
        p.h(abVar, "$this$isCaptured");
        boolean z = abVar.hKE() instanceof b;
        AppMethodBeat.o(60035);
        return z;
    }

    public static /* synthetic */ ay c(ay ayVar) {
        AppMethodBeat.i(60036);
        p.h(ayVar, "$this$wrapWithCapturingSubstitution");
        if (ayVar instanceof z) {
            as[] asVarArr = ((z) ayVar).TOb;
            av[] avVarArr = ((z) ayVar).TOc;
            as[] asVarArr2 = ((z) ayVar).TOb;
            p.h(avVarArr, "$this$zip");
            p.h(asVarArr2, FacebookRequestErrorClassification.KEY_OTHER);
            int min = Math.min(avVarArr.length, asVarArr2.length);
            ArrayList arrayList = new ArrayList(min);
            for (int i2 = 0; i2 < min; i2++) {
                arrayList.add(s.U(avVarArr[i2], asVarArr2[i2]));
            }
            ArrayList<o> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(j.a(arrayList2, 10));
            for (o oVar : arrayList2) {
                arrayList3.add(a(oVar.first, oVar.second));
            }
            Object[] array = arrayList3.toArray(new av[0]);
            if (array == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                AppMethodBeat.o(60036);
                throw tVar;
            }
            z zVar = new z(asVarArr, (av[]) array, true);
            AppMethodBeat.o(60036);
            return zVar;
        }
        b bVar = new b(ayVar, ayVar);
        AppMethodBeat.o(60036);
        return bVar;
    }

    public static final class b extends m {
        final /* synthetic */ ay TIq;
        final /* synthetic */ boolean TIr = true;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ay ayVar, ay ayVar2) {
            super(ayVar2);
            this.TIq = ayVar;
        }

        @Override // kotlin.l.b.a.b.m.ay, kotlin.l.b.a.b.m.m
        public final boolean hKG() {
            return this.TIr;
        }

        @Override // kotlin.l.b.a.b.m.ay, kotlin.l.b.a.b.m.m
        public final av N(ab abVar) {
            as asVar = null;
            AppMethodBeat.i(60033);
            p.h(abVar, "key");
            av N = super.N(abVar);
            if (N != null) {
                h hzS = abVar.hKE().hzS();
                if (hzS instanceof as) {
                    asVar = hzS;
                }
                av a2 = d.a(N, asVar);
                AppMethodBeat.o(60033);
                return a2;
            }
            AppMethodBeat.o(60033);
            return null;
        }
    }

    static final av a(av avVar, as asVar) {
        AppMethodBeat.i(60037);
        if (asVar == null || avVar.hLI() == bh.INVARIANT) {
            AppMethodBeat.o(60037);
            return avVar;
        } else if (asVar.hAJ() != avVar.hLI()) {
            ax axVar = new ax(b(avVar));
            AppMethodBeat.o(60037);
            return axVar;
        } else if (avVar.hLH()) {
            kotlin.l.b.a.b.l.j jVar = kotlin.l.b.a.b.l.b.TMN;
            p.g(jVar, "LockBasedStorageManager.NO_LOCKS");
            ax axVar2 = new ax(new ae(jVar, new a(avVar)));
            AppMethodBeat.o(60037);
            return axVar2;
        } else {
            ax axVar3 = new ax(avVar.hBy());
            AppMethodBeat.o(60037);
            return axVar3;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.a<ab> {
        final /* synthetic */ av TIp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(av avVar) {
            super(0);
            this.TIp = avVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ab invoke() {
            AppMethodBeat.i(60032);
            ab hBy = this.TIp.hBy();
            p.g(hBy, "this@createCapturedIfNeeded.type");
            AppMethodBeat.o(60032);
            return hBy;
        }
    }
}
