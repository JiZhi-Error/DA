package kotlin.l.b.a.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.v;
import kotlin.g.b.q;
import kotlin.l.b.a.b.a.m;
import kotlin.l.b.a.b.b.an;
import kotlin.l.b.a.b.d.b.e;
import kotlin.l.b.a.b.d.b.p;
import kotlin.l.b.a.b.d.b.s;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.c.a;
import kotlin.l.b.a.b.e.c.a.e;
import kotlin.l.b.a.b.e.c.a.i;
import kotlin.l.b.a.b.h.i;
import kotlin.l.b.a.b.k.a.z;
import kotlin.l.b.a.b.l.j;
import kotlin.l.b.a.b.m.ab;
import kotlin.n.n;
import kotlin.t;

public abstract class a<A, C> implements kotlin.l.b.a.b.k.a.c<A, C> {
    private static final Set<kotlin.l.b.a.b.f.a> TuW;
    public static final C2292a TuX = new C2292a((byte) 0);
    private final n TqR;
    private final kotlin.l.b.a.b.l.c<p, c<A, C>> TuV;

    /* access modifiers changed from: package-private */
    public enum b {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD;

        static {
            AppMethodBeat.i(58144);
            AppMethodBeat.o(58144);
        }

        public static b valueOf(String str) {
            AppMethodBeat.i(58146);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(58146);
            return bVar;
        }
    }

    /* access modifiers changed from: protected */
    public abstract A a(a.C2299a aVar, kotlin.l.b.a.b.e.b.c cVar);

    /* access modifiers changed from: protected */
    public abstract p.a a(kotlin.l.b.a.b.f.a aVar, an anVar, List<A> list);

    /* access modifiers changed from: protected */
    public abstract C fq(C c2);

    static final class f extends q implements kotlin.g.a.b<p, c<? extends A, ? extends C>> {
        final /* synthetic */ a Tve;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar) {
            super(1);
            this.Tve = aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Object invoke(p pVar) {
            AppMethodBeat.i(58157);
            p pVar2 = pVar;
            kotlin.g.b.p.h(pVar2, "kotlinClass");
            c a2 = a.a(this.Tve, pVar2);
            AppMethodBeat.o(58157);
            return a2;
        }
    }

    public a(j jVar, n nVar) {
        kotlin.g.b.p.h(jVar, "storageManager");
        kotlin.g.b.p.h(nVar, "kotlinClassFinder");
        this.TqR = nVar;
        this.TuV = jVar.U(new f(this));
    }

    private static p a(z.a aVar) {
        an anVar = aVar.Tik;
        if (!(anVar instanceof r)) {
            anVar = null;
        }
        r rVar = (r) anVar;
        if (rVar != null) {
            return rVar.TvP;
        }
        return null;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<A> b(z.a aVar) {
        kotlin.g.b.p.h(aVar, "container");
        p a2 = a(aVar);
        if (a2 == null) {
            throw new IllegalStateException(("Class for loading annotations is not found: " + aVar.hLf()).toString());
        }
        ArrayList arrayList = new ArrayList(1);
        kotlin.g.b.p.h(a2, "kotlinClass");
        a2.a(new e(this, arrayList));
        return arrayList;
    }

    public static final class e implements p.c {
        final /* synthetic */ a Tve;
        final /* synthetic */ ArrayList hTI;

        e(a aVar, ArrayList arrayList) {
            this.Tve = aVar;
            this.hTI = arrayList;
        }

        @Override // kotlin.l.b.a.b.d.b.p.c
        public final p.a a(kotlin.l.b.a.b.f.a aVar, an anVar) {
            AppMethodBeat.i(58156);
            kotlin.g.b.p.h(aVar, "classId");
            kotlin.g.b.p.h(anVar, "source");
            p.a a2 = a.a(this.Tve, aVar, anVar, this.hTI);
            AppMethodBeat.o(58156);
            return a2;
        }

        @Override // kotlin.l.b.a.b.d.b.p.c
        public final void Td() {
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInvokeVisitor
        java.lang.IndexOutOfBoundsException: Index: 4, Size: 4
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.searchCastTypes(MethodInvokeVisitor.java:267)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:127)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:102)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:73)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:66)
        */
    @Override // kotlin.l.b.a.b.k.a.c
    public final java.util.List<A> a(kotlin.l.b.a.b.k.a.z r8, kotlin.l.b.a.b.h.q r9, kotlin.l.b.a.b.k.a.b r10) {
        /*
            r7 = this;
            r3 = 0
            java.lang.String r0 = "container"
            kotlin.g.b.p.h(r8, r0)
            java.lang.String r0 = "proto"
            kotlin.g.b.p.h(r9, r0)
            java.lang.String r0 = "kind"
            kotlin.g.b.p.h(r10, r0)
            kotlin.l.b.a.b.k.a.b r0 = kotlin.l.b.a.b.k.a.b.PROPERTY
            if (r10 != r0) goto L_0x0020
            kotlin.l.b.a.b.e.a$m r9 = (kotlin.l.b.a.b.e.a.m) r9
            kotlin.l.b.a.b.d.b.a$b r0 = kotlin.l.b.a.b.d.b.a.b.PROPERTY
            java.util.List r0 = r7.a(r8, r9, r0)
        L_0x001f:
            return r0
        L_0x0020:
            kotlin.l.b.a.b.e.b.c r0 = r8.SZH
            kotlin.l.b.a.b.e.b.h r1 = r8.SZI
            kotlin.l.b.a.b.d.b.s r2 = a(r9, r0, r1, r10)
            if (r2 != 0) goto L_0x002f
            kotlin.a.v r0 = kotlin.a.v.SXr
            java.util.List r0 = (java.util.List) r0
            goto L_0x001f
        L_0x002f:
            r4 = 0
            r6 = 60
            r0 = r7
            r1 = r8
            r5 = r3
            java.util.List r0 = a(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x001f
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.b.a.a(kotlin.l.b.a.b.k.a.z, kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.k.a.b):java.util.List");
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<A> a(z zVar, a.m mVar) {
        kotlin.g.b.p.h(zVar, "container");
        kotlin.g.b.p.h(mVar, "proto");
        return a(zVar, mVar, b.BACKING_FIELD);
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<A> b(z zVar, a.m mVar) {
        kotlin.g.b.p.h(zVar, "container");
        kotlin.g.b.p.h(mVar, "proto");
        return a(zVar, mVar, b.DELEGATE_FIELD);
    }

    private final List<A> a(z zVar, a.m mVar, b bVar) {
        boolean z;
        Boolean avk = kotlin.l.b.a.b.e.b.b.TBq.avk(mVar.Txb);
        kotlin.g.b.p.g(avk, "Flags.IS_CONST.get(proto.flags)");
        boolean booleanValue = avk.booleanValue();
        boolean f2 = i.f(mVar);
        if (bVar == b.PROPERTY) {
            s a2 = a(mVar, zVar.SZH, zVar.SZI, false, true, false, 40);
            if (a2 == null) {
                return v.SXr;
            }
            return a((a) this, zVar, a2, true, Boolean.valueOf(booleanValue), f2, 8);
        }
        s a3 = a(mVar, zVar.SZH, zVar.SZI, true, false, false, 48);
        if (a3 == null) {
            return v.SXr;
        }
        boolean a4 = n.a((CharSequence) a3.signature, (CharSequence) "$delegate", false);
        if (bVar == b.DELEGATE_FIELD) {
            z = true;
        } else {
            z = false;
        }
        if (a4 != z) {
            return v.SXr;
        }
        return a(zVar, a3, true, true, Boolean.valueOf(booleanValue), f2);
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<A> a(z zVar, a.f fVar) {
        kotlin.g.b.p.h(zVar, "container");
        kotlin.g.b.p.h(fVar, "proto");
        s.a aVar = s.TvQ;
        String string = zVar.SZH.getString(fVar.Tyk);
        String sG = ((z.a) zVar).Tfj.sG();
        kotlin.g.b.p.g(sG, "(container as ProtoConta…Class).classId.asString()");
        return a((a) this, zVar, s.a.ou(string, kotlin.l.b.a.b.e.c.a.b.btW(sG)), false, (Boolean) null, false, 60);
    }

    private static /* synthetic */ List a(a aVar, z zVar, s sVar, boolean z, Boolean bool, boolean z2, int i2) {
        boolean z3;
        Boolean bool2;
        boolean z4;
        if ((i2 & 4) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i2 & 16) != 0) {
            bool2 = null;
        } else {
            bool2 = bool;
        }
        if ((i2 & 32) != 0) {
            z4 = false;
        } else {
            z4 = z2;
        }
        return aVar.a(zVar, sVar, z3, false, bool2, z4);
    }

    private final List<A> a(z zVar, s sVar, boolean z, boolean z2, Boolean bool, boolean z3) {
        p a2 = a(zVar, a(zVar, z, z2, bool, z3));
        if (a2 == null) {
            return v.SXr;
        }
        List<A> list = this.TuV.invoke(a2).Tvc.get(sVar);
        if (list == null) {
            return v.SXr;
        }
        return list;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<A> a(a.p pVar, kotlin.l.b.a.b.e.b.c cVar) {
        kotlin.g.b.p.h(pVar, "proto");
        kotlin.g.b.p.h(cVar, "nameResolver");
        Object e2 = pVar.e(kotlin.l.b.a.b.e.c.a.TAN);
        kotlin.g.b.p.g(e2, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<a.C2299a> iterable = (Iterable) e2;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(iterable, 10));
        for (a.C2299a aVar : iterable) {
            kotlin.g.b.p.g(aVar, LocaleUtil.ITALIAN);
            arrayList.add(a(aVar, cVar));
        }
        return arrayList;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final List<A> a(a.r rVar, kotlin.l.b.a.b.e.b.c cVar) {
        kotlin.g.b.p.h(rVar, "proto");
        kotlin.g.b.p.h(cVar, "nameResolver");
        Object e2 = rVar.e(kotlin.l.b.a.b.e.c.a.TAO);
        kotlin.g.b.p.g(e2, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable<a.C2299a> iterable = (Iterable) e2;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(iterable, 10));
        for (a.C2299a aVar : iterable) {
            kotlin.g.b.p.g(aVar, LocaleUtil.ITALIAN);
            arrayList.add(a(aVar, cVar));
        }
        return arrayList;
    }

    @Override // kotlin.l.b.a.b.k.a.c
    public final C a(z zVar, a.m mVar, ab abVar) {
        boolean z = true;
        kotlin.g.b.p.h(zVar, "container");
        kotlin.g.b.p.h(mVar, "proto");
        kotlin.g.b.p.h(abVar, "expectedType");
        p a2 = a(zVar, a(zVar, true, true, kotlin.l.b.a.b.e.b.b.TBq.avk(mVar.Txb), i.f(mVar)));
        if (a2 == null) {
            return null;
        }
        kotlin.l.b.a.b.e.c.a.f fVar = a2.hCA().Twm;
        e.a aVar = e.Tvz;
        kotlin.l.b.a.b.e.c.a.f fVar2 = e.Tvy;
        kotlin.g.b.p.h(fVar2, "version");
        int i2 = fVar2.major;
        int i3 = fVar2.minor;
        int i4 = fVar2.TAP;
        if (fVar.major <= i2 && (fVar.major < i2 || (fVar.minor <= i3 && (fVar.minor < i3 || fVar.TAP < i4)))) {
            z = false;
        }
        s a3 = a(mVar, zVar.SZH, zVar.SZI, kotlin.l.b.a.b.k.a.b.PROPERTY, z);
        if (a3 == null) {
            return null;
        }
        C c2 = this.TuV.invoke(a2).Tvd.get(a3);
        if (c2 == null) {
            return null;
        }
        m mVar2 = m.Tfo;
        return m.E(abVar) ? fq(c2) : c2;
    }

    private static p a(z zVar, p pVar) {
        if (pVar != null) {
            return pVar;
        }
        if (zVar instanceof z.a) {
            return a((z.a) zVar);
        }
        return null;
    }

    private final p a(z zVar, boolean z, boolean z2, Boolean bool, boolean z3) {
        z.a aVar;
        kotlin.l.b.a.b.j.e.c cVar;
        if (z) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + zVar + ')').toString());
            } else if ((zVar instanceof z.a) && ((z.a) zVar).TLA == a.b.EnumC2306b.INTERFACE) {
                n nVar = this.TqR;
                kotlin.l.b.a.b.f.a o = ((z.a) zVar).Tfj.o(kotlin.l.b.a.b.f.f.btY("DefaultImpls"));
                kotlin.g.b.p.g(o, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
                return o.a(nVar, o);
            } else if (bool.booleanValue() && (zVar instanceof z.b)) {
                an anVar = zVar.Tik;
                if (!(anVar instanceof j)) {
                    anVar = null;
                }
                j jVar = (j) anVar;
                if (jVar != null) {
                    cVar = jVar.TvG;
                } else {
                    cVar = null;
                }
                if (cVar != null) {
                    n nVar2 = this.TqR;
                    String hKI = cVar.hKI();
                    kotlin.g.b.p.g(hKI, "facadeClassName.internalName");
                    kotlin.l.b.a.b.f.a p = kotlin.l.b.a.b.f.a.p(new kotlin.l.b.a.b.f.b(n.a(hKI, '/', '.')));
                    kotlin.g.b.p.g(p, "ClassId.topLevel(FqName(…lName.replace('/', '.')))");
                    return o.a(nVar2, p);
                }
            }
        }
        if (z2 && (zVar instanceof z.a) && ((z.a) zVar).TLA == a.b.EnumC2306b.COMPANION_OBJECT && (aVar = ((z.a) zVar).TLB) != null && (aVar.TLA == a.b.EnumC2306b.CLASS || aVar.TLA == a.b.EnumC2306b.ENUM_CLASS || (z3 && (aVar.TLA == a.b.EnumC2306b.INTERFACE || aVar.TLA == a.b.EnumC2306b.ANNOTATION_CLASS)))) {
            return a(aVar);
        }
        if (!(zVar instanceof z.b) || !(zVar.Tik instanceof j)) {
            return null;
        }
        an anVar2 = zVar.Tik;
        if (anVar2 == null) {
            throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        }
        j jVar2 = (j) anVar2;
        p pVar = jVar2.TvJ;
        if (pVar == null) {
            return o.a(this.TqR, jVar2.hyy());
        }
        return pVar;
    }

    public static final class d implements p.d {
        final /* synthetic */ a Tve;
        final /* synthetic */ HashMap Tvf;
        final /* synthetic */ HashMap Tvg;

        d(a aVar, HashMap hashMap, HashMap hashMap2) {
            this.Tve = aVar;
            this.Tvf = hashMap;
            this.Tvg = hashMap2;
        }

        @Override // kotlin.l.b.a.b.d.b.p.d
        public final p.e a(kotlin.l.b.a.b.f.f fVar, String str) {
            AppMethodBeat.i(58154);
            kotlin.g.b.p.h(fVar, "name");
            kotlin.g.b.p.h(str, "desc");
            s.a aVar = s.TvQ;
            String sG = fVar.sG();
            kotlin.g.b.p.g(sG, "name.asString()");
            C2296a aVar2 = new C2296a(this, s.a.ot(sG, str));
            AppMethodBeat.o(58154);
            return aVar2;
        }

        @Override // kotlin.l.b.a.b.d.b.p.d
        public final p.c b(kotlin.l.b.a.b.f.f fVar, String str) {
            AppMethodBeat.i(58155);
            kotlin.g.b.p.h(fVar, "name");
            kotlin.g.b.p.h(str, "desc");
            s.a aVar = s.TvQ;
            String sG = fVar.sG();
            kotlin.g.b.p.g(sG, "name.asString()");
            b bVar = new b(this, s.a.ou(sG, str));
            AppMethodBeat.o(58155);
            return bVar;
        }

        /* renamed from: kotlin.l.b.a.b.d.b.a$d$a  reason: collision with other inner class name */
        public final class C2296a extends b implements p.e {
            final /* synthetic */ d Tvh;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C2296a(d dVar, s sVar) {
                super(dVar, sVar);
                kotlin.g.b.p.h(sVar, "signature");
                this.Tvh = dVar;
                AppMethodBeat.i(58150);
                AppMethodBeat.o(58150);
            }

            @Override // kotlin.l.b.a.b.d.b.p.e
            public final p.a a(int i2, kotlin.l.b.a.b.f.a aVar, an anVar) {
                AppMethodBeat.i(58149);
                kotlin.g.b.p.h(aVar, "classId");
                kotlin.g.b.p.h(anVar, "source");
                s.a aVar2 = s.TvQ;
                s a2 = s.a.a(this.Tvj, i2);
                ArrayList arrayList = (List) this.Tvh.Tvf.get(a2);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.Tvh.Tvf.put(a2, arrayList);
                }
                p.a a3 = a.a(this.Tvh.Tve, aVar, anVar, arrayList);
                AppMethodBeat.o(58149);
                return a3;
            }
        }

        public class b implements p.c {
            final /* synthetic */ d Tvh;
            private final ArrayList<A> Tvi = new ArrayList<>();
            final s Tvj;

            public b(d dVar, s sVar) {
                kotlin.g.b.p.h(sVar, "signature");
                this.Tvh = dVar;
                AppMethodBeat.i(58153);
                this.Tvj = sVar;
                AppMethodBeat.o(58153);
            }

            @Override // kotlin.l.b.a.b.d.b.p.c
            public final p.a a(kotlin.l.b.a.b.f.a aVar, an anVar) {
                AppMethodBeat.i(58151);
                kotlin.g.b.p.h(aVar, "classId");
                kotlin.g.b.p.h(anVar, "source");
                p.a a2 = a.a(this.Tvh.Tve, aVar, anVar, this.Tvi);
                AppMethodBeat.o(58151);
                return a2;
            }

            @Override // kotlin.l.b.a.b.d.b.p.c
            public final void Td() {
                AppMethodBeat.i(58152);
                if (!this.Tvi.isEmpty()) {
                    this.Tvh.Tvf.put(this.Tvj, this.Tvi);
                }
                AppMethodBeat.o(58152);
            }
        }
    }

    private static /* synthetic */ s a(a.m mVar, kotlin.l.b.a.b.e.b.c cVar, h hVar, boolean z, boolean z2, boolean z3, int i2) {
        boolean z4;
        boolean z5 = false;
        if ((i2 & 8) != 0) {
            z4 = false;
        } else {
            z4 = z;
        }
        if ((i2 & 16) == 0) {
            z5 = z2;
        }
        return a(mVar, cVar, hVar, z4, z5, (i2 & 32) != 0 ? true : z3);
    }

    private static s a(a.m mVar, kotlin.l.b.a.b.e.b.c cVar, h hVar, boolean z, boolean z2, boolean z3) {
        i.f<a.m, a.c> fVar = kotlin.l.b.a.b.e.c.a.TBO;
        kotlin.g.b.p.g(fVar, "propertySignature");
        a.c cVar2 = (a.c) kotlin.l.b.a.b.e.b.f.a(mVar, fVar);
        if (cVar2 == null) {
            return null;
        }
        if (z) {
            kotlin.l.b.a.b.e.c.a.i iVar = kotlin.l.b.a.b.e.c.a.i.TCN;
            e.a a2 = kotlin.l.b.a.b.e.c.a.i.a(mVar, cVar, hVar, z3);
            if (a2 == null) {
                return null;
            }
            s.a aVar = s.TvQ;
            return s.a.a(a2);
        } else if (!z2 || !cVar2.hIz()) {
            return null;
        } else {
            s.a aVar2 = s.TvQ;
            a.b bVar = cVar2.TCb;
            kotlin.g.b.p.g(bVar, "signature.syntheticMethod");
            return s.a.a(cVar, bVar);
        }
    }

    /* access modifiers changed from: private */
    public static s a(kotlin.l.b.a.b.h.q qVar, kotlin.l.b.a.b.e.b.c cVar, h hVar, kotlin.l.b.a.b.k.a.b bVar, boolean z) {
        if (qVar instanceof a.c) {
            s.a aVar = s.TvQ;
            kotlin.l.b.a.b.e.c.a.i iVar = kotlin.l.b.a.b.e.c.a.i.TCN;
            e.b a2 = kotlin.l.b.a.b.e.c.a.i.a((a.c) qVar, cVar, hVar);
            if (a2 != null) {
                return s.a.a(a2);
            }
            return null;
        } else if (qVar instanceof a.h) {
            s.a aVar2 = s.TvQ;
            kotlin.l.b.a.b.e.c.a.i iVar2 = kotlin.l.b.a.b.e.c.a.i.TCN;
            e.b a3 = kotlin.l.b.a.b.e.c.a.i.a((a.h) qVar, cVar, hVar);
            if (a3 != null) {
                return s.a.a(a3);
            }
            return null;
        } else if (!(qVar instanceof a.m)) {
            return null;
        } else {
            i.f<a.m, a.c> fVar = kotlin.l.b.a.b.e.c.a.TBO;
            kotlin.g.b.p.g(fVar, "propertySignature");
            a.c cVar2 = (a.c) kotlin.l.b.a.b.e.b.f.a((i.c) qVar, fVar);
            if (cVar2 == null) {
                return null;
            }
            switch (b.$EnumSwitchMapping$0[bVar.ordinal()]) {
                case 1:
                    if (!cVar2.hIA()) {
                        return null;
                    }
                    s.a aVar3 = s.TvQ;
                    a.b bVar2 = cVar2.TCc;
                    kotlin.g.b.p.g(bVar2, "signature.getter");
                    return s.a.a(cVar, bVar2);
                case 2:
                    if (!cVar2.hIB()) {
                        return null;
                    }
                    s.a aVar4 = s.TvQ;
                    a.b bVar3 = cVar2.TCd;
                    kotlin.g.b.p.g(bVar3, "signature.setter");
                    return s.a.a(cVar, bVar3);
                case 3:
                    return a((a.m) qVar, cVar, hVar, true, true, z);
                default:
                    return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c<A, C> {
        final Map<s, List<A>> Tvc;
        final Map<s, C> Tvd;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Map<kotlin.l.b.a.b.d.b.s, ? extends java.util.List<? extends A>> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<kotlin.l.b.a.b.d.b.s, ? extends C> */
        /* JADX WARN: Multi-variable type inference failed */
        public c(Map<s, ? extends List<? extends A>> map, Map<s, ? extends C> map2) {
            kotlin.g.b.p.h(map, "memberAnnotations");
            kotlin.g.b.p.h(map2, "propertyConstants");
            AppMethodBeat.i(58147);
            this.Tvc = map;
            this.Tvd = map2;
            AppMethodBeat.o(58147);
        }
    }

    /* renamed from: kotlin.l.b.a.b.d.b.a$a  reason: collision with other inner class name */
    public static final class C2292a {
        private C2292a() {
        }

        public /* synthetic */ C2292a(byte b2) {
            this();
        }
    }

    static {
        List<kotlin.l.b.a.b.f.b> listOf = kotlin.a.j.listOf((Object[]) new kotlin.l.b.a.b.f.b[]{kotlin.l.b.a.b.d.a.p.Tpj, kotlin.l.b.a.b.d.a.p.Tpm, kotlin.l.b.a.b.d.a.p.Tpn, new kotlin.l.b.a.b.f.b("java.lang.annotation.Target"), new kotlin.l.b.a.b.f.b("java.lang.annotation.Retention"), new kotlin.l.b.a.b.f.b("java.lang.annotation.Documented")});
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(listOf, 10));
        for (kotlin.l.b.a.b.f.b bVar : listOf) {
            arrayList.add(kotlin.l.b.a.b.f.a.p(bVar));
        }
        TuW = kotlin.a.j.r((Iterable) arrayList);
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInvokeVisitor
        java.lang.IndexOutOfBoundsException: Index: 4, Size: 4
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.searchCastTypes(MethodInvokeVisitor.java:267)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:127)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:102)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:73)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:66)
        */
    @Override // kotlin.l.b.a.b.k.a.c
    public final java.util.List<A> a(kotlin.l.b.a.b.k.a.z r8, kotlin.l.b.a.b.h.q r9, kotlin.l.b.a.b.k.a.b r10, int r11, kotlin.l.b.a.b.e.a.t r12) {
        /*
        // Method dump skipped, instructions count: 155
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.b.a.a(kotlin.l.b.a.b.k.a.z, kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.k.a.b, int, kotlin.l.b.a.b.e.a$t):java.util.List");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInvokeVisitor
        java.lang.IndexOutOfBoundsException: Index: 4, Size: 4
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.searchCastTypes(MethodInvokeVisitor.java:267)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:127)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:102)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:73)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:66)
        */
    @Override // kotlin.l.b.a.b.k.a.c
    public final java.util.List<A> b(kotlin.l.b.a.b.k.a.z r8, kotlin.l.b.a.b.h.q r9, kotlin.l.b.a.b.k.a.b r10) {
        /*
            r7 = this;
            r3 = 0
            java.lang.String r0 = "container"
            kotlin.g.b.p.h(r8, r0)
            java.lang.String r0 = "proto"
            kotlin.g.b.p.h(r9, r0)
            java.lang.String r0 = "kind"
            kotlin.g.b.p.h(r10, r0)
            kotlin.l.b.a.b.e.b.c r0 = r8.SZH
            kotlin.l.b.a.b.e.b.h r1 = r8.SZI
            kotlin.l.b.a.b.d.b.s r0 = a(r9, r0, r1, r10)
            if (r0 == 0) goto L_0x002e
            kotlin.l.b.a.b.d.b.s$a r1 = kotlin.l.b.a.b.d.b.s.TvQ
            kotlin.l.b.a.b.d.b.s r2 = kotlin.l.b.a.b.d.b.s.a.a(r0, r3)
            r4 = 0
            r6 = 60
            r0 = r7
            r1 = r8
            r5 = r3
            java.util.List r0 = a(r0, r1, r2, r3, r4, r5, r6)
        L_0x002d:
            return r0
        L_0x002e:
            kotlin.a.v r0 = kotlin.a.v.SXr
            java.util.List r0 = (java.util.List) r0
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l.b.a.b.d.b.a.b(kotlin.l.b.a.b.k.a.z, kotlin.l.b.a.b.h.q, kotlin.l.b.a.b.k.a.b):java.util.List");
    }

    public static final /* synthetic */ p.a a(a aVar, kotlin.l.b.a.b.f.a aVar2, an anVar, List list) {
        if (TuW.contains(aVar2)) {
            return null;
        }
        return aVar.a(aVar2, anVar, list);
    }

    public static final /* synthetic */ c a(a aVar, p pVar) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        kotlin.g.b.p.h(pVar, "kotlinClass");
        pVar.a(new d(aVar, hashMap, hashMap2));
        return new c(hashMap, hashMap2);
    }
}
