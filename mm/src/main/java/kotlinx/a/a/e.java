package kotlinx.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.sharp.jni.QLog;
import kotlin.g.b.ac;
import kotlin.g.b.ae;
import kotlin.g.b.c;
import kotlin.g.b.d;
import kotlin.g.b.f;
import kotlin.g.b.o;
import kotlin.g.b.p;
import kotlin.g.b.r;
import kotlin.l;
import kotlinx.a.b.ab;
import kotlinx.a.b.al;
import kotlinx.a.b.be;
import kotlinx.a.b.bf;
import kotlinx.a.b.k;
import kotlinx.a.b.n;
import kotlinx.a.b.q;
import kotlinx.a.b.t;
import kotlinx.a.h;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001aD\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\n\b\u0001\u0010\u0003*\u0004\u0018\u0001H\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\u001a=\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\n\b\u0000\u0010\u0004\u0018\u0001*\u00020\u0005\"\f\b\u0001\u0010\u0003\u0018\u0001*\u0004\u0018\u0001H\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001H\b\u001a\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0001\u001a\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001\u001a\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001\u001a\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001\u001a\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001\u001a\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001\u001a\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001\u001a\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001\u001a\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0001\u001a\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0001*\u00020\u001d¢\u0006\u0002\u0010\u001e\u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020 \u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020!0\u0001*\u00020\"\u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020#0\u0001*\u00020$\u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020%0\u0001*\u00020&\u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020'0\u0001*\u00020(\u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020)0\u0001*\u00020*\u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020+0\u0001*\u00020,\u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020-0\u0001*\u00020.¨\u0006/"}, hxF = {"ArraySerializer", "Lkotlinx/serialization/KSerializer;", "", QLog.TAG_REPORTLEVEL_USER, "T", "", "kClass", "Lkotlin/reflect/KClass;", "elementSerializer", "BooleanArraySerializer", "", "ByteArraySerializer", "", "CharArraySerializer", "", "DoubleArraySerializer", "", "FloatArraySerializer", "", "IntArraySerializer", "", "LongArraySerializer", "", "ShortArraySerializer", "", "UnitSerializer", "", "serializer", "", "Lkotlin/Boolean$Companion;", "(Lkotlin/jvm/internal/BooleanCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "Lkotlin/Byte$Companion;", "", "Lkotlin/Char$Companion;", "", "Lkotlin/Double$Companion;", "", "Lkotlin/Float$Companion;", "", "Lkotlin/Int$Companion;", "", "Lkotlin/Long$Companion;", "", "Lkotlin/Short$Companion;", "", "Lkotlin/String$Companion;", "kotlinx-serialization-runtime"})
public final class e {
    public static final h<Character> a(f fVar) {
        AppMethodBeat.i(225608);
        p.h(fVar, "$this$serializer");
        n nVar = n.TYl;
        AppMethodBeat.o(225608);
        return nVar;
    }

    public static final h<Byte> a(d dVar) {
        AppMethodBeat.i(225609);
        p.h(dVar, "$this$serializer");
        k kVar = k.TYj;
        AppMethodBeat.o(225609);
        return kVar;
    }

    public static final h<Short> a(ac acVar) {
        AppMethodBeat.i(225610);
        p.h(acVar, "$this$serializer");
        be beVar = be.TYU;
        AppMethodBeat.o(225610);
        return beVar;
    }

    public static final h<Integer> a(o oVar) {
        AppMethodBeat.i(225611);
        p.h(oVar, "$this$serializer");
        ab abVar = ab.TYt;
        AppMethodBeat.o(225611);
        return abVar;
    }

    public static final h<Long> a(r rVar) {
        AppMethodBeat.i(225612);
        p.h(rVar, "$this$serializer");
        al alVar = al.TYB;
        AppMethodBeat.o(225612);
        return alVar;
    }

    public static final h<Float> a(kotlin.g.b.l lVar) {
        AppMethodBeat.i(225613);
        p.h(lVar, "$this$serializer");
        t tVar = t.TYr;
        AppMethodBeat.o(225613);
        return tVar;
    }

    public static final h<Double> a(kotlin.g.b.k kVar) {
        AppMethodBeat.i(225614);
        p.h(kVar, "$this$serializer");
        q qVar = q.TYo;
        AppMethodBeat.o(225614);
        return qVar;
    }

    public static final h<Boolean> a(c cVar) {
        AppMethodBeat.i(225615);
        p.h(cVar, "$this$serializer");
        kotlinx.a.b.h hVar = kotlinx.a.b.h.TYh;
        AppMethodBeat.o(225615);
        return hVar;
    }

    public static final h<String> a(ae aeVar) {
        AppMethodBeat.i(225616);
        p.h(aeVar, "$this$serializer");
        bf bfVar = bf.TYV;
        AppMethodBeat.o(225616);
        return bfVar;
    }
}
