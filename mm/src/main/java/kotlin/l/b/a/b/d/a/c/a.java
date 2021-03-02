package kotlin.l.b.a.b.d.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k;
import kotlin.l.b.a.b.b.a.c;
import kotlin.l.b.a.b.b.g;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.d.a.a;
import kotlin.l.b.a.b.d.a.e.x;
import kotlin.l.b.a.b.d.a.f.h;

public final class a {
    public static /* synthetic */ h a(h hVar, g gVar, x xVar, int i2) {
        AppMethodBeat.i(57740);
        if ((i2 & 2) != 0) {
            xVar = null;
        }
        p.h(hVar, "$this$childForClassOrPackage");
        p.h(gVar, "containingDeclaration");
        h a2 = a(hVar, gVar, xVar, 0, kotlin.g.a(k.NONE, new C2282a(hVar, gVar)));
        AppMethodBeat.o(57740);
        return a2;
    }

    public static final h b(h hVar, kotlin.l.b.a.b.b.a.g gVar) {
        AppMethodBeat.i(57741);
        p.h(hVar, "$this$copyWithNewDefaultTypeQualifiers");
        p.h(gVar, "additionalAnnotations");
        if (gVar.isEmpty()) {
            AppMethodBeat.o(57741);
            return hVar;
        }
        h hVar2 = new h(hVar.Trv, hVar.Trw, kotlin.g.a(k.NONE, new b(hVar, gVar)));
        AppMethodBeat.o(57741);
        return hVar2;
    }

    public static final d a(h hVar, kotlin.l.b.a.b.b.a.g gVar) {
        EnumMap enumMap;
        EnumMap<a.EnumC2281a, h> enumMap2;
        k kVar;
        h a2;
        AppMethodBeat.i(57737);
        p.h(hVar, "$this$computeNewDefaultTypeQualifiers");
        p.h(gVar, "additionalAnnotations");
        if (hVar.Trv.Trd.HIg) {
            d hDJ = hVar.hDJ();
            AppMethodBeat.o(57737);
            return hDJ;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = gVar.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            kotlin.l.b.a.b.d.a.a aVar = hVar.Trv.Trd;
            p.h(cVar, "annotationDescriptor");
            if (aVar.Tob.hLT()) {
                kVar = null;
            } else {
                k kVar2 = kotlin.l.b.a.b.d.a.b.hDq().get(cVar.hBk());
                if (kVar2 != null) {
                    h hVar2 = kVar2.TrC;
                    Collection<a.EnumC2281a> collection = kVar2.TrD;
                    kotlin.l.b.a.b.o.g f2 = aVar.f(cVar);
                    kotlin.l.b.a.b.o.g gVar2 = f2 != kotlin.l.b.a.b.o.g.IGNORE ? f2 : null;
                    kVar = gVar2 == null ? null : new k(h.a(hVar2, gVar2.hLU()), collection);
                } else {
                    kVar = null;
                }
            }
            if (kVar == null) {
                a.b e2 = aVar.e(cVar);
                if (e2 == null) {
                    kVar = null;
                } else {
                    c cVar2 = e2.Toh;
                    List<a.EnumC2281a> hDm = e2.hDm();
                    kotlin.l.b.a.b.o.g g2 = aVar.g(cVar);
                    if (g2 == null) {
                        g2 = aVar.f(cVar2);
                    }
                    if (g2.hLV()) {
                        kVar = null;
                    } else {
                        h i2 = hVar.Trv.Tre.i(cVar2);
                        kVar = (i2 == null || (a2 = h.a(i2, g2.hLU())) == null) ? null : new k(a2, hDm);
                    }
                }
            }
            if (kVar != null) {
                arrayList.add(kVar);
            }
        }
        ArrayList<k> arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            d hDJ2 = hVar.hDJ();
            AppMethodBeat.o(57737);
            return hDJ2;
        }
        d hDJ3 = hVar.hDJ();
        if (hDJ3 == null || (enumMap2 = hDJ3.Trl) == null) {
            enumMap = new EnumMap(a.EnumC2281a.class);
        } else {
            enumMap = new EnumMap((EnumMap) enumMap2);
        }
        boolean z = false;
        for (k kVar3 : arrayList2) {
            h hVar3 = kVar3.TrC;
            boolean z2 = z;
            for (a.EnumC2281a aVar2 : kVar3.TrD) {
                enumMap.put((Object) aVar2, (Object) hVar3);
                z2 = true;
            }
            z = z2;
        }
        if (!z) {
            d hDJ4 = hVar.hDJ();
            AppMethodBeat.o(57737);
            return hDJ4;
        }
        d dVar = new d(enumMap);
        AppMethodBeat.o(57737);
        return dVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: kotlin.l.b.a.b.d.a.c.a$a  reason: collision with other inner class name */
    public static final class C2282a extends q implements kotlin.g.a.a<d> {
        final /* synthetic */ h TqM;
        final /* synthetic */ g TqN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2282a(h hVar, g gVar) {
            super(0);
            this.TqM = hVar;
            this.TqN = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ d invoke() {
            AppMethodBeat.i(57735);
            d a2 = a.a(this.TqM, this.TqN.hzL());
            AppMethodBeat.o(57735);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b extends q implements kotlin.g.a.a<d> {
        final /* synthetic */ h TqO;
        final /* synthetic */ kotlin.l.b.a.b.b.a.g TqP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h hVar, kotlin.l.b.a.b.b.a.g gVar) {
            super(0);
            this.TqO = hVar;
            this.TqP = gVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ d invoke() {
            AppMethodBeat.i(57736);
            d a2 = a.a(this.TqO, this.TqP);
            AppMethodBeat.o(57736);
            return a2;
        }
    }

    private static final h a(h hVar, l lVar, x xVar, int i2, f<d> fVar) {
        i iVar;
        AppMethodBeat.i(57738);
        b bVar = hVar.Trv;
        if (xVar != null) {
            iVar = new i(hVar, lVar, xVar, i2);
        } else {
            iVar = hVar.Trw;
        }
        h hVar2 = new h(bVar, iVar, fVar);
        AppMethodBeat.o(57738);
        return hVar2;
    }

    public static final h a(h hVar, l lVar, x xVar, int i2) {
        AppMethodBeat.i(57739);
        p.h(hVar, "$this$childForMethod");
        p.h(lVar, "containingDeclaration");
        p.h(xVar, "typeParameterOwner");
        h a2 = a(hVar, lVar, xVar, i2, hVar.Trx);
        AppMethodBeat.o(57739);
        return a2;
    }
}
