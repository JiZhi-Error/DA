package kotlin.l.b.a.b.b.c;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.e;
import kotlin.a.v;
import kotlin.a.x;
import kotlin.aa;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ac;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.b.n;
import kotlin.l.b.a.b.b.u;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.l.c;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.a.r;

public final class w extends j implements y {
    final j TcN;
    private final g TiH;
    private final Map<y.a<?>, Object> TlL;
    u TlM;
    ac TlN;
    private final c<kotlin.l.b.a.b.f.b, ad> TlO;
    private final f TlP;
    private final kotlin.l.b.a.b.g.b TlQ;
    private final kotlin.l.b.a.b.f.f TlR;
    private boolean daZ;

    public w(kotlin.l.b.a.b.f.f fVar, j jVar, g gVar) {
        this(fVar, jVar, gVar, (Map) null, 48);
    }

    private final i hCk() {
        AppMethodBeat.i(57178);
        i iVar = (i) this.TlP.getValue();
        AppMethodBeat.o(57178);
        return iVar;
    }

    static final class b extends q implements kotlin.g.a.b<kotlin.l.b.a.b.f.b, r> {
        final /* synthetic */ w TlS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(w wVar) {
            super(1);
            this.TlS = wVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ r invoke(kotlin.l.b.a.b.f.b bVar) {
            AppMethodBeat.i(57172);
            kotlin.l.b.a.b.f.b bVar2 = bVar;
            p.h(bVar2, "fqName");
            r rVar = new r(this.TlS, bVar2, this.TlS.TcN);
            AppMethodBeat.o(57172);
            return rVar;
        }
    }

    @Override // kotlin.l.b.a.b.b.l
    public final <R, D> R a(n<R, D> nVar, D d2) {
        AppMethodBeat.i(57190);
        p.h(nVar, "visitor");
        p.h(nVar, "visitor");
        R a2 = nVar.a(this, d2);
        AppMethodBeat.o(57190);
        return a2;
    }

    @Override // kotlin.l.b.a.b.b.l
    public final l hzx() {
        return null;
    }

    @Override // kotlin.l.b.a.b.b.y
    public final g hBh() {
        return this.TiH;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ w(kotlin.l.b.a.b.f.f r8, kotlin.l.b.a.b.l.j r9, kotlin.l.b.a.b.a.g r10, java.util.Map r11, int r12) {
        /*
            r7 = this;
            r6 = 57189(0xdf65, float:8.0139E-41)
            r0 = r12 & 16
            if (r0 == 0) goto L_0x001a
            java.util.Map r5 = kotlin.a.ae.emptyMap()
        L_0x000b:
            r4 = 0
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            return
        L_0x001a:
            r5 = r11
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.b.c.w.<init>(kotlin.l.b.a.b.f.f, kotlin.l.b.a.b.l.j, kotlin.l.b.a.b.a.g, java.util.Map, int):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private w(kotlin.l.b.a.b.f.f fVar, j jVar, g gVar, kotlin.l.b.a.b.g.b bVar, Map<y.a<?>, ? extends Object> map) {
        super(g.a.hBP(), fVar);
        p.h(fVar, "moduleName");
        p.h(jVar, "storageManager");
        p.h(gVar, "builtIns");
        p.h(map, "capabilities");
        g.a aVar = kotlin.l.b.a.b.b.a.g.TiC;
        AppMethodBeat.i(186245);
        this.TcN = jVar;
        this.TiH = gVar;
        this.TlQ = null;
        this.TlR = null;
        if (!fVar.TDa) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Module name must be special: ".concat(String.valueOf(fVar)));
            AppMethodBeat.o(186245);
            throw illegalArgumentException;
        }
        p.h(map, "$this$toMutableMap");
        this.TlL = new LinkedHashMap(map);
        this.TlL.put(kotlin.l.b.a.b.m.a.j.hLL(), new r());
        this.daZ = true;
        this.TlO = this.TcN.U(new b(this));
        this.TlP = kotlin.g.ah(new a(this));
        AppMethodBeat.o(186245);
    }

    @Override // kotlin.l.b.a.b.b.y
    public final List<y> hBi() {
        AppMethodBeat.i(57175);
        u uVar = this.TlM;
        if (uVar == null) {
            AssertionError assertionError = new AssertionError("Dependencies of module " + getId() + " were not set");
            AppMethodBeat.o(57175);
            throw assertionError;
        }
        List<w> hCi = uVar.hCi();
        AppMethodBeat.o(57175);
        return hCi;
    }

    @Override // kotlin.l.b.a.b.b.y
    public final ad e(kotlin.l.b.a.b.f.b bVar) {
        AppMethodBeat.i(57176);
        p.h(bVar, "fqName");
        hCj();
        ad invoke = this.TlO.invoke(bVar);
        AppMethodBeat.o(57176);
        return invoke;
    }

    @Override // kotlin.l.b.a.b.b.y
    public final Collection<kotlin.l.b.a.b.f.b> a(kotlin.l.b.a.b.f.b bVar, kotlin.g.a.b<? super kotlin.l.b.a.b.f.f, Boolean> bVar2) {
        AppMethodBeat.i(57177);
        p.h(bVar, "fqName");
        p.h(bVar2, "nameFilter");
        hCj();
        Collection<kotlin.l.b.a.b.f.b> a2 = hCl().a(bVar, bVar2);
        AppMethodBeat.o(57177);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final boolean isInitialized() {
        return this.TlN != null;
    }

    private void a(u uVar) {
        AppMethodBeat.i(57179);
        p.h(uVar, "dependencies");
        boolean z = this.TlM == null;
        if (!aa.SXc || z) {
            this.TlM = uVar;
            AppMethodBeat.o(57179);
            return;
        }
        AssertionError assertionError = new AssertionError("Dependencies of " + getId() + " were already set");
        AppMethodBeat.o(57179);
        throw assertionError;
    }

    public final void a(w... wVarArr) {
        AppMethodBeat.i(57180);
        p.h(wVarArr, "descriptors");
        kC(e.W(wVarArr));
        AppMethodBeat.o(57180);
    }

    private void a(List<w> list, Set<w> set) {
        AppMethodBeat.i(57182);
        p.h(list, "descriptors");
        p.h(set, NativeProtocol.AUDIENCE_FRIENDS);
        a(new v(list, set, v.SXr));
        AppMethodBeat.o(57182);
    }

    @Override // kotlin.l.b.a.b.b.y
    public final boolean a(y yVar) {
        AppMethodBeat.i(57183);
        p.h(yVar, "targetModule");
        if (p.j(this, yVar)) {
            AppMethodBeat.o(57183);
            return true;
        }
        u uVar = this.TlM;
        if (uVar == null) {
            p.hyc();
        }
        if (kotlin.a.j.a(uVar.hCh(), yVar)) {
            AppMethodBeat.o(57183);
            return true;
        } else if (hBi().contains(yVar)) {
            AppMethodBeat.o(57183);
            return true;
        } else if (yVar.hBi().contains(this)) {
            AppMethodBeat.o(57183);
            return true;
        } else {
            AppMethodBeat.o(57183);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final String getId() {
        AppMethodBeat.i(57184);
        String fVar = hAH().toString();
        p.g(fVar, "name.toString()");
        AppMethodBeat.o(57184);
        return fVar;
    }

    public final void a(ac acVar) {
        AppMethodBeat.i(57185);
        p.h(acVar, "providerForModuleContent");
        boolean z = !isInitialized();
        if (!aa.SXc || z) {
            this.TlN = acVar;
            AppMethodBeat.o(57185);
            return;
        }
        AssertionError assertionError = new AssertionError("Attempt to initialize module " + getId() + " twice");
        AppMethodBeat.o(57185);
        throw assertionError;
    }

    public final ac hCl() {
        AppMethodBeat.i(57186);
        hCj();
        i hCk = hCk();
        AppMethodBeat.o(57186);
        return hCk;
    }

    @Override // kotlin.l.b.a.b.b.y
    public final <T> T a(y.a<T> aVar) {
        AppMethodBeat.i(57187);
        p.h(aVar, "capability");
        T t = (T) this.TlL.get(aVar);
        if (!(t instanceof Object)) {
            t = null;
        }
        AppMethodBeat.o(57187);
        return t;
    }

    private void hCj() {
        AppMethodBeat.i(57174);
        if (!this.daZ) {
            u uVar = new u("Accessing invalid module descriptor ".concat(String.valueOf(this)));
            AppMethodBeat.o(57174);
            throw uVar;
        }
        AppMethodBeat.o(57174);
    }

    static final class a extends q implements kotlin.g.a.a<i> {
        final /* synthetic */ w TlS;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(w wVar) {
            super(0);
            this.TlS = wVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ i invoke() {
            AppMethodBeat.i(57171);
            u uVar = this.TlS.TlM;
            if (uVar == null) {
                AssertionError assertionError = new AssertionError("Dependencies of module " + this.TlS.getId() + " were not set before querying module content");
                AppMethodBeat.o(57171);
                throw assertionError;
            }
            List<w> hCg = uVar.hCg();
            boolean contains = hCg.contains(this.TlS);
            if (!aa.SXc || contains) {
                for (T t : hCg) {
                    boolean isInitialized = t.isInitialized();
                    if (aa.SXc && !isInitialized) {
                        AssertionError assertionError2 = new AssertionError("Dependency module " + t.getId() + " was not initialized by the time contents of dependent module " + this.TlS.getId() + " were queried");
                        AppMethodBeat.o(57171);
                        throw assertionError2;
                    }
                }
                List<w> list = hCg;
                ArrayList arrayList = new ArrayList(kotlin.a.j.a(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ac acVar = it.next().TlN;
                    if (acVar == null) {
                        p.hyc();
                    }
                    arrayList.add(acVar);
                }
                i iVar = new i(arrayList);
                AppMethodBeat.o(57171);
                return iVar;
            }
            AssertionError assertionError3 = new AssertionError("Module " + this.TlS.getId() + " is not contained in his own dependencies, this is probably a misconfiguration");
            AppMethodBeat.o(57171);
            throw assertionError3;
        }
    }

    private void kC(List<w> list) {
        AppMethodBeat.i(57181);
        p.h(list, "descriptors");
        a(list, x.SXt);
        AppMethodBeat.o(57181);
    }
}
