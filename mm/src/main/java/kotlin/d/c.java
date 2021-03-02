package kotlin.d;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import java.io.Serializable;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", FacebookRequestErrorClassification.KEY_OTHER, "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", QLog.TAG_REPORTLEVEL_USER, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"})
public final class c implements Serializable, f {
    private final f SXB;
    private final f.b SXC;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    static final class b extends q implements m<String, f.b, String> {
        public static final b SXF = new b();

        static {
            AppMethodBeat.i(129624);
            AppMethodBeat.o(129624);
        }

        b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ String invoke(String str, f.b bVar) {
            AppMethodBeat.i(129623);
            String str2 = str;
            f.b bVar2 = bVar;
            p.h(str2, "acc");
            p.h(bVar2, "element");
            if (str2.length() == 0) {
                String obj = bVar2.toString();
                AppMethodBeat.o(129623);
                return obj;
            }
            String str3 = str2 + ", " + bVar2;
            AppMethodBeat.o(129623);
            return str3;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"})
    /* renamed from: kotlin.d.c$c  reason: collision with other inner class name */
    static final class C2261c extends q implements m<x, f.b, x> {
        final /* synthetic */ f[] SXG;
        final /* synthetic */ z.d hvi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2261c(f[] fVarArr, z.d dVar) {
            super(2);
            this.SXG = fVarArr;
            this.hvi = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(x xVar, f.b bVar) {
            AppMethodBeat.i(129630);
            f.b bVar2 = bVar;
            p.h(xVar, "<anonymous parameter 0>");
            p.h(bVar2, "element");
            f[] fVarArr = this.SXG;
            z.d dVar = this.hvi;
            int i2 = dVar.SYE;
            dVar.SYE = i2 + 1;
            fVarArr[i2] = bVar2;
            x xVar2 = x.SXb;
            AppMethodBeat.o(129630);
            return xVar2;
        }
    }

    public c(f fVar, f.b bVar) {
        p.h(fVar, "left");
        p.h(bVar, "element");
        AppMethodBeat.i(129619);
        this.SXB = fVar;
        this.SXC = bVar;
        AppMethodBeat.o(129619);
    }

    @Override // kotlin.d.f
    public final f plus(f fVar) {
        AppMethodBeat.i(129620);
        p.h(fVar, "context");
        f a2 = f.a.a(this, fVar);
        AppMethodBeat.o(129620);
        return a2;
    }

    @Override // kotlin.d.f
    public final <E extends f.b> E get(f.c<E> cVar) {
        AppMethodBeat.i(129611);
        p.h(cVar, "key");
        c cVar2 = this;
        while (true) {
            E e2 = (E) cVar2.SXC.get(cVar);
            if (e2 != null) {
                AppMethodBeat.o(129611);
                return e2;
            }
            f fVar = cVar2.SXB;
            if (fVar instanceof c) {
                cVar2 = (c) fVar;
            } else {
                E e3 = (E) fVar.get(cVar);
                AppMethodBeat.o(129611);
                return e3;
            }
        }
    }

    @Override // kotlin.d.f
    public final <R> R fold(R r, m<? super R, ? super f.b, ? extends R> mVar) {
        AppMethodBeat.i(129612);
        p.h(mVar, "operation");
        R r2 = (R) mVar.invoke((Object) this.SXB.fold(r, mVar), this.SXC);
        AppMethodBeat.o(129612);
        return r2;
    }

    @Override // kotlin.d.f
    public final f minusKey(f.c<?> cVar) {
        AppMethodBeat.i(129613);
        p.h(cVar, "key");
        if (this.SXC.get(cVar) != null) {
            f fVar = this.SXB;
            AppMethodBeat.o(129613);
            return fVar;
        }
        f minusKey = this.SXB.minusKey(cVar);
        if (minusKey == this.SXB) {
            c cVar2 = this;
            AppMethodBeat.o(129613);
            return cVar2;
        } else if (minusKey == g.SXK) {
            f.b bVar = this.SXC;
            AppMethodBeat.o(129613);
            return bVar;
        } else {
            c cVar3 = new c(minusKey, this.SXC);
            AppMethodBeat.o(129613);
            return cVar3;
        }
    }

    private final int size() {
        c cVar = this;
        int i2 = 2;
        while (true) {
            f fVar = cVar.SXB;
            if (!(fVar instanceof c)) {
                fVar = null;
            }
            c cVar2 = (c) fVar;
            if (cVar2 == null) {
                return i2;
            }
            i2++;
            cVar = cVar2;
        }
    }

    private final boolean b(f.b bVar) {
        AppMethodBeat.i(129614);
        boolean j2 = p.j(get(bVar.getKey()), bVar);
        AppMethodBeat.o(129614);
        return j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        if (r0 != false) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r1 = 0
            r3 = 129615(0x1fa4f, float:1.8163E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            r0 = r4
            kotlin.d.c r0 = (kotlin.d.c) r0
            if (r0 == r5) goto L_0x002a
            boolean r0 = r5 instanceof kotlin.d.c
            if (r0 == 0) goto L_0x004e
            r0 = r5
            kotlin.d.c r0 = (kotlin.d.c) r0
            int r0 = r0.size()
            int r2 = r4.size()
            if (r0 != r2) goto L_0x004e
            kotlin.d.c r5 = (kotlin.d.c) r5
        L_0x001f:
            kotlin.d.f$b r0 = r4.SXC
            boolean r0 = r5.b(r0)
            if (r0 != 0) goto L_0x002f
            r0 = r1
        L_0x0028:
            if (r0 == 0) goto L_0x004e
        L_0x002a:
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
        L_0x002e:
            return r0
        L_0x002f:
            kotlin.d.f r0 = r4.SXB
            boolean r2 = r0 instanceof kotlin.d.c
            if (r2 == 0) goto L_0x0039
            kotlin.d.c r0 = (kotlin.d.c) r0
            r4 = r0
            goto L_0x001f
        L_0x0039:
            if (r0 != 0) goto L_0x0047
            kotlin.t r0 = new kotlin.t
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element"
            r0.<init>(r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            throw r0
        L_0x0047:
            kotlin.d.f$b r0 = (kotlin.d.f.b) r0
            boolean r0 = r5.b(r0)
            goto L_0x0028
        L_0x004e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            r0 = r1
            goto L_0x002e
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.d.c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        AppMethodBeat.i(129616);
        int hashCode = this.SXB.hashCode() + this.SXC.hashCode();
        AppMethodBeat.o(129616);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(129617);
        String str = "[" + ((String) fold("", b.SXF)) + "]";
        AppMethodBeat.o(129617);
        return str;
    }

    private final Object writeReplace() {
        AppMethodBeat.i(129618);
        int size = size();
        f[] fVarArr = new f[size];
        z.d dVar = new z.d();
        dVar.SYE = 0;
        fold(x.SXb, new C2261c(fVarArr, dVar));
        if (!(dVar.SYE == size)) {
            IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(129618);
            throw illegalStateException;
        }
        a aVar = new a(fVarArr);
        AppMethodBeat.o(129618);
        return aVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, hxF = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", MessengerShareContentUtility.ELEMENTS, "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"})
    static final class a implements Serializable {
        public static final C2260a SXE = new C2260a((byte) 0);
        private final f[] SXD;

        static {
            AppMethodBeat.i(129633);
            AppMethodBeat.o(129633);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
        /* renamed from: kotlin.d.c$a$a  reason: collision with other inner class name */
        public static final class C2260a {
            private C2260a() {
            }

            public /* synthetic */ C2260a(byte b2) {
                this();
            }
        }

        public a(f[] fVarArr) {
            p.h(fVarArr, MessengerShareContentUtility.ELEMENTS);
            AppMethodBeat.i(129632);
            this.SXD = fVarArr;
            AppMethodBeat.o(129632);
        }

        private final Object readResolve() {
            AppMethodBeat.i(129631);
            f[] fVarArr = this.SXD;
            f fVar = g.SXK;
            for (f fVar2 : fVarArr) {
                fVar = fVar.plus(fVar2);
            }
            AppMethodBeat.o(129631);
            return fVar;
        }
    }
}
