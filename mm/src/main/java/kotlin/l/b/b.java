package kotlin.l.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.c;
import kotlin.g.a.m;
import kotlin.g.b.aa;
import kotlin.g.b.n;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b.a.ae;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.e.a;
import kotlin.l.b.a.b.e.b.h;
import kotlin.l.b.a.b.e.c.a.f;
import kotlin.l.b.a.b.e.c.a.g;
import kotlin.l.b.a.b.e.c.a.i;
import kotlin.l.b.a.b.k.a.w;
import kotlin.l.b.a.j;
import kotlin.l.d;
import kotlin.l.e;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\u0004"}, hxF = {"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"})
public final class b {
    public static final <R> e<R> a(c<? extends R> cVar) {
        AppMethodBeat.i(56271);
        p.h(cVar, "$this$reflect");
        l lVar = (l) cVar.getClass().getAnnotation(l.class);
        if (lVar == null) {
            AppMethodBeat.o(56271);
            return null;
        }
        String[] hxE = lVar.hxE();
        if (hxE.length == 0) {
            hxE = null;
        }
        if (hxE == null) {
            AppMethodBeat.o(56271);
            return null;
        }
        o<g, a.h> g2 = i.g(hxE, lVar.hxF());
        A a2 = g2.first;
        B b2 = g2.second;
        f fVar = new f(lVar.hxD(), (lVar.hxG() & 8) != 0);
        a.s sVar = b2.TxH;
        p.g(sVar, "proto.typeTable");
        am amVar = (am) ae.a(cVar.getClass(), b2, a2, new h(sVar), fVar, a.SZu);
        if (amVar == null) {
            AppMethodBeat.o(56271);
            return null;
        }
        j jVar = new j(kotlin.l.b.a.a.SZv, amVar);
        AppMethodBeat.o(56271);
        return jVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0015\u0010\u0005\u001a\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;", "R", "p1", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "p2", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function;", "Lkotlin/ParameterName;", "name", "proto", "invoke"})
    static final /* synthetic */ class a extends n implements m<w, a.h, am> {
        public static final a SZu = new a();

        static {
            AppMethodBeat.i(56270);
            AppMethodBeat.o(56270);
        }

        a() {
            super(2);
        }

        @Override // kotlin.g.b.e
        public final d Rs() {
            AppMethodBeat.i(56269);
            kotlin.l.b bp = aa.bp(w.class);
            AppMethodBeat.o(56269);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "loadFunction";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ am invoke(w wVar, a.h hVar) {
            AppMethodBeat.i(56268);
            w wVar2 = wVar;
            a.h hVar2 = hVar;
            p.h(wVar2, "p1");
            p.h(hVar2, "p2");
            am g2 = wVar2.g(hVar2);
            AppMethodBeat.o(56268);
            return g2;
        }
    }
}
